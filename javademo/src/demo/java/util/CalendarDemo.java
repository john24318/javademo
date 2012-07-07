package demo.java.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class CalendarDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cale = Calendar.getInstance();
        System.out.println(df.format(cale.getTime()));
        df.setTimeZone(TimeZone.getTimeZone("PST"));
        System.out.println(df.format(cale.getTime()));

        Calendar pstCale = Calendar.getInstance(TimeZone.getTimeZone("PST"));
        System.out.println(pstCale.get(Calendar.HOUR_OF_DAY));
        System.out.println(df.format(pstCale.getTime()));
    }

}
