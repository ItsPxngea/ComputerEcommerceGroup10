package za.ac.cput.interfaces;

import za.ac.cput.domain.CheckOut;

import java.util.*;

public class CheckOutRepository implements iCheckOutRepository {

    private Set<CheckOut> checkOutDB = null;
    private static CheckOutRepository repo = null;

    private CheckOutRepository() {
        checkOutDB = new HashSet<CheckOut>();
    }

    public static CheckOutRepository getRepo() {
        if (repo == null) {
            repo = new CheckOutRepository();
        }
        return repo;
    }

    public CheckOut create(CheckOut checkOut) {
        boolean success = checkOutDB.add(checkOut);
        if (!success) {
            return null;
        }
        return checkOut;
    }

    public CheckOut read(String checkOutID) {
        CheckOut checkOut = checkOutDB.stream()
                .filter(e -> e.getCheckOutID().equals(checkOutID))
                .findAny()
                .orElse(null);
        return checkOut;

    }

    public CheckOut update(CheckOut checkOut) {
        CheckOut previousCheckOut = read(checkOut.getCheckOutID());
        if (previousCheckOut != null) {
            checkOutDB.remove(previousCheckOut);
            checkOutDB.add(checkOut);
            return checkOut;
        }
        return null;
    }

    public boolean delete(String checkOutID) {
        CheckOut checkOutDelete = read(checkOutID);
        if (checkOutDelete == null) {
            return false;
        }
        checkOutDB.remove(checkOutDelete);
        return true;
    }

    @Override
    public Set<CheckOut> getAll() {
        return checkOutDB;
    }


}
