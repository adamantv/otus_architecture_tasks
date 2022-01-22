package task2.actions.log;

import lombok.AllArgsConstructor;
import task2.elements.UObject;

@AllArgsConstructor
public class LoggableAdapter implements Loggable {
    private final UObject<String> uObject;

    @Override
    public String getLog() {
        return uObject.getProperty(String.class, "log");
    }

    @Override
    public void setLog(String message) {
        uObject.setProperty("log", message);
    }
}
