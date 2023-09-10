package za.ac.cput.domain;
/* Product.java
 Entity for the Product
 Author: Reece Bergstedt - 221075240
 Date: 22 March 2023
*/

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Product implements Serializable {

    @Id
    public String productID;

    public String productName;
    public String productType;
    public String productDescription;
    public double productPrice;

     @OneToMany(cascade = CascadeType.ALL)
    private List<SalesItem> salesItems = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<SupplierOrder> supplierOrders = new ArrayList<>();

    public Product(){

    }

    private Product(Builder b) {
        this.productID = b.productID;
        this.productType = b.productType;
        this.productDescription = b.productDescription;
        this.productPrice = b.productPrice;
        this.productName = b.productName;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productID, product.productID) && Objects.equals(productPrice, product.productPrice) && Objects.equals(productName, product.productName) && Objects.equals(productType, product.productType) && Objects.equals(productDescription, product.productDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, productName, productType, productDescription, productPrice);
    }

    @Override
    public String toString() {
        return "Bundle{" +
                ", productID='" + productID + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                "productType='" + productType + '\'' +
                ", productName='" + productName + '\''
                + '}';
    }


    public static class Builder {
        public String productID;
        private String productType;
        private String productDescription;
        private double productPrice;
        public String productName;

        public Builder setProductID(String productID) {
            this.productID = productID;
            return this;

        }
        public Builder setProductType(String productType) {
            this.productType = productType;
            return this;
        }

        public Builder setProductDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;

        }

        public Builder setProductPrice(double productPrice) {
            this.productPrice = productPrice;
            return this;

        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;

        }

        public Builder copy(Product product) {
            this.productID = product.productID;
            this.productType = product.productType;
            this.productDescription = product.productDescription;
            this.productPrice = product.productPrice;
            this.productName = product.productName;
            return this;
        }

        public Product build(){
            return new Product(this);
        }

    }
}

