import java.util.LinkedList;
import java.util.List;

public class ReaderRegistry implements Registry{
    private List<Reader> readerList;

    public ReaderRegistry(){
        readerList = new LinkedList<>();
    }
    public void addUser(String name, String surname, String login, String password){
        Reader reader = new Reader(readerList.size()+1,name,surname,login,password);
        readerList.add(reader);
    }

    public void updateUserPassword(Integer readerID, String newPassword){
        readerList.stream()
                .filter(reader -> reader.getReaderId().equals(readerID))
                .findFirst()
                .ifPresent(reader -> reader.setPassword(newPassword));
    }

    @Override
    public String toString() {
        return "ReaderRegistry{" +
                "readerList=" + readerList +
                '}';
    }

    @Override
    public Reader getEntryById(Integer readerId) {
        for(Reader reader: readerList)
            if(reader.getReaderId().equals(readerId)) return reader;
        return null;
    }

    @Override
    public void deleteEntryById(Integer readerID) {
        readerList.stream()
                .filter( reader -> reader.getReaderId().equals(readerID))
                .findFirst()
                .ifPresent(reader -> readerList.remove(reader));
    }
}
