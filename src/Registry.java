import java.io.Serializable;

/**
 * An interface of Registry that declares methods used for interaction: reading, deleting, checking if contains entry.
 * @param <T> - class of objects stored in a registry
 */
public interface Registry<T> extends Serializable{
    public T getEntryById(Integer id);
    public void deleteEntryById(Integer id);
    public boolean checkIfcontainsID(Integer id);
}
