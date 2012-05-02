
/**
 *
 * @author 490501
 * Every power consumer must implement methods from this interface to compute strømforbruk 
 * in different conditions
 */
public interface PowerComputer {
    /**
     * 
     * @param hours simulation period
     * @return array of kW*T values
     */
    public Double[] computeConsumption(int hours); //returns array with kW/T values

    
}
