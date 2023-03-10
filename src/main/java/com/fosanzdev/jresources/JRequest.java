package com.fosanzdev.jresources;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JRequest {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Request the user a String with a personalized request message
     * and loops input request in case length of the String given is not between {@code [minLon-maxLon]}
     * <p>
     * Examples:
     * <blockquote><pre>
     *
     * String string = leerString("Enter an String: ", 0, 20);
     *
     * </pre></blockquote>
     * <p>
     *
     * @param message String with the personalized message
     * @param minLon Integer with the minimum length
     * @param maxLon Integer with the maximum length
     * @return String with the validated input
     */
    public static String requestString(String message, int minLon, int maxLon) {
        String resultado;
        boolean valido;
        do {
            System.out.print(message);
            resultado = scanner.nextLine();
            valido = resultado.length() >= minLon && resultado.length() <= maxLon;
            if (!valido) {
                System.out.printf("El string debe tener entre %d y %d letras\n", minLon, maxLon);
            }
        } while (!valido);
        return resultado;
    }

    /**
     * Reads a String with a personalized request message
     * @param message Message to be printed
     * @return String with the input
     */
    public static String requestString(String message){
        System.out.print(message);
        return scanner.nextLine();
    }


    /**
     * Reads and returns a true/false user statement
     *
     * @param msj Personalized request message
     * @return boolean with the user selection
     */
    public static boolean readOption(String msj) {
        System.out.print(msj);
        return scanner.nextLine().charAt(0) == 'y';
    }

    /**
     * Reads an integer with a limited number of digits with a personalized message
     *
     * @param msj String with the message
     * @return integer with the validated input
     */
    public static int requestLimitedInt(String msj, int limit) {
        int res = 0;
        boolean valid;

        do {
            System.out.print(msj);
            valid = true;
            try {
                res = scanner.nextInt();
                scanner.nextLine();
                if (Integer.toString(res).length() != limit) {
                    System.out.println("Invalid Entry");
                    valid = false;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid Entry");
                valid = false;
            }
        } while (!valid);

        return res;
    }

    /**
     * Reads an integer with a personalized message
     *
     * @param msj String with the message
     * @return Validated integer
     */
    public static int requestInt(String msj) {
        int res = 0;
        boolean valid;

        do {
            System.out.print(msj);
            valid = true;
            try {
                res = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid Entry");
                valid = false;
            }
        } while (!valid);

        return res;
    }

    /**
     * Reads an integer with a personalized message and a range of values
     *
     * @param msj String with the message
     * @param min Minimum value
     * @param max Maximum value
     * @return Validated integer
     */
    public static int requestInt(String msj, int min, int max) {
        int res = 0;
        boolean valid;

        do {
            System.out.print(msj);
            valid = true;
            try {
                res = scanner.nextInt();
                scanner.nextLine();
                if (res < min || res > max) {
                    System.out.println("Invalid Entry");
                    valid = false;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid Entry");
                valid = false;
            }
        } while (!valid);

        return res;
    }

    /**
     * Reads and validates a double
     *
     * @param msj String to be printed
     * @return Validated double
     */
    public static double requestDouble(String msj) {
        boolean valid;
        double d;
        do {
            d = 0;
            valid = true;
            System.out.print(msj);

            try {
                d = scanner.nextDouble();
                scanner.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida");
                scanner.nextLine();
                valid = false;
            }

        } while (!valid);

        return d;
    }

}
