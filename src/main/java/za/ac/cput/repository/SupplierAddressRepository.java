package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.SupplierAddress;

@Repository
public interface SupplierAddressRepository extends JpaRepository<SupplierAddress,String> {
}
