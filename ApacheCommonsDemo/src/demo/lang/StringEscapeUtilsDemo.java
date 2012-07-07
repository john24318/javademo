package demo.lang;

import org.apache.commons.lang.StringEscapeUtils;

public class StringEscapeUtilsDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String html = "<p>服务<span style=\"font-size: 13px\"><span style=\"font-family: 宋体\">简</span></span>介</p><p>&nbsp;</p>";
        System.out.println(html);
        System.out.println(StringEscapeUtils.escapeHtml(html));
        System.out.println(StringEscapeUtils.unescapeHtml(StringEscapeUtils.escapeHtml(html)));
    }

}
