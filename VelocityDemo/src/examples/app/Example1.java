package examples.app;

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

import org.apache.velocity.app.Velocity;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.Template;

import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import java.io.*;
import java.util.ArrayList;

/**
 * This class is a simple demonstration of how the Velocity Template Engine can be used in a standalone application.
 * 
 * @author <a href="mailto:jvanzyl@apache.org">Jason van Zyl</a>
 * @author <a href="mailto:geirm@optonline.net">Geir Magnusson Jr.</a>
 * @version $Id: Example.java 463298 2006-10-12 16:10:32Z henning $
 */

public class Example1 {

    public static ArrayList getNames() {
        ArrayList list = new ArrayList();
        list.add("ArrayList element 1");
        list.add("ArrayList element 2");
        list.add("ArrayList element 3");
        list.add("ArrayList element 4");
        return list;
    }

    public static void main(String[] args) {
        String templateFile = "WebRoot\\WEB-INF\\templates\\example1.vm";

        try {
            // 初始化
            Velocity.init("Webroot\\WEB-INF\\velocity.properties");

            // 设置数据到Velocity环境中
            VelocityContext context = new VelocityContext();
            context.put("list", getNames());

            // 获取模板
            Template template = null;
            try {
                template = Velocity.getTemplate(templateFile, "UTF-8");
            } catch (ResourceNotFoundException rnfe) {
                System.out.println("Example : error : cannot find template " + templateFile);
            } catch (ParseErrorException pee) {
                System.out.println("Example : Syntax error in template " + templateFile + ":" + pee);
            }

            // 创建输出字符流
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            // 使用上下文中的数据处理模板
            if (template != null)
                template.merge(context, writer);

            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
