package com.fosanzdev.jresources;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

public class JDateConverter {

    /**
     * Returns a LocalDate instance from a Date instance
     * @param date Date instance
     * @return LocalDate instance
     */
    public static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Returns a LocalDate instance from a Date instance
     * @param date Date instance
     * @param zoneId ZoneId instance
     * @return LocalDate instance
     */
    public static LocalDate toLocalDate(Date date, ZoneId zoneId) {
        return date.toInstant().atZone(zoneId).toLocalDate();
    }

    /**
     * Returns a LocalDate instance from a GregorianCalendar instance
     * @param gc GregorianCalendar instance
     * @return LocalDate instance
     */
    public static LocalDate toLocalDate(GregorianCalendar gc){
        return gc.toZonedDateTime().toLocalDate();
    }

    /**
     * Returns a Date instance from a LocalDate instance
     * @param localDate LocalDate instance
     * @return Date instance
     */
    public static Date toDate(LocalDate localDate){
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Returns a Date instance from a LocalDate instance
     * @param localDate LocalDate instance
     * @param zoneId ZoneId instance
     * @return Date instance
     */
    public static Date toDate(LocalDate localDate, ZoneId zoneId){
        return Date.from(localDate.atStartOfDay().atZone(zoneId).toInstant());
    }

    /**
     * Returns a Date instance from a GregorianCalendar instance
     * @param gc GregorianCalendar instance
     * @return Date instance
     */
    public static Date toDate(GregorianCalendar gc){
        return gc.getTime();
    }

    /**
     * Returns a GregorianCalendar instance from a Date instance
     * @param date Date instance
     * @return GregorianCalendar instance
     */
    public static GregorianCalendar toGregorianCalendar(Date date){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        return gc;
    }

    /**
     * Returns a GregorianCalendar instance from a LocalDate instance
     * @param localDate LocalDate instance
     * @return GregorianCalendar instance
     */
    public static GregorianCalendar toGregorianCalendar(LocalDate localDate){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(toDate(localDate));
        return gc;
    }

    /**
     * Returns a GregorianCalendar instance from a Date instance
     * @param localDate LocalDate instance
     * @param zoneId ZoneId instance
     * @return GregorianCalendar instance
     */
    public static GregorianCalendar toGregorianCalendar(LocalDate localDate, ZoneId zoneId){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(toDate(localDate, zoneId));
        return gc;
    }
}
