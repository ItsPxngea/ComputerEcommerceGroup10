package za.ac.cput.interfaces;
import za.ac.cput.domain.Enquiry;
import za.ac.cput.domain.StoreDetails;
import java.util.Set;
public interface iStoryDetailsRepository {
    public Set<StoreDetails> getAll();
}
