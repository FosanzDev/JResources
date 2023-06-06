package com.fosanzdev.jresources;

import java.util.Date;
import java.util.GregorianCalendar;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JRequest {

    private Scanner scanner;
    private PrintStream printer;

    public JRequest(PrintStream printer, Scanner scanner) {
        this.scanner = scanner;
        this.printer = printer;
    }

    public JRequest() {
        this(System.out, new Scanner(System.in));
    }

    public JRequest(Scanner scanner) {
        this(System.out, scanner);
    }

    public JRequest(PrintStream printer){
        this(printer, new Scanner(System.in));
    }

    
    /**
     * Request the user a String with a personalized request message
     * and loops input request in case length of the String given is not between
     * {@code [minLon-maxLon]}
     * <p>
     * Examples:
     * <blockquote>
     * 
     * <pre>
     *
     * String string = leerString("Enter an String: ", 0, 20);
     *
     * </pre>
     * 
     * </blockquote>
     * <p>
     *
     * @param message String with the personalized message
     * @param minLon  Integer with the minimum length
     * @param maxLon  Integer with the maximum length
     * @return String with the validated input
     */
    public String requestString(String message, int minLon, int maxLon) {
        String resultado;
        boolean valido;
        do {
            printer.print(message);
            resultado = scanner.nextLine();
            valido = resultado.length() >= minLon && resultado.length() <= maxLon;
            if (!valido) {
                printer.printf("El string debe tener entre %d y %d letras\n", minLon, maxLon);
            }
        } while (!valido);
        return resultado;
    }

    /**
     * Reads a String with a personalized request message
     * 
     * @param message Message to be printed
     * @return String with the input
     */
    public String requestString(String message) {
        printer.print(message);
        return scanner.nextLine();
    }

    /**
     * Reads and returns a true/false user statement
     *
     * @param msj Personalized request message
     * @return boolean with the user selection
     */
    public boolean readOption(String msj) {
        printer.print(msj);
        return scanner.nextLine().charAt(0) == 'y';
    }

    /**
     * Reads an integer with a limited number of digits with a personalized message
     *
     * @param msj String with the message
     * @return integer with the validated input
     */
    public int requestLimitedInt(String msj, int limit) {
        int res = 0;
        boolean valid;

        do {
            printer.print(msj);
            valid = true;
            try {
                res = scanner.nextInt();
                scanner.nextLine();
                String resString = Integer.toString(res);
                if (!resString.matches("\\d{1," + limit + "}")) {
                    printer.println("Invalid Entry");
                    valid = false;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                printer.println("Invalid Entry");
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
    public int requestInt(String msj) {
        int res = 0;
        boolean valid;

        do {
            printer.print(msj);
            valid = true;
            try {
                res = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                printer.println("Invalid Entry");
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
    public int requestInt(String msj, int min, int max) {
        int res = min - 1;
        boolean valid;

        do {
            printer.print(msj);
            valid = true;
            try {
                res = scanner.nextInt();
                scanner.nextLine();
                if (res < min || res > max) {
                    printer.println("Invalid Entry");
                    valid = false;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                printer.println("Invalid Entry");
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
    public double requestDouble(String msj) {
        boolean valid;
        double d;
        do {
            d = 0;
            valid = true;
            printer.print(msj);

            try {
                d = scanner.nextDouble();
                scanner.nextLine();

            } catch (InputMismatchException e) {
                printer.println("Entrada no valida");
                scanner.nextLine();
                valid = false;
            }

        } while (!valid);

        return d;
    }

    /**
     * Reads a boolean with a personalized message
     *
     * @param msj String with the message
     * @return Validated boolean
     */
    public boolean requestBoolean(String msj) {
        boolean res = false;
        boolean valid;

        do {
            printer.print(msj);
            valid = true;
            try {
                res = scanner.nextBoolean();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                printer.println("Invalid Entry");
                valid = false;
            }
        } while (!valid);

        return res;
    }

    /**
     * Reads a character with a personalized message
     *
     * @param msj String with the message
     * @return Validated character
     */
    public char requestChar(String msj) {
        char res = ' ';
        boolean valid;

        do {
            printer.print(msj);
            valid = true;
            try {
                res = scanner.nextLine().charAt(0);
            } catch (InputMismatchException | StringIndexOutOfBoundsException e) {
                printer.println("Invalid Entry");
                valid = false;
            }
        } while (!valid);

        return res;
    }

    public GregorianCalendar requestDate(String msj, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        GregorianCalendar date = new GregorianCalendar();
        boolean valid;
        do {
            printer.print(msj);
            valid = true;
            try {
                date.setTime(sdf.parse(scanner.next()));
            } catch (ParseException e) {
                printer.println("Invalid Entry");
                valid = false;
            }
        } while (!valid);

        return date;
    }

    public GregorianCalendar requestDate(String msj){
        return requestDate(msj, "dd/MM/yyyy");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintStream printer = System.out;
        JRequest request = new JRequest(printer, scanner);

        GregorianCalendar date = request.requestDate("Introduce una fecha: ");
        printer.println(date.getTime());


    }

}
