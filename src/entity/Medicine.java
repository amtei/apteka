package entity;

public class Medicine {

    private  long id;
    private String primaryelement;

    private  String med_name;

    private int price;

    public Medicine(long id, String medName, String primaryelement) {
    }

    @Override
    public String toString() {
        return "Medicine{" +
               "id=" + id +
               ", primaryelement='" + primaryelement + '\'' +
               ", med_name='" + med_name + '\'' +
               ", price=" + price +
               '}';
    }

    public Medicine(long id, String primaryelement, String med_name, int price) {
        this.id = id;
        this.primaryelement = primaryelement;
        this.med_name = med_name;
        this.price = price;
    }

    public Medicine() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrimaryelement() {
        return primaryelement;
    }

    public void setPrimaryelement(String primaryelement) {
        this.primaryelement = primaryelement;
    }

    public String getMed_name() {
        return med_name;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
