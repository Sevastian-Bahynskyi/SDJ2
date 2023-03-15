package traffic;

import traffic.trafficlight.TrafficLight;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        TrafficLight light = new TrafficLight();
        TrafficlightRunner runner = new TrafficlightRunner(light);
        Thread lightThread = new Thread(runner);
        lightThread.start();
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");
        Driver driverA = new Driver(carA);
        TaxiDriver driverB = new TaxiDriver(carB);
        SleepyDriver driverC = new SleepyDriver(carC);
        Pedestrian pedestrian = new Pedestrian("Bob Bobson");
        carA.start();
        carB.start();
        //carC.start();
        pedestrian.go();
        light.addPropertyChangeListener(driverA);
        light.addPropertyChangeListener(driverB);
        light.addPropertyChangeListener(driverC);
        light.addPropertyChangeListener(pedestrian);
        Thread.sleep(2000);
    }
}
