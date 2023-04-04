package za.ac.cput.factory;

import za.ac.cput.domain.Enquiry;
import za.ac.cput.util.Helper;
public class EnquiryFactory {
    public static Enquiry buildEnquiry(String customerID, String enquiryName, String enquirySubjectLine, String enquiryBodyContent){
        if (Helper.isNullOrEmpty(customerID) || Helper.isNullOrEmpty(enquiryName) || Helper.isNullOrEmpty(enquirySubjectLine) || Helper.isNullOrEmpty(enquiryBodyContent))
            return null;
        String enquiryID = Helper.generateID();

        return new Enquiry.Builder().setEnquiryID(enquiryID)
                .setCustomerID(customerID)
                .setEnquiryName(enquiryName)
                .setEnquirySubjectLine(enquirySubjectLine)
                .setEnquiryBodyContent(enquiryBodyContent)
                .build();
    }
}
