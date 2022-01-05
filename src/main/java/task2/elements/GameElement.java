package task2.elements;

import task2.exception.IllegalParameterException;

import java.util.HashMap;
import java.util.Map;

public class GameElement implements UObject {
    private final Map<String, Object> properties;

    public GameElement() {
        this.properties = new HashMap<>();
    }

    @Override
    public Object getProperty(String propertyName) {
        if (!properties.containsKey(propertyName)) {
            throw new IllegalParameterException(propertyName);
        }
        return properties.get(propertyName);
    }

    @Override
    public void setProperty(String propertyName, Object newValue) {
        properties.put(propertyName, newValue);
    }
}
