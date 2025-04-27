package entity;

public class Basket {
     long basket_id;
String med_name;
 int price;

public Basket(){

 }

    public long getBasket_id() {
        return basket_id;
    }

    public void setBasket_id(long basket_id) {
        this.basket_id = basket_id;
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
