package za.ac.cput.factory;

/* CountryFactory.java
Factory class for Country.java
Author: Michael Daniel Johnson 221094040
Date: 19 August 2023
*/

import za.ac.cput.domain.Country;
import za.ac.cput.util.Helper;

public class CountryFactory {

    public static Country createCountry(String countryName) {
        if (Helper.isNullOrEmpty(countryName)) {
            return null;
        }
        String countryID = Helper.generateID();
        return new Country.Builder().setCountryName(countryName)
                .setCountryID(countryID)
                .build();
    }
}
