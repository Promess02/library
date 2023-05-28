public class Reader {
    private Integer ReaderId;
    private String name;
    private String surname;
    private String login;
    private String password;
    public Reader(Integer readerId, String name, String surname, String login, String password) {
        ReaderId = readerId;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public Integer getReaderId() {
        return ReaderId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "ReaderId=" + ReaderId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
