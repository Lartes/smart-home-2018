package ru.sbt.mipt.oop;

import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.coolcompany.smarthome.events.SensorEventsManager;

@Configuration
public class SmartHomeConfig {

    @Bean
    SmartHomeLoader smartHomeLoader() {
        return new FileSmartHomeLoader();
    }

    @Bean
    EventsManager eventsManager() {
        return new EventManagerAdapter(new SensorEventsManager());
    }

    @Bean
    RemoteControlRegistry remoteControlRegistry() {return new RemoteControlRegistry();}

    @Bean
    GeneralRemoteControl programController() throws IOException {
        return  new GeneralRemoteControl();
    }
}