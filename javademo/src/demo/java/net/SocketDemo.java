package demo.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketDemo {

	public static void get() {
		try {
			Socket socket = new Socket("www.baidu.com", 80);
			boolean autoflush = true;
			OutputStream outputStream = socket.getOutputStream();
			InputStream inputStream = socket.getInputStream();
			PrintWriter out = new PrintWriter(outputStream, autoflush);

			// send an HTTP request to the web server
			// out.println("GET / HTTP/1.1");
			out.println("GET /index.html HTTP/1.1");
			out.println("Host: www.baidu.com");
			out.println("Connection: Close");
			out.println();

			// read the response
			// read message header
			int[] temp = new int[4];
			StringBuilder messageHeader = new StringBuilder(1000);
			while (true) {
				temp[0] = temp[1];
				temp[1] = temp[2];
				temp[2] = temp[3];
				temp[3] = inputStream.read();

				if ('\r' == temp[0] && '\n' == temp[1] && '\r' == temp[2] && '\n' == temp[3])
					break;

				messageHeader.append((char) temp[3]);
			}

			// get message body charset
			String[] headers = messageHeader.toString().split("\r\n");
			String contentType = null;
			for (String filed : headers) {
				if (filed.indexOf("Content-Type") > -1) {
					contentType = filed;
					break;
				}
			}
			String charset = contentType.substring(contentType.indexOf("charset=") + 8).trim();

			// read message body
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, charset));
			boolean loop = true;
			StringBuffer sb = new StringBuffer(8096);
			while (loop) {
				if (in.ready()) {
					int length = 0;
					int bufferSize = 8192;
					char[] buffer = new char[bufferSize];

					while ((length = in.read(buffer, 0, bufferSize)) != -1) {
						sb.append(buffer, 0, length);
					}

					loop = false;
				}
				// Thread.currentThread().sleep(50);
			}

			// display the response to the out console
			String content = sb.toString();
			content = content.replaceAll("&nbsp;", "");
			content = content.replaceAll("<br />", "\n");
			content = content.replaceAll("<br/>", "\n");
			content = content.replaceAll("<br>", "\n");
			System.out.println(content);

			socket.close();
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: Victest.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: Victest.");
			System.exit(1);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		get();
	}

}
