package za.ac.cput.interfaces;

/*
Interface file for CheckOut repository, containing the getAll method
Author: Michael Johnson, 221094040
Date: 06/04/2023
*/

import za.ac.cput.domain.CheckOut;

import java.util.Set;

public interface iCheckOutRepository {
    Set<CheckOut> getAll();
}
