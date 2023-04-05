package za.ac.cput.domain;

import java.util.Objects;

public class SupplierOrder {

    public String supplierID;
    public String productID;
    public int productQuantity;
    public double productPrice;
    private String orderID;
    private String dateOfOrder;
    private String expectedDeliveryDate;
    private String actualDeliveryDate;
    private double importTax;
    private double totalCost;

    public SupplierOrder(String supplierID, String productID,
                         int productQuantity, double productPrice,
                         String orderID, String dateOfOrder,
                         String expectedDeliveryDate,
                         String actualDeliveryDate, double importTax, double totalCost) {
        this.supplierID = supplierID;
        this.productID = productID;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.orderID = orderID;
        this.dateOfOrder = dateOfOrder;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.actualDeliveryDate = actualDeliveryDate;
        this.importTax = importTax;
        this.totalCost = totalCost;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getProductID() {
        return productID;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public String getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public String getActualDeliveryDate() {
        return actualDeliveryDate;
    }

    public double getImportTax() {
        return importTax;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public void setActualDeliveryDate(String actualDeliveryDate) {
        this.actualDeliveryDate = actualDeliveryDate;
    }

    public void setImportTax(double importTax) {
        this.importTax = importTax;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierOrder that = (SupplierOrder) o;
        return productQuantity == that.productQuantity && Double.compare(that.productPrice, productPrice) == 0 && Double.compare(that.importTax, importTax) == 0 && Double.compare(that.totalCost, totalCost) == 0 && Objects.equals(supplierID, that.supplierID) && Objects.equals(productID, that.productID) && Objects.equals(orderID, that.orderID) && Objects.equals(dateOfOrder, that.dateOfOrder) && Objects.equals(expectedDeliveryDate, that.expectedDeliveryDate) && Objects.equals(actualDeliveryDate, that.actualDeliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierID, productID, productQuantity, productPrice, orderID, dateOfOrder, expectedDeliveryDate, actualDeliveryDate, importTax, totalCost);
    }

    @Override
    public String toString() {
        return "SupplierOrder{" +
                "supplierID='" + supplierID + '\'' +
                ", productID='" + productID + '\'' +
                ", productQuantity=" + productQuantity +
                ", productPrice=" + productPrice +
                ", orderID='" + orderID + '\'' +
                ", dateOfOrder='" + dateOfOrder + '\'' +
                ", expectedDeliveryDate='" + expectedDeliveryDate + '\'' +
                ", actualDeliveryDate='" + actualDeliveryDate + '\'' +
                ", importTax=" + importTax +
                ", totalCost=" + totalCost +
                '}';
    }


    public SupplierOrder(Builder b){

    }


    public static class Builder{

        public String supplierID;
        public String productID;
        public int productQuantity;
        public double productPrice;
        private String orderID;
        private String dateOfOrder;
        private String expectedDeliveryDate;
        private String actualDeliveryDate;
        private double importTax;
        private double totalCost;



        public Builder setSupplierID(String supplierID) {
            this.supplierID = supplierID;
            return this;
        }

        public Builder setProductID(String productID) {
            this.productID = productID;
            return this;
        }

        public Builder setProductQuantity(int productQuantity) {
            this.productQuantity = productQuantity;
            return this;
        }

        public Builder setProductPrice(double productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setDateOfOrder(String dateOfOrder) {
            this.dateOfOrder = dateOfOrder;
            return this;
        }

        public Builder setExpectedDeliveryDate(String expectedDeliveryDate) {
            this.expectedDeliveryDate = expectedDeliveryDate;
            return this;
        }

        public Builder setActualDeliveryDate(String actualDeliveryDate) {
            this.actualDeliveryDate = actualDeliveryDate;
            return this;
        }

        public Builder setImportTax(double importTax) {
            this.importTax = importTax;
            return this;
        }

        public Builder setTotalCost(double totalCost) {
            this.totalCost = totalCost;
            return this;
        }



        public Builder copy(SupplierOrder supplierOrder){
            this.supplierID = supplierOrder.supplierID;
            this.productID = supplierOrder.productID;
            this.productQuantity = supplierOrder.productQuantity;
            this.productPrice = supplierOrder.productPrice;
            this.orderID = supplierOrder.orderID;
            this.dateOfOrder = supplierOrder.dateOfOrder;
            this.expectedDeliveryDate = supplierOrder.expectedDeliveryDate;
            this.actualDeliveryDate = supplierOrder.actualDeliveryDate;
            this.importTax = supplierOrder.importTax;
            this.totalCost = supplierOrder.totalCost;
            return this;
        }

        public SupplierOrder build(){
            return new SupplierOrder(this);
        }

    }


}
