package za.ac.cput.factory;

import za.ac.cput.domain.InvoiceHistory;
import za.ac.cput.util.Helper;


public class InvoiceHistoryFactory {
    private String historyID ;
    private String invoiceNumber ;
    private String invoiceDescription ;
    public static InvoiceHistory buildInvoiceHistory(String historyID, String invoiceNumber, String invoiceDescription)
    {
        if (Helper.isNullOrEmpty(historyID) ||
            Helper.isNullOrEmpty(invoiceNumber) ||
            Helper.isNullOrEmpty(invoiceDescription)) {
            return null;
        }

        return new InvoiceHistory.Builder()
                .setHistoryId(historyID)
                .setInvoiceNumber(invoiceNumber)
                .setInvoiceDescription(invoiceDescription)
                .build();
    }


}
