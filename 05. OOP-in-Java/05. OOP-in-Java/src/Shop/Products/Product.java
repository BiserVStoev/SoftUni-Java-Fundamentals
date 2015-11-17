package Shop.Products;

import Shop.Enum.AgeRestriction;
import interfaces.Buyable;

public abstract class Product implements Buyable {

    private String name;
    private double price;
    private int quantity;
    private AgeRestriction ageRestriction;

    public Product(String name, double price,int quantity, AgeRestriction ageRestriction){
        setName(name);
        setAgeRestriction(ageRestriction);
        setPrice(price);
        setQuantity(quantity);
    }

    public void soldProduct(){
        this.quantity--;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0){
            throw new IllegalArgumentException("The quantity of the product cannot be a negative number");
        }
        this.quantity = quantity;
    }

    public double price(){
        return this.price;
    }

    public void setPrice(double price) {
        if(price < 0){
            throw new IllegalArgumentException("The price of the product cannot be a negative number");
        }
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name.equals(" ")){
            throw new IllegalArgumentException("The name of the product cannot be empty string");
        }
        this.name = name;
    }

}
