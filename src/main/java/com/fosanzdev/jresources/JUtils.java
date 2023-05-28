package com.fosanzdev.jresources;

public class JUtils {
    
    /**
     * Counts the number of vowels in a string
     *
     * @param s String to be analyzed
     * @return Integer with the number of vowels
     */
    public static int countVowels(String s) {
        final String vowels = "ÁÀÂÄÉÈËÊÍÌÏÎÓÒÔÖÚÙÜÛ";
        // Variable definition
        s = s.toUpperCase();
        int counter = 0;

        // Count the vowels
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowels.indexOf(c) != -1)
                counter++;
        }

        return counter;
    }

    /**
     * Counts the number of consonants in a string
     *
     * @param s String to be analyzed
     * @return Integer with the number of consonants
     */
    public static int countConsontants(String s){
        return s.length() - countVowels(s);
    }

    /**
     * Gets q alphanumeric number of chars over a String and saves it into a char
     * Array
     * 
     * @param s String with the alphanumeric characters
     * @param q Number of chars to be
     * @return char Array length q
     */
    public static char[] charDivider(String s, int q) {

        if (q > s.length()){
            System.out.println("Error: q is greater than the string length");
            return null;
        }

        s = JString.cleanString(s);
        char[] cArray = new char[q];

        for (int i = 0; i < q; i++) {
            cArray[i] = s.charAt(i);
        }

        return cArray;
    }

    /**
     * Returns wether the number is between a range of numbers or not (inclusive)
     * <p>
     * Examples:
     * <blockquote><pre>
     * boolean b = inRange(3, 2.5, 4)
     *      //b = true
     * </pre></blockquote>
     * @param x Number to be checked
     * @param lowerBound Min range border
     * @param upperBound Max range border
     * @return a boolean with the result
     */
    public static boolean inclusiveInRange(double x, double lowerBound, double upperBound){
        return x >= lowerBound && x <= upperBound;
    }

    /**
     * Returns wether the number is between a range of numbers or not (exclusive)
     * <p>
     * Examples:
     * <blockquote><pre>
     * boolean b = inRange(3, 2.5, 4)
     *      //b = true
     * </pre></blockquote>
     * @param x Number to be checked
     * @param lowerBound Min range border
     * @param upperBound Max range border
     * @return a boolean with the result
     */
    public static boolean exclusiveInRange(double x, double lowerBound, double upperBound){
        return x > lowerBound && x < upperBound;
    }

}