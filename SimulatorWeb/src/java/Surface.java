
import interfaces.PowerComputer;
import interfaces.HeatLoss;
import exceptions.OversizedException;
import java.util.ArrayList;


/**
 * 
 * @author 490501
 * class represents an outer surface in a simulation unit, such as wall, floor or roof
 * 
 * OBS! alle tall gitt i: lengde - mm; U verdi - W/m^2*K
 */
public class Surface implements PowerComputer, HeatLoss{

    private double dimX; //width in mm

    private double dimY; //high in mm
    
    private double square; // square of entity

    private double uValue;//Overall heat transfer coefficient

    private char orientation;//south, norh, west, east
    
    private double tempDifference; //difference between tempereture innside and outside
    
    private double[] tempDifferences;//differences between tempereture innside and outside
    /**
     * uses if surface represents wall with windows, or roof with windows
     */
    private ArrayList<Surface> windows; 
    /**************************************************************************/
    /*Constructors area*/ 
     
    /**
     * empty constructor
     */
    public Surface() {
        //her skal konstrueres et "standard vegg 1m^2, med u-verdi = 1 W/m^2*K"
        this.dimX = 1000; //mm
        this.dimY = 1000; //mm
        this.square = this.dimX*this.dimY; //mm^2
        this.uValue = 1.0; //W/m^2*K
        this.tempDifferences = new double[0];//Celcius grads
        
    }
    /**
     * constructor
     * @param dimX width of surface in mm
     * @param dimY high of surface in mm
     */
    public Surface(double dimX, double dimY) {
        this.dimX = dimX; //mm
        this.dimY = dimY; //mm
        this.square = this.dimX*this.dimY; //mm^2
        this.uValue = 1.0;//1 watt per m^2*K
        this.tempDifferences = new double[0];
        
        
    }
    /**
     * constructor
     * @param dimX width of surface in mm
     * @param dimY high of surface in mm
     * @param uValue U-value
     */
    public Surface(double dimX, double dimY, double uValue) {
        this.dimX = dimX; //mm
        this.dimY = dimY; //mm
        this.square = this.dimX*this.dimY; //mm^2
        this.uValue = uValue;//1 watt per m^2*K
        this.tempDifferences = new double[0];
        
    }
    /**
     * constructor
     * @param dimX width of surface in mm
     * @param dimY high of surface in mm
     * @param uValue Overall heat transfer coefficient
     * @param window surface object
     * 
     */
    public Surface(double dimX, double dimY, double uValue, Surface window) {
        windows = new ArrayList<Surface>();
        this.dimX = dimX; //mm
        this.dimY = dimY; //mm
        this.square = this.dimX*this.dimY; // in mm^2
        this.uValue = uValue;//1 watt per m^2*K     
        this.windows.add(window);//vindu
        this.tempDifferences = new double[0];
        
    }  
    
/******************************************************************************/
    //End of constructors area

/******************************************************************************/
    //functions 
    /**
     * 
     * @param dimXint width of surface in mm
     * @param dimYint high of surface in mm
     * @param uValue  verall heat transfer coefficient
     */
    public void addWindow(double dimXint, double dimYint, double uValue) throws OversizedException{
        if(this.windows == null)
            this.windows = new ArrayList<Surface>();
        if(this.square < dimXint*dimYint+this.countSquareOfWindows())
            throw new OversizedException("square of window(s) more than square of wall");
        this.windows.add(new Surface(dimXint, dimYint,uValue));
    }
    
    /**
     * 
     * @param i position of window which had to be removed in windows arraylist
     */
    public void removeWindow(int i) {
        this.windows.remove(i);
    }
    
    /**
     * 
     * @param s window which had to be removed from windows array
     */
    public void removeWindow(Surface s) {
        this.windows.remove(s);
    }
    
    /**
     * 
     * @param tempInside inside temperature in Celcius grades
     * @param tempOutside outside temperature in Celcius grades
     * @return heat loss in W/m^2*K where K is temp inside - temp outside
     */
    @Override
    public double computeHeatLoss(double tempInside, double tempOutside) {
        if(tempOutside < 0)
            this.tempDifference = tempInside + Math.abs(tempOutside);
        else
            this.tempDifference = tempInside  - tempOutside;
        return this.computeHeatLoss(tempDifference);//Watt
    }
    
