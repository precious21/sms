package com.momentumTech.rms.springmvc.utility;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64DecoderStream;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;

public class CommonUtility {
  

  public static String convertArrayToCsv(String[] arr) {
    String csv = "";
    for (String value : arr) {
      csv += value + ",";
    }
    return csv;
  }

  public static String[] convertCsvToArr(String csv) {
    String[] values = csv.split(",");
    return values;
  }

  public static Date dateFormat(Date date) {
    final String OLD_FORMAT = "dd/MM/yyyy";
    final String NEW_FORMAT = "yyyy/MM/dd";

    // August 12, 2010
    String oldDateString = "12/08/2010";
    String newDateString;

    SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
    Date d = new Date();
    try {
      d = sdf.parse(oldDateString);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    sdf.applyPattern(NEW_FORMAT);
    newDateString = sdf.format(d);
    return d;
  }

  public static String passwordToHash(String password) {
    String passwordToHash = password;
    String generatedPassword = null;
    try {
      // Create MessageDigest instance for MD5
      MessageDigest md = MessageDigest.getInstance("MD5");
      // Add password bytes to digest
      md.update(passwordToHash.getBytes());
      // Get the hash's bytes
      byte[] bytes = md.digest();
      // This bytes[] has bytes in decimal format;
      // Convert it to hexadecimal format
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < bytes.length; i++) {
        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
      }
      // Get complete hashed password in hex format
      generatedPassword = sb.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    System.out.println(generatedPassword);
    return generatedPassword;
  }

  public static String generateRandomNumber(int length) {
    List<Integer> numbers = new ArrayList<Integer>();
    for (int i = 0; i < 10; i++) {
      numbers.add(i);
    }

    Collections.shuffle(numbers);

    String result = "";
    for (int i = 0; i < length; i++) {
      result += numbers.get(i).toString();
    }
    System.out.println(result);
    return result;
  }

  // encrypt string
  public static String encrypt(String str) {

    try {

      // encode the string into a sequence of bytes using the named charset

      // storing the result into a new byte array.

      byte[] utf8 = str.getBytes("UTF8");

      // byte[] enc = ecipher.doFinal(utf8);

      // encode to base64

      byte[] enc = BASE64EncoderStream.encode(utf8);

      return new String(enc);

    }

    catch (Exception e) {

      e.printStackTrace();

    }

    return null;

  }

  // decrypt string
  public static String decrypt(String str) {

    try {

      // decode with base64 to get bytes

      byte[] dec = BASE64DecoderStream.decode(str.getBytes());

      // byte[] utf8 = dcipher.doFinal(dec);

      // create new string based on the specified charset

      return new String(dec, "UTF8");

    }

    catch (Exception e) {

      e.printStackTrace();

    }

    return null;

  }

  public static String convertDateToString(Date date) {
    String dateString = "";
    if (date != null) {
      SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
      dateString = f.format(date);
    }
    return dateString;
  }

  public static Date convertStringToDate(String dateString) {
    Date date = null;
    if (dateString != null && !dateString.equals("")) {
      SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
      date = new Date();
      try {
        date = f.parse(dateString);
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    return date;
  }
  
  public static Date convertStringToDateNew(String dateString) {
	    Date date = null;
	    if (dateString != null && !dateString.equals("")) {
	      SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
	      date = new Date();
	      try {
	        date = f.parse(dateString);
	      } catch (ParseException e) {
	        e.printStackTrace();
	      }
	    }
	    return date;
	  }

  public static String convertDateToStringWithFormat(Date date, String format) {
    SimpleDateFormat f = new SimpleDateFormat(format);
    String dateString = f.format(date);
    return dateString;
  }

  public static Date convertStringToDateWithFormat(String dateString, String format) {
    SimpleDateFormat f = new SimpleDateFormat(format);
    Date date = new Date();
    try {
      date = f.parse(dateString);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

  public static String getStatusProperty(String key) {
    // create a new ResourceBundle with default locale
    String result = "NA";
    ResourceBundle bundle = ResourceBundle.getBundle("status");
    if (bundle.containsKey(key))
      result = bundle.getString(key);
    return result;
  }

  public static long getDifferenceInMinutes(String startDateString, String endDateString,
      String dateFormat) {
    SimpleDateFormat format = new SimpleDateFormat(dateFormat);

    Date d1 = null;
    Date d2 = null;

    try {
      d1 = format.parse(startDateString);
      d2 = format.parse(endDateString);

      // in milliseconds
      long diff = d2.getTime() - d1.getTime();

      long diffSeconds = diff / 1000 % 60;
      long diffMinutes = diff / (60 * 1000) % 60;
      long diffHours = diff / (60 * 60 * 1000) % 24;
      long diffDays = diff / (24 * 60 * 60 * 1000);

      long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(diff);

      System.out.print(diffDays + " days, ");
      System.out.print(diffHours + " hours, ");
      System.out.print(diffMinutes + " minutes, ");
      System.out.print(diffSeconds + " seconds.");
      return diffInMinutes;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return 0;

  }
  
  
  /****************30-12-2016 to 2016-12-30*************************************************************/
  public static Date convertStringToDbDate(String dateString) {
	  
	    Date date = null;
	    
	    if (dateString != null && !dateString.equals("")) {
	      SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	      SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy/MM/dd");
	      date = new Date();
	      try {
	        date = f.parse(dateString);	        	        
	        String tmp = dbFormat.format(date);
	        date =new Date();
	        date = dbFormat.parse(tmp);
	        
	      } catch (ParseException e) {
	        e.printStackTrace();
	      }
	    }
	    return date;
	  }

}
