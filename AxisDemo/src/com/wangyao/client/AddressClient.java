package com.wangyao.client;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import com.wangyao.service.Address;

@SuppressWarnings("unchecked")
public class AddressClient {
    private static String url = "http://127.0.0.1:9000/AxisDemo/services/AddressService";

    public static void getServerList() {
        Service service = new Service();
        try {
            Call call = (Call) service.createCall();
            QName qn = new QName("urn:AddressService", "Address");
            call.registerTypeMapping(Address.class, qn, new org.apache.axis.encoding.ser.BeanSerializerFactory(Address.class, qn),
                    new org.apache.axis.encoding.ser.BeanDeserializerFactory(Address.class, qn));
            call.setTargetEndpointAddress(new java.net.URL(url));
            call.setOperationName(new QName("AddressService", "getAddressList"));
            call.setReturnClass(ArrayList.class);
            Object[] sss = null;
            List<Address> list = (ArrayList) call.invoke(sss);
            System.out.println("List size: " + list.size());
            for (Iterator<Address> iter = list.iterator(); iter.hasNext();) {
                Address address = iter.next();
                System.out.println("id号：" + address.getIdentifier() + " address：" + address.getAddress() + " city：" + address.getCity()
                        + " country：" + address.getCountry() + " postalCode：" + address.getPostalCode() + " province："
                        + address.getProvince() + " isExist: " + address.isExist());
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void setServerList() {
        Service service = new Service();
        List<Address> list = new ArrayList<Address>();
        Address address = new Address();
        address.setIdentifier(1);
        address.setAddress("Haidian");
        address.setCity("BeiJing");
        address.setCountry("China");
        address.setPostalCode("100081");
        address.setProvince("Beijing");
        address.setExist(false);
        list.add(address);
        address = new Address();
        address.setIdentifier(2);
        address.setAddress("Chaoyang");
        address.setCity("BeiJing");
        address.setCountry("China");
        address.setPostalCode("100081");
        address.setProvince("Beijing");
        address.setExist(true);
        list.add(address);
        try {
            Call call = (Call) service.createCall();
            QName qn = new QName("urn:AddressService", "Address");
            call.registerTypeMapping(Address.class, qn, new org.apache.axis.encoding.ser.BeanSerializerFactory(Address.class, qn),
                    new org.apache.axis.encoding.ser.BeanDeserializerFactory(Address.class, qn));
            call.setTargetEndpointAddress(new java.net.URL(url));
            call.setOperationName(new QName("AddressService", "setAddressList"));
            call.setReturnClass(ArrayList.class);
            call.addParameter("list", XMLType.XSD_ANYTYPE, ParameterMode.IN);
            list = (ArrayList) call.invoke(new Object[] { list });
            System.out.println("List size: " + list.size());
            for (Iterator<Address> iter = list.iterator(); iter.hasNext();) {
                address = iter.next();
                System.out.println("id号：" + address.getIdentifier() + " address：" + address.getAddress() + " city：" + address.getCity()
                        + " country：" + address.getCountry() + " postalCode：" + address.getPostalCode() + " province："
                        + address.getProvince() + " isExist: " + address.isExist());
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void getServerMap() {
        Service service = new Service();
        try {
            Call call = (Call) service.createCall();
            QName qn = new QName("urn:AddressService", "Address");
            call.registerTypeMapping(Address.class, qn, new org.apache.axis.encoding.ser.BeanSerializerFactory(Address.class, qn),
                    new org.apache.axis.encoding.ser.BeanDeserializerFactory(Address.class, qn));
            call.setTargetEndpointAddress(new java.net.URL(url));
            Object[] sss = null;
            call.setOperationName(new QName("AddressService", "getAddressMap"));
            call.setReturnClass(HashMap.class);
            Map<Integer, Address> map = (Map) call.invoke(sss);
            System.out.println("Map size: " + map.size());
            for (Iterator<Integer> iter = map.keySet().iterator(); iter.hasNext();) {
                Integer key = iter.next();
                Address address = map.get(key);
                System.out.println("id号：" + address.getIdentifier() + " address：" + address.getAddress() + " city：" + address.getCity()
                        + " country：" + address.getCountry() + " postalCode：" + address.getPostalCode() + " province："
                        + address.getProvince() + " isExist: " + address.isExist());
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void setServerMap() {
        Service service = new Service();
        Map<Integer, Address> map = new HashMap<Integer, Address>();
        Address address = new Address();
        address.setIdentifier(1);
        address.setAddress("Haidian");
        address.setCity("BeiJing");
        address.setCountry("China");
        address.setPostalCode("100081");
        address.setProvince("Beijing");
        address.setExist(false);
        map.put(address.getIdentifier(), address);
        address = new Address();
        address.setIdentifier(2);
        address.setAddress("Chaoyang");
        address.setCity("BeiJing");
        address.setCountry("China");
        address.setPostalCode("100081");
        address.setProvince("Beijing");
        address.setExist(true);
        map.put(address.getIdentifier(), address);
        try {
            Call call = (Call) service.createCall();
            QName qn = new QName("urn:AddressService", "Address");
            call.registerTypeMapping(Address.class, qn, new org.apache.axis.encoding.ser.BeanSerializerFactory(Address.class, qn),
                    new org.apache.axis.encoding.ser.BeanDeserializerFactory(Address.class, qn));
            call.setTargetEndpointAddress(new java.net.URL(url));
            call.setOperationName(new QName("AddressService", "setAddressMap"));
            call.setReturnClass(HashMap.class);
            call.addParameter("list", XMLType.XSD_ANYTYPE, ParameterMode.IN);
            map = (Map) call.invoke(new Object[] { map });
            System.out.println("Map size: " + map.size());
            for (Iterator<Integer> iter = map.keySet().iterator(); iter.hasNext();) {
                Integer key = iter.next();
                address = map.get(key);
                System.out.println("id号：" + address.getIdentifier() + " address：" + address.getAddress() + " city：" + address.getCity()
                        + " country：" + address.getCountry() + " postalCode：" + address.getPostalCode() + " province："
                        + address.getProvince() + " isExist: " + address.isExist());
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        getServerList();
        getServerMap();
        setServerList();
        setServerMap();
    }

}
