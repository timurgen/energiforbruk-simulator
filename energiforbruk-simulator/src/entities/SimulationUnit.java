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
    private int type;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        String a;
        a = String.valueOf(area * type);
        return a;
    }

    
}
