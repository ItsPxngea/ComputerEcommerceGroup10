package za.ac.cput.domain;

import java.util.Objects;
/*
Author: Alexander Draai - 220118744
This is the Pojo + Builder for the InvoiceHistory Class.
Date: 04 - 04 - 2023
 */

public class InvoiceHistory {
    private String historyID ;
    private String invoiceNumber ;
    private String invoiceDescription ;

    public InvoiceHistory() {}

    public String getHistoryID() {return historyID;}
    public String getInvoiceNumber() {return invoiceNumber;}
    public String getInvoiceDescription() {return invoiceDescription;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceHistory that = (InvoiceHistory) o;
        return Objects.equals(historyID, that.historyID) && Objects.equals(invoiceNumber, that.invoiceNumber) && Objects.equals(invoiceDescription, that.invoiceDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(historyID, invoiceNumber, invoiceDescription);
    }

    @Override
    public String toString() {
        return "InvoiceHistory{" +
                "historyID='" + historyID + '\'' +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", invoiceDescription='" + invoiceDescription + '\'' +
                '}';
    }

    private InvoiceHistory(Builder builder){
        this.historyID = builder.historyID;
        this.invoiceNumber = builder.invoiceNumber;;
        this.invoiceDescription = builder.invoiceDescription;
    }


    public static class Builder {
        private String historyID ;
        private String invoiceNumber ;
        private String invoiceDescription ;

        public Builder setHistoryId(String historyId){
            this.historyID = historyId;
            return this;
        }
        public Builder setInvoiceNumber(String invoiceNumber){
            this.invoiceNumber = invoiceNumber;
            return this;
        }
        public Builder setInvoiceDescription(String invoiceDescription){
            this.invoiceDescription = invoiceDescription;
            return this;
        }

        public Builder copy(InvoiceHistory invoiceHistory){
            this.historyID = invoiceHistory.historyID;
            this.invoiceNumber = invoiceHistory.invoiceNumber;
            this.invoiceDescription = invoiceHistory.invoiceDescription;
            return this;
        }

        public InvoiceHistory build(){return new InvoiceHistory(this);}

    }
}
