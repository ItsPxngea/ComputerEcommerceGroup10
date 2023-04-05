package za.ac.cput.factory;

import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.SupplierOrder;
import za.ac.cput.util.Helper;

public class SupplierOrderFactory {

 
    public static SupplierOrder buildSupplierOrder(String dateOfOrder, String expectedDeliveryDate, String actualDeliveryDate, double importTax, double totalCost,
                                                   int productQuantity, double productPrice, String supplierID, String productID){

        if (Helper.isNullOrEmpty(dateOfOrder) || Helper.isNullOrEmpty(expectedDeliveryDate) || Helper.isNullOrEmpty(actualDeliveryDate)
        || Helper.isNullOrEmpty(supplierID) || Helper.isNullOrEmpty(productID)) {
            return null;
        }
        if(Helper.isInvalidDouble(importTax) || Helper.isInvalidDouble(totalCost) || Helper.isInvalidDouble(productPrice)){
            return null;
        }
        if(Helper.isInvalidInt(productQuantity)){
            return null;
        }

        String dateFormat  = "yyyy-MM-dd";

        if(!Helper.isValidDate(actualDeliveryDate, dateFormat) || !Helper.isValidDate(expectedDeliveryDate, dateFormat) || !Helper.isValidDate(dateOfOrder, dateFormat)){
            return null;
        }

        String orderID = Helper.generateID();

        return new SupplierOrder.Builder()
                .setSupplierID(supplierID)
                .setDateOfOrder(dateOfOrder)
                .setExpectedDeliveryDate(expectedDeliveryDate)
                .setActualDeliveryDate(actualDeliveryDate)
                .setImportTax(importTax)
                .setTotalCost(totalCost)
                .setProductQuantity(productQuantity)
                .setProductPrice(productPrice)
                .setProductID(productID)
                .setOrderID(orderID)
                .build();

    }

}
