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
                String pat = dateToPattern(format);
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
     * The separator used is the char given in defaultSeparator
     *
     * @param date      String with the date format
     * @param separators char array with the separators
     * @param defaultSeparator char with the default separator
     * @return String with the regular expression
     */
    public static String dateToPattern(String date, char[] separators, char defaultSeparator) {
        String[] dateParts = date.split("[" + new String(separators) + "]");
        return String.format("\\d{%d}%s\\d{%d}%s\\d{%d}", dateParts[0].length(), defaultSeparator, dateParts[1].length(), defaultSeparator, dateParts[2].length());
    }

    /**
     * Transforms a date format to a regular expression
     * The default separator is /
     *
     * @param date String with the date format
     * @param separators char array with the separators
     * @return String with the regular expression
     */
    public static String dateToPattern(String date, char[] separators) {
        return dateToPattern(date, separators, '/');
    }

    /**
     * Transforms a date format to a regular expression
     * The default separators are '/', '-', '.'
     *
     * @param date String with the date format
     * @return String with the regular expression
     */
    public static String dateToPattern(String date){
        return dateToPattern(date, new char[]{'/', '-', '.'}, '/');
    }

}
