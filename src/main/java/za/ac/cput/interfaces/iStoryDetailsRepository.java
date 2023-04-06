package za.ac.cput.interfaces;
/*
Author: Hanno Visser Immelman 221074414
*/
import za.ac.cput.domain.Enquiry;
import za.ac.cput.domain.StoreDetails;
import java.util.Set;
public interface iStoryDetailsRepository {
    public Set<StoreDetails> getAll();
}
