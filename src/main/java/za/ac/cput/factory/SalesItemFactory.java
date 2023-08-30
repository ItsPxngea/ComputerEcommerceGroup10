package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.domain.Sales;
import za.ac.cput.domain.SalesItem;
import za.ac.cput.util.Helper;

import java.util.List;

public class SalesItemFactory {
    public static SalesItem buildSales(Sales sales, List<Product> products, int quantity, double itemPrice) {
        // Check for invalid values here

        String salesItemID = Helper.generateID();

        return new SalesItem.Builder()
                .setSalesItemID(salesItemID)
                .setSales(sales)
                .setProducts(products) // Use the new method to set products
                .setQuantity(quantity)
                .setItemPrice(itemPrice)
                .build();
    }
}
