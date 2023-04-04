package za.ac.cput.domain;
/*
PreBuilt.java
A POJO class for a computer that is already built before purchase
Author: Michael Daniel Johnson, 221094040
Date: 04/04/2023
*/
import java.util.Date;

public class PreBuilt {
    private String buildID;
    private String buildName;
    private String buildType;
    private String buildCategory;
    private String buildDescription;
    private double buildPrice;
    private String buildWarranty;
    public String productID;
    public String productName;
    public String reviewComment;
    public String reviewRating;
    public Date reviewDate;

    public PreBuilt() {
    }

    public String getBuildID() {
        return buildID;
    }

    public String getBuildName() {
        return buildName;
    }

    public String getBuildType() {
        return buildType;
    }

    public String getBuildCategory() {
        return buildCategory;
    }

    public String getBuildDescription() {
        return buildDescription;
    }

    public double getBuildPrice() {
        return buildPrice;
    }

    public String getBuildWarranty() {
        return buildWarranty;
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

    public String getReviewRating() {
        return reviewRating;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    @Override
    public String toString() {
        return "PreBuilt{" + "buildID='" + buildID + '\'' + ", buildName='" + buildName + '\'' + ", buildType='" + buildType + '\'' + ", buildCategory='" + buildCategory + '\'' + ", buildDescription='" + buildDescription + '\'' + ", buildPrice=" + buildPrice + ", buildWarranty='" + buildWarranty + '\'' + ", productID='" + productID + '\'' + ", productName='" + productName + '\'' + ", reviewComment='" + reviewComment + '\'' + ", reviewRating='" + reviewRating + '\'' + ", reviewDate=" + reviewDate + '}';
    }

    private PreBuilt(PreBuilt.Builder b) {
        this.buildID = b.buildID;
        this.buildName = b.buildName;
        this.buildType = b.buildType;
        this.buildCategory = b.buildCategory;
        this.buildPrice = b.buildPrice;
        this.buildDescription = b.buildDescription;
        this.buildWarranty = b.buildWarranty;
        this.productID = b.productID;
        this.productName = b.productName;
        this.reviewComment = b.reviewComment;
        this.reviewRating = b.reviewRating;
        this.reviewDate = b.reviewDate;


    }

    public static class Builder {
        private String buildID;
        private String buildName;
        private String buildType;
        private String buildCategory;
        private String buildDescription;
        private double buildPrice;
        private String buildWarranty;
        public String productID;
        public String productName;
        public String reviewComment;
        public String reviewRating;
        public Date reviewDate;

        public PreBuilt.Builder setBuildID(String buildID) {
            this.buildID = buildID;
            return this;
        }

        public PreBuilt.Builder setBuildName(String buildName) {
            this.buildName = buildName;
            return this;
        }

        public PreBuilt.Builder setBuildType(String buildType) {
            this.buildType = buildType;
            return this;
        }

        public PreBuilt.Builder setBuildCategory(String buildCategory) {
            this.buildCategory = buildCategory;
            return this;
        }

        public PreBuilt.Builder setBuildDescription(String buildDescription) {
            this.buildDescription = buildDescription;
            return this;
        }

        public PreBuilt.Builder setBuildPrice(double buildPrice) {
            this.buildPrice = buildPrice;
            return this;
        }

        public PreBuilt.Builder setBuildWarranty(String buildWarranty) {
            this.buildWarranty = buildWarranty;
            return this;
        }

        public PreBuilt.Builder setProductID(String productID) {
            this.productID = productID;
            return this;
        }

        public PreBuilt.Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public PreBuilt.Builder setReviewComment(String reviewComment) {
            this.reviewComment = reviewComment;
            return this;
        }

        public PreBuilt.Builder setReviewRating(String reviewRating) {
            this.reviewRating = reviewRating;
            return this;
        }

        public PreBuilt.Builder setReviewDate(Date reviewDate) {
            this.reviewDate = reviewDate;
            return this;
        }

        public PreBuilt.Builder copy(PreBuilt preBuilt) {
            this.buildID = preBuilt.buildID;
            this.buildName = preBuilt.buildName;
            this.buildType = preBuilt.buildType;
            this.buildCategory = preBuilt.buildCategory;
            this.buildPrice = preBuilt.buildPrice;
            this.buildDescription = preBuilt.buildDescription;
            this.buildWarranty = preBuilt.buildWarranty;
            this.productID = preBuilt.productID;
            this.productName = preBuilt.productName;
            this.reviewComment = preBuilt.reviewComment;
            this.reviewRating = preBuilt.reviewRating;
            this.reviewDate = preBuilt.reviewDate;
            return this;
        }

        public PreBuilt build() {
            return new PreBuilt(this);
        }

    }


}

