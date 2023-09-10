package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceFactoryTest {

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
    Customer customer_one = CustomerFactory.buildCustomer("Alexander", "Draai", "alec.draai@gmail.com", "AlexDraai143");
    Sales sales_one = SalesFactory.buildSales("20-08-2023",4000.00,customer_one);
    StoreDetails storeDetails_one = StoreDetailsFactory.buildStoreDetails("Evetech",homeAddress,"021 445 9912","techEve@gmail.com");

    Customer customer_two = CustomerFactory.buildCustomer("Jonathan", "Draai", "jonno.draai@gmail.com", "Batman143");
    Sales sales_two = SalesFactory.buildSales("20-07-2023",60000.00,customer_two);
    StoreDetails storeDetails_two = StoreDetailsFactory.buildStoreDetails("Incredible Connection",homeAddress,"021 555 9902","credible@outlook.com");

    Invoice invoice_one = InvoiceFactory.buildInvoice(storeDetails_one,sales_one);
    Invoice invoice_two = InvoiceFactory.buildInvoice(storeDetails_two,sales_two);
    @Test
    void createInvoice(){
        Invoice invoice = InvoiceFactory.buildInvoice(storeDetails_one,sales_one);
        System.out.println(invoice.toString());
        assertNotNull(invoice);
    }

    @Test
    void testEquality(){
        System.out.println(invoice_one.toString());
        System.out.println(invoice_two.toString());
        assertEquals(invoice_two,invoice_two);
    }

}