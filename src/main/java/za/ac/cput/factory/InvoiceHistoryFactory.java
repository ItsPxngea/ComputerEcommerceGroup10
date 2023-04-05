package za.ac.cput.factory;

import za.ac.cput.domain.InvoiceHistory;
import za.ac.cput.util.Helper;


public class InvoiceHistoryFactory {
    private String historyID ;
    private String invoiceNumber ;
    private String invoiceDescription ;
    public static InvoiceHistory buildInvoiceHistory(String historyID, String invoiceDescription)
    {
        if (Helper.isNullOrEmpty(historyID) ||
            Helper.isNullOrEmpty(invoiceDescription)) {
            return null;
        }

        return new InvoiceHistory.Builder()
                .setHistoryId(historyID)
                .setInvoiceDescription(invoiceDescription)
                .build();
    }


}
