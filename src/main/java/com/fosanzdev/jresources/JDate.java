package com.fosanzdev.jresources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JDate {

    /**
     * Reads a date with a personalized message and format
     * SimpleDateFormat is used to parse the date.
     * If no format is given, the default format is dd/MM/yyyy
     *
     * @param msj    String with the message
     * @param format String with the format
     */
    public static String readDate(String msj, String format) {
        String res = "";
        boolean valid;

        do {
            valid = true;

            try {
                //Requests the date
                res = JRequest.requestString(msj);
                //Creates the pattern from the format
                String pat = dateToPattern(format, "/");
                //Compile and compare with the date
                Pattern pattern = Pattern.compile(pat);
                Matcher m = pattern.matcher(res);

                if (!m.matches()) {
                    System.out.println("Invalid date format");
                    valid = false;
                    continue;
                }
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.parse(res);

            } catch (ParseException e) {
                System.out.println("Invalid format");
                valid = false;
            }
        } while (!valid);

        return res;
    }


    /**
     * Reads a date with a personalized message and format
     * SimpleDateFormat is used to parse the date
     * if no format is given, the default format is dd/MM/yyyy
     *
     * @param msj String with the message
     * @return String with the validated date
     */
    public static String readDate(String msj) {
        return readDate(msj, "dd/MM/yyyy");
    }

    /**
     * Transforms a date format to a regular expression
     * The returned string has the same separators as the format
     *
     * @param date      String with the date format
     * @param separator String with the separator
     * @return String with the regular expression
     */
    public static String dateToPattern(String date, String separator) {
        String[] dateParts = date.split(separator);
        return String.format("\\d{%d}%s\\d{%d}%s\\d{%d}", dateParts[0].length(), separator, dateParts[1].length(), separator, dateParts[2].length());
    }


}
