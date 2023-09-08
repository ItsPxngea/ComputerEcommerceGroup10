package za.ac.cput.factory;
/*
    Author: Hanno Visser Immelman 221074414
    This is the test class for StoreDetails Factory
    Date: 06 - 04 - 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Country;
import za.ac.cput.domain.StoreDetails;
import static org.junit.jupiter.api.Assertions.*;

class StoreDetailsFactoryTest {

    private static Country southAfrica = CountryFactory.createCountry(
            "South Africa"
    );
    private static City homeCity = CityFactory.createCity(
            "Cape Town",
            southAfrica
    );
    private static Address homeAddress = AddressFactory.buildAddress(
            "53 Main Road",
            "6045",
            homeCity
    );

    @Test
    void createStoreDetails(){
        StoreDetails sd = StoreDetailsFactory.buildStoreDetails("PC Warehouse",homeAddress,"0895643684","PCWarehouseStore@gmail.com");
        System.out.println(sd.toString());
        assertNotNull(sd);
    }

    @Test
    void emptyParameters1(){
        StoreDetails sd = StoreDetailsFactory.buildStoreDetails("",homeAddress,"0895643684","PCWarehouseStore@gmail.com");
        assertNull(sd);
    }

    @Test
    void invalidTel(){
        StoreDetails sd = StoreDetailsFactory.buildStoreDetails("PC Warehouse",homeAddress,"654","PCWarehouseStore@gmail.com");
        assertNull(sd);
    }

    @Test
    void invalidEmail(){
        StoreDetails sd = StoreDetailsFactory.buildStoreDetails("PC Warehouse",homeAddress,"0895643684","PCWarehouseStore@gmail");
        assertNull(sd);
    }

    @Test
    void testEquality(){
        StoreDetails sd1 = StoreDetailsFactory.buildStoreDetails("PC Warehouse",homeAddress,"0895643684","PCWarehouseStore@gmail.com");
        StoreDetails sd2 = StoreDetailsFactory.buildStoreDetails("PC Mark",homeAddress,"0895643684","PCMarkStore@gmail.com");
        System.out.println(sd1.toString());
        System.out.println(sd2.toString());
        assertNotEquals(sd1,sd2);
    }

    @Test
    void testEquality2(){
        StoreDetails sd1 = StoreDetailsFactory.buildStoreDetails("PC Warehouse",homeAddress,"0895643684","PCWarehouseStore@gmail.com");
        StoreDetails sd2 = sd1;
        System.out.println(sd1.toString());
        assertEquals(sd1,sd2);
    }



}
