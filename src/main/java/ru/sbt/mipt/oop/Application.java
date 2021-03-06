package ru.sbt.mipt.oop;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    private static Logger logger = LogManager.getLogger(Application.class);

    public static void main(String... args) throws IOException {
        logger.info("Starting configuration...");
        ApplicationContext context = new AnnotationConfigApplicationContext(SmartHomeConfig.class);
        SmartHomeLoader smartHomeLoader = context.getBean(SmartHomeLoader.class);
        EventsManager eventsManager = context.getBean(EventsManager.class);

        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        smartHome.setAlarm(new Alarm("112233"));
        EventsLoader.runEvents(smartHome, eventsManager);

        RemoteControlRegistry remoteControlRegistry = context.getBean(RemoteControlRegistry.class);
        GeneralRemoteControl remoteControl = context.getBean(GeneralRemoteControl.class);
        remoteControlRegistry.registerRemoteControl(remoteControl, "123");
    }
}
