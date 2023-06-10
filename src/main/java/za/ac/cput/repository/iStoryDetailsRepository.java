package za.ac.cput.repository;
/*
    Author: Author: Hanno Visser Immelman 221074414
    This is Story Details Repository
    Date: 02 - 04 - 2022
 */

import za.ac.cput.domain.StoreDetails;
import java.util.Set;
public interface iStoryDetailsRepository {
    public Set<StoreDetails> getAll();
}
