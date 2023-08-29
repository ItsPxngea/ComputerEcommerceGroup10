package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Supplier;

import java.util.List;
import java.util.Set;
/*
    Author: Ethan Botes
    This is SupplierRepository
    Date: 02 - 04 - 2022
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {
}
