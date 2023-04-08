package za.ac.cput.factory;
/*
Author: Michael Johnson
This is the checkout class.
Date: 04 - 04 - 2023
 */
import za.ac.cput.domain.CheckOut;
import za.ac.cput.util.Helper;

public class CheckOutFactory {
    public static CheckOut buildCheckOut(String productName,int productQuantity,double productPrice,double totalPrice, double tax){
        if ( Helper.isNullOrEmpty(productName) || Helper.isInvalidInt(productQuantity) ||
             Helper.isInvalidDouble(productPrice) || Helper.isInvalidDouble(totalPrice) ||
             Helper.isInvalidDouble(tax)){
            return null;
        }

        String firstName = "Jeff";
        String lastName = "Bezos";
        String checkOutID = Helper.generateID();
        String customerID = Helper.generateCustomerID(firstName, lastName);
        String productID = Helper.generateID();

        return new CheckOut.Builder().setCheckOutID(checkOutID)
                .setCustomerID(customerID)
                .setProductID(productID)
                .setProductQuantity(productQuantity)
                .setProductName(productName)
                .setProductPrice(productPrice)
                .setTotalPrice(totalPrice)
                .setTax(tax)
                .build();
    }
}
