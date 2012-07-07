package demo.java.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesDemo {

    @SuppressWarnings("unchecked")
    public static void test() {
        Properties properties = new Properties();

        // 从输入流中读取属性列表
        try {
            properties.load(PropertiesDemo.class.getResourceAsStream("PropertiesDemo.properties"));
            // properties.loadFromXML(PropertiesDemo.class.getResourceAsStream("PropertiesDemo.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 打印属性列表到指定的输出流
        properties.list(System.out);

        // 获取属性
        System.out.println(properties.getProperty("jdbc.drivers"));

        // 获取属性
        System.out.println(properties.getProperty("jdbc.test", "default value."));

        // 返回属性列表中所有键的枚举
        Enumeration<String> names = (Enumeration<String>) properties.propertyNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }

        // 添加或更新属性
        properties.setProperty("now", new Date().toString());

        // 将属性列表写入输出流
        try {
            properties.store(new FileOutputStream("src/demo/java/util/PropertiesDemo.properties"), "aaa");
            properties.storeToXML(new FileOutputStream("src/demo/java/util/PropertiesDemo.xml"), "aaa");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
    }

}
