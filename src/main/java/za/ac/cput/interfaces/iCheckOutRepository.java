package za.ac.cput.interfaces;

import za.ac.cput.domain.CheckOut;

import java.util.Set;

public interface iCheckOutRepository {
    Set<CheckOut> getAll();
}
