package za.ac.cput.interfaces;

import za.ac.cput.domain.Supplier;

import java.util.Set;
/*
    Author: Ethan Botes
    This is SupplierRepository
    Date: 02 - 04 - 2022
 */
public interface iSupplierRepository{
    public Set<Supplier> getAll();
}
