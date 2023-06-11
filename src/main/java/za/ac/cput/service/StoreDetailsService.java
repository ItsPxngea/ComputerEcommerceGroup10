package za.ac.cput.service;
/*
Author: Hanno Visser Immelman 221074414
*/
import za.ac.cput.domain.StoreDetails;

import java.util.Set;

public interface StoreDetailsService extends IService<StoreDetails, String> {
    Set<StoreDetails> getAll();
}
