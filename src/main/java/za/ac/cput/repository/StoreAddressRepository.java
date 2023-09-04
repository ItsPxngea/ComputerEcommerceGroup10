package za.ac.cput.repository;


import org.springframework.stereotype.Repository;
import za.ac.cput.domain.StoreAddress;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StoreAddressRepository extends JpaRepository<StoreAddress, String> {
}
