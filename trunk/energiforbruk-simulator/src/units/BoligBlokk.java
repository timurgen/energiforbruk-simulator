
package units;

/**
 *
 * @author 490501
 */
public class BoligBlokk extends StandartUnit{
    
    public BoligBlokk(String name, double area, double equipment, double light, double warm, double operationTimeHours, double operationTimeDays, double operationTimeWeeks) {
        super(name, area, equipment, light, warm, operationTimeHours, operationTimeDays, operationTimeWeeks);
    }

    public BoligBlokk(double area) { // tall tatt av Standard Norge
        super(area);
        super.light = 2.9; //W per m^2
        super.equipment = 2.6; //W per m^2
        super.warm = 3.4; //W per m^2
        super.operationTimeHours = 16; //times per day
        super.operationTimeDays = 7; //days per week
        super.operationTimeWeeks = 52; // weeks per year
        
    }
}
