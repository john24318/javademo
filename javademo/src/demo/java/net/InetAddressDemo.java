package demo.java.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

    public static void test() {
        try {
            // 获取本机IP地址
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("1.");
            System.out.println(address);
            System.out.println(address.getCanonicalHostName());
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());

            // 根据域名获取IP地址列表
            String domain = "www.sina.com.cn";
            InetAddress[] addresses = InetAddress.getAllByName(domain);
            System.out.println("2.");
            for (InetAddress add : addresses) {
                System.out.println(add);
                System.out.println(add.getCanonicalHostName());
            }

            // 根据域名获取IP地址
            System.out.println("3.");
            System.out.println(InetAddress.getByName(domain));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        test();
    }
}
