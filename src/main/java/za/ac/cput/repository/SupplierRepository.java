package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Supplier;

/*
    Author: Ethan Botes
    This is SupplierRepository
    Date: 02 - 04 - 2022
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
