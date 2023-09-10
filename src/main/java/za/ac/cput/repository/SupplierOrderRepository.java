package za.ac.cput.repository;
/*
    Author: Ethan Botes
    This is Supplier Order Repository
    Date: 02 - 04 - 2022
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.SupplierOrder;

import java.util.Set;

@Repository
public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, String> {

}
