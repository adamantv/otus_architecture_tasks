package game.elements;

import game.exception.IllegalParameterException;
import game.exception.IllegalPropertyTypeException;

import java.util.HashMap;
import java.util.Map;

public class GameElement implements UObject {
    private final Map<String, Object> properties = new HashMap<>();

    @Override
    public Object getProperty(Class<?> cls, String propertyName) {
        if (!properties.containsKey(propertyName)) {
            throw new IllegalParameterException(propertyName);
        }
        if (!cls.isInstance(properties.get(propertyName))) {
            throw new IllegalPropertyTypeException(cls, propertyName);
        }
        return properties.get(propertyName);
    }

    @Override
    public void setProperty(String propertyName, Object newValue) {
        properties.put(propertyName, newValue);
    }
}
