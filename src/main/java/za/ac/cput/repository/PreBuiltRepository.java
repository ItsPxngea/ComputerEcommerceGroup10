package za.ac.cput.repository;
/*
    Author: Michael Johnson
    This is Pre-Built Repository
    Date: 02 - 04 - 2022
 */
import za.ac.cput.domain.PreBuilt;

import java.util.Set;

public interface PreBuiltRepository {
    Set<PreBuilt> getAll();
}
