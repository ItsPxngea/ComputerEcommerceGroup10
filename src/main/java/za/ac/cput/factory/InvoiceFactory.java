package za.ac.cput.factory;

import za.ac.cput.domain.Invoice;
import za.ac.cput.util.Helper;

import java.util.Date;
/*
Author: Alexander Draai - 220118744
This is the factory for Invoice Class
Date: 04 - 04 - 2023
 */
public class InvoiceFactory {
    public static Invoice buildInvoice(String invoiceNumber, String productID, String storeID, String productName, String productDescription,
                                       int quantity, Double price, Double totalPrice, int tax, Date dateOfTransaction)
    {
        if (Helper.isNullOrEmpty(invoiceNumber) || Helper.isNullOrEmpty(productID) ||
            Helper.isNullOrEmpty(storeID) || Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(productDescription) ) {
            return null;
        }

        if(Helper.isInvalidInt(quantity) || Helper.isInvalidInt(tax)){
            return null;
        }

        if (Helper.isInvalidDouble(price) || Helper.isInvalidDouble(totalPrice)) {
            return null;
        }

        // What do I do with the date provided ?

        String InvoiceNumber = Helper.generateInvoiceNumber(productName);

        return new Invoice.Builder().setInvoiceNumber(InvoiceNumber)
                                    .setProductID(productName)
                                    .setStoreID(storeID)
                                    .setProductName(productName)
                                    .setProductDescription(productDescription)
                                    .setQuantity(quantity)
                                    .setPrice(price)
                                    .setTotalPrice(totalPrice)
                                    .setTax(tax).setDateOfTransaction(dateOfTransaction)
                                    .build();
    }

}
