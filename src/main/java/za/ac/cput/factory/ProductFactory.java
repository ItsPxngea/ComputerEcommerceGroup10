package za.ac.cput.factory;
/* ProductFactory.java
 Entity for the ProductFactory
 Author: Reece Bergstedt - 221075240
 Date: 22 March 2023
*/

import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;


public class ProductFactory {

    public static Product buildProduct(String productName, String productType, String productDescription, double productPrice) {
        if (Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(productType) || Helper.isNullOrEmpty(productDescription)) {
            return null;
        }

        if(Helper.isInvalidDouble(productPrice)){
            return null;
        }

        String productID = Helper.generateProductID(productName, productType);

        return new Product.Builder()
                .setProductID(productID)
                .setProductName(productName)
                .setProductPrice(productPrice)
                .setProductType(productType)
                .setProductDescription(productDescription)
                .build();
    }

}



