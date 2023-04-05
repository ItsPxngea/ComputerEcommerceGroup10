package za.ac.cput.interfaces;

import za.ac.cput.domain.Supplier;

import java.util.Set;

public interface iSupplierRepository{
    public Set<Supplier> getAll();
}
