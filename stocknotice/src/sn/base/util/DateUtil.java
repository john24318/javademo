package sn.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 日期工具类
 * 
 * @author wangyao
 * 
 */
public class DateUtil {

    private static Log log = LogFactory.getLog(DateUtil.class);

    private static String datePattern = "yyyy-MM-dd"; // 默认日期格式

    private static String timePattern = "HH:mm:ss"; // 默认时间格式

    /**
     * 返回默认的日期格式
     * 
     * @return
     */
    public static String getDatePattern() {
        return datePattern;
    }

    /**
     * 返回默认的时间格式
     * 
     * @return
     */
    public static String getTimePattern() {
        return timePattern;
    }

    /**
     * 返回默认的日期时间格式
     * 
     * @return
     */
    public static String getDateTimePattern() {
        return datePattern + " " + timePattern;
    }

    /**
     * 将Date转换成字符串
     * 
     * @param pattern 日期字符串格式
     * @param date
     * @return
     */
    public static final String convertDateToString(String pattern, Date date) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (date != null) {
            df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }

        return returnValue;
    }

    /**
     * 将Date转换成yyyy-MM-dd HH:mm:ss格式的字符串
     * 
     * @param date
     * @return
     */
    public static final String convertDateToString(Date date) {
        return convertDateToString(getDateTimePattern(), date);
    }

    /**
     * 将日期字串转换成Date
     * 
     * @param pattern 日期字符串格式
     * @param str 日期时间字串
     * @return
     * @throws ParseException
     */
    public static final Date convertStringToDate(String pattern, String str) {
        Date date = null;
        SimpleDateFormat df = new SimpleDateFormat(pattern);

        try {
            date = df.parse(str);
        } catch (ParseException pe) {
            log.error("日期解析错误！str=" + str);
            log.error(pe.getMessage());
        }

        return date;
    }

    /**
     * 将日期字串按照yyyy-MM-dd HH:mm:ss格式转换成Date
     * 
     * @param str
     * @return
     */
    public static final Date convertStringToDate(String str) {
        return convertStringToDate(getDateTimePattern(), str);
    }

    public static void main(String[] args) {

    }
}
