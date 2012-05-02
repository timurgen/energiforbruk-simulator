
import exceptions.OversizedException;

/**
 *
 * @author 490501
 */
public class Tester {
    public static void main(String[] args) throws OversizedException {
        SimulationUnit sim1 = new SimulationUnit();
        //walls
        Surface wall_1 = new Surface(7000, 3050, 0.23);
        Surface wall_2 = new Surface(3000,3050,0.23);
        wall_2.addWindow(1500, 1000, 1.7);
        Surface wall_3 = new Surface(7000,3050,0.23);
        wall_3.addWindow(3500, 1000, 1.7);
        Surface wall_4 = new Surface(3000,3050,0.23);
        Surface floor = new Surface(7000,3000,0.17);
        Surface roof = new Surface (7000,3000,0.15);
        sim1.addWall(wall_1);
        sim1.addWall(wall_2);
        sim1.addWall(wall_3);
        sim1.addWall(wall_4);
        //sim1.addWall(roof);
        //sim1.addFloor(floor);
        double loss = sim1.computeHeatLoss(22, -15);
        //System.out.println(loss);
        double[] a = {11.0,7.0,11.0,6.0,15.0,4.0,13.0,12.0,11.0,0.0,3.0,4.0,5.0};
        sim1.setTempDiff(a);
        Double[] b = sim1.computeConsumption(a.length);
        for(Double c : b){
        System.out.println(c);
    }

        
    }
}
