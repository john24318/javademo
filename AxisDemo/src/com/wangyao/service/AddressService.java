package com.wangyao.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressService {

    private static List<Address> list = new ArrayList<Address>();

    private static Map<Integer, Address> map = new HashMap<Integer, Address>();

    static {
        Address address = new Address();
        address.setIdentifier(1);
        address.setAddress("Haidian");
        address.setCity("BeiJing");
        address.setCountry("China");
        address.setPostalCode("100081");
        address.setProvince("Beijing");
        address.setExist(false);
        list.add(address);
        map.put(address.getIdentifier(), address);

        address = new Address();
        address.setIdentifier(2);
        address.setAddress("Chaoyang");
        address.setCity("BeiJing");
        address.setCountry("China");
        address.setPostalCode("100081");
        address.setProvince("Beijing");
        address.setExist(true);
        list.add(address);
        map.put(address.getIdentifier(), address);
    }

    public Address getFromList(int index) {
        synchronized (list) {
            if (index < 0 || index > list.size()) {
                return null;
            } else {
                return list.get(index);
            }
        }
    }

    public List<Address> getAddressList() {
        synchronized (list) {
            return list;
        }
    }

    public List<Address> addToList(List<Address> list) {
        return list;
    }

    public Address getFromMap(Integer key) {
        synchronized (map) {
            return map.get(key);
        }
    }

    public Map<Integer, Address> getAddressMap() {
        synchronized (map) {
            return map;
        }
    }

    public void addToMap(Map<Integer, Address> map) {
        synchronized (map) {
            map.putAll(map);
        }
    }
}
