
package simulator;

import units.*;

/**
 *
 * @author 490501
 */
public class StandartProfileTester {
    
    public static void main(String[] args) {
        StandartUnit[] st = new StandartUnit[20];
        for(int i = 0; i < st.length; i++) {
            st[i] = new SmallHouse(i*50);
            System.out.println("дом №" + i + " на месяц нужно" + st[i].getLightyear());
        }
        
    }
    
}
