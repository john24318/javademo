package sn.base.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtils {

    private static Log log = LogFactory.getLog(FileUtils.class);

    /**
     * 读取propertis文件
     * 
     * @param filePath
     * @return
     */
    public static Properties loadPropertyFile(String filePath) {
        Properties properties = new Properties();
        InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(filePath);

        try {
            properties.load(inputStream);// 加载文件
        } catch (IOException e) {
            log.error("加载文件" + filePath + "失败！");
            log.error(e.getMessage());
            return null;
        } finally {
            try {
                inputStream.close();
                inputStream = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return properties;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

}
