package za.ac.cput.service;

import za.ac.cput.domain.StoreDetails;

import java.util.Set;

public interface StoreDetailsService extends IService<StoreDetails, String> {
    Set<StoreDetails> getAll();
}
