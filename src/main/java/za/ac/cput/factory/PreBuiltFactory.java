package za.ac.cput.factory;

/*
PreBuiltFactory.java
A class for the PreBuilt.java class
Author: Michael Daniel Johnson, 221094040
Date: 04/04/2023

*/


import za.ac.cput.domain.PreBuilt;
import za.ac.cput.util.Helper;

import java.util.Date;

public class PreBuiltFactory {
    public static PreBuilt buildPreBuilt(String productName, String reviewComment, String reviewRating, /*Date reviewDate,*/ String buildCategory, String buildType, String buildWarranty, double buildPrice) {

        if (Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(reviewComment) || Helper.isNullOrEmpty(reviewRating) || Helper.isNullOrEmpty(buildCategory) || Helper.isNullOrEmpty(buildCategory) || Helper.isNullOrEmpty(buildType) || Helper.isNullOrEmpty(buildWarranty) || Helper.isNullOrEmpty(buildType) || Helper.isInvalidDouble(buildPrice)) {

            return null;
        }


        String preBuiltID = Helper.generateID();
        String productID = Helper.generateID();
        String buildName = "Freezing Blizzard";
        String lastName = "Joe";

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
