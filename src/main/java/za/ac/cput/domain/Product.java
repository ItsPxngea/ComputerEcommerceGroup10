package za.ac.cput.domain;
/* Product.java
 Entity for the Product
 Author: Reece Bergstedt - 221075240
 Date: 22 March 2023
*/

import java.util.Objects;
import java.util.Date;


public class Product {

    private String productType;
    private String productCategory;
    private String productDescription;
    private int productQuantity;
    private String productBrand;
    private double productPrice;
    private String productWarranty;
    public String productID;
    public String productName;
    public String reviewComment;
    public String reviewDate;
    public String reviewRating;

    private Product(){

    }
    public String getProductType() {
        return productType;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductWarranty() {
        return productWarranty;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public String getReviewRating() {
        return reviewRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productType, product.productType) && Objects.equals(productCategory, product.productCategory) && Objects.equals(productDescription, product.productDescription) && Objects.equals(productQuantity, product.productQuantity) && Objects.equals(productBrand, product.productBrand) && Objects.equals(productPrice, product.productPrice) && Objects.equals(productWarranty, product.productWarranty) && Objects.equals(productID, product.productID) && Objects.equals(productName, product.productName) && Objects.equals(reviewComment, product.reviewComment) && Objects.equals(reviewDate, product.reviewDate) && Objects.equals(reviewRating, product.reviewRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, productCategory, productDescription, productQuantity, productBrand, productPrice, productWarranty, productID, productName, reviewComment, reviewDate, reviewRating);
    }

    @Override
    public String toString() {
        return "Bundle{" +
                "productType='" + productType + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productQuantity='" + productQuantity + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productPrice=" + productPrice +
                ", productWarranty='" + productWarranty + '\'' +
                ", productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", reviewComment='" + reviewComment + '\'' +
                ", reviewDate='" + reviewDate + '\'' +
                ", reviewRating='" + reviewRating + '\'' +
                '}';
    }

    private Product(Product.Builder p) {
        this.productType = p.productType;
        this.productCategory = p.productCategory;
        this.productDescription = p.productDescription;
        this.productQuantity = p.productQuantity;
        this.productBrand = p.productBrand;
        this.productPrice = p.productPrice;
        this.productWarranty = p.productWarranty;
        this.productID = p.productID;
        this.productName = p.productName;
        this.reviewComment = p.reviewComment;
        this.reviewDate = p.reviewDate;
        this.reviewRating = p.reviewRating;
    }
    public static class Builder {
        private String productType;
        private String productCategory;
        private String productDescription;
        private int productQuantity;
        private String productBrand;
        private double productPrice;
        private String productWarranty;
        public String productID;
        public String productName;
        public String reviewComment;
        public String reviewDate;
        public String reviewRating;

        public Product.Builder setProductType(String productType) {
            this.productType = productType;
            return this;
        }

        public Product.Builder setProductCategory(String productCategory) {
            this.productCategory = productCategory;
            return this;

        }

        public Product.Builder setProductDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;

        }

        public Product.Builder setProductQuantity(int productQuantity) {
            this.productQuantity = productQuantity;
            return this;

        }

        public Product.Builder setProductBrand(String productBrand) {
            this.productBrand = productBrand;
            return this;

        }

        public Product.Builder setProductPrice(double productPrice) {
            this.productPrice = productPrice;
            return this;

        }

        public Product.Builder setProductWarranty(String productWarranty) {
            this.productWarranty = productWarranty;
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

        public Product.Builder setReviewComment(String reviewComment) {
            this.reviewComment = reviewComment;
            return this;

        }

        public Product.Builder setReviewDate(String reviewDate) {
            this.reviewDate = reviewDate;
            return this;

        }

        public Product.Builder setReviewRating(String reviewRating) {
            this.reviewRating = reviewRating;
            return this;

        }

        public Product.Builder copy(Product product) {
            this.productType = product.productType;
            this.productCategory = product.productCategory;
            this.productDescription = product.productDescription;
            this.productQuantity = product.productQuantity;
            this.productBrand = product.productBrand;
            this.productPrice = product.productPrice;
            this.productWarranty = product.productWarranty;
            this.productID = product.productID;
            this.productName = product.productName;
            this.reviewComment = product.reviewComment;
            this.reviewDate = product.reviewDate;
            this.reviewRating = product.reviewRating;
            return this;
        }

        public Product build(){
            return new Product(this);
        }

    }
}

