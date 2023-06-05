import java.io.Serializable;

public interface Registry<T> extends Serializable{
    public T getEntryById(Integer id);
    public void deleteEntryById(Integer id);
}
