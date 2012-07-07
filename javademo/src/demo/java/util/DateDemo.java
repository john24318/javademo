package demo.java.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    /*
     * 在 JDK 1.1 之前，Date类允许把日期解释为年、月、日、小时、分钟和秒值，也允许格式化和解析日期字符串。但这些函数的 API 不易于实现国际化。 从 JDK 1.1
     * 开始，应该使用Calendar类实现日期和时间字段之间转换，使用DateFormat 类来格式化和解析日期字符串。Date 中的相应方法已废弃。
     */

    /**
     * 打印日期
     */
    public static void print(DateFormat df, Date date) {
        if (null == date)
            return;

        if (null == df) {
            df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }

        System.out.println(df.format(date));
    }

    /**
     * 打印日期
     * 
     * @param df
     * @param timeMillis
     */
    public static void print(DateFormat df, long timeMillis) {
        Date d = new Date(timeMillis);
        print(df, d);
    }

    /**
     * 对日期某字段增加指定值
     * 
     * @param date
     * @param field
     * @param amount
     * @return
     */
    public static Date add(Date date, int field, int amount) {
        Date retDate = null;

        if (null == date)
            return retDate;

        // Calendar 类是一个抽象类，它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR 等
        // 日历字段之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法。
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // add(f, delta) 将 delta 添加到 f 字段中。与 set() 不同，add() 强迫日历系统立即重新计算日历的毫秒数和所有字段。
        calendar.add(field, amount);
        retDate = calendar.getTime();

        return retDate;
    }

    /**
     * 设置日期字段为指定值
     * 
     * @param date
     * @param field
     * @param amount
     * @return
     */
    public static Date set(Date date, int field, int amount) {
        Date retDate = null;

        if (null == date)
            return retDate;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 尽管日历字段 f 是立即更改的，但是直到下次调用 get()、getTime()、getTimeInMillis()、add() 或 roll()
        // 时才会重新计算日历的时间值（以毫秒为单位）。因此，多次调用 set() 不会触发多次不必要的计算。
        calendar.set(field, amount);
        retDate = calendar.getTime();

        return retDate;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        print(null, date);

        Date tomorrow = add(date, Calendar.DATE, 1);
        print(null, tomorrow);

        date = add(date, Calendar.DATE, 30);
        print(null, date);

        date = set(date, Calendar.DATE, 1);
        print(null, date);

        // 通过System获取当前时间
        long longDate = System.currentTimeMillis();
        print(null, longDate);
    }

}
