package entities;

import java.util.ArrayList;

/**
 *
 * @author 490501
 */
public class SimulationUnit {
    //list of power consumers in an unit
    private ArrayList<PowerConsumer> consumers;
    private double area; // boligs areal for eksempel
    private int type; //feks 1 - enebolig, 2 - rekkehus, 3 - leilighet 

    /**
     * default empty constructor
     */
    public SimulationUnit() {
        consumers = new ArrayList<PowerConsumer>();
    }
    /**
     * 
     * @param area
     * @param type 
     */
    public SimulationUnit(double area, int type) {
        consumers = new ArrayList<PowerConsumer>();
        this.area = area;
        this.type = type;
    }
    
    
    /**
     * 
     * @return area of object
     */
    public double getArea() {
        return area;
    }
    /***
     * 
     * @param area - area of object
     */
    public void setArea(double area) {
        this.area = area;
    }
    /**
     * 
     * @return type of object
     */
    public int getType() {
        return type;
    }
    /**
     * 
     * @param type of object
     */
    public void setType(int type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        String a;
        a = String.valueOf(area * type);
        return a;
    }
    /**
     * 
     * @param pw power consumer to be added to list of consumers
     */
    public void addConsumer(PowerConsumer pw) {
        consumers.add(pw);
    }

    
}
