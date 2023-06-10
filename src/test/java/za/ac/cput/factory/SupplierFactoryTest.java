package za.ac.cput.factory;
/*
    Author: Ethan Botes
    This is the test class for Supplier Factory
    Date: 06 - 04 - 2022
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SupplierFactoryTest {

    @Test
    void createSupplier() {
        Supplier s = SupplierFactory.buildSupplier("supplier@intel.com",
                "0214564389", "5 Alvin Road, Woodstock", "Intel® Core™ Processors",
                "Intel");
        System.out.println(s.toString());
        assertNotNull(s);
    }

    @Test
    void emptyParameters1() {
        Supplier s = SupplierFactory.buildSupplier("",
                "0214564389", "5 Alvin Road, Woodstock", "Intel® Core™ Processors",
                "Intel");
        assertNull(s);
    }

    @Test
    void emptyParameters2() {
        Supplier s = SupplierFactory.buildSupplier("supplier@intel.com",
                "", "5 Alvin Road, Woodstock", "Intel® Core™ Processors",
                "Intel");
        assertNull(s);
    }

    @Test
    void emptyParameters3() {
        Supplier s = SupplierFactory.buildSupplier("supplier@intel.com",
                "0214564389", "", "Intel® Core™ Processors",
                "Intel");
        assertNull(s);
    }

    @Test
    void emptyParameters4() {
        Supplier s = SupplierFactory.buildSupplier("supplier@intel.com",
                "0214564389", "5 Alvin Road, Woodstock", "",
                "Intel");
        assertNull(s);
    }

    @Test
    void emptyParameters5() {
        Supplier s = SupplierFactory.buildSupplier("supplier@intel.com",
                "0214564389", "5 Alvin Road, Woodstock", "Intel® Core™ Processors",
                "");
        assertNull(s);
    }

    @Test
    void invalidParameters1() {
        Supplier s = SupplierFactory.buildSupplier("supplierintel",
                "0214564389", "5 Alvin Road, Woodstock", "Intel® Core™ Processors",
                "Intel");
        assertNull(s);
    }

    @Test
    void invalidParameters2() {
        Supplier s = SupplierFactory.buildSupplier("supplier@intel.com",
                "021456438999", "5 Alvin Road, Woodstock", "Intel® Core™ Processors",
                "Intel");
        assertNull(s);
    }

    @Test
    void testEquality1() {
        Supplier s = SupplierFactory.buildSupplier("supplier@intel.com",
                "0214564389", "5 Alvin Road, Woodstock", "Intel® Core™ Processors",
                "Intel");
        Supplier s2 = SupplierFactory.buildSupplier("ryzen@technologies.com",
                "0214580649", "12 Treebard Close, Sea Point", "2.4 Zen 3 based",
                "Ryzen");
        System.out.println(s.toString());
        System.out.println(s2.toString());

        assertNotEquals(s, s2);

    }

    @Test
    void testEquality2() {
        Supplier s = SupplierFactory.buildSupplier("supplier@intel.com",
                "021456438999", "5 Alvin Road, Woodstock", "Intel® Core™ Processors",
                "Intel");

        Supplier s2 = s;
        assertEquals(s, s2);

    }


}

