package com.wangyao.service;

import java.io.Serializable;

public class Address implements Serializable {

    private static final long serialVersionUID = 2402885057307057966L;

    private Integer identifier;
    /** 地址 */
    private String address;
    /** 城市 */
    private String city;
    /** 省份 */
    private String province;
    /** 国家 */
    private String country;
    /** 邮编 */
    private String postalCode;

    private boolean isExist;

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean isExist) {
        this.isExist = isExist;
    }

}
