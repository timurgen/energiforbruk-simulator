package entities;

public class PowerConsumer {
    private double powerEffect;
    private String name;
    private String category;
    private double energyConversionEfficiency;
    /**
     * default constructor
     */
    public PowerConsumer() {
        this.powerEffect = 0.00;
        this.name = "Default consumer";
        this.category = "without category";
        this.energyConversionEfficiency = 0.00;
        
    }
    /**
     *
     * @param effect
     */
    public void setPowerEffect(double effect) {
        this.powerEffect = effect;
    }
    /**
     *
     * @return
     */
    public double getPowerEffect() {
        return powerEffect;
    }
    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /**
     *
     * @return
     */
    public String getCategory() {
        return category;
    }
    /**
     *
     * @param energyConversionEfficiency
     */
    public void setEnergyConversionEfficiency(double energyConversionEfficiency) {
        this.energyConversionEfficiency = energyConversionEfficiency;
    }
    /**
     *
     * @return
     */
    public double getEnergyConversionEfficiency() {
        return energyConversionEfficiency;
    }
}
