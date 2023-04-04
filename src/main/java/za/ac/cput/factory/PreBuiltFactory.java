package za.ac.cput.factory;

import za.ac.cput.domain.PreBuilt;
import za.ac.cput.util.Helper;

import java.util.Date;

public class PreBuiltFactory {
    public static PreBuilt buildPreBuilt(String productName, String reviewComment, String reviewRating, Date reviewDate, String buildCategory, String buildType, String buildWarranty) {
        if (Helper.isNullOrEmpty(productName) || (Helper.isNullOrEmpty(reviewComment)) || (Helper.isNullOrEmpty(reviewRating)) || Helper.isNullOrEmpty(buildCategory) || Helper.isNullOrEmpty(buildCategory) || Helper.isNullOrEmpty(buildType) || Helper.isNullOrEmpty(buildWarranty) || Helper.isNullOrEmpty(buildType)) {

            return null;
        }


        String preBuiltID = Helper.generateID();
        String productID = Helper.generateID();
        String buildName = "Freezing Blizzard";
        String lastName = "Joe";
        double buildPrice = 2000;

        return new PreBuilt.Builder().setBuildID(preBuiltID)
                .setBuildCategory(buildCategory)
                .setBuildName(buildName)
                .setBuildType(buildType)
                .setBuildPrice(buildPrice)
                .setBuildWarranty(buildWarranty)
                .setProductName(productName)
                .setProductID(productID)
                .build();


    }
}
