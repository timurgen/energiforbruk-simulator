/******************************************************************************
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 ******************************************************************************/

package entities;


import interfaces.HeatLoss;
import interfaces.PowerComputer;
import java.util.ArrayList;


/**
 * 
 * @author 490501
 * @version 1.0.0
 */
public class SimulationUnit implements PowerComputer, HeatLoss{

    
    /**
     * all outer surfaces such that: walls, floor, roof
     */
    private ArrayList<Surface> surfaces;
    
    /**
     * total square m^2
     */
    private double square; 
    
    /**
     * 
     */
    private double[] tempInside, tempOutside, tempDiff; //grades Celsius
    
    /**
     * represents the lattitude of building 
     * 
     */
    private double lattitude;
    
    /**
     * represents day of year 
     * (1st year 0...364, from 365 add 0.25 for every completed year within the Great Year consisting of 4 years, i.e. 365.25 etc.
     */
    private double dayOfYear;
    
    /**
     * Ventilation unit
     */
    private Ventilation vent;
    
    
    /**
     * Default empty constructor
     */
    public SimulationUnit() {
        surfaces = new ArrayList<Surface>();
    }
    
    /**
     * Computes power consumptions of this unit
     * @param hours
     * @return 
     */
    @Override
    public Double[] computeConsumption(int hours) {
        if(tempDiff.length < hours)
            hours = tempDiff.length;
        Double[] result = new Double[hours];
        for(int i = 0; i < hours; i++) {
            result[i] = 0.00;
            for(int j = 0; j < this.surfaces.size(); j++) {
                result[i] += this.surfaces.get(j).computeHeatLoss(tempDiff[i])/1000; //metod returnerer i Watt vi trenger kW/t
            }
        }
        return result;//kWT
        
    }

    /**
     * 
     * @param tempInside temperature inside entity in Celcius or Kelvin
     * @param tempOutside temperature outside entity  Celcius or Kelvin
     * @return total heat loss trough outer surfaces
     */
    @Override
    public double computeHeatLoss(double tempInside, double tempOutside) {
        if(this.square == 0)
            this.computeSquareIfFloorDoesntExist();
        double result = 0;
        for(int i = 0; i < surfaces.size(); i++) {
            result += surfaces.get(i).computeHeatLoss(tempInside, tempOutside);
        }
        return result;//wt*m^2
    }
    /**
     * 
     * @param tempDifference difference between temperature outside and inside
     * @return total heat loss trough outer surfaces
     */
    @Override
    public double computeHeatLoss(double tempDifference) {
        if(this.square == 0)
            this.computeSquareIfFloorDoesntExist();        
        double result = 0;
        for(int i = 0; i < surfaces.size(); i++) {
            result += surfaces.get(i).computeHeatLoss(tempDifference);
        }
        return result;//wt*m^2
    }

    /**
     * 
     * @return total heat loss trough outer surfaces
     */
    @Override
    public double computeHeatLoss() {
        if(this.square == 0)
            this.computeSquareIfFloorDoesntExist();
        
        double result = 0;
        for(int i = 0; i < surfaces.size(); i++) {
            result += surfaces.get(i).computeHeatLoss();
        }
        return result; //wt*m^2
    }
    /**
     * sets new surface that represents outer wall or roof
     * @param s 
     */
    public void addWall(Surface s) {
        this.surfaces.add(s);
    }
    
    /**
     * sets new surface that represents a floor(ground) of unit
     * @param s 
     */
    public void addFloor(Surface s) {
        this.surfaces.add(s);
        this.square += s.getSquare(); 
    }
    
    /**
     * Remove outer surface from unit
     * @param i 
     */
    public void removeSurface(int i) {
        this.surfaces.remove(i);
    }
    
    
    public void removeSurface(Surface s) {
        this.surfaces.remove(s);
    }
    
    public void computeSquareIfFloorDoesntExist() {
        double P = 0;
        for(int i = 0; i < this.surfaces.size(); i++) {
            P += this.surfaces.get(i).getDimX();
        }
        this.square = Math.pow(P/4, 2);
        //System.out.println(this.square/1000000); //m^2
    }
    
    public void computeTempDifferenceFromInsideTempAndOutSideTemp() throws Exception {
        
        if(this.tempInside.length != this.tempOutside.length){
            throw new Exception("rekker er ikke like");
        }
        this.tempDiff = new double[this.tempInside.length];
        for(int i = 0; i < this.tempInside.length; i++) {
        if(tempOutside[i] < 0)
            this.tempDiff[i] = tempInside[i] + Math.abs(tempOutside[i]);
        else
            this.tempDiff[i] = tempInside[i]  - tempOutside[i];
        }
    }
    
    /**
     * Sets empty ventilation unit 
     */
    public void newVentilation() {
        this.vent = new Ventilation();
    }
    
    /**
     * Sets ventilation unit
     * @param v Ventilation unit that was created before
     */
    public void addVentilation(Ventilation v) {
        this.vent = v;
    }
    
    /**
     * saves profile of simulation unit as a readable txt file
     */
    public void saveAsTxt() {
        
    }
    
    public void loadFromTxt(String path) {
        
    }

    
    
    //**********************************************************************/
    //                      GETTERS & SETTERS
    /**
     * 
     * @return total square of unit in mm^2 
     */
    public double getSquare() {
        return square;
    }
    /**
     * Uses with simple simulation to set total square of unit
     * 
     * @param square total square of unit in mm^2
     */
    public void setSquare(double square) {
        this.square = square;
    }

    public ArrayList<Surface> getSurfaces() {
        return surfaces;
    }

    public void setSurfaces(ArrayList<Surface> surfaces) {
        this.surfaces = surfaces;
    }

    public double[] getTempDiff() {
        return tempDiff;
    }

    public void setTempDiff(double[] tempDiff) {
        this.tempDiff = tempDiff;
    }

    public double[] getTempInside() {
        return tempInside;
    }

    public void setTempInside(double[] tempInside) {
        this.tempInside = tempInside;
    }

    public double[] getTempOutside() {
        return tempOutside;
    }

    public void setTempOutside(double[] tempOutside) {
        this.tempOutside = tempOutside;
    }
    
    
    
    

}

