package demo.java.io;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataStreamDemo {

    /**
     * 将数据写入文件
     * 
     * @param personList
     * @param file
     */
    public static void write(List<Person> personList, File file) {
        FileOutputStream fileOutputStream = null;
        DataOutputStream dataOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            dataOutputStream = new DataOutputStream(fileOutputStream);

            for (Person p : personList) {
                dataOutputStream.writeUTF(p.getName());
                dataOutputStream.writeInt(p.getAge());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileOutputStream)
                    fileOutputStream.close();
                if (null != dataOutputStream)
                    dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从文件读出数据
     * 
     * @param file
     * @param n
     * @return
     */
    public static List<Person> read(File file, final int n) {
        List<Person> ret = new ArrayList<Person>();
        FileInputStream fileInputStream = null;
        DataInputStream dataInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
            dataInputStream = new DataInputStream(fileInputStream);

            for (int i = 0; i < n; i++) {
                String name = dataInputStream.readUTF();
                int age = dataInputStream.readInt();
                Person p = new Person(name, age);
                ret.add(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileInputStream)
                    fileInputStream.close();
                if (null != dataInputStream)
                    dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("aaa", 1));
        list.add(new Person("bbb", 2));
        list.add(new Person("ccc", 3));

        System.out.print("请输入数据文件路径：");
        String outputFilePath = reader.readLine();
        File outputFile = new File(outputFilePath);
        if (!outputFile.exists()) {
            boolean ret = outputFile.createNewFile();
            System.out.println("输出文件：" + outputFilePath + "不存在，创建文件" + (ret ? "成功" : "失败"));
        }

        if (outputFile.exists()) {
            write(list, outputFile);
        }

        if (outputFile.exists()) {
            List<Person> personList = read(outputFile, list.size());
            System.out.println(personList);
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
        name = "N/A";
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + "[name=" + name + ", age=" + age + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}