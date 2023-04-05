package za.ac.cput.factory;
import za.ac.cput.domain.Supplier;
import za.ac.cput.util.Helper;
public class SupplierFactory {

    public static Supplier buildSupplier(String supplierEmail, String supplierTel, String supplierAddress,
                                         String supplierProductLine, String supplierCompanyName){

        if(Helper.isNullOrEmpty(supplierProductLine) || Helper.isNullOrEmpty(supplierAddress) || Helper.isNullOrEmpty(supplierCompanyName)){
            return null;
        }

        if(!Helper.isValidPhoneNumber(supplierTel)){
            return null;
        }

        if(!Helper.isValidEmail(supplierEmail)){
            return null;
        }

        String supplierID = Helper.generateID();

        return new Supplier.Builder()
                .setSupplierID(supplierID)
                .setSupplierEmail(supplierEmail)
                .setSupplierTel(supplierTel)
                .setSupplierAddress(supplierAddress)
                .setSupplierProductLine(supplierProductLine)
                .setSupplierCompanyName(supplierCompanyName)
                .build();


    }

}
