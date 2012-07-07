package demo.java.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RuntimeDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        System.out.println("Processors number\t" + runtime.availableProcessors());
        System.out.println("JVM Max Memory\t\t" + runtime.maxMemory() + "\tbytes");
        System.out.println("JVM Memory\t\t" + runtime.totalMemory() + "\t\tbytes");
        System.out.println("JVM Free Memory\t\t" + runtime.freeMemory() + "\t\tbytes");

        String command = "cmd.exe /c ipconfig";
        InputStream in = null;
        BufferedReader reader = null;
        try {
            Process process = runtime.exec(command);
            in = process.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 运行垃圾回收器
        runtime.gc();

        runtime.exit(1);
        System.out.println("Can't print out!");
    }

}
