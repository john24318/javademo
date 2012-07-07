1.发布webservice：
	在%TOMCAT_HOME%\webapps\AxisDemo\WEB-INF 目录下键入如下命令：
	java -Djava.ext.dirs=lib org.apache.axis.client.AdminClient deploy.wsdd -lhttp://localhost:8080/AxisDemo/services/AdminService

2.取消webservice：
	在%TOMCAT_HOME%\webapps\AxisDemo\WEB-INF 目录下键入如下命令：
	java -Djava.ext.dirs=lib org.apache.axis.client.AdminClient undeploy.wsdd -lhttp://localhost:8080/AxisDemo/services/AdminService

3.TCPMonitor使用：
	在%TOMCAT_HOME%\webapps\AxisDemo\WEB-INF 目录下键入如下命令：
	javaw -Djava.ext.dirs=lib org.apache.axis.utils.tcpmon
	出现工具界面，填写监听端口（并非webservice服务器端口，而是转发端口，如9000，代码中的请求的端口也改成和该值一样，否则无法查看）
	
4.WSDL2Java：
	在%TOMCAT_HOME%\webapps\AxisDemo\WEB-INF 目录下键入如下命令：
	java -Djava.ext.dirs=lib org.apache.axis.wsdl.WSDL2Java (WSDL-file-URL)	