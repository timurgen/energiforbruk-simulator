package entities;

/**
 *
 * @author 490501
 */
public abstract class PowerConsumer {
    private int effectW; //kor mye Kwh i time bruker enhet
    private String name; //ka heter enhet

    public int getEffectW() {
        return effectW;
    }

    public void setEffectW(int effectW) {
        this.effectW = effectW;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
