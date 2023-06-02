public interface Registry<T> {
    public T getEntryById(Integer id);
    public void deleteEntryById(Integer id);
}
