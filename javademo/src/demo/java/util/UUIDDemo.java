package demo.java.util;

import java.util.UUID;

public class UUIDDemo {

    /**
     * <pre>
     * UUID具有多个版本，每个版本的算法不同，应用范围也不同。
     *   UUID Version 1：基于时间的UUID
     *     基于时间的UUID通过计算当前时间戳、随机数和机器MAC地址得到。由于在算法中使用了MAC地址，
     *     这个版本的UUID可以保证在全球范围的唯一性。但与此同时，使用MAC地址会带来安全性问题，这
     *     就是这个版本UUID受到批评的地方。如果应用只是在局域网中使用，也可以使用退化的算法，以IP
     *     地址来代替MAC地址－－Java的UUID往往是这样实现的（当然也考虑了获取MAC的难度）。
     *   UUID Version 2：DCE安全的UUID
     *     DCE（Distributed Computing Environment）安全的UUID和基于时间的UUID算法相同，但会
     *     把时间戳的前4位置换为POSIX的UID或GID。这个版本的UUID在实际中较少用到。
     *   UUID Version 3：基于名字的UUID（MD5）
     *     基于名字的UUID通过计算名字和名字空间的MD5散列值得到。这个版本的UUID保证了：相同名字空间
     *     中不同名字生成的UUID的唯一性；不同名字空间中的UUID的唯一性；相同名字空间中相同名字的UUID
     *     重复生成是相同的。
     *   UUID Version 4：随机UUID
     *     根据随机数，或者伪随机数生成UUID。这种UUID产生重复的概率是可以计算出来的，但还是需要注意重复的问题。
     *   UUID Version 5：基于名字的UUID（SHA1）
     *     和版本3的UUID算法类似，只是散列值计算使用SHA1（Secure Hash Algorithm 1）算法。
     * </pre>
     */

    /**
     * @param args
     */
    public static void main(String[] args) {
        UUID uuid = null;
        // 检索类型 4（伪随机生成的）UUID 的静态工厂。 使用加密的强伪随机数生成器生成该UUID。
        uuid = UUID.randomUUID();
        System.out.println("Random UUID " + uuid);
        uuid = UUID.randomUUID();
        System.out.println("Random UUID " + uuid);

        System.out.println("------------------------------------------------");

        // 根据指定的字节数组检索类型 3（基于名称的）UUID的静态工厂。
        uuid = UUID.nameUUIDFromBytes("abc".getBytes());
        System.out.println("MD5 UUID " + uuid);
        uuid = UUID.nameUUIDFromBytes("abc".getBytes());
        System.out.println("MD5 UUID " + uuid);

    }

}
