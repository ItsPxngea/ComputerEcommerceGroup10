package za.ac.cput.domain;

import java.util.Date;
import java.util.Objects;
/*
Author: Alexander Draai - 220118744
This is the Pojo + Builder for the Invoice Class.
Date: 04 - 04 - 2023
 */
public class Invoice {
    private String invoiceNumber ;
    private String productID ;
    private String storeID ;
    private String productName ;
    private String productDescription ;
    private int quantity ;
    private Double price ;
    private Double totalPrice ;
    private int tax ;
    private String dateOfTransaction ;

    public Invoice(){}

    public String getInvoiceNumber() {return invoiceNumber;}
    public String getProductID() {return productID;}
    public String getStoreID() {return storeID;}
    public String getProductName() {return productName;}
    public String getProductDescription() {return productDescription;}
    public int getQuantity() {return quantity;}
    public Double getPrice() {return price;}
    public Double getTotalPrice() {return totalPrice;}
    public int getTax() {return tax;}
    public String getDateOfTransaction() {return dateOfTransaction;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return quantity == invoice.quantity && tax == invoice.tax && Objects.equals(invoiceNumber, invoice.invoiceNumber) && Objects.equals(productID, invoice.productID) && Objects.equals(storeID, invoice.storeID) && Objects.equals(productName, invoice.productName) && Objects.equals(productDescription, invoice.productDescription) && Objects.equals(price, invoice.price) && Objects.equals(totalPrice, invoice.totalPrice) && Objects.equals(dateOfTransaction, invoice.dateOfTransaction);
    }
    @Override
    public int hashCode() {
        return Objects.hash(invoiceNumber, productID, storeID, productName, productDescription, quantity, price, totalPrice, tax, dateOfTransaction);
    }
    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNo='" + invoiceNumber + '\'' +
                ", productID='" + productID + '\'' +
                ", storeID='" + storeID + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", tax=" + tax +
                ", dateOfTransaction=" + dateOfTransaction +
                '}';
    }


    private Invoice (Builder builder){
        this.invoiceNumber = builder.invoiceNumber;
        this.productID = builder.productID;
        this.storeID = builder.storeID;
        this.productName = builder.productName;
        this.productDescription = builder.productDescription;
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.totalPrice = builder.totalPrice;
        this.tax = builder.tax;
        this.dateOfTransaction = builder.dateOfTransaction;
    }

    public static class Builder {
        private String invoiceNumber ;
        private String productID ;
        private String storeID ;
        private String productName ;
        private String productDescription ;
        private int quantity ;
        private Double price ;
        private Double totalPrice ;
        private int tax ;
        private String dateOfTransaction ;

        public Builder setInvoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }
        public Builder setProductID(String productID) {
            this.productID = productID;
            return this;
        }
        public Builder setStoreID(String storeID) {
            this.storeID = storeID;
            return this;
        }
        public Builder setProductName(String product){
            this.productName = product;
            return this;
        }
        public Builder setProductDescription(String productDescription){
            this.productDescription = productDescription;
            return this;
        }
        public Builder setQuantity (int  quantity){
            this.quantity = quantity;
            return this;
        }
        public Builder setPrice (double price){
            this.price = price;
            return this;
        }
        public Builder setTotalPrice(double totalPrice){
            this.totalPrice = totalPrice;
            return this;
        }
        public Builder setTax (int tax){
            this.tax = tax;
            return this;
        }
        public Builder setDateOfTransaction(String dateOfTransaction){
            this.dateOfTransaction = dateOfTransaction;
            return this;
        }

        public Builder copy(Invoice invoice){
            this.invoiceNumber = invoice.invoiceNumber;
            this.productID = invoice.productID;
            this.storeID = invoice.storeID;
            this.productName = invoice.productName;
            this.productDescription = invoice.productDescription;
            this.quantity = invoice.quantity;
            this.price = invoice.price;
            this.totalPrice = invoice.totalPrice;
            this.tax = invoice.tax;
            this.dateOfTransaction = invoice.dateOfTransaction;
            return this;
        }

        public Invoice build() {
            return new Invoice(this);
        }

    }

}