    /**
     * 
     * @param tempDifference between temperature inside and outside in Celcius grades
     * @return 
     */
    @Override
    public double computeHeatLoss(double tempDifference) {
        double result; //W/m^2*K
        this.tempDifference = tempDifference; // Celcius grads
        if(this.windows != null && this.windows.size() > 0) {
            double winHeatLoss = 0;//transmisjonsvarmetap gjennom vinduer
            for(int i = 0; i < this.windows.size(); i++) {
                winHeatLoss += this.windows.get(i).computeHeatLoss(this.tempDifference);//summerer varmetap fra alle vinduer
            }
            result = ((this.square - this.countSquareOfWindows())/1000000) * this.uValue * this.tempDifference + winHeatLoss;
            
        }
        else {
            result = (this.square/1000000) * this.uValue * this.tempDifference;//deler på 10000 fordi vi har areal i mm^2 og trenger resultat i w/m^2*K, where K = tempDifference
        }
        return result;//Watt         
    }
    
    @Override
    public double computeHeatLoss() {//antar at tempDifference var satt opp tidligere
        return this.computeHeatLoss(this.tempDifference);//Watt
    }
    
    /**
     *  
     * @param hours
     * @return transmisjonsvarmetap til hver time
     */
    @Override
    public Double[] computeConsumption(int hours){
        ArrayList<Double> result = new ArrayList<Double>(hours);
        if(this.tempDifferences.length > 0 & this.tempDifferences.length != hours) {
            hours = this.tempDifferences.length; //trim hours value to temperature data size
            for(int i = 0; i < hours; i++){
                result.add(this.computeHeatLoss());
            }
            Double[] arr = result.toArray(new Double[0]);
            return arr; //kW/T
        }
        else if(this.tempDifferences.length == 0) {//will use value from tempDifference in every iteration
            for(int i = 0; i < hours; i++){
                result.add(this.computeHeatLoss());
            }
            Double[] arr = result.toArray(new Double[0]);
            return arr;    //kW/T
        }
        else {
            for(int i = 0; i < hours; i++){
                this.tempDifference = this.tempDifferences[i];
                result.add(this.computeHeatLoss());
            }
            Double[] arr = result.toArray(new Double[0]);
            return arr;  //kW/T
        }
    }
    /**
     * Create sequence of temperature values that are temperaturforskjell mellom ute- og innemiljøet
     * @param tempInside
     * @param tempOutside 
     */
    public void createTempSequence(double[] tempInside, double tempOutside[]) throws OversizedException {
        if(tempInside.length != tempOutside.length) {
            throw new OversizedException("Size of arrays is not equal");
        }
        else {
            this.tempDifferences = new double[tempInside.length];
            for(int i = 0; i < this.tempDifferences.length; i++) {
                if(tempOutside[i] < 0.00)
                    this.tempDifferences[i] = tempInside[i] + Math.abs(tempOutside[i]);
                else
                    this.tempDifferences[i] = tempInside[i]  - tempOutside[i];
            }
        }
    }
    
    /**
     * 
     * @return total squire of all windows at this surface
     */
    public double countSquareOfWindows() {
        double result= 0;
        if(this.windows == null)
            return 0;
        for(int i = 0; i < this.windows.size(); i++) {
            result += this.windows.get(i).square;
        }
        return result;
    }
   
    /*************************************************************************/
    /* get og set metoder her */
    
    public double getDimX() {
        return dimX;
    }

    public void setDimX(double dimX) {
        this.dimX = dimX;
    }

    public double getDimY() {
        return dimY;
    }

    public void setDimY(double dimY) {
        this.dimY = dimY;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getuValue() {
        return uValue;
    }

    public void setuValue(double uValue) {
        this.uValue = uValue;
    }

    public ArrayList<Surface> getWindows() {
        return windows;
    }

    public void setWindows(ArrayList<Surface> windows) {
        this.windows = windows;
    }

    public double getTempDifference() {
        return tempDifference;
    }

    public void setTempDifference(double tempDifference) {
        this.tempDifference = tempDifference;
    }

    public double[] getTempDifferences() {
        return tempDifferences;
    }

    public void setTempDifferences(double[] tempDifferences) {
        this.tempDifferences = tempDifferences;
    }

    

    /***************************************************************************/
    
    @Override
    public String toString() {
        String s = "Surface #"+this.hashCode()+System.getProperty("line.separator");
        s +="dimension x: "+this.dimX+System.getProperty("line.separator");
        s +="dimension y: "+this.dimY+System.getProperty("line.separator");
        s +="U value: "+this.uValue+System.getProperty("line.separator");
        s +="Total square: "+this.square/1000000+"m^2"+System.getProperty("line.separator");
        //s +="Windows quantity: "+this.windows.size()+System.getProperty("line.separator");
        //s +="Windows area: "+this.windows.get(0).square;
        return s;
    }
    
    
    

    
    
    
}

