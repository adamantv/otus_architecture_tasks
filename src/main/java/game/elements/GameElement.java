package game.elements;

import game.exception.IllegalParameterException;
import game.exception.IllegalPropertyTypeException;

import java.util.HashMap;
import java.util.Map;

public class GameElement<T> implements UObject<T> {
    private final Map<String, T> properties = new HashMap<>();

    @Override
    public T getProperty(Class<T> cls, String propertyName) {
        if (!properties.containsKey(propertyName)) {
            throw new IllegalParameterException(propertyName);
        }
        if (!cls.isInstance(properties.get(propertyName))) {
            throw new IllegalPropertyTypeException(cls, propertyName);
        }
        return properties.get(propertyName);
    }

    @Override
    public void setProperty(String propertyName, T newValue) {
        properties.put(propertyName, newValue);
    }
}
