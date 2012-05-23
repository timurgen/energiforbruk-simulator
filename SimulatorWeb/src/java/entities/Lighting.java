/*******************************************************************************
 * Denne klassen representerer en lamp eller en annen lyskilde
 * 
 * 
 * 
 * 
 * 
 ******************************************************************************/

package entities;


import interfaces.HeatLoss;
import interfaces.PowerComputer;

/**
 * 
 * 
 * @author 490501
 * @version 1.0.0
 * 
 * 
 */

public class Lighting implements PowerComputer{
    //true if turned on, false if turned off, period from 0 to 23 hours
    public static final boolean[] HOUSE_PROFILE = {false,false,false,false,false,false,false,true,true,false,false,false,false,false,false,false,false,true,true,true,true,true,true,true};
    public static final boolean[] SKOLE_PROFILE = {false,false,false,false,false,false,false,true,true,true,true,true,true,true,true,true,true,true,false,false,false,false,false,false};
        
    /**
     * Obliquity of the ecliptic
     */
    public static final double AXIS = 23.439;
    
    /**
     * The expression pi/182.625 uses to compute length of light day
     */
    public static final double J = Math.PI / 182.625;
    /**************************************************************************/
    
    /**
     * represents the lattitude of element
     */
    private double lattitude;
    
    /**
     * represents day of year
     */
    private double dayOfYear;
    
    /**
     * watt, electrical power consumption
     */
    private double power; //
    
    /**
     * light output in lumens (lm)
     */
    private double lightOutput; // 
    
    /**
     * true om lamp is on, ellers false
     */
    private boolean isTurnedOn; //
    
    /**
     * representerer timer fra klokka 0 til klokka 23 flase om lamp slåttav i denne time, true om lamp slått på
     */
    private boolean[] dailyProfile; // 
    
    /**
     * true om profile skal brukes ved beregning ellers false (da antar vi at lampen slått på hele tiden)
     */
    private boolean useDailyProfile; 

    /**
    * 
    * @param hours
    * @return 
    */
    @Override
    public Double[] computeConsumption(int hours) {
        Double[] result = new Double[hours];
        if(useDailyProfile) {
            for(int i = 0; i < hours; i++) {
                if(dailyProfile[i])
                    result[i] = power;
                else
                    result[i] = 0D;
                if(i == 23){
                    i = 0;
                    hours-=24;
                }
            }
        }
        else {
            for(int i = 0; i < hours; i++) {
                result[i] = power;
            }
        }
        return result;
    }
    
    /**
     * uses to compute the length of day in depence of 
     * lattitude and day of year
     * @return length of day
     */
    public double getLengthOfDay() {
        double cp3 = J * this.dayOfYear;
        double cp2 = (AXIS * Math.cos(cp3))*(Math.PI/180.0);
        double cp1 = this.lattitude * (Math.PI/180.0);
        double m = 1.0 - Math.tan(cp1)*Math.tan(cp2);
        if(m < 0)
            m = 0;
        if(m > 2)
            m = 2;
        return Math.acos(1.0-m) / Math.PI*24.0;
    }
    
//    public double getLengthOfDayWithCivilTwilight() {
//        
//    }
    
    /************************************************************************/
    //get og set metoder
    public boolean[] getDailyProfile() {
        return dailyProfile;
    }

    public void setDailyProfile(boolean[] dailyProfile) {
        this.dailyProfile = dailyProfile;
    }

    public boolean isIsTurnedOn() {
        return isTurnedOn;
    }

    public void setIsTurnedOn(boolean isTurnedOn) {
        this.isTurnedOn = isTurnedOn;
    }

    public double getLightOutput() {
        return lightOutput;
    }

    public void setLightOutput(double lightOutput) {
        this.lightOutput = lightOutput;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public boolean isUseDailyProfile() {
        return useDailyProfile;
    }

    public void setUseDailyProfile(boolean useDailyProfile) {
        this.useDailyProfile = useDailyProfile;
    }

    public double getDayOfYear() {
        return dayOfYear;
    }

    public void setDayOfYear(double dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }
    
    /**************************************************************************/
    //test
    
    public static void main(String[] args) {
        Lighting l = new Lighting();
        l.setDayOfYear(210);
        l.setLattitude(0);
        System.out.println(l.getLengthOfDay());
    }


    
}
