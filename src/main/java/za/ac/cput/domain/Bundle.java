package za.ac.cput.domain;
/* Bundle.java
 Entity for the Bundle
 Author: Reece Bergstedt - 221075240
 Date: 22 March 2023
*/
import java.util.Objects;
import java.util.Date;


public class Bundle {

    private String bundleType;
    private String bundleCategory;
    private String bundleDescription;
    private int bundleQuantity;
    private double bundlePrice;
    private String bundleWarranty;
    private String bundleID;
    private String bundleName;
    private String productID;
    private String productName;
    private String reviewComment;
    private String reviewDate;
    private String reviewRating;

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
                "BundleType='" + bundleType + '\'' +
                ", BundleCategory='" + bundleCategory + '\'' +
                ", BundleDescription='" + bundleDescription + '\'' +
                ", BundleQuantity='" + bundleQuantity + '\'' +
                ", BundlePrice=" + bundlePrice +
                ", BundleWarranty='" + bundleWarranty + '\'' +
                ", BundleID='" + bundleID + '\'' +
                ", BundleName='" + bundleName + '\'' +
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
        this.bundleID = b.bundleID;
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
        private String productID;
        private String productName;
        private String reviewComment;
        private String reviewDate;
        private String reviewRating;


        public Builder setBundleType(String bundleType) {
            bundleType = bundleType;
            return this;

        }

        public Builder setBundleCategory(String bundleCategory) {
            bundleCategory = bundleCategory;
            return this;

        }

        public Builder setBundleDescription(String bundleDescription) {
            bundleDescription = bundleDescription;
            return this;

        }

        public Builder setBundleQuantity(int bundleQuantity) {
            bundleQuantity = bundleQuantity;
            return this;

        }

        public Builder setBundlePrice(double bundlePrice) {
            bundlePrice = bundlePrice;
            return this;

        }

        public Builder setBundleWarranty(String bundleWarranty) {
            bundleWarranty = bundleWarranty;
            return this;

        }

        public Builder setBundleID(String bundleID) {
            bundleID = bundleID;
            return this;

        }

        public Builder setBundleName(String bundleName) {
            bundleName = bundleName;
            return this;

        }

        public Builder setProductID(String productID) {
            this.productID = productID;
            return this;

        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;

        }

        public Builder setReviewComment(String reviewComment) {
            this.reviewComment = reviewComment;
            return this;

        }

        public Builder setReviewDate(String reviewDate) {
            this.reviewDate = reviewDate;
            return this;

        }

        public Builder setReviewRating(String reviewRating) {
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
            this.productID = productID;
            this.productName = productName;
            this.reviewComment = reviewComment;
            this.reviewDate = reviewDate;
            this.reviewRating = reviewRating;
            return this;
        }

        public Bundle build(){
            return new Bundle(this);
        }

    }
}


