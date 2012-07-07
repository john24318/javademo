package demo.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		URL url = null;
		HttpURLConnection connect = null;
		InputStream is = null;
		OutputStream os = null;

		try {
			// url = new URL("http://www.google.cn/images/nav_logo4.png");
			url = new URL("http://www.google.com.hk");
			connect = (HttpURLConnection) url.openConnection();
			// connect.connect();

			for (int j = 1;; j++) {
				String header = connect.getHeaderField(j);
				if (header == null)
					break;
				System.out.println(connect.getHeaderFieldKey(j) + " " + header);
			}

			String contentType = connect.getHeaderField("Content-Type").toLowerCase();
			String charset = contentType.substring(contentType.indexOf("charset=") + 8).trim();

			if (HttpURLConnection.HTTP_OK == connect.getResponseCode()) {
				is = connect.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(is, charset));
				StringBuilder sb = new StringBuilder(8096);
				int length = 0;
				int bufferSize = 8192;
				char[] buffer = new char[bufferSize];

				while ((length = reader.read(buffer, 0, bufferSize)) != -1) {
					sb.append(buffer, 0, length);
				}
				System.out.println(sb.toString());
				// os = new FileOutputStream("E:\\logo.png");
				// int length = 0;
				// int bufferSize = 8192;
				// byte[] buffer = new byte[bufferSize];
				// while ((length = is.read(buffer, 0, bufferSize)) != -1) {
				// os.write(buffer, 0, length);
				// }
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (null != connect) {
				connect.disconnect();
			}
		}

	}
}
