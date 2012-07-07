package demo.java.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {

    public static void check(Pattern p, String str) {
        if (null != p) {
            System.out.println(str + ":" + p.matcher(str).matches());
        }
    }

    /**
     * 检测数字是否有效
     * 
     * @param str
     */
    public static void checkNumber(String str) {
        Pattern p = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
        check(p, str);
    }

    /**
     * 检测日期是否有效
     * 
     * @param str yyyy-MM-dd格式的日期
     */
    public static void checkDate(String str) {
        Pattern p = Pattern
                .compile("^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29))$");
        check(p, str);
    }

    /**
     * 检测文件的后缀名是否为xls或xlsx
     * 
     * @param str
     */
    public static void checkFileName(String str) {
        Pattern p = Pattern.compile("^.+\\.(xls|xlsx)$");
        check(p, str);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();
        System.out.println(b);

        System.out.println(Pattern.matches("a*b", "aaaaab"));

        checkNumber("12");
        checkNumber("12.00");
        checkNumber("12.10");
        checkNumber("0.10");
        checkNumber(".10");

        checkDate("2008-01-01");
        checkDate("2008-1-01");
        checkDate("2008-01-1");
        checkDate("2008-1-1");
        checkDate("2008-2-28");
        checkDate("2009-2-29");
        checkDate("2008-2-29");
        checkDate("2008-02-30");

        checkFileName("abc.xls");
        checkFileName("abc.xlsx");
        checkFileName(".xls");
        checkFileName("xls");
        checkFileName("aaa.xlss");
        checkFileName("bbb.xl");
        checkFileName(".xlsx");
        checkFileName("xlsx");
        checkFileName("ccc.xlsxd");
        checkFileName("ddd.xl");
    }

}
