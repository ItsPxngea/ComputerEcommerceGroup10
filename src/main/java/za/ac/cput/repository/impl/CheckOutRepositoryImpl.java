package za.ac.cput.repository.impl;
/*
    Author: David Garrancho
    This is Checkout Repository
    Date: 02 - 04 - 2022
 */

import java.util.HashSet;
import java.util.Set;

public class CheckOutRepositoryImpl implements za.ac.cput.repository.CheckOutRepository {

    private Set<za.ac.cput.domain.CheckOut> checkOutDB = null;
    private static CheckOutRepositoryImpl repo = null;

    private CheckOutRepositoryImpl() {
        checkOutDB = new HashSet<za.ac.cput.domain.CheckOut>();
    }

    public static CheckOutRepositoryImpl getRepo() {
        if (repo == null) {
            repo = new CheckOutRepositoryImpl();
        }
        return repo;
    }

    public za.ac.cput.domain.CheckOut create(za.ac.cput.domain.CheckOut checkOut) {
        boolean success = checkOutDB.add(checkOut);
        if (!success) {
            return null;
        }
        return checkOut;
    }

    public za.ac.cput.domain.CheckOut read(String checkOutID) {
        za.ac.cput.domain.CheckOut checkOut = checkOutDB.stream()
                .filter(e -> e.getCheckOutID().equals(checkOutID))
                .findAny()
                .orElse(null);
        return checkOut;

    }

    public za.ac.cput.domain.CheckOut update(za.ac.cput.domain.CheckOut checkOut) {
        za.ac.cput.domain.CheckOut previousCheckOut = read(checkOut.getCheckOutID());
        if (previousCheckOut != null) {
            checkOutDB.remove(previousCheckOut);
            checkOutDB.add(checkOut);
            return checkOut;
        }
        return null;
    }

    public boolean delete(String checkOutID) {
        za.ac.cput.domain.CheckOut checkOutDelete = read(checkOutID);
        if (checkOutDelete == null) {
            return false;
        }
        checkOutDB.remove(checkOutDelete);
        return true;
    }

    @Override
    public Set<za.ac.cput.domain.CheckOut> getAll() {
        return checkOutDB;
    }


}
