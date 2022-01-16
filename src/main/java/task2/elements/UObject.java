package task2.elements;

public interface UObject<T> {
    T getProperty(Class<T> cls, String propertyName);

    void setProperty(String propertyName, T newValue);
}
