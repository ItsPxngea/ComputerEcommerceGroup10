package za.ac.cput.service;
/* CheckOutService.java
 Service layer for the CheckOutService class
 Author: Michael Daniel Johnson 221094040
 Date: 11/05/2023
*/

import za.ac.cput.domain.CheckOut;


import java.util.Set;
public interface CheckOutService extends IService<CheckOut, String>{
    Set<CheckOut> getAll();
}
