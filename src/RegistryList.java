import java.io.Serializable;
import java.util.List;

public class RegistryList implements Serializable {
    private List<Registry> registryList;

    public RegistryList(List<Registry> registryList) {
        this.registryList = registryList;
    }

    public List<Registry> getRegistryList() {
        return registryList;
    }
    public RentalRegistry getRentalRegistry(){
        return (RentalRegistry) registryList.get(0);
    }
    public ReaderRegistry getReaderRegistry(){
        return (ReaderRegistry) registryList.get(1);
    }

    public BookCopyRegistry getBookCopyRegistry(){
        return (BookCopyRegistry) registryList.get(2);
    }



    public void setRegistryList(List<Registry> registryList) {
        this.registryList = registryList;
    }

    public void setRentalRegistry(RentalRegistry rentalRegistry){
        this.registryList.add(0, rentalRegistry);
    }
    public void setReaderRegistry(ReaderRegistry readerRegistry){
        this.registryList.add(1, readerRegistry);
    }
    public void setBookCopyRegistry(BookCopyRegistry bookCopyRegistry){
        this.registryList.add(2, bookCopyRegistry);
    }
}
