public class Authoriz {


    private String name;
    private String lastName;

    private String Login;


    public Authoriz(String name, String lastName, String login, int idCard) {
        this.name = name;
        this.lastName = lastName;
        Login = login;
        this.idCard = idCard;
    }

    private int idCard;




    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return Login;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }
}
