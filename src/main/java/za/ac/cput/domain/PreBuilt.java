package za.ac.cput.domain;
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
        return "PreBuilt{" +
                "buildID='" + buildID + '\'' +
                ", buildName='" + buildName + '\'' +
                ", buildType='" + buildType + '\'' +
                ", buildCategory='" + buildCategory + '\'' +
                ", buildDescription='" + buildDescription + '\'' +
                ", buildPrice=" + buildPrice +
                ", buildWarranty='" + buildWarranty + '\'' +
                ", productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", reviewComment='" + reviewComment + '\'' +
                ", reviewRating='" + reviewRating + '\'' +
                ", reviewDate=" + reviewDate +
                '}';
    }

}

