package za.ac.cput.factory;

import za.ac.cput.domain.CheckOut;
import za.ac.cput.util.Helper;

public class CheckOutFactory {
    public static CheckOut checkOut(String checkOutID,String customerID,String productID,String productName,String productQuantity,double productPrice,double totalPrice, double tax){
        if (Helper.isNullOrEmpty(checkOutID) || Helper.isNullOrEmpty(customerID) || Helper.isNullOrEmpty(productID) || Helper.isNullOrEmpty(productName) || Helper.isInvalidDouble(productPrice) || Helper.isInvalidDouble(totalPrice) || Helper.isInvalidDouble(tax)){
            return null;
        }

        String firstName = "Jeff";
        String lastName = "Bezos";
        checkOutID = Helper.generateID();
        customerID = Helper.generateCustomerID(firstName, lastName);
        productID = Helper.generateID();

        return new CheckOut.Builder().setCheckOutID(checkOutID)
                .setCustomerID(customerID)
                .setProductID(productID)
                .setProductName(productName)
                .setProductPrice(productPrice)
                .setTotalPrice(totalPrice)
                .setTax(tax)
                .build();

    }
}
