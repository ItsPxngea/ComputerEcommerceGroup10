package za.ac.cput.factory;

/*
    Factory for the SupplierOrder
    Author: Ethan Andrew Botes (220101299)
    Date: 6 April 2023
*/


import za.ac.cput.domain.Product;
import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.SupplierOrder;
import za.ac.cput.util.Helper;

import java.util.List;

public class SupplierOrderFactory {


    public static SupplierOrder buildSupplierOrder(String dateOfOrder, String expectedDeliveryDate, double importTax, double totalCost,
                                                   int productQuantity, List<Product> products, Supplier supplier){

        if (Helper.isNullOrEmpty(dateOfOrder) || Helper.isNullOrEmpty(expectedDeliveryDate)
                ) {
            return null;
        }
        if(Helper.isInvalidDouble(importTax) || Helper.isInvalidDouble(totalCost)){
            return null;
        }
        if(Helper.isInvalidInt(productQuantity)){
            return null;
        }

        String orderID = Helper.generateID();


        if(Helper.isValidDate(expectedDeliveryDate)==null || Helper.isValidDate(dateOfOrder)==null){
            return null;
        }

        return new SupplierOrder.Builder()
                .setSupplier(supplier)
                .setProductQuantity(productQuantity)
                .setDateOfOrder(dateOfOrder)
                .setExpectedDeliveryDate(expectedDeliveryDate)
                .setImportTax(importTax)
                .setTotalCost(totalCost)
                .setProducts(products)
                .build();

    }

}

