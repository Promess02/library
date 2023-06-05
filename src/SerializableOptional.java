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

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeBoolean(isPresent);
        if (isPresent) {
            out.writeObject(value);
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        isPresent = in.readBoolean();
        if (isPresent) {
            value = (T) in.readObject();
        }
    }

    public Optional<T> toOptional() {
        return isPresent ? Optional.ofNullable(value) : Optional.empty();
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
