/******************************************************************************
 * ventilasjonstap = (tetthet(kg/m^3) * vollum(m^3))/(29 g/moll)*((T1-T2)*7/2*R(gasskonstant))/t(tid i sekunder)
 * formuler tatt her http://en.wikipedia.org/wiki/Natural_ventilation
 * Videre må finne ut tall som brukes i virkelighet (tetthet og sirkulasjonshastighet )
 * 
 * 
 * OBS! pass på å bruke riktige måleenheter!
 * 
 ******************************************************************************/
package entities;

import interfaces.HeatLoss;

/**
 *
 * @author 490501
 * @version 1.0.0
 * @start date 04 mai 2012
 */


public class Ventilation implements HeatLoss{
    /******************************/
    //Konstanter
    public static final double R = 8.3144621;//gasskonstant G/moll
    public static final double g = 9.81; // m/s^2, gravitional constant
    public static final double MOLARMASS = 0.029;// kg/moll
    public static final double VENTILATION_NATURAL_AIRFLOW_RATE = 1.0; 
    public static final double VENTILATION_AVTREKK_AIRFLOW_RATE = 1.0; 
    public static final double CD = 0.62; //Discharge coefficient for opening (typical value is 0,62)
    //*****************************/
    private double tempDiff; //differnse between temperature inside and outside in Celcius units
    private double tempInside;//temperature inside unit
    private double tempOutside; //temperature outside
    private double densityOfAir; //lufttetthet in kg/m^3
    private double volume; //vollum in m^3
    private double heightOfPipe; // height between inlet and outlet in natural ventilation in milimeter
    private double areaOfOpening; //cross-sectional area of opening, m^2 (assumes equal area for inlet and outlet)
    private double airFlowRate; //ventilation airflow rate, m³/s
    /**************************************************************************/
    
    
    
    /******Constructors *******************************************************/
    /**
     * Default empty constructor
     */
    public Ventilation() {
        
    }
    /**
     * 
     * @param densityOfAir kg/m^3
     * @param volume m^3
     * @param heightOfPipe mm
     * @param areaOfOpening m^2
     */
    public Ventilation(double densityOfAir, double volume, double heightOfPipe, double areaOfOpening) {
        this.densityOfAir = densityOfAir;
        this.volume = volume;
        this.heightOfPipe = heightOfPipe;
        this.areaOfOpening = areaOfOpening;
    }
    
    

    @Override
    public double computeHeatLoss(double tempInside, double tempOutside) {
        double tempDiff = tempInside - tempOutside;
        return computeHeatLoss(tempDiff);
    }

    @Override
    public double computeHeatLoss(double tempDifference) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double computeHeatLoss() {
        return computeHeatLoss(this.tempDiff);
    }
    /**
     * 
     * @return computed airflow rate in m^3/s
     */
    public double getAirFlowRate() {
        this.airFlowRate = CD * this.areaOfOpening * Math.sqrt(g*this.heightOfPipe*(this.tempDiff/this.tempInside)); //m^3/s
        return this.airFlowRate;
    }

    /***************************************************************************
     * Getter and setters here
     **************************************************************************/
    
    public double getAreaOfOpening() {
        return areaOfOpening;
    }

    public void setAreaOfOpening(double areaOfOpening) {
        this.areaOfOpening = areaOfOpening;
    }

    public double getDensityOfAir() {
        return densityOfAir;
    }

    public void setDensityOfAir(double densityOfAir) {
        this.densityOfAir = densityOfAir;
    }

    public double getHeightOfPipe() {
        return heightOfPipe;
    }

    public void setHeightOfPipe(double heightOfPipe) {
        this.heightOfPipe = heightOfPipe;
    }

    public double getTempDiff() {
        return tempDiff;
    }

    public void setTempDiff(double tempDiff) {
        this.tempDiff = tempDiff;
    }

    public double getTempInside() {
        return tempInside;
    }

    public void setTempInside(double tempInside) {
        this.tempInside = tempInside;
    }

    public double getTempOutside() {
        return tempOutside;
    }

    public void setTempOutside(double tempOutside) {
        this.tempOutside = tempOutside;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
/*********END OF GETTERS & SETTERS ********************************************/ 

}





