package za.ac.cput.repository;
/*
    Author: Hanno Visser Immelman 221074414
    Date: 02 - 04 - 2022
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Enquiry;

import java.util.Set;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, String> {
}
