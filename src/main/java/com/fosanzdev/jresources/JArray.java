package com.fosanzdev.jresources;

import java.util.Random;

public class JArray {

    /**
     * Returns an array of Strings with the separated words of a phrase
     * <p>
     * Example:
     * <blockquote>
     * 
     * <pre>
     * String[] words = separateWords("Hola buenos dias")
     * //      words = ["Hola", "buenos", "dias"]
     * </pre>
     * 
     * </blockquote>
     * 
     * @param phrase String with the phrase
     * @return String array with the words
     */
    public static String[] separateWords(String phrase) {
        return phrase.trim().split("\\s+");
    }


     /**
     * Returns the longest String in an array
     * <p>
     * Example:
     * <blockquote>
     * 
     * <pre>
     * String s = getMaxLength("Hola", "Buenos", "Dias")
     * //    s = "Buenos"
     * </pre>
     * 
     * </blockquote>
     * 
     * @param args Undefinied number of Strings or an array
     * @return String with the longest word
     */
    public static String getMaxLength(String... args) {

        int maxValue = 0;
        int indexMax = 0;

        for (int i = 0; i < args.length; i++) {
            int len = args[i].length();
            if (len > maxValue) {
                maxValue = len;
                indexMax = i;
            }
        }

        return args[indexMax];
    }


    /**
     * Receives two integer arrays and returns another array of integers with the
     * length equal to the min length of the two given arrays with the result of adding
     * values of the string by its index
     * 
     * @param a1 integer array one
     * @param a2 integer array two
     * @return integer array with the result of the additions
     */
    public static int[] sumArray(int[] a1, int[] a2) {
        int len = Math.min(a1.length, a2.length);
        int[] res = new int[len];

        for (int i = 0; i < len; i++)
            res[i] = a1[i] + a2[i];

        return res;

    }


    /**
     * Receives two integer arrays and returns another array of integer with the
     * length equal to the min length of the two given arrays, with the result of the
     * division from both arrays by its index
     * 
     * @param a1 integer array with the dividends
     * @param a2 integer array with the divisors
     * @return double array with the result of the divisions
     */
    public static double[] divArray(int[] a1, int[] a2) {
        int len = Math.min(a1.length, a2.length);
        double[] res = new double[len];

        for (int i = 0; i < len; i++)
            res[i] = (double) a1[i] / a2[i];

        return res;

    }


    /**
     * Receives an integer and returns an array of random integers with
     * the length given by the parameter
     *
     * @param len length of the array
     * @return integer array with random integers
     */
    public static int[] genIntArray(int len) {
        Random gen = new Random();
        int[] res = new int[len];

        for (int i = 0; i < len; i++)
            res[i] = gen.nextInt();

        return res;
    }

    /**
     * Receives an integer and returns an array of random integers with
     * the length given by the parameter
     *
     * @param len length of the array
     * @param limit max value of the random integers
     * @return integer array with random integers
     */
    public static int[] genIntArray(int len, int limit) {
        Random gen = new Random();
        int[] res = new int[len];

        for (int i = 0; i < len; i++)
            res[i] = gen.nextInt(limit+1);

        return res;
    }

    /**
     * Returns the reverse of an array
     * @param arr array to reverse
     * @return reversed array
     */
    public static int[] reverseArray(int[] arr) {
        int[] res = new int[arr.length];

        for (int i = arr.length - 1; i > 0; i--) {
            res[arr.length - 1 - i] = arr[i];
        }

        res[arr.length - 1] = arr[0];

        return res;
    }

}