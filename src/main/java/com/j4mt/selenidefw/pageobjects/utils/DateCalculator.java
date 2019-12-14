package com.j4mt.selenidefw.pageobjects.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateCalculator {

    private static final DateFormat americanDateFormat = new SimpleDateFormat("MM/dd/yyyy");

    public static String calculateAmericanReturnDate(String fromdate, int days) throws ParseException {
        Date returnDate = new Date();
        Date fromDate = new SimpleDateFormat("MM/dd/yyyy").parse(fromdate);
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(fromDate);
        calendar.add(Calendar.DATE, days);

        returnDate = calendar.getTime();
//        LocalDateTime ldt = LocalDateTime.now();
//        returnDate = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt);
//        System.out.println(returnDate);
//        returnDate= returnDate.replaceAll("-","/");
//        System.out.println();
        return americanDateFormat.format(returnDate);
    }

    public static String getTodaysDateAmerican(){
        String todaysDate = "";
        LocalDateTime ldt = LocalDateTime.now();
        todaysDate = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt);
        System.out.println(todaysDate);
        todaysDate = todaysDate.replaceAll("-","/");
        return todaysDate;
    }
}
