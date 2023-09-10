package za.ac.cput.factory;

import org.apache.commons.digester.annotations.rules.FactoryCreate;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.util.Helper;

/*
Author: Alexander Draai - 220118744
This is the factory for Address
Date: 19 - 08 - 2023
 */

public class AddressFactory {

    public static Address buildAddress(String streetAddress, String postalCode, City city){


        if ( Helper.isNullOrEmpty(streetAddress) ||
             Helper.isNullOrEmpty(postalCode)){
             return null ;
        }
        String addressID = Helper.generateID();

        return new Address.Builder().setAddressID(addressID)
                                    .setStreetAddress(streetAddress)
                                    .setPostalCode(postalCode)
                                    .setCity(city)
                                    .build();
    } // End of Address - buildAddress


}
