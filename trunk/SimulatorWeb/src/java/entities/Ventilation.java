/******************************************************************************
 * ventilasjonstap = (tetthet(kg/m^3) * vollum(m^3))/(29 g/moll)*((T1-T2)*7/2*R(gasskonstant))/t(tid i sekunder)
 * flow rate for natural ventilation here http://en.wikipedia.org/wiki/Natural_ventilation#Estimating_buoyancy-driven_ventilation   
 * Videre må finne ut tall som brukes i virkelighet (tetthet og sirkulasjonshastighet )
 * Klassen skal utviddes slik at rekuperasjon skal være med
 * 
 * OBS! pass på å bruke riktige måleenheter! Standard enheter til prosjekt ligger 
 * her: https://www.itslearning.com/file/fs_folderfile.aspx?FolderFileID=242941
 * 
 ******************************************************************************/
package entities;

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
     * air changes per hour
     */
    private double ventilationRate; 
    
    /**
     * Heat recovery coeffisient (Virkningsgrad på gjenvinner) equal 1 by default
     */
    private double  heatRecovery;
    
    /**
     * power effect (strømforbruk) for avtrekk ventilasjon i kWt
     */
    private double powerEffect;
    
    /**
     * 
     */
    private int ventType;
    /**************************************************************************/
      
    /******Constructors *******************************************************/
    
    /**
     * Default empty constructor
     */
    public Ventilation() {
        
    }
    
    /**
     * Constructor for natural ventilation
     * @param densityOfAir kg/m^3
     * @param volume inside entity m^3
     * @param heightOfPipe height of ventilation pipe from inlet to outlet mm
     * @param areaOfOpening m^2
     */
    public Ventilation(double densityOfAir, double volume, double heightOfPipe, double areaOfOpening) {
        this.densityOfAir = densityOfAir;
        this.volume = volume;
        this.heightOfPipe = heightOfPipe;
        this.areaOfOpening = areaOfOpening;
        this.ventType = 0;
    }
    
    /**
     * Constructor for mechanical ventilation
     * with warm recuperation
     * @param heatRecovery 
     */
    public Ventilation(double heatRecovery) {
        this.ventType = 1;
    }
    
    
    /**
     * 
     * @param tempInside
     * @param tempOutside
     * @return 
     */
    @Override
    public double computeHeatLoss(double tempInside, double tempOutside) {
        tempDiff = tempInside - tempOutside;
        return computeHeatLoss(tempDiff);
    }
    
    /**
     * 
     * @param tempDifference
     * @return 
     */
    @Override
    public double computeHeatLoss(double tempDifference) {
        //ventilationLoss = (tetthet*this.volume)/mm*((this.sliderTemperatureInside.getValue() - this.averageTemp)*7/2*R)/t;
        return (this.densityOfAir*this.volume)/MOLARMASS*(tempDifference*7/2*R)/this.ventilationRate;   
    }

    @Override
    public double computeHeatLoss() {
        return computeHeatLoss(this.tempDiff);
    }
    
    /**
     * Compute air flowrate for natural ventilation 
     * @return computed airflow rate in m^3/s for natural ventilation
     * @throws Exception if inside temp equal or less than zero
     */
    public double getAirFlowRate() throws Exception {
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
    public double getAirFlowRate(double cd) throws Exception {
        if(this.tempInside <= 0)
            throw new Exception("Inside temperature must be greater than zero");
        this.airFlowRate = cd * this.areaOfOpening * Math.sqrt(g*(this.heightOfPipe/1000)*(this.tempDiff/this.tempInside)); //m^3/s
        return this.airFlowRate;
    }

    /**
     * 
     * @return air changes per hour
     * @throws Exception if parameter tempInside in getAirFlowRate equal or less than zero;
     */
    public double getVentilationRate() throws Exception {
        return (3600*getAirFlowRate())/this.volume;
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
     * 
     * @param densityOfAir 
     */
    public void setDensityOfAir(double densityOfAir) {
        this.densityOfAir = densityOfAir;
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
     * 
     * @param volume 
     */
    public void setVolume(double volume) {
        this.volume = volume;
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


}





