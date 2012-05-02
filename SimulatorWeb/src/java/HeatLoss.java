/**
 * every outer surface such that: wall, window, roof, floor must implement this interface
 * to compute heat loss trough that surface
 * @author 490501
 */
public interface HeatLoss {
    public double computeHeatLoss(double tempInside, double tempOutside); //returns watt per entity
    public double computeHeatLoss(double tempDifference);//returns watt per entity
    public double computeHeatLoss();//returns watt per entity
    
}
