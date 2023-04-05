package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

import java.util.Date;

public class ProductFactory {

    public static Product buildProduct(String productName, String productType, String productDescription, int productQuantity, String productBrand, String productWarranty, String productCategory, String reviewComment, String reviewDate, String reviewRating, double productPrice) {
        if (Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(productType) || Helper.isNullOrEmpty(productDescription) || Helper.isNullOrEmpty(productBrand) || Helper.isNullOrEmpty(productWarranty) || Helper.isNullOrEmpty(productCategory) || Helper.isNullOrEmpty(reviewRating) || Helper.isNullOrEmpty(reviewComment) || Helper.isNullOrEmpty(reviewDate)) {
            return null;
        }

        if(Helper.isInvalidInt(productQuantity)){
            return null;
        }

        if(Helper.isInvalidDouble(productPrice)){
            return null;
        }


        Helper.isValidDate(reviewDate);

        String productID = Helper.generateProductID(productName, productType, productCategory);

        return new Product.Builder().setProductID(productID)
                .setProductID(productID)
                .setProductName(productName)
                .setProductQuantity(productQuantity)
                .setProductPrice(productPrice)
                .setProductType(productType)
                .setProductDescription(productDescription)
                .setProductBrand(productBrand)
                .setProductWarranty(productWarranty)
                .setProductCategory(productCategory)
                .setReviewComment(reviewComment)
                .setReviewDate(reviewDate)
                .setReviewRating(reviewRating)
                .build();
    }
}



