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

import java.io.StringWriter;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;

/**
 * This class is a simple demonstration of how the Velocity Template Engine can be used in a standalone application using the Velocity utility
 * class.
 * 
 * It demonstrates two of the 'helper' methods found in the org.apache.velocity.util.Velocity class, mergeTemplate() and evaluate().
 * 
 * 
 * @author <a href="mailto:geirm@optonline.net">Geir Magnusson Jr.</a>
 * @version $Id: Example2.java 463298 2006-10-12 16:10:32Z henning $
 */

public class Example2 {
    public static void main(String args[]) {
        // 1.初始化
        try {
            Velocity.init();
        } catch (Exception e) {
            System.out.println("Problem initializing Velocity : " + e);
            return;
        }

        // 2.创建Velocity环境，并设置好数据
        VelocityContext context = new VelocityContext();
        context.put("name", "Velocity");
        context.put("project", "Jakarta");

        // 3.使用模板渲染
        StringWriter w = new StringWriter();
        try {
            Velocity.mergeTemplate("WebRoot\\WEB-INF\\templates\\example2.vm", "UTF-8", context, w);
        } catch (Exception e) {
            System.out.println("Problem merging template : " + e);
        }
        System.out.println(" template : " + w);

        // 动态创建模板，并使用evaluate()方法渲染
        String s = "我们使用 $project $name to render this.";
        w = new StringWriter();
        try {
            Velocity.evaluate(context, w, "mystring", s);
        } catch (ParseErrorException pee) {
            System.out.println("ParseErrorException : " + pee);
        } catch (MethodInvocationException mee) {
            System.out.println("MethodInvocationException : " + mee);
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
        System.out.println(" string : " + w);
    }
}
