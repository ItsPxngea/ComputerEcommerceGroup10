package za.ac.cput.factory;
/*
Author: Hanno Visser Immelman 221074414
*/
import za.ac.cput.domain.StoreDetails;
import za.ac.cput.util.Helper;
public class StoreDetailsFactory {
    public static StoreDetails buildStoreDetails(String storeName, String storeAddress, String storeTel, String storeEmail){
        if (Helper.isNullOrEmpty(storeName) || Helper.isNullOrEmpty(storeAddress))
            return null;

        if (!Helper.isValidPhoneNumber(storeTel))
            return null;

        if (!Helper.isValidEmail(storeEmail))
            return null;

        String storeID = Helper.generateID();

        return new StoreDetails.Builder().setStoreID(storeID)
                .setStoreName(storeName)
                .setStoreAddress(storeAddress)
                .setStoreTel(storeTel)
                .setStoreEmail(storeEmail)
                .build();
    }
}
