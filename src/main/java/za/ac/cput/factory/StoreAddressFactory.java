package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.StoreAddress;
import za.ac.cput.domain.StoreDetails;
import za.ac.cput.util.Helper;


public class StoreAddressFactory {

    public static StoreAddress build(String storeAddressID, Address address, StoreDetails storeDetails ) {

        if (Helper.isNullOrEmpty(storeAddressID)) {
            return null;
        }

        String newStoreAddressID = Helper.generateID();

        return new StoreAddress.Builder()
                .setStoreAddressID(newStoreAddressID)
                .setAddress(address)
                .setStoreDetails(storeDetails)
                .build();
    }



    }


