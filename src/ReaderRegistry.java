import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * This class implements registry which contains all the readers.
 */
public class ReaderRegistry implements Registry, Serializable {
    private static final long serialVersionUID = 2L;

    private List<Reader> readerList;

    /**
     * Class constructor.
     */
    public ReaderRegistry(){
        readerList = new LinkedList<>();
    }

    /**
     * Adds a user to a registry.
     * @param name - name of the user
     * @param surname - surname of the user
     * @param login - login of the user
     * @param password - password of the user
     */
    public void addUser(String name, String surname, String login, String password){
        Reader reader = new Reader(readerList.size()+1,name,surname,login,password);
        readerList.add(reader);
    }

    /**
     * Updates a password of a given reader.
     * @param readerID - ID of reader whose password is being updated
     * @param newPassword - new password of a reader
     */
    public void updateUserPassword(Integer readerID, String newPassword){
        readerList.stream()
                .filter(reader -> reader.getReaderId().equals(readerID))
                .findFirst()
                .ifPresent(reader -> reader.setPassword(newPassword));
    }

    /**
     * Returns string which contains information about all of the readers in the registry.
     * @return String
     */
    @Override
    public String toString() {
        return "ReaderRegistry: " +
                "readerList=" + readerList +
                '\n';
    }

    /**
     * Returns a list of all readers in registry.
     * @return List of Readers
     */
    public List<Reader> getReaderList() {
        return readerList;
    }

    /**
     * Returns a Reader object corresponding to the given ID.
     * @param readerId - ID of a reader
     * @return Reader
     */
    @Override
    public Reader getEntryById(Integer readerId) {
        for(Reader reader: readerList)
            if(reader.getReaderId().equals(readerId)) return reader;
        return null;
    }

    /**
     * Deletes a reader with a given ID from the register.
     * @param readerID - ID of a reader
     */
    @Override
    public void deleteEntryById(Integer readerID) {
        readerList.stream()
                .filter( reader -> reader.getReaderId().equals(readerID))
                .findFirst()
                .ifPresent(reader -> readerList.remove(reader));
    }

    /**
     * Checks if the reader with a given ID is present in the registry.
     * @param id - ID of a reader
     * @return boolean
     */
    @Override
    public boolean checkIfcontainsID(Integer id) {
        for(Reader reader: readerList){
            if(reader.getReaderId().equals(id)) return true;
        }
        return false;
    }
}
