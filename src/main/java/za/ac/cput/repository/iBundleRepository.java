package za.ac.cput.repository;
/*
     Entity for the BundleRepository
     Author: Reece Bergstedt - 221075240
     Date: 22 March 2023
*/
import za.ac.cput.domain.Bundle;

import java.util.Set;

public interface iBundleRepository {

    public Set<Bundle> getAll();

}
