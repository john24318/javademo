package demo.java.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamDemo {

    /**
     * 将对象写入文件
     * 
     * @param personList
     * @param file
     * @param append 是否附加到文件
     */
    public static void write(List<Student> personList, File file, boolean append) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file, append);
            if (append) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream) {
                    /**
                     * 附加到文件时，不需要再写头信息
                     */
                    protected void writeStreamHeader() throws IOException {
                    }
                };
            } else {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }

            for (Student s : personList) {
                objectOutputStream.writeObject(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileOutputStream)
                    fileOutputStream.close();
                if (null != objectOutputStream)
                    objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从文件读出对象
     * 
     * @param file
     * @return
     */
    public static List<Student> read(File file) {
        List<Student> ret = new ArrayList<Student>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);

            while (fileInputStream.available() > 0) {
                Object obj = objectInputStream.readObject();
                ret.add((Student) obj);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileInputStream)
                    fileInputStream.close();
                if (null != objectInputStream)
                    objectInputStream.close();
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
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("aaa", 1, "a"));
        list.add(new Student("bbb", 2, "b"));
        list.add(new Student("ccc", 3, "c"));

        System.out.print("请输入数据文件路径：");
        String outputFilePath = reader.readLine();
        File outputFile = new File(outputFilePath);
        if (!outputFile.exists()) {
            boolean ret = outputFile.createNewFile();
            System.out.println("输出文件：" + outputFilePath + "不存在，创建文件" + (ret ? "成功" : "失败"));
            System.out.println("文件大小：" + outputFile.length());
        }

        if (outputFile.exists()) {
            // write(list, outputFile, false);
            write(list, outputFile, true);
        }

        if (outputFile.exists()) {
            List<Student> studentList = read(outputFile);
            for (Student s : studentList)
                System.out.println(s);
        }
    }

}

class Student implements Serializable {
    private static final long serialVersionUID = -3886998652720843143L;
    private String name;
    private int age;
    private transient String nickname = null; // static或transient修饰的变量不会写入

    public Student() {
        name = "N/A";
        nickname = "N/A";
    }

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String nickname) {
        super();
        this.name = name;
        this.age = age;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return super.toString() + "[name=" + name + ", age=" + age + ", nickname=" + nickname + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Student other = (Student) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}