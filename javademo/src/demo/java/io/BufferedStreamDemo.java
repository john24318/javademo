package demo.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedStreamDemo {

    public static void copyFile(File srcFile, File destFile) {
        int data = -1;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);
            bufferedInputStream = new BufferedInputStream(fileInputStream); // 可指定输入缓存大小，默认为8k
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);// 可指定输出缓存大小，默认为8k

            while (-1 != (data = bufferedInputStream.read())) {
                bufferedOutputStream.write(data);
            }

            // 刷新此缓冲的输出流。这迫使所有缓冲的输出字节被写出到底层输出流中。
            bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bufferedOutputStream)
                    bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (null != bufferedInputStream)
                    bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (null != fileOutputStream)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (null != fileInputStream)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("请输入输入文件路径：");
        String inputFilePath = reader.readLine();
        File inputFile = new File(inputFilePath);
        // File.exists()测试此抽象路径名表示的文件或目录是否存在
        // File.isFile()测试此抽象路径名表示的文件是否是一个标准文件。
        if (!inputFile.exists() || !inputFile.isFile()) {
            System.out.println("输入文件：" + inputFilePath + "不存在！");
            System.exit(1); // 非 0 的状态码表示异常终止。
        }
        System.out.println("输入文件大小：" + inputFile.length());

        System.out.print("请输入输出文件路径：");
        String outputFilePath = reader.readLine();
        File outputFile = new File(outputFilePath);
        if (!outputFile.exists()) {
            boolean ret = outputFile.createNewFile();
            System.out.println("输出文件：" + outputFilePath + "不存在，创建文件" + (ret ? "成功" : "失败"));
        }

        if (outputFile.exists()) {
            copyFile(inputFile, outputFile);
        }
    }

}
