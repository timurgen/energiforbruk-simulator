/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package units;

/**
 *
 * @author obu
 */
public class KontorBygg extends StandartUnit{
    public KontorBygg(String name, double area, double equipment, double light, double warm, double operationTimeHours, double operationTimeDays, double operationTimeWeeks) {
        super(name, area, equipment, light, warm, operationTimeHours, operationTimeDays, operationTimeWeeks);
    }

    public KontorBygg(double area) { // tall tatt av Standard Norge
        super(area);
        super.light = 8; //W per m^2
        super.equipment = 10.9; //W per m^2
        super.warm = 1.6; //W per m^2
        super.operationTimeHours = 12; //times per day
        super.operationTimeDays = 5; //days per week
        super.operationTimeWeeks = 52; // weeks per year
        
    }
    
}
