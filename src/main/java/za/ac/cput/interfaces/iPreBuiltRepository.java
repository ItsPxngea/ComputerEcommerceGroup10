package za.ac.cput.interfaces;
/*
Interface file for PreBuilt repository, containing getAll method
Author: Michael Johnson, 221094040
Date: 06/04/2023
*/

import za.ac.cput.domain.PreBuilt;

import java.util.Set;

public interface iPreBuiltRepository {
    Set<PreBuilt> getAll();
}
