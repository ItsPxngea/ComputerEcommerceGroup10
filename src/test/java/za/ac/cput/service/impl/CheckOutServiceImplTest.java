package za.ac.cput.service.impl;
/*
CheckOutServiceImpl.java
Test for the CheckOutService entity
Author: Michael Daniel Johnson 221094040
Date: 11/06/2023
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.CheckOut;
import za.ac.cput.factory.CheckOutFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CheckOutServiceImplTest {

    private static CheckOutServiceImpl checkOutService = CheckOutServiceImpl.getService();

    private  static CheckOut checkOut = CheckOutFactory.buildCheckOut("GTX850", 5, 4500.00, 22500.00, 3375);

    @Test
    void a_create() {
        CheckOut created = checkOutService.create(checkOut);
        assertEquals(checkOut.getCheckOutID(), created.getCheckOutID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        CheckOut read =  checkOutService.read(checkOut);
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        CheckOut updated = new CheckOut.Builder().copy(checkOut)
                .setProductName("Razor")
                .setProductPrice(2500)
                .build();
        assertNotNull(checkOutService.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = checkOutService.delete(checkOut);
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(checkOutService.getAll());
    }
}