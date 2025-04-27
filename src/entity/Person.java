package entity;

public class Person {


    private String name;
    private String lastname;

    private int wallet;

    private int id;

    public Person() {
    }
    public Person(String name, String lastname, int wallet,int id) {
        this.name = name;
        this.lastname = lastname;
        this.wallet = wallet;
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }



    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getWallet() {
        return wallet;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", wallet=" + wallet +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
