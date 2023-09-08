package za.ac.cput.service;

import za.ac.cput.domain.StoreAddress;
import java.util.List;

public interface StoreAddressService extends IService<StoreAddress, String> {
    List<StoreAddress> getAll();
}
