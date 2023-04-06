package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static String generateID(){
        return UUID.randomUUID().toString();
    }

    public static String generateCustomerID(String fn, String ln){
        Random random = new Random();
        int randNum = random.nextInt(900000) + 100000;
        String customerID = fn.substring(0,3).toUpperCase() + ln.substring(0,3).toUpperCase() + randNum;
        return customerID;
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

         if (i < 0) {
            return true;

        }
        return false;
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

    public static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern phoneNumberPattern = Pattern.compile("^\\d{10}$");
        Matcher findAMatch = phoneNumberPattern.matcher(phoneNumber);
        return (findAMatch.matches());
    }
}
