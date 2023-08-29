package za.ac.cput.service;

import za.ac.cput.domain.Country;
import za.ac.cput.domain.SalesItem;

import java.util.List;

public interface SalesItemService extends IService<SalesItem, String>{
    List<SalesItem> getAll();
}
