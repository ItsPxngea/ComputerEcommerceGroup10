package za.ac.cput.domain;

import java.util.Objects;

public class Enquiry {
    private String enquiryID;
    private String customerID;
    private String enquiryName;
    private String enquirySubjectLine;
    private String enquiryBodyContent;

    public Enquiry() {
    }

    public String getEnquiryID() {
        return enquiryID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getEnquiryName() {
        return enquiryName;
    }

    public String getEnquirySubjectLine() {
        return enquirySubjectLine;
    }

    public String getEnquiryBodyContent() {
        return enquiryBodyContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enquiry enquiry = (Enquiry) o;
        return Objects.equals(enquiryID, enquiry.enquiryID) && Objects.equals(customerID, enquiry.customerID) && Objects.equals(enquiryName, enquiry.enquiryName) && Objects.equals(enquirySubjectLine, enquiry.enquirySubjectLine) && Objects.equals(enquiryBodyContent, enquiry.enquiryBodyContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enquiryID, customerID, enquiryName, enquirySubjectLine, enquiryBodyContent);
    }

    @Override
    public String toString() {
        return "Enquiry{" +
                "enquiryID='" + enquiryID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", enquiryName='" + enquiryName + '\'' +
                ", enquirySubjectLine='" + enquirySubjectLine + '\'' +
                ", enquiryBodyContent='" + enquiryBodyContent + '\'' +
                '}';
    }

    private Enquiry(Builder b){
        this.enquiryID = b.enquiryID;
        this.customerID = b.customerID;
        this.enquiryName = b.enquiryName;
        this.enquirySubjectLine = b.enquirySubjectLine;
        this.enquiryBodyContent = b.enquiryBodyContent;
    }

    public static class Builder{
        private String enquiryID;
        private String customerID;
        private String enquiryName;
        private String enquirySubjectLine;
        private String enquiryBodyContent;

        public Builder setEnquiryID(String enquiryID){
            this.enquiryID = enquiryID;
            return this;
        }

        public Builder setCustomerID(String customerID){
            this.customerID = customerID;
            return this;
        }

        public Builder setEnquiryName(String enquiryName){
            this.enquiryName = enquiryName;
            return this;
        }

        public Builder setEnquirySubjectLine(String enquirySubjectLine){
            this.enquirySubjectLine = enquirySubjectLine;
            return this;
        }

        public Builder setEnquiryBodyContent(String enquiryBodyContent){
            this.enquiryBodyContent = enquiryBodyContent;
            return this;
        }

        public Builder copy(Enquiry enquiry){
            this.enquiryID = enquiry.enquiryID;
            this.customerID = enquiry.customerID;
            this.enquiryName = enquiry.enquiryName;
            this.enquirySubjectLine = enquiry.enquirySubjectLine;
            this.enquiryBodyContent = enquiry.enquiryBodyContent;
            return this;
        }

        public Enquiry build(){
            return new Enquiry(this);
        }
    }
}
