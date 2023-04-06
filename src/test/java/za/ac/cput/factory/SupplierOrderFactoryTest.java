package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.SupplierOrder;

import static org.junit.jupiter.api.Assertions.*;

class SupplierOrderFactoryTest {

    @Test
    void createSupplierOrder(){
        SupplierOrder sor = SupplierOrderFactory.buildSupplierOrder("2023-01-06", "2023-01-12", "2023-01-12",
                120.00, 12120.00, 2, 6000.00, "Int847");
        System.out.println(sor.toString());
        assertNotNull(sor);
    }

    @Test
    void emptyParameters1(){
        SupplierOrder sor = SupplierOrderFactory.buildSupplierOrder("", "2023-01-12", "2023-01-12",
                120.00, 12120.00, 2, 6000.00, "Int847");
        assertNull(sor);
    }

    @Test
    void emptyParameters2(){
        SupplierOrder sor = SupplierOrderFactory.buildSupplierOrder("2023-01-06", "", "2023-01-12",
                120.00, 12120.00, 2, 6000.00, "Int847");
        assertNull(sor);
    }

    @Test
    void emptyParameters3(){
        SupplierOrder sor = SupplierOrderFactory.buildSupplierOrder("2023-01-06", "2023-01-12", "",
                120.00, 12120.00, 2, 6000.00, "Int847");
        assertNull(sor);
    }

    @Test
    void emptyParameters4(){
        SupplierOrder sor = SupplierOrderFactory.buildSupplierOrder("2023-01-06", "2023-01-12", "2023-01-12",
                120.00, 12120.00, 2, 6000.00, "");
        assertNull(sor);
    }

    @Test
    void invalidParameters1(){
        SupplierOrder sor = SupplierOrderFactory.buildSupplierOrder("2023-01-06", "2023-01-12", "2023-01-12",
                -120.00, 12120.00, 2, 6000.00, "Int847");
        assertNull(sor);
    }

    @Test
    void invalidParameters2(){
        SupplierOrder sor = SupplierOrderFactory.buildSupplierOrder("2023-01-06", "2023-01-12", "2023-01-12",
                120.00, 12120.00, 2, -6000.00, "Int847");
        assertNull(sor);
    }

    @Test
    void invalidParameters3(){
        SupplierOrder sor = SupplierOrderFactory.buildSupplierOrder("2023-01-06", "2023-01-12", "2023-01-12",
                120.00, 12120.00, -2, 6000.00, "Int847");
        assertNull(sor);
    }

    @Test
    void invalidParameters4(){
        SupplierOrder sor = SupplierOrderFactory.buildSupplierOrder("2023-01-06", "2023-01-12", "2023-01-12",
                120.00, -12120.00, 2, 6000.00, "Int847");
        assertNull(sor);
    }

    @Test
    void invalidParametersDate1(){
        SupplierOrder sor = SupplierOrderFactory.buildSupplierOrder("20263-01-06", "2023-01-12", "2023-01-12",
                120.00, 12120.00, 2, 6000.00, "Int847");
        assertNull(sor);
    }
    @Test
    void invalidParametersDate2(){
        SupplierOrder sor = SupplierOrderFactory.buildSupplierOrder("2023-01-06", "2023-31-12", "2023-01-12",
                120.00, 12120.00, 2, 6000.00, "Int847");
        assertNull(sor);
    }

    @Test
    void invalidParametersDate3(){
        SupplierOrder sor = SupplierOrderFactory.buildSupplierOrder("2023-01-06", "2023-01-12", "2023-01-42",
                120.00, 12120.00, 2, 6000.00, "Int847");
        assertNull(sor);
    }


}