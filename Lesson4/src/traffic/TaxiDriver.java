package traffic;



import traffic.trafficlight.Lights;
import traffic.trafficlight.TrafficLight;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TaxiDriver implements PropertyChangeListener {
    private final Car car;

    public TaxiDriver(Car car) {
        this.car = car;
    }

    public void onLightChange(TrafficLight trafficLight) {
        if (trafficLight.isTurnedOn(Lights.GREEN)) {
            car.accelerate();
            trafficLight.removePropertyChangeListener(this);
        } else if (trafficLight.isTurnedOn(Lights.RED) && trafficLight.isTurnedOn(Lights.YELLOW)) {
            if (!car.isRunning()) car.start();
            car.accelerate();
        } else if (trafficLight.isTurnedOn(Lights.YELLOW)) {
            // ignore
        } else {
            car.stop();
        }
    }

    public Car getCar() {
        return car;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TrafficLight light = (TrafficLight) evt.getSource();
        onLightChange(light);
    }
}

