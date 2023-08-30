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
    private String productType;
    private String productDescription;
    private double productPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<SalesItem> salesItems = new ArrayList<>();

    public Product(){

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


    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.productPrice, productPrice) == 0 && Objects.equals(productID, product.productID) && Objects.equals(productName, product.productName) && Objects.equals(productType, product.productType) && Objects.equals(productDescription, product.productDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, productName, productType, productDescription, productPrice);
    }

    @Override
    public String toString() {
        return "Bundle{" +
                "productType='" + productType + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productID='" + productID + '\'' +
                ", productName='" + productName + '\''
                + '}';
    }

    private Product(Product.Builder p) {
        this.productType = p.productType;
        this.productDescription = p.productDescription;
        this.productPrice = p.productPrice;
        this.productID = p.productID;
        this.productName = p.productName;
    }
    public static class Builder {
        private String productType;
        private String productDescription;
        private double productPrice;
        public String productID;
        public String productName;

        public Product.Builder setProductType(String productType) {
            this.productType = productType;
            return this;
        }

        public Product.Builder setProductDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;

        }

        public Product.Builder setProductPrice(double productPrice) {
            this.productPrice = productPrice;
            return this;

        }

        public Product.Builder setProductID(String productID) {
            this.productID = productID;
            return this;

        }

        public Product.Builder setProductName(String productName) {
            this.productName = productName;
            return this;

        }

        public Product.Builder copy(Product product) {
            this.productType = product.productType;
            this.productDescription = product.productDescription;
            this.productPrice = product.productPrice;
            this.productID = product.productID;
            this.productName = product.productName;
            return this;
        }

        public Product build(){
            return new Product(this);
        }

    }
}

