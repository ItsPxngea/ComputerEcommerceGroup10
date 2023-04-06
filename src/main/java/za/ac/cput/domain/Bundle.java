package za.ac.cput.domain;
/* Bundle.java
 Entity for the Bundle
 Author: Reece Bergstedt - 221075240
 Date: 22 March 2023
*/
import java.util.Objects;



public class Bundle {

    private String bundleType;
    private String bundleCategory;
    private String bundleDescription;
    private int bundleQuantity;
    private double bundlePrice;
    private String bundleWarranty;
    private String bundleID;
    private String bundleName;
    public String productID;
    public String productName;
    public String reviewComment;
    public String reviewDate;
    public String reviewRating;

    public Bundle(){
    }

    public String getBundleType() {
        return bundleType;
    }

    public String getBundleCategory() {
        return bundleCategory;
    }

    public String getBundleDescription() {
        return bundleDescription;
    }

    public  int getBundleQuantity() {
        return bundleQuantity;
    }

    public double getBundlePrice() {
        return bundlePrice;
    }

    public String getBundleWarranty() {
        return bundleWarranty;
    }

    public String getBundleID() {
        return bundleID;
    }

    public String getBundleName() {
        return bundleName;
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
        Bundle bundle = (Bundle) o;
        return Objects.equals(bundleType, bundle.bundleType) && Objects.equals(bundleCategory, bundle.bundleCategory) && Objects.equals(bundleDescription, bundle.bundleDescription) && Objects.equals(bundleQuantity, bundle.bundleQuantity) && Objects.equals(bundlePrice, bundle.bundlePrice) && Objects.equals(bundleWarranty, bundle.bundleWarranty) && Objects.equals(bundleID, bundle.bundleID) && Objects.equals(bundleName, bundle.bundleName) && Objects.equals(productID, bundle.productID) && Objects.equals(productName, bundle.productName) && Objects.equals(reviewComment, bundle.reviewComment) && Objects.equals(reviewDate, bundle.reviewDate) && Objects.equals(reviewRating, bundle.reviewRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bundleType, bundleCategory, bundleDescription, bundleQuantity, bundlePrice, bundleWarranty, bundleID, bundleName, productID, productName, reviewComment, reviewDate, reviewRating);
    }

    @Override
    public String toString() {
        return "Bundle{" +
                "bundleType='" + bundleType + '\'' +
                ", bundleCategory='" + bundleCategory + '\'' +
                ", bundleDescription='" + bundleDescription + '\'' +
                ", bundleQuantity=" + bundleQuantity +
                ", bundlePrice=" + bundlePrice +
                ", bundleWarranty='" + bundleWarranty + '\'' +
                ", bundleID='" + bundleID + '\'' +
                ", bundleName='" + bundleName + '\'' +
                ", productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", reviewComment='" + reviewComment + '\'' +
                ", reviewDate='" + reviewDate + '\'' +
                ", reviewRating='" + reviewRating + '\'' +
                '}';
    }

    private Bundle(Bundle.Builder b) {
        this.bundleType = b.bundleType;
        this.bundleCategory = b.bundleCategory;
        this.bundleDescription = b.bundleDescription;
        this.bundleQuantity = b.bundleQuantity;
        this.bundlePrice = b.bundlePrice;
        this.bundleWarranty = b.bundleWarranty;
        this.bundleID = b.productID; //Davids is also like this for cart
        this.bundleName = b.bundleName;
        this.productID = b.productID;
        this.productName = b.productName;
        this.reviewComment = b.reviewComment;
        this.reviewDate = b.reviewDate;
        this.reviewRating = b.reviewRating;
    }

    public static class Builder {
        private String bundleType;
        private String bundleCategory;
        private String bundleDescription;
        private int bundleQuantity;
        private double bundlePrice;
        private String bundleWarranty;
        private String bundleID;
        private String bundleName;
        public String productID;
        public String productName;
        public String reviewComment;
        public String reviewDate;
        public String reviewRating;


        public Bundle.Builder setBundleType(String bundleType) {
            this.bundleType = bundleType;
            return this;

        }

        public Bundle.Builder setBundleCategory(String bundleCategory) {
            this.bundleCategory = bundleCategory;
            return this;

        }

        public Bundle.Builder setBundleDescription(String bundleDescription) {
            this.bundleDescription = bundleDescription;
            return this;

        }

        public Bundle.Builder setBundleQuantity(int bundleQuantity) {
            this.bundleQuantity = bundleQuantity;
            return this;

        }

        public Bundle.Builder setBundlePrice(double bundlePrice) {
            this.bundlePrice = bundlePrice;
            return this;

        }

        public Bundle.Builder setBundleWarranty(String bundleWarranty) {
            this.bundleWarranty = bundleWarranty;
            return this;

        }

        public Bundle.Builder setBundleID(String bundleID) {
            this.bundleID = bundleID;
            return this;

        }

        public Bundle.Builder setBundleName(String bundleName) {
            this.bundleName = bundleName;
            return this;

        }

        public Bundle.Builder setProductID(String productID) {
            this.productID = productID;
            return this;

        }

        public Bundle.Builder setProductName(String productName) {
            this.productName = productName;
            return this;

        }

        public Bundle.Builder setReviewComment(String reviewComment) {
            this.reviewComment = reviewComment;
            return this;

        }

        public Bundle.Builder setReviewDate(String reviewDate) {
            this.reviewDate = reviewDate;
            return this;

        }

        public Bundle.Builder setReviewRating(String reviewRating) {
            this.reviewRating = reviewRating;
            return this;

        }

        public Bundle.Builder copy(Bundle bundle){
            this.bundleType = bundle.bundleType;
            this.bundleCategory = bundle.bundleCategory;
            this.bundleDescription = bundle.bundleDescription;
            this.bundleQuantity = bundle.bundleQuantity;
            this.bundlePrice = bundle.bundlePrice;
            this.bundleWarranty = bundle.bundleWarranty;
            this.bundleID = bundle.bundleID;
            this.bundleName = bundle.bundleName;
            this.productID = bundle.productID;
            this.productName = bundle.productName;
            this.reviewComment = bundle.reviewComment;
            this.reviewDate = bundle.reviewDate;
            this.reviewRating = bundle.reviewRating;
            return this;
        }

        public Bundle build(){
            return new Bundle(this);
        }

    }
}


