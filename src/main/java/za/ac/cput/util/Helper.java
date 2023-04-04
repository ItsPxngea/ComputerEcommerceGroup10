package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;
import za.ac.cput.domain.Invoice;

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

}
