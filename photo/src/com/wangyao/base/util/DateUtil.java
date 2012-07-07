package com.wangyao.base.util;

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

    private static String datePattern = "yyyy-MM-dd";

    private static String timePattern = "HH:mm:ss";

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
     * 按照指定的格式将Date转换成String
     * 
     * @param aMask
     * @param aDate
     * @return
     */
    public static final String convertDateToString(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return returnValue;
    }

    /**
     * 按照默认日期格式将Date转换为String
     * 
     * @param aDate
     * @return
     */
    public static final String getDate(Date aDate) {
        return convertDateToString(getDatePattern(), aDate);
    }

    /**
     * 按照默认时间格式将Date转换为String
     * 
     * @param theTime
     * @return
     */
    public static String getTime(Date theTime) {
        return convertDateToString(getTimePattern(), theTime);
    }

    /**
     * 按指定的日期格式将字串解析成日期类型
     * 
     * @param aMask
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static final Date convertStringToDate(String aMask, String strDate) throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        if (log.isDebugEnabled()) {
            log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
        }

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return date;
    }

    /**
     * 按照默认日期格式将String解析成Date
     * 
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date convertStringToDate(String strDate) throws ParseException {
        return convertStringToDate(getDatePattern(), strDate);
    }

    public static void main(String[] args) {
        try {
            System.out.println(convertStringToDate(getDate(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
