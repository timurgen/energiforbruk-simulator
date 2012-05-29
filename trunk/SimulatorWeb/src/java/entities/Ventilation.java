/******************************************************************************
 * ventilasjonstap = (tetthet(kg/m^3) * vollum(m^3))/(0.029 kg/moll)*((T1-T2)*7/2*R(gasskonstant J·K^-1·mol^-1))/t(tid)
 * flow rate for natural ventilation here http://en.wikipedia.org/wiki/Natural_ventilation#Estimating_buoyancy-driven_ventilation   
 * Videre må finne ut tall som brukes i virkelighet (tetthet og sirkulasjonshastighet )
 * Klassen skal utviddes slik at rekuperasjon skal være med
 * 
 * OBS! pass på å bruke riktige måleenheter! Standard enheter til prosjekt ligger 
 * her: https://www.itslearning.com/file/fs_folderfile.aspx?FolderFileID=242941
 * 
 ******************************************************************************/
package entities;

import exceptions.LessThanZeroException;
import interfaces.HeatLoss;
import interfaces.PowerComputer;
/**
 *
 * @author 490501
 * @version 1.0.0
 * @start date 04 mai 2012
 */
public class Ventilation implements HeatLoss, PowerComputer{
    
    /**************************************************************************/
    
    /**
     * kinds of ventilation
     */
    public static final int VENTTYPE_NATURAL = 0;
    public static final int VENTTYPE_FORCED = 1;

    /**
     * gasskonstant G/moll
     */
    public static final double R = 8.3144621;
    /**
     * m/s^2, gravitional constant
     */
    public static final double g = 9.81; 
    /**
     * kg/moll molar mass of air
     */
    public static final double MOLARMASS = 0.029;
    /**
     * default airflow rate for natural ventilation
     */
    public static final double VENTILATION_NATURAL_AIRFLOW_RATE = 1.0;
    /**
     * default airflow rate for exhaust ventilation
     */
    public static final double VENTILATION_AVTREKK_AIRFLOW_RATE = 2.0; 
    /**
     * Discharge coefficient for opening (typical value is 0,62)
     */
    public static final double CD = 0.62; 
    
    /**************************************************************************/
    
    /**
     * differense between temperature inside and outside in Celcius units
     */
    private double tempDiff; 
    
    /**
     * temperature inside unit
     */
    private double tempInside;
    
    /**
     * temperature outside
     */
    private double tempOutside; 
    
    /**
     * lufttetthet in kg/m^3
     */
    private double densityOfAir; 
    
    /**
     * vollum in m^3
     */
    private double volume; 
    
    /**
     * height between inlet and outlet in natural ventilation in milimeter
     */
    private double heightOfPipe; 
    
    /**
     * cross-sectional area of opening, m^2 (assumes equal area for inlet and outlet)
     */
    private double areaOfOpening; 
   
    /**
     * ventilation airflow rate, m³/s
     */
    private double airFlowRate; 
    
    /**
     * represents air changes per hour
     * 1 - by default
     */
    private double ventilationRate; 
    
    /**
     * Heat recovery coeffisient (Virkningsgrad på gjenvinner) i prosent
     */
    private double  heatRecovery;
    
    /**
     * power effect (strømforbruk) for avtrekk ventilasjon i kWt
     */
    private double powerEffect;
    
    /**
     * type of ventilation 
     * 0 - natural
     * 1 - forced
     */
    private int ventType;
    /**************************************************************************/
      
    /******Constructors *******************************************************/
    
    /**
     * Default empty constructor
     */
    public Ventilation() {
        this.ventilationRate = 1;
    }
    
    /**
     * Constructor for natural ventilation with ventilation pipe length
     * @param densityOfAir kg/m^3
     * @param volume inside entity m^3
     * @param heightOfPipe height of ventilation pipe from inlet to outlet mm
     * @param areaOfOpening m^2
     */
    public Ventilation(double heightOfPipe, double areaOfOpening) {
        this.heightOfPipe = heightOfPipe;
        this.areaOfOpening = areaOfOpening;
        this.ventType = 0;
        this.ventilationRate = 1;
    }
    
