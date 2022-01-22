package task2.elements;

import java.util.Map;

public interface UObject<T> {
    T getProperty(Class<T> cls, String propertyName);

    void setProperty(String propertyName, T newValue);

    Map<String, T> getProperties();
}
