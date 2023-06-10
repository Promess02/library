import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Optional;

public class SerializableOptional<T> implements Serializable {

    private boolean isPresent;
    private T value;

    public SerializableOptional(Optional<T> optional) {
        this.isPresent = optional.isPresent();
        this.value = optional.orElse(null);
    }
    public Optional<T> toOptional() {
        return isPresent ? Optional.ofNullable(value) : Optional.empty();
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.isPresent = true;
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
