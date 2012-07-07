package demo.java.net;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderDemo {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String url = "http://www.google.cn/search?q=";
		String parameterValue = "中文";
		System.out.println("Original URL:\t" + url + parameterValue);

		System.out.println("\nEncode URL:");
		String url_utf8 = url + URLEncoder.encode(parameterValue, "UTF-8");
		System.out.println("\tUTF-8\t\t" + url_utf8);
		String url_iso88591 = url + URLEncoder.encode(parameterValue, "ISO-8859-1");
		System.out.println("\tISO-8859-1\t" + url_iso88591);
		String url_gbk = url + URLEncoder.encode(parameterValue, "GBK");
		System.out.println("\tGBK\t\t" + url_gbk);
		String url_gb2312 = url + URLEncoder.encode(parameterValue, "GB2312");
		System.out.println("\tGB2312\t\t" + url_gb2312);

		System.out.println("\nDecode URL:");
		url_utf8 = URLDecoder.decode(url_utf8, "UTF-8");
		System.out.println("\tUTF-8\t\t" + url_utf8);
		url_iso88591 = URLDecoder.decode(url_iso88591, "ISO-8859-1");
		System.out.println("\tISO-8859-1\t" + url_iso88591);
		url_gbk = URLDecoder.decode(url_gbk, "GBK");
		System.out.println("\tGBK\t\t" + url_gbk);
		url_gb2312 = URLDecoder.decode(url_gb2312, "GB2312");
		System.out.println("\tGB2312\t\t" + url_gb2312);
	}

}
