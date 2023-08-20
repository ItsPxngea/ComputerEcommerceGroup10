package za.ac.cput.factory;

import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.util.Helper;

public class CityFactory {

    public static City createCity(String cityName, Country country) {

        if (Helper.isNullOrEmpty(cityName)) {
            return null;
        }
        String ID = Helper.generateID();

        return new City.Builder().setCityID(ID)
                .setCityName(cityName)
                .setCountry(country)
                .build();

    }

}
