package za.ac.cput.interfaces;

/*
Test file for CheckOut Repository
Author: Michael Johnson, 221094040
Date: 06/04/2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.CheckOut;
import za.ac.cput.factory.CheckOutFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CheckOutRepositoryTest {

    private static CheckOutRepository repo = CheckOutRepository.getRepo();
    private static CheckOut checkOut = CheckOutFactory.buildCheckOut("GTX850", 5, 4500.00, 22500.00, 3375);

    @Test
    void a_create() {
        CheckOut created = repo.create(checkOut);
        assertEquals(checkOut.getCheckOutID(), created.getCheckOutID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        CheckOut read = repo.read(checkOut.getCheckOutID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        CheckOut updated = new CheckOut.Builder().copy(checkOut)
                .setProductName("Razor")
                .setProductPrice(2500)
                .build();
        assertNotNull(repo.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean delete = repo.delete(checkOut.getCheckOutID());
        assertTrue(delete);
        System.out.println("Deleted: " + delete);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repo.getAll());
    }

}