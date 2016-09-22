package org.jitesh.stockquotes.googleservice.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String formatDate(Date date, String format) {
        String formattedDate = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            formattedDate = simpleDateFormat.format(date);
        } catch (Exception e) {
            formattedDate = date.toString();
            e.printStackTrace();
        }
        return formattedDate;
    }

    public static final Date parseDate(String date, String format) {
        Date formattedDate = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            formattedDate = simpleDateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }
}
