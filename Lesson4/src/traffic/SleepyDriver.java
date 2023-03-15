package traffic;

import javafx.scene.effect.Light;
import traffic.trafficlight.Lights;
import traffic.trafficlight.TrafficLight;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SleepyDriver implements PropertyChangeListener
{
    private Car car;

    public SleepyDriver(Car car)
    {
        this.car = car;
    }

    public void onLightChange(TrafficLight trafficLight)
    {
        if(trafficLight.isTurnedOn(Lights.GREEN)) {
            car.start();
            car.accelerate();
            trafficLight.removePropertyChangeListener(this);
        } else if(trafficLight.isTurnedOn(Lights.RED) && trafficLight.isTurnedOn(Lights.YELLOW)) {
            // nothing
        }
        else if (trafficLight.isTurnedOn(Lights.YELLOW)) {
            car.decelerate();
        }
        else {
            car.stop();
        }
    }

    public Car getCar() {
        return car;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        TrafficLight light = (TrafficLight) evt.getSource();
        onLightChange(light);
    }
}
