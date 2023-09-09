package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.StoreAddress;
import za.ac.cput.domain.StoreDetails;
import za.ac.cput.util.Helper;


public class StoreAddressFactory {

    public static StoreAddress build( Address address, StoreDetails storeDetails ) {

        String newStoreAddressID = Helper.generateID();

        return new StoreAddress.Builder()
                .setStoreAddressID(newStoreAddressID)
                .setAddress(address)
                .setStoreDetails(storeDetails)
                .build();
    }



    }


