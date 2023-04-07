package za.ac.cput.interfaces;
/*
    Author: Michael Johnson
    This is CheckOut Repository
    Date: 02 - 04 - 2022
 */
import za.ac.cput.domain.CheckOut;

import java.util.Set;

public interface iCheckOutRepository {
    Set<CheckOut> getAll();
}
