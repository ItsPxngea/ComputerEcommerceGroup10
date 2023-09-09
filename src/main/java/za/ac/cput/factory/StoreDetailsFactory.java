package za.ac.cput.factory;
/*
Author: Hanno Visser Immelman 221074414
*/
import za.ac.cput.domain.Address;
import za.ac.cput.domain.StoreDetails;
import za.ac.cput.util.Helper;
public class StoreDetailsFactory {
    public static StoreDetails buildStoreDetails(String storeName, Address address, String storeTel, String storeEmail){
        if (Helper.isNullOrEmpty(storeName))
            return null;

        if (!Helper.isValidEmail(storeEmail))
            return null;

        String storeID = Helper.generateID();

        return new StoreDetails.Builder().setStoreID(storeID)
                .setStoreName(storeName)
                .setStoreAddress(address)
                .setStoreTel(storeTel)
                .setStoreEmail(storeEmail)
                .build();
    }

    public static StoreDetails buildTestStoreDetails(String id, String storeName, Address address, String storeTel, String storeEmail){
        if (Helper.isNullOrEmpty(storeName))
            return null;



        if (!Helper.isValidEmail(storeEmail))
            return null;

        return new StoreDetails.Builder().setStoreID(id)
                .setStoreName(storeName)
                .setStoreAddress(address)
                .setStoreTel(storeTel)
                .setStoreEmail(storeEmail)
                .build();
    }
}
