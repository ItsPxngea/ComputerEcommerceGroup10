package za.ac.cput.repository;
/*
    Author: Alexander Draai
    Date: 02 - 04 - 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Invoice;
import za.ac.cput.domain.Sales;

import java.util.List;
import java.util.Set;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {

}
