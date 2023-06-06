import org.junit.Test;

import com.fosanzdev.jresources.JRequest;

import java.io.ByteArrayInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import static org.junit.Assert.*;

public class JRequestTest {

    @Test
    public void testRequestInt() {
        int expected = 5;
        String input = "5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        JRequest jRequest = new JRequest(scanner);
        int actual = jRequest.requestInt("Enter an integer: ");
        assertEquals(expected, actual);
    }

    @Test
    public void testRequestLimitedInt() {
        int expected = 123;
        String input = "123\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        JRequest jRequest = new JRequest(scanner);
        int actual = jRequest.requestLimitedInt("Enter an integer with 3 or less digits: ", 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testRequestDouble() {
        double expected = 3.14;
        Scanner scanner = new Scanner("3,14" + "\n");
        JRequest jRequest = new JRequest(scanner);
        double actual = jRequest.requestDouble("Enter a double: ");
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testRequestString() {
        String expected = "hello";
        String input = "hello\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        JRequest jRequest = new JRequest(scanner);
        String actual = jRequest.requestString("Enter a string: ");
        assertEquals(expected, actual);
    }

    @Test
    public void testRequestDate(){
        Date expected = new GregorianCalendar(2004, Calendar.MAY, 22).getTime();
        String input = "22/05/2004\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        JRequest jRequest = new JRequest(scanner);
        Date actual = jRequest.requestDate("Enter a date: ").getTime();
        assertEquals(expected, actual);
    }

    @Test
    public void testRequestDateFormat(){
        Date expected = new GregorianCalendar(2004, Calendar.MAY, 22).getTime();
        String input = "2004-05-22\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        JRequest jRequest = new JRequest(scanner);
        Date actual = jRequest.requestDate("Enter a date: ", "yyyy-MM-dd").getTime();
        assertEquals(expected, actual);
    }
}