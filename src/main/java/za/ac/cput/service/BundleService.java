package za.ac.cput.service;
/* BundleService.java
 Entity for the BundleService
 Author: Reece Bergstedt - 221075240
 Date: 10 June 2023
*/
import za.ac.cput.domain.Bundle;

import java.util.Set;

public interface BundleService extends IService<Bundle, String>{
    Set<Bundle> getAll();
}

