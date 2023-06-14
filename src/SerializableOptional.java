import java.io.Serializable;
import java.util.Optional;

/**
 * Class containing a value and info if the value is present.
 * Easily convertible to an Optional. Solves the issue of
 * Optional objects not being serializable
 * @param <T> parameter
 * @see Optional
 */
public class SerializableOptional<T> implements Serializable {

    private boolean isPresent;
    private T value;

    /**
     * Sets the value and isPresent variables based on given optional
     * @param optional
     */
    public SerializableOptional(Optional<T> optional) {
        this.isPresent = optional.isPresent();
        this.value = optional.orElse(null);
    }

    /**
     * Converts SerializableOptional object to an Optional object
     * @return Optional
     * @see Optional
     */
    public Optional<T> toOptional() {
        return isPresent ? Optional.ofNullable(value) : Optional.empty();
    }

    /**
     * Returns the value in Optional
     * @return value
     */
    public T get() {
        return value;
    }

    /**
     * Sets the value inside the SerializableOptional and sets the isPresent boolean to true
     * @param value
     */
    public void set(T value) {
        this.isPresent = true;
        this.value = value;
    }

    /**
     * returns value to string if present else returns string of "null"
     * @return String
     */
    @Override
    public String toString() {
        if(isPresent) return value.toString();
        else return "null";
    }
}
