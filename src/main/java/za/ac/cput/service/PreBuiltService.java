package za.ac.cput.service;
/* PreBuilt.java
 Service layer for the PreBuiltService class
 Author: Michael Daniel Johnson 221094040
 Date: 11/05/2023
*/
import za.ac.cput.domain.PreBuilt;

import java.util.Set;
public interface PreBuiltService extends IService<PreBuilt, String>{
    Set<PreBuilt> getAll();
}
