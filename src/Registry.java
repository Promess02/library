import java.io.Serializable;

/**
 * An interface of Registry that declares methods used for interaction: reading, deleting, checking if contains entry.
 * @param <T> - class of objects stored in a registry
 */
public interface Registry<T> extends Serializable{
    /**
     *
     * @param id entry id
     * @return object which the registry is containing
     */
    public T getEntryById(Integer id);

    /**
     * deletes the entry in registry based on the id
     * @param id entry id
     */
    public void deleteEntryById(Integer id);

    /**
     * checks id registry contains Entry of the id provided
     * @param id entry id
     * @return boolean
     */
    public boolean checkIfcontainsID(Integer id);
}
