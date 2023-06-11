package za.ac.cput.domain;
/*
CheckOut.java
A POJO class for user to check out at purchase
Author: Michael Daniel Johnson, 221094040
Date: 04/04/2023
*/
import java.util.Objects;

public class CheckOut {
    private String checkOutID;
    public String customerID;
    public String productID;
    public String productName;
    public int productQuantity;
    public double productPrice;
    public double totalPrice;
    public double tax;

    public String getCheckOutID() {
        return checkOutID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTax() {
        return tax;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckOut checkOut)) return false;
        return productQuantity == checkOut.productQuantity && Double.compare(checkOut.productPrice, productPrice) == 0 && Double.compare(checkOut.totalPrice, totalPrice) == 0 && Double.compare(checkOut.tax, tax) == 0 && checkOutID.equals(checkOut.checkOutID) && customerID.equals(checkOut.customerID) && productID.equals(checkOut.productID) && productName.equals(checkOut.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkOutID, customerID, productID, productName, productQuantity, productPrice, totalPrice, tax);
    }

    @Override
    public String toString() {
        return "CheckOut{" + "checkOutID='" + checkOutID + '\'' + ", customerID='" + customerID + '\'' + ", productID='" + productID + '\'' + ", productName='" + productName + '\'' + ", productQuantity='" + productQuantity + '\'' + ", productPrice=" + productPrice + ", totalPrice=" + totalPrice + ", tax=" + tax + '}';
    }

    private CheckOut(CheckOut.Builder b) {
        this.checkOutID = b.checkOutID;
        this.customerID = b.customerID;
        this.productPrice = b.productPrice;
        this.productID = b.productID;
        this.productName = b.productName;
        this.productQuantity = b.productQuantity;
        this.totalPrice = b.totalPrice;
        this.tax = b.tax;
    }

    public static class Builder {
        private String checkOutID;
        public String customerID;
        public String productID;
        public String productName;
        public int productQuantity;
        public double productPrice;
        public double totalPrice;
        public double tax;


        public CheckOut.Builder setCheckOutID(String checkOutID) {
            this.checkOutID = checkOutID;
            return this;
        }

        public CheckOut.Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public CheckOut.Builder setProductID(String productID) {
            this.productID = productID;
            return this;
        }

        public CheckOut.Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public CheckOut.Builder setProductQuantity(int productQuantity) {
            this.productQuantity = productQuantity;
            return this;
        }

        public CheckOut.Builder setProductPrice(double productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public CheckOut.Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public CheckOut.Builder setTax(double tax) {
            this.tax = tax;
            return this;
        }

        public CheckOut.Builder copy(CheckOut checkOut) {
            this.checkOutID = checkOut.checkOutID;
            this.productPrice = checkOut.productPrice;
            this.customerID = checkOut.customerID;
            this.productID = checkOut.productID;
            this.productQuantity = checkOut.productQuantity;
            this.productName = checkOut.productName;
            this.totalPrice = checkOut.totalPrice;
            this.tax = checkOut.tax;

            return this;
        }

        public CheckOut build() {
            return new CheckOut(this);
            
        }


    }


}
