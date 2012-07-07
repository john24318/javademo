package demo.java.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileInputStream fin;
		FileOutputStream fout;
		try {
			fin = new FileInputStream("src/demo/java/nio/FileChannelDemo.java");
			FileChannel fcin = fin.getChannel();
			fout = new FileOutputStream("writesomebytes.txt");
			FileChannel fcout = fout.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);

			// while (true) {
			// buffer.clear();
			// int r = fcin.read(buffer);
			//
			// if (r == -1) {
			// break;
			// }
			//
			// buffer.flip();
			// fcout.write(buffer);
			// }

			// 读数据
			while (-1 != fcin.read(buffer)) {
				// 读写转换
				buffer.flip();

				// 写数据
				fcout.write(buffer);

				// 清空/重置缓冲区
				buffer.clear();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
