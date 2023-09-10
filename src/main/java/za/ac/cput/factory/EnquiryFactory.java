package za.ac.cput.factory;
/*
Author: Hanno Visser Immelman 221074414
*/
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Enquiry;
import za.ac.cput.util.Helper;
public class EnquiryFactory {
    public static Enquiry buildEnquiry(Customer customer, String enquiryName, String enquirySubjectLine, String enquiryBodyContent){
        if (Helper.isNullOrEmpty(enquiryName) || Helper.isNullOrEmpty(enquirySubjectLine) || Helper.isNullOrEmpty(enquiryBodyContent))
            return null;
        String enquiryID = Helper.generateID();

        return new Enquiry.Builder().setEnquiryID(enquiryID)
                .setCustomer(customer)
                .setEnquiryName(enquiryName)
                .setEnquirySubjectLine(enquirySubjectLine)
                .setEnquiryBodyContent(enquiryBodyContent)
                .build();
    }
}
