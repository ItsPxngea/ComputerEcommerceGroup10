package za.ac.cput.factory;

import za.ac.cput.domain.InvoiceHistory;
import za.ac.cput.util.Helper;


public class InvoiceHistoryFactory {
    public static InvoiceHistory buildInvoiceHistory(String invoiceDescription)
    {
        if (Helper.isNullOrEmpty(invoiceDescription)) {
            return null;
        }

        String historyID = Helper.generateID();
        String invoiceNumber = Helper.generateID();

        return new InvoiceHistory.Builder()
                .setHistoryId(historyID)
                .setInvoiceNumber(invoiceNumber)
                .setInvoiceDescription(invoiceDescription)
                .build();
    }


}
