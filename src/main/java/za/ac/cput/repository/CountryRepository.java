package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Country;

public interface CountryRepository extends JpaRepository<Country,String> {
}
