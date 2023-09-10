package za.ac.cput.service.impl;
/*
Ethan Botes - 220101299
This is the SupplierOrderImpl Test
Date: 11 - 060 2023
 */
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SupplierOrderServiceImplTest {

    @Autowired
    private SupplierOrderServiceImpl service;

    private final static Country southAfrica = CountryFactory.createCountry(
            "South Africa"
    );
    private final static City homeCity = CityFactory.createCity(
            "Cape Town",
            southAfrica
    );
    private final static Address homeAddress = AddressFactory.buildAddress(
            "53 Main Road",
            "6045",
            homeCity
    );

    private final static Supplier supplier = SupplierFactory.buildSupplier
            ("supplier@intel.com",
                    "0214564389",
                    homeAddress,
                    "Intel");

    private static final List<Product> products = Arrays.asList(
            ProductFactory.buildProduct("FX 3060", "Item", "Next Generation gaming with the RTX 3060 TI", 3000.00),
            ProductFactory.buildProduct("RX 4050", "Item", "Next Generation gaming with the RTX 4050", 4800.00)
    );

    private static final SupplierOrder supplierOrder = SupplierOrderFactory.buildSupplierOrder
            ("06-01-2022", "12-01-2022", "11-01-2022",
                    120.00, 12120.00, 2, 6000.00, products, supplier);

    @Test
    @Order(1)
  // @Transactional
    void a_create() {
        SupplierOrder created = service.create(supplierOrder);
        assertEquals(supplierOrder.getOrderID(), created.getOrderID());
        System.out.println(supplierOrder.getOrderID() + " Created " + created);
    }

    @Test
    @Order(2)
  //  @Transactional
    void b_read() {
        SupplierOrder read = service.read(supplierOrder.getOrderID());

        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
 //   @Transactional
    void c_update(){
        SupplierOrder updated = new SupplierOrder.Builder().copy(supplierOrder)
                .setImportTax(100.00)
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
  //  @Order(4)
  //  @Transactional
    @Disabled
    void e_delete(){
        boolean success = service.delete(supplierOrder.getOrderID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    @Order(4)
  //  @Transactional
    void d_getAll(){
        System.out.println("Show all: " + service.getAll());
    }

}