    /**
     * Constructor for mechanical ventilation
     * with warm recuperation
     * @param heatRecovery varmgjenvinning (heat recuperation) i prosent
     * @param ach represents air changes per hour
     */
    public Ventilation(double heatRecovery, double ach, int ventType) {
        this.ventType = ventType;
        this.heatRecovery = heatRecovery;
        this.ventilationRate = ach;
    }
    
    
    /**
     * 
     * @param tempInside temperature inside of unit
     * @param tempOutside temperature outside of unit
     * @return 
     */
    @Override
    public double computeHeatLoss(double tempInside, double tempOutside) {
        tempDiff = tempInside - tempOutside;
        return computeHeatLoss(tempDiff);
    }
    
    /**
     * 
     * @param tempDifference difference between inside temperature and outside temperature
     * @return Heatloss trough ventilation  gitt i kilowatt per time
     */
    @Override
    public double computeHeatLoss(double tempDifference) {
        if(this.ventType == 0)
            return (((this.densityOfAir*this.volume)/MOLARMASS)*(tempDifference*7/2)*(R/3600)* this.ventilationRate * (1- this.heatRecovery/100))/1000;
        else if(this.ventType == 1)
            return (((this.airFlowRate*3600) * tempDifference) / 3.0 * (1+this.heatRecovery/100))/1000;
        else 
            throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @return 
     */
    @Override
    public double computeHeatLoss() {
        return computeHeatLoss(this.tempDiff);
    }
    
    /**
     * Compute air flowrate for natural ventilation 
     * @return computed airflow rate in m^3/s for natural ventilation
     * @throws Exception if inside temp equal or less than zero
     */
    public double getAirFlowRateNatural() throws Exception {
        if(this.tempInside <= 0)
            throw new Exception("Inside temperature must be greater than zero");
        this.airFlowRate = CD * this.areaOfOpening * Math.sqrt(g*(this.heightOfPipe/1000)*(this.tempDiff/this.tempInside)); //m^3/s
        
        return this.airFlowRate;
    }
    
    /**
     * Compute air flowrate for natural ventilation 
     * @param cd Discharge coefficient for opening
     * @return computed airflow rate in m^3/s for natural ventilation
     * @throws Exception if inside temp equal or less than zero
     */
    public double getAirFlowRateNatural(double cd) throws Exception {
        if(this.tempInside <= 0)
            throw new LessThanZeroException("Inside temperature must be greater than zero");
        this.airFlowRate = cd * this.areaOfOpening * Math.sqrt(g*(this.heightOfPipe/1000)*(this.tempDiff/this.tempInside)); //m^3/s
        return this.airFlowRate;
    }

    /**
     * 
     * @return air changes per hour
     * @throws Exception if parameter tempInside in getAirFlowRateNatural equal or less than zero;
     */
    public double getVentilationRate() throws Exception {
        return (3600*getAirFlowRateNatural())/this.volume;
    }

    /***************************************************************************
     * Getter and setters here
     **************************************************************************/
    
    /**
     * 
     * @return 
     */
    public double getAreaOfOpening() {
        return areaOfOpening;
    }
    
    /**
     * 
     * @param areaOfOpening 
     */
    public void setAreaOfOpening(double areaOfOpening) {
        this.areaOfOpening = areaOfOpening;
    }
    
    /**
     * 
     * @return 
     */
    public double getDensityOfAir() {
        return densityOfAir;
    }
    
    /**
     * Sets the density of air (kg/m^3)
     * +35 	 	1.1455 	
     * +30 	 	1.1644 	
     * +25 	 	1.1839 
     * +20 	 	1.2041 
     * +15 		1.2250 	
     * +10 	 	1.2466 	
     * +5 	 	1.2690 	
     * ±0 	 	1.2922 
     * -5 	 	1.3163 	
     * -10 	 	1.3413 
     * -15 	 	1.3673 	
     * -20 	 	1.3943 	
     * -25 	 	1.4224 
     * @param densityOfAir gitt i kg per kubikkmeter
     */
    public void setDensityOfAir(double densityOfAir) {
        this.densityOfAir = densityOfAir;
    }
    
    /**
     * return density of air 
     * @param temp temperature of air in Celsius
     * @param humidity of air im prosent
     * @param pressure  in hPa
     * @return dencity of air
     */
    public double computeDensityofAir(double temp, double humidity, double pressure){
        return 0;
    }
    
    /**
     * 
     * @return 
     */
    public double getHeightOfPipe() {
        return heightOfPipe;
    }
    
    /**
     * 
     * @param heightOfPipe 
     */
    public void setHeightOfPipe(double heightOfPipe) {
        this.heightOfPipe = heightOfPipe;
    }
    
    /**
     * 
     * @return 
     */
    public double getTempDiff() {
        return tempDiff;
    }
    
    /**
     * 
     * @param tempDiff 
     */
    public void setTempDiff(double tempDiff) {
        this.tempDiff = tempDiff;
    }
    
    /**
     * 
     * @return 
     */
    public double getTempInside() {
        return tempInside;
    }
    
    /**
     * 
     * @param tempInside 
     */
    public void setTempInside(double tempInside) {
        this.tempInside = tempInside;
    }
    
    /**
     * 
     * @return 
     */
    public double getTempOutside() {
        return tempOutside;
    }
    
    /**
     * 
     * @param tempOutside 
     */
    public void setTempOutside(double tempOutside) {
        this.tempOutside = tempOutside;
    }
    
    /**
     * 
     * @return 
     */
    public double getVolume() {
        return volume;
    }
    
    /**
     * Set the volume of the unit
     * @param volume of unit in m^3
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    /**
     * 
     * @return airflow rate in kubikkmeter per sekund 
     */
    public double getAirFlowRate() {
        return airFlowRate;
    }
    
    /**
     * sets the airflow rate in kubikkmeter per sekund
     * @param airFlowRate 
     */
    public void setAirFlowRate(double airFlowRate) {
        this.airFlowRate = airFlowRate;
    }
    
    /**
     * returns heat recovery value
     * @return 
     */
    public double getHeatRecovery() {
        return heatRecovery;
    }
    
    /**
     * sets heat recovery value
     * @param heatRecovery  heat recuperation value in prosents
     */
    public void setHeatRecovery(double heatRecovery) {
        this.heatRecovery = heatRecovery;
    }

    /**
     * 
     * @return power consumption of forced ventilation
     */
    public double getPowerEffect() {
        return powerEffect;
    }
    
    /**
     * sets the power consumption of forced ventialtion
     * @param powerEffect 
     */
    public void setPowerEffect(double powerEffect) {
        this.powerEffect = powerEffect;
    }
    
    /**
     * 
     * @return type of ventilation 
     */
    public int getVentType() {
        return ventType;
    }

    /**
     * Sets type of ventilation
     * 0 - natural 
     * 1 - forced
     * @param ventType 
     */
    public void setVentType(int ventType) {
        this.ventType = ventType;
    }

    
    
    
    
 /*********END OF GETTERS & SETTERS ********************************************/ 
    
    /**
     * 
     * @param hours
     * @return 
     */
    @Override
    public Double[] computeConsumption(int hours) {
        //TODO implementere strømforbruk for ventilasjon med avtrekk
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
/*****************************************************************************/
//Test area

    public static void main(String[] args) {
        Ventilation v = new Ventilation();
        v.setVolume(400);
        v.setDensityOfAir(1.2041);
        v.setTempDiff(40);
        System.out.println(v.computeHeatLoss());
        v.setVentType(1);
        v.setAirFlowRate(400.0/3600.0);
        System.out.println(v.computeHeatLoss());
    }
}





