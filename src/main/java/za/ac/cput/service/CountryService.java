package za.ac.cput.service;

import za.ac.cput.domain.Country;

import java.util.List;


public interface CountryService extends IService<Country, String>{
    List<Country> getAll();
}
