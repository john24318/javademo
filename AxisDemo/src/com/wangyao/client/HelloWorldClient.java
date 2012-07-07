package com.wangyao.client;

import java.rmi.RemoteException;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class HelloWorldClient {

    /**
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            String url = "http://127.0.0.1:8080/AxisDemo/services/HelloWorld";
            Service serv = new Service();
            Call call = (Call) serv.createCall();
            call.setTargetEndpointAddress(url);

            // 调用hello方法
            call.setOperationName(new QName(url, "hello"));
            String result = (String) call.invoke(new Object[] { "World" });
            System.out.println("result = " + result);

            // 调用add方法
            call.setOperationName(new QName(url, "add"));
            // call.addParameter("a", org.apache.axis.Constants.XSD_FLOAT, javax.xml.rpc.ParameterMode.IN);
            // call.addParameter("b", org.apache.axis.Constants.XSD_FLOAT, javax.xml.rpc.ParameterMode.IN);
            // call.setReturnType(org.apache.axis.Constants.XSD_FLOAT);
            Float returnValue = (Float) call.invoke(new Object[] { new Float(3.2), new Float(2.8) });
            System.out.println("returnValue = " + returnValue);

            // 调用list方法
            call.setOperationName(new QName(url, "list"));
            // call.setReturnType(org.apache.axis.Constants.XSD_ANYTYPE);
            call.setReturnType(org.apache.axis.Constants.SOAP_VECTOR);
            List<String> list = (List<String>) call.invoke(new Object[] {});
            System.out.println("result = " + list);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
