package units;

import java.io.Serializable;

public class StandartUnit implements Serializable{

    /**
     * Name of unit
     */
    protected String name;
    /**
     * Area of unit in m^2
     */
    protected double area;
    /**
     *  standardverdier for gjennomsnittlig effektbruk i driftstiden W/m^2
     */
    protected double equipment;
    protected double light;
    protected double warm;
    /**
     * standard driftstid in hours per day, days per week, weeks per year
     */
    protected double operationTimeHours;
    protected double operationTimeDays;
    protected double operationTimeWeeks;

    public StandartUnit () {
        this.name = "unit";
        this.equipment = 0;
        this.light = 0;
        this.warm = 0;
    }

    public StandartUnit(String name, double area, double equipment, double light, double warm, double operationTimeHours, double operationTimeDays, double operationTimeWeeks) {
        this.name = name;
        this.area = area;
        this.equipment = equipment;
        this.light = light;
        this.warm = warm;
        this.operationTimeHours = operationTimeHours;
        this.operationTimeDays = operationTimeDays;
        this.operationTimeWeeks = operationTimeWeeks;
    }

    public StandartUnit(double area) {
        this.area = area;
    }
    

    

    
    

    public double getEquipment () {
        return equipment;
    }


    public void setEquipment (double val) {
        this.equipment = val;
    }

    public double getLight () {
        return light;
    }


    public void setLight (double val) {
        this.light = val;
    }


    public String getName () {
        return name;
    }


    public void setName (String val) {
        this.name = val;
    }


    public double getWarm () {
        return warm;
    }


    public void setWarm (double val) {
        this.warm = val;
    }

    public double getOperationTimeDays() {
        return operationTimeDays;
    }

    public void setOperationTimeDays(double operationTimeDays) {
        this.operationTimeDays = operationTimeDays;
    }

    public double getOperationTimeHours() {
        return operationTimeHours;
    }

    public void setOperationTimeHours(double operationTimeHours) {
        this.operationTimeHours = operationTimeHours;
    }

    public double getOperationTimeWeeks() {
        return operationTimeWeeks;
    }

    public void setOperationTimeWeeks(double operationTimeWeeks) {
        this.operationTimeWeeks = operationTimeWeeks;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
    
    
    
    public double getEffectDay() {
        return (this.area*this.equipment+this.area*this.light+this.area*this.warm)*this.operationTimeHours/1000;
    }
    
    public double getEffectWeek() {
        return (this.area*this.equipment+this.area*this.light+this.area*this.warm)*this.operationTimeHours*this.operationTimeDays/1000;
    }
    public double getEffectMonth() {
        return ((this.area*this.equipment+this.area*this.light+this.area*this.warm)*this.operationTimeHours*this.operationTimeDays*this.operationTimeWeeks)/365*30/1000;
    }
    public double getEffectYear() {
        return ((this.area*this.equipment+this.area*this.light+this.area*this.warm)*this.operationTimeHours*this.operationTimeDays*this.operationTimeWeeks)/1000;
    }
    public double getLightyear() {
        return this.area*this.light*this.operationTimeHours*365/1000;
    }

}

