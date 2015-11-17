package Shop.Products;
import Shop.Enum.AgeRestriction;

import java.util.Date;

public abstract class ElectonicsProduct extends Product {
    protected Date guaranteePeriod;

    public ElectonicsProduct(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);
    }
}
