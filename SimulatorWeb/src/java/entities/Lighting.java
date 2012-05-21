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
    /**************************************************************************/
    
    private double power; //watt, electrical power consumption
    private double lightOutput; // light output in lumens (lm)
    private boolean isTurnedOn; //true om lamp is on, ellers false
    private boolean[] dailyProfile; // representerer timer fra klokka 0 til klokka 23 flase om lamp slåttav i denne time, true om lamp slått på
    private boolean useDailyProfile; //true om profile skal brukes ved beregning ellers false (da antar vi at lampen slått på hele tiden)

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
    


    
}
