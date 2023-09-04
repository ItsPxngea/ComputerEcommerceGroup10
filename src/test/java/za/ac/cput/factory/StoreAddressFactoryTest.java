package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import static org.junit.jupiter.api.Assertions.*;

class StoreAddressFactoryTest {
    private static final StoreDetails storeDetails = StoreDetailsFactory.buildStoreDetails("Walmart","29 Dean Street","0817629877","221094040@mycput.ac.za");

    private static final Country country = CountryFactory.createCountry("South Africa");

    private static final City city = CityFactory.createCity("Cairo",country);

    private static final Address address = AddressFactory.buildAddress("420 Road","7780",city);

    @Test
    void build() {
        StoreAddress storeAddress = StoreAddressFactory.build(address,storeDetails);
        System.out.println(storeAddress.toString());
        assertNotNull(storeAddress);
    }
}