package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;

public class LightsEventProcessor implements EventProcessor {
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isLightEvent(event)) return;
        smartHome.executeAction(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        changeLightState(light, true);
                    } else {
                        changeLightState(light, false);
                    }
                }
            }
        });
    }

    private void changeLightState(Light light, boolean isOn) {
        light.setOn(isOn);
        System.out.println("Light " + light.getId() + (isOn ? " turned on" : " turned off"));
    }

    private boolean isLightEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }
}
