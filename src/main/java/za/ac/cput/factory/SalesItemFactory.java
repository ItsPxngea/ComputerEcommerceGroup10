package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.domain.Sales;
import za.ac.cput.domain.SalesItem;
import za.ac.cput.util.Helper;

public class SalesItemFactory {
    public static SalesItem buildSales(Sales sales, Product product, int quantity, double itemPrice) {
        if (Helper.isInvalidInt(quantity)) {
            return null;
        }

        if (Helper.isInvalidDouble(itemPrice)) {
            return null;
        }

        String salesItemID = Helper.generateID();

        return new SalesItem.Builder()
                .setSalesItemID(salesItemID)
                .setSales(sales)
                .setProduct(product)
                .setQuantity(quantity)
                .setItemPrice(itemPrice)
                .build();
    }
}
