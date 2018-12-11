package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class HomeEventObserver implements EventsManager {
    protected SmartHome smartHome;
    private SensorEventProvider sensorEventProvider;
    private static Collection<EventProcessor> eventProcessors = null;

    public HomeEventObserver(SmartHome smartHome, SensorEventProvider sensorEventProvider){
        this.smartHome = smartHome;
        this.sensorEventProvider = sensorEventProvider;
    }

    @Override
    public void runEventsCycle(SmartHome smartHome) {
        SensorEvent event = SensorEventProvider.getNextSensorEvent();
          while (event != null) {
            System.out.println("Event: " + event);
            for (EventProcessor eventProcessor : eventProcessors) {
                eventProcessor.processEvent(smartHome, event);
            }
            event = SensorEventProvider.getNextSensorEvent();
        }
    }

    @Override
    public void addEventProcessor(EventProcessor eventProcessor) {
        if (eventProcessors == null) {
            eventProcessors = new ArrayList<>();
        }
        eventProcessors.add(eventProcessor);
    }

    public void addAllEventProcessors( Collection<EventProcessor> allEventProcessors) {
        if (eventProcessors == null) {
            eventProcessors = new ArrayList<>();
        }
        eventProcessors.addAll(allEventProcessors);
    }
}