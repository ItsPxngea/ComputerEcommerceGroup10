package za.ac.cput.domain;
/*
Author: Hanno Visser Immelman 221074414
*/
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Enquiry implements Serializable {

    @Id
    private String enquiryID;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    private String enquiryName;
    private String enquirySubjectLine;
    private String enquiryBodyContent;

    public Enquiry() {
    }

    public String getEnquiryID() {
        return enquiryID;
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

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enquiry enquiry = (Enquiry) o;
        return Objects.equals(enquiryID, enquiry.enquiryID) && Objects.equals(customer, enquiry.customer) && Objects.equals(enquiryName, enquiry.enquiryName) && Objects.equals(enquirySubjectLine, enquiry.enquirySubjectLine) && Objects.equals(enquiryBodyContent, enquiry.enquiryBodyContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enquiryID, customer, enquiryName, enquirySubjectLine, enquiryBodyContent);
    }

    @Override
    public String toString() {
        return "Enquiry{" +
                "enquiryID='" + enquiryID + '\'' +
                ", customer=" + customer +
                ", enquiryName='" + enquiryName + '\'' +
                ", enquirySubjectLine='" + enquirySubjectLine + '\'' +
                ", enquiryBodyContent='" + enquiryBodyContent + '\'' +
                '}';
    }

    private Enquiry(Builder b){
        this.enquiryID = b.enquiryID;
        this.customer = b.customer;
        this.enquiryName = b.enquiryName;
        this.enquirySubjectLine = b.enquirySubjectLine;
        this.enquiryBodyContent = b.enquiryBodyContent;
    }

    public static class Builder{
        private String enquiryID;
        private Customer customer;
        private String enquiryName;
        private String enquirySubjectLine;
        private String enquiryBodyContent;

        public Builder setEnquiryID(String enquiryID){
            this.enquiryID = enquiryID;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
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
            this.customer = enquiry.customer;
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
