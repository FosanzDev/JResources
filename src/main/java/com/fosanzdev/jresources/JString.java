package com.fosanzdev.jresources;

public class JString {

    /**
     * Counts the number of words in a string
     * <p>
     * Example:
     * <blockquote>
     * 
     * <pre>
     * int n = countWords("Hola buenos dias");
     * // n = 3
     * </pre>
     * 
     * </blockquote>
     * 
     * @param s String with the words to be counted
     * @return Integer with the number of words
     */
    public static int countWords(String s) {
        // Example using arrays
        // String[] words = s.trim(). split("\\s+");
        // return words.length;

        // Using alternative method: counting whitespaces
        s = s.trim().replaceAll("\\s+", " ");
        if (s.equals(""))
            return 0;

        int count = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                count++;
        }

        return count;
    }

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
     * Multiplies a String by n times
     * <p>
     * Example:
     * <blockquote>
     * 
     * <pre>
     * String s = multiplyString("hola", 3)
     * //    s = "holaholahola"
     * </pre>
     * 
     * </blockquote>
     * 
     * @param s     String to be multiplied
     * @param times N times that s will be multiplied
     * @return String with the multiplied String
     */
    public static String multiplyString(String s, int times) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < times; i++)
            sb.append(s);

        return sb.toString();
    }

    /**
     * Removes whitespaces and scape characters of a string
     * 
     * @param text String to be cleaned
     * @return The clean String
     */
    public static String cleanString(String text) {
        final String vowels = "ÁÀÂÄÉÈËÊÍÌÏÎÓÒÔÖÚÙÜÛ";
        final String normal = "AEIOU";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int idx = vowels.indexOf(text.charAt(i));
            if (idx == -1)
                sb.append(text.charAt(i));
            else
                sb.append(normal.charAt(idx / 4));
        }
        text = sb.toString();
        return text.trim().replaceAll("\\s+", " ");
    }

    /**
     * Checks wether a String is palindrome or not (Ignores whitespaces and scape
     * characters)
     * 
     * @param text String with the text to be analized
     * @return Boolean with the response
     */
    public static boolean isPalindrome(String text) {
        text = cleanString(text).replaceAll("\\s+", "");
        int sep;
        int len = text.length();

        if (len % 2 == 0)
            sep = len / 2;
        else
            sep = len / 2 + 1;

        StringBuilder original = new StringBuilder();
        StringBuilder reversed = new StringBuilder();

        for (int i = 0; i < sep; i++)
            original.append(text.charAt(i));

        for (int i = len - 1; i > sep - 2; i--)
            reversed.append(text.charAt(i));

        String sOriginal = original.toString();
        String sReversed = reversed.toString();

        return sOriginal.equals(sReversed);
    }

    /**
     * Reverses a String
     * <p>
     * Example:
     * <blockquote>
     * 
     * <pre>
     * String s = reverseString("hello")
     * //    s = "olleh"
     * </pre>
     * 
     * </blockquote>
     * 
     * @param s String to be reversed
     * @return String with the reversed String
     */
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Splits a camel case string into separate words
     * <p>
     * Example:
     * <blockquote>
     * 
     * <pre>
     * String[] words = splitCamelCase("helloWorld");
     * // words = ["hello", "World"]
     * </pre>
     * 
     * </blockquote>
     * 
     * @param s String to be split
     * @return Array of strings with the split words
     */
    public static String[] splitCamelCase(String s) {
        return s.split("(?<=[a-z])(?=[A-Z])");
    }

    /**
     * Capitalizes the first letter of each word in a string
     * <p>
     * Example:
     * <blockquote>
     * 
     * <pre>
     * String s = capitalizeWords("hello world");
     * // s = "Hello World"
     * </pre>
     * 
     * </blockquote>
     * 
     * @param s String to be capitalized
     * @return String with the capitalized words
     */
    public static String capitalizeWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)));
            sb.append(word.substring(1));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * Truncates a string to a maximum length
     * <p>
     * Example:
     * <blockquote>
     * 
     * <pre>
     * String s = truncateString("hello world", 5);
     * // s = "hello"
     * </pre>
     * 
     * </blockquote>
     * 
     * @param s         String to be truncated
     * @param maxLength Maximum length of the truncated string
     * @return Truncated string
     */
    public static String truncateString(String s, int maxLength) {
        if (s.length() <= maxLength) {
            return s;
        } else {
            return s.substring(0, maxLength);
        }
    }

}