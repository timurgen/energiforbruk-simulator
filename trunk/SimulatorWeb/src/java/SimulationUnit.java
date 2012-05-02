
import interfaces.PowerComputer;
import interfaces.HeatLoss;
import java.util.ArrayList;


/**
 * 
 * @author 490501
 */
public class SimulationUnit implements PowerComputer, HeatLoss{
    private ArrayList<Surface> surfaces; //all outer surfaces such that: walls, floor, roof 
    private double square; //total square mm
    private double[] tempInside, tempOutside, tempDiff;

    public SimulationUnit() {
        surfaces = new ArrayList<Surface>();
    }
    @Override
    public Double[] computeConsumption(int hours) {
        if(tempDiff.length < hours)
            hours = tempDiff.length;
        Double[] result = new Double[hours];
        for(int i = 0; i < hours; i++) {
            result[i] = 0.00;
            for(int j = 0; j < this.surfaces.size(); j++) {
                result[i] += this.surfaces.get(j).computeHeatLoss(tempDiff[i]);
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
     * 
     * @param s 
     */
    public void addWall(Surface s) {
        this.surfaces.add(s);
    }
    
    public void addFloor(Surface s) {
        this.surfaces.add(s);
        this.square = s.getSquare(); 
    }
    
    /**
     * 
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
     * Shouldn't uses without specially reason, coz square computes in addFloor() function normally
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

