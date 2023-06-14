import java.io.Serializable;

/**
 * This class represents data of a reader.
 */
public class Reader implements Serializable {
    private Integer ReaderId;
    private String name;
    private String surname;
    private String login;
    private String password;

    /**
     * Sets the name of the reader to a given value.
     * @param name - name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the surname of the reader to a given value.
     * @param surname - surname to be set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Class constructor.
     * @param readerId - ID of the reader
     * @param name - name of the reader
     * @param surname - surname of the reader
     * @param login - reader's login
     * @param password - reader's password
     */
    public Reader(Integer readerId, String name, String surname, String login, String password) {
        ReaderId = readerId;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    /**
     * Returns reader's ID.
     * @return Integer
     */
    public Integer getReaderId() {
        return ReaderId;
    }

    /**
     * Returns reader's name.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns reader's surname.
     * @return String
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Returns reader's login.
     * @return String
     */
    public String getLogin() {
        return login;
    }

    /**
     * Returns reader's password.
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the login of the reader to a given value.
     * @param login - login to be set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Sets the password of the reader to a given value.
     * @param password - password to be set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns string which contains all the information about the reader.
     * @return String
     */
    @Override
    public String toString() {
        return "Reader: " +
                "ReaderId=" + ReaderId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\n' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '\n';
    }
}
