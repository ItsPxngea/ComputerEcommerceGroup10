package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.SupplierAddress;
import za.ac.cput.util.Helper;

public class SupplierAddressFactory {
    public static SupplierAddress build(Address address, Supplier supplier){

        String supplierAddressID = Helper.generateID();

        return new SupplierAddress.Builder()
                .setSupplierAddressID(supplierAddressID)
                .setAddress(address)
                .setSupplier(supplier)
                .build();

    }
}
