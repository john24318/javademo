package com.wangyao.dp.structural.bridge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileLogger implements MessageLogger {

    public void logMsg(String msg) {
        File file = new File("log.txt");
        FileOutputStream fos = null;

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            fos = new FileOutputStream(file, true);
            fos.write(msg.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
