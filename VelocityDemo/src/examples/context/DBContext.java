package examples.context;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.velocity.context.AbstractContext;
import org.apache.velocity.context.Context;

/**
 * Example context impl that uses a database to store stuff :)
 * 
 * yes, this is silly
 * 
 * expects a mysql db test with table
 * 
 * CREATE TABLE contextstore ( k varchar(100), val blob );
 * 
 * very fragile, crappy code.... just a demo!
 * 
 * @author <a href="mailto:geirm@optonline.net">Geir Magnusson Jr.</a>
 * @version $Id: DBContext.java 463298 2006-10-12 16:10:32Z henning $
 */

public class DBContext extends AbstractContext {
    Connection conn = null;

    public DBContext() {
        super();
        setup();
    }

    public DBContext(Context inner) {
        super(inner);
        setup();
    }

    /**
     * 获取保存在数据库中的序列化对象
     */
    public Object internalGet(String key) {
        try {
            Blob data = null;

            String sql = "SELECT k, val FROM contextstore WHERE k ='" + key + "'";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if (rs.next())
                data = rs.getBlob("val");
            rs.close();
            s.close();

            ObjectInputStream in = new ObjectInputStream(data.getBinaryStream());
            Object o = in.readObject();
            in.close();

            return o;
        } catch (Exception e) {
            System.out.println("internalGet() : " + e);
        }

        return null;
    }

    /**
     * 将序列化对象保存到数据库中（如何将OutputStream转换为InputStream参http://ostermiller.org/convert_java_outputstream_inputstream.html）
     */
    public Object internalPut(String key, Object value) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(baos);
            out.writeObject(value);
            byte[] data = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(data);

            // 删除数据库中的旧对象
            Statement s = conn.createStatement();
            s.executeUpdate("DELETE FROM contextstore WHERE k = '" + key + "'");
            s.close();

            // 保存数据到数据库
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO contextstore (k,val) values (?, ?)");
            pstmt.setString(1, key);
            pstmt.setBinaryStream(2, bais, data.length);
            pstmt.executeUpdate();
            pstmt.close();

            out.close();
            baos.close();
        } catch (Exception e) {
            System.out.println("internalGet() : " + e);
        }

        return null;
    }

    /**
     * Not implementing. Not required for Velocity core operation, so not bothering. As we say above : "very fragile, crappy code..."
     */
    public boolean internalContainsKey(Object key) {
        return false;
    }

    /**
     * Not implementing. Not required for Velocity core operation, so not bothering. As we say above : "very fragile, crappy code..."
     */
    public Object[] internalGetKeys() {
        return null;
    }

    /**
     * Not implementing. Not required for Velocity core operation, so not bothering. As we say above : "very fragile, crappy code..."
     */
    public Object internalRemove(Object key) {
        return null;
    }

    /**
     * 初始化数据库连接
     */
    private void setup() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root");
        } catch (Exception e) {
            System.out.println(e);
        }

        return;
    }
}
