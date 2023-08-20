package za.ac.cput.factory;

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
