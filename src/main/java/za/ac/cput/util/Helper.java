package za.ac.cput.util;
/*
    Author: Group 10
    This is the helper class.
    Date: 02 - 04 - 2022
 */

import org.apache.commons.validator.routines.EmailValidator;

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
        if (str == null || str.isEmpty()){
            return true;
        }
        return false;
    }
    public static boolean isValidEmail(String email) {
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }
    public static String generateID(){return UUID.randomUUID().toString();}

    public static String generateProductID(String pn, String pt){
        Random random = new Random();
        int randNum = random.nextInt(900000) + 100000;
        String productID = pn.substring(0,3).toUpperCase() + pt.substring(0,3).toUpperCase() + randNum;
        return productID;
    }
    public static String generateBundleID(String bn, String bt, String bc){
        Random random = new Random();
        int randNum = random.nextInt(900000) + 100000;
        String bundleID = bn.substring(0,3).toUpperCase() + bt.substring(0,3).toUpperCase() + bc.substring(0,3).toUpperCase() + randNum;
        return bundleID;
    }
    public static String generateCustomerID(String fn, String ln){
        Random random = new Random();
        int randNum = random.nextInt(900000) + 100000;

        StringBuilder sb = new StringBuilder();

        if (fn.length() >= 3) {
            sb.append(fn.substring(0, 3).toUpperCase());
        } else {
            sb.append(fn.toUpperCase());
            for (int i = 0; i < 3 - fn.length(); i++) {
                sb.append('X');
            }
        }

        if (ln.length() >= 3) {
            sb.append(ln.substring(0, 3).toUpperCase());
        } else {
            sb.append(ln.toUpperCase());
            for (int i = 0; i < 3 - ln.length(); i++) {
                sb.append('X');
            }
        }

        sb.append(randNum);
        return sb.toString();
    }
    public static boolean isInvalidDouble(Double d) {
        if (d == null || d.isNaN()) {
            return true;
        } else if (d < 0) {
            return true;
        }
        return false;
    }
    public static boolean isInvalidInt(int i) {
        return i < 0;
    }
    /*public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern phoneNumberPattern = Pattern.compile("^\\d{10}$");
        Matcher findAMatch = phoneNumberPattern.matcher(phoneNumber);
        return (findAMatch.matches());
    }

     */
    public static LocalDate isValidDate(String dateStr) {
        if (dateStr == null) {
            return null;
        }
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("dd-MM-uuuu")
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
    public static String generateInvoiceNumber(){
        Random random = new Random();
        int randNum = random.nextInt(900000) + 100000;
        return String.valueOf(randNum);
    }

}
