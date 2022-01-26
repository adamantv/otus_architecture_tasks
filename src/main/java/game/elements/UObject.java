package game.elements;

public interface UObject {
    Object getProperty(Class<?> cls, String propertyName);

    void setProperty(String propertyName, Object newValue);
}
