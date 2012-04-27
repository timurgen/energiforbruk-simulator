
package units;

/**
 *
 * @author 490501
 */
public class SkoleBygg extends StandartUnit{
    public SkoleBygg(String name, double area, double equipment, double light, double warm, double operationTimeHours, double operationTimeDays, double operationTimeWeeks) {
        super(name, area, equipment, light, warm, operationTimeHours, operationTimeDays, operationTimeWeeks);
    }

    public SkoleBygg(double area) { // tall tatt av Standard Norge
        super(area);
        super.light = 10; //W per m^2
        super.equipment = 5.9; //W per m^2
        super.warm = 4.5; //W per m^2
        super.operationTimeHours = 10; //times per day
        super.operationTimeDays = 5; //days per week
        super.operationTimeWeeks = 44; // weeks per year
        
    }
    
}
