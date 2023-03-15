package traffic;

import traffic.trafficlight.Lights;
import traffic.trafficlight.TrafficLight;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Pedestrian implements PropertyChangeListener
{
    private boolean isGoing;
    private final String name;

    public Pedestrian(String name) {
        isGoing = false;
        this.name = name;
    }

    public void onLightChange(TrafficLight trafficLight) {
        if (trafficLight.isTurnedOn(Lights.GREEN)) {
            if (!isGoing) waitForGreen();
            stop();
        } else if (trafficLight.isTurnedOn(Lights.RED) && trafficLight.isTurnedOn(Lights.YELLOW)) {
            ready();
        } else if (trafficLight.isTurnedOn(Lights.YELLOW)) {
            run();
            trafficLight.removePropertyChangeListener(this);
        } else {
           go();
        }
    }

    private void ready() {
        if(isGoing) {
            System.out.println(name + " ready to cross");
        }
    }

    private void run() {
        if(isGoing) {
            System.out.println(name + " runs");
        }
    }

    private void stop() {
        if(isGoing) {
            System.out.println(name + " stops");
            isGoing = false;
        }
    }

    public void go() {
        if(!isGoing) {
            System.out.println(name + " goes");
            isGoing = true;
        }
    }

    public void waitForGreen()
    {
        if(isGoing) {
            System.out.println(name + " waits");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TrafficLight light = (TrafficLight) evt.getSource();
        onLightChange(light);
    }
}
