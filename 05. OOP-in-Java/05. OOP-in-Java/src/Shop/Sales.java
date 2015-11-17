package Shop;

import Shop.Customers.Customer;
import Shop.Enum.AgeRestriction;
import Shop.Products.FoodProduct;

public class Sales {
    public static void main(String[] args) {
        FoodProduct cigars = new FoodProduct("420 Blaze it fgt", 6.90, 0, AgeRestriction.Adult);
        Customer pecata = new Customer("Pecata", 17, 30.00);
        try {
            PurchaseManager.processPurchase(pecata, cigars);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        Customer gopeto = new Customer("Gopeto", 18, 18);
        try {
            PurchaseManager.processPurchase(gopeto, cigars);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
