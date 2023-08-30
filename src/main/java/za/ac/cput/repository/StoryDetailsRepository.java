package za.ac.cput.repository;
/*
    Author: Author: Hanno Visser Immelman 221074414
    This is Story Details Repository
    Date: 02 - 04 - 2022
 */

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.StoreDetails;

import java.util.Set;

@Repository
public interface StoryDetailsRepository {
    public Set<StoreDetails> getAll();
}
