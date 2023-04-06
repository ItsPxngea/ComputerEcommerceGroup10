package za.ac.cput.factory;

import za.ac.cput.domain.Bundle;
import za.ac.cput.util.Helper;


public class BundleFactory {

    public static Bundle buildBundle(String bundleName, String bundleType, String bundleDescription, int bundleQuantity, String bundleWarranty, String bundleCategory, String reviewComment, String reviewDate, String reviewRating, double bundlePrice, String productName) {
        if (Helper.isNullOrEmpty(bundleName) || Helper.isNullOrEmpty(bundleType) || Helper.isNullOrEmpty(bundleDescription) || Helper.isNullOrEmpty(bundleWarranty) || Helper.isNullOrEmpty(bundleCategory) || Helper.isNullOrEmpty(reviewRating) || Helper.isNullOrEmpty(reviewComment) || Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(reviewDate) || Helper.isInvalidInt(bundleQuantity)) {
            return null;
        }


        if(Helper.isInvalidDouble(bundlePrice)){
            return null;
        }


        if(!Helper.isValidDate(reviewDate)){
            return null;
        }

        String bundleID = Helper.generateBundleID(bundleName, bundleType, bundleCategory);
        String productCategory = "System";
        String productType = "Business";// What is product type?
        String productID = Helper.generateProductID(productName, productType, productCategory);

        return new Bundle.Builder().setBundleID(bundleID)
                .setBundleID(bundleID)
                .setBundleName(bundleName)
                .setBundleQuantity(bundleQuantity)
                .setBundlePrice(bundlePrice)
                .setBundleType(bundleType)
                .setBundleDescription(bundleDescription)
                .setBundleWarranty(bundleWarranty)
                .setBundleCategory(bundleCategory)
                .setProductID(productID)
                .setProductName(productName)
                .setReviewComment(reviewComment)
                .setReviewDate(reviewDate)
                .setReviewRating(reviewRating)
                .build();
    }
}

