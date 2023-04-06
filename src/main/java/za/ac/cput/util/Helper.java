package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;
import za.ac.cput.domain.Invoice;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    public static boolean isNullOrEmpty(String str){
        return str == null || str.isEmpty();
    }

    public static boolean isValidEmail(String email) {
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }

    public static String generateID(){
        return UUID.randomUUID().toString();
    }

    public static String generateCustomerID(String fn, String ln){
        Random random = new Random();
        int randNum = random.nextInt(900000) + 100000;
        String customerID = fn.substring(0,3).toUpperCase() + ln.substring(0,3).toUpperCase() + randNum;
        return customerID;
    }

    public static String generateInvoiceNumber (String productName){
        Random random = new Random();
        int randNum = random.nextInt(900000) + 100000;
        String randStr = generateRandomString();
        return productName.substring(0,2) + randStr + randNum;
    }
    static String generateRandomString() { // This function is used to create a random string and returning the first 3 letters of the random string.
        UUID randomStringUUID = UUID.randomUUID();
        return randomStringUUID.toString().replaceAll("_", "").substring(0,3);
    }
    public static boolean isInvalidDouble(Double d) {
        if (d == null || d.isNaN()) {
            return true;
        } else return d < 0;
    }


    public static boolean isInvalidInt(int i) {
        return i < 0;
    }


    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern phoneNumberPattern = Pattern.compile("^\\d{10}$");
        Matcher findAMatch = phoneNumberPattern.matcher(phoneNumber);
        return (findAMatch.matches());
    }
    public static LocalDate isValidDate(String dateStr){
        if (dateStr == null) {
            return null;
        }
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("dd-MM-yyyy")
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT);

        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            int dayOfMonth = date.getDayOfMonth();
            if(dayOfMonth < 1 || dayOfMonth > date.getMonth().maxLength()) {
                return null;
            }
            if (date.getDayOfMonth() == 29 && date.getMonth() == Month.FEBRUARY && !date.isLeapYear()) {
                return null;
            }
            return date;

        } catch (DateTimeParseException e) {
            return null;
        }
    }
    
    public static String generateProductID(String pn, String pt, String pc){
        Random random = new Random();
        int randNum = random.nextInt(900000) + 100000;
        String productID = pn.substring(0,3).toUpperCase() + pt.substring(0,3).toUpperCase() + pc.substring(0,3).toUpperCase() + randNum;
        return productID;
    }

    public static String generateBundleID(String bn, String bt, String bc){
        Random random = new Random();
        int randNum = random.nextInt(900000) + 100000;
        String bundleID = bn.substring(0,3).toUpperCase() + bt.substring(0,3).toUpperCase() + bc.substring(0,3).toUpperCase() + randNum;
        return bundleID;
    }

}
