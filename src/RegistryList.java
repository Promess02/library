import java.io.Serializable;
import java.util.List;

/**
 * class with a list containg all registries in the library
 */
public class RegistryList implements Serializable {
    /**
     * list with registries
     */
    private List<Registry> registryList;

    /**
     * Constructor with a list of registries as an argument
     * @param registryList list of registries
     * @see Registry
     */
    public RegistryList(List<Registry> registryList) {
        this.registryList = registryList;
    }

    /**
     * @return list of registries
     */
    public List<Registry> getRegistryList() {
        return registryList;
    }

    /**
     * Returns the rental registry which is at index 0 in the list
     * @return rental registry
     * @see RentalRegistry
     */
    public RentalRegistry getRentalRegistry(){
        return (RentalRegistry) registryList.get(0);
    }
    /**
     * Returns the reader registry which is  at index 1 in the list
     * @return reader registry
     * @see ReaderRegistry
     */
    public ReaderRegistry getReaderRegistry(){
        return (ReaderRegistry) registryList.get(1);
    }

    /**
     * Returns the book copy registry which is at index 2 in the list
     * @return book copy registry
     * @see BookCopyRegistry
     */
    public BookCopyRegistry getBookCopyRegistry(){
        return (BookCopyRegistry) registryList.get(2);
    }

    /**
     * sets the list of registries
     * @param registryList - list of registries
     * @see Registry
     */
    public void setRegistryList(List<Registry> registryList) {
        this.registryList = registryList;
    }

    /**
     * sets the rental registry at index 0 of the list
     * @param rentalRegistry
     * @see RentalRegistry
     */
    public void setRentalRegistry(RentalRegistry rentalRegistry){
        this.registryList.add(0, rentalRegistry);
    }
    /**
     * sets the rental registry at index 1 of the list
     * @param readerRegistry
     * @see ReaderRegistry
     */
    public void setReaderRegistry(ReaderRegistry readerRegistry){
        this.registryList.add(1, readerRegistry);
    }
    /**
     * sets the book copy registry at index 2 of the list
     * @param bookCopyRegistry
     * @see BookCopyRegistry
     */
    public void setBookCopyRegistry(BookCopyRegistry bookCopyRegistry){
        this.registryList.add(2, bookCopyRegistry);
    }
}
