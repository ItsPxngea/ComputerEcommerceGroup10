package za.ac.cput.factory;
import za.ac.cput.domain.InvoiceHistory;
import za.ac.cput.util.Helper;

/*
Author: Alexander Draai - 220118744
This is the factory for InvoiceHistory Class
Date: 04 - 04 - 2023
 */
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
