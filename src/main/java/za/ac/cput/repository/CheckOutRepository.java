package za.ac.cput.repository;
/*
    Author: Michael Daniel Johnson
    This is Checkout Repository
    Date: 02 - 04 - 2022
 */
import za.ac.cput.domain.CheckOut;

import java.util.Set;

public interface CheckOutRepository {
    Set<CheckOut> getAll();
}
