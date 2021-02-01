package com.example.blogs.data.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHelper {
    public static String getFormattedDate(String date)  {

        SimpleDateFormat displayDateFormat = new SimpleDateFormat("MMM dd, yyy h:mm a", Locale.US);
        DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        Date formattedDate = null;
        try {
            formattedDate = inputDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (formattedDate == null){
            return "-";
        }
        return displayDateFormat.format(formattedDate);
    }
}