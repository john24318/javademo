package com.wangyao.base.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wangyao.base.persistence.model.BaseObject;

/**
 * Utility class to convert one object to another.
 * 
 * @author 王耀
 * 
 */
public final class ConvertUtil {

    private static Log log = LogFactory.getLog(ConvertUtil.class);

    /**
     * 拷贝ResourceBundle对象的内容到Map中
     * 
     * @param rb
     * @return
     */
    public static Map convertBundleToMap(ResourceBundle rb) {
        Map map = new HashMap();

        for (Enumeration keys = rb.getKeys(); keys.hasMoreElements();) {
            String key = (String) keys.nextElement();
            map.put(key, rb.getString(key));
        }

        return map;
    }

    /**
     * 拷贝ResourceBundle对象的内容到Properties中
     * 
     * @param rb
     * @return
     */
    public static Properties convertBundleToProperties(ResourceBundle rb) {
        Properties props = new Properties();

        for (Enumeration keys = rb.getKeys(); keys.hasMoreElements();) {
            String key = (String) keys.nextElement();
            props.put(key, rb.getString(key));
        }

        return props;
    }

    /**
     * 拷贝ResourceBundle对象的内容到传入的obj中
     * 
     * @param obj
     * @param rb
     * @return
     */
    public static Object populateObject(Object obj, ResourceBundle rb) {
        try {
            Map map = convertBundleToMap(rb);
            BeanUtils.copyProperties(obj, map);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception occured populating object: " + e.getMessage());
        }

        return obj;
    }

    /**
     * 更根据传入的Model或Form，返回一个对应的Form和Model实例
     * 
     * @param o
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static Object getOpposingObject(Object o) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String name = o.getClass().getName();

        if (o instanceof BaseObject) {
            if (log.isDebugEnabled()) {
                log.debug("getting form equivalent of pojo...");
            }

            name = StringUtils.replace(name, ".permanence.model.", ".web.form.");
            name += "Form";
        } else {
            if (log.isDebugEnabled()) {
                log.debug("getting pojo equivalent of form...");
            }
            name = StringUtils.replace(name, ".web.form.", ".permanence.model.");
            name = name.substring(0, name.lastIndexOf("Form"));
        }

        Class obj = Class.forName(name);

        if (log.isDebugEnabled()) {
            log.debug("returning className: " + obj.getName());
        }

        return obj.newInstance();
    }

    /**
     * 将Form转换为POJO，或者POJO转为Form
     * 
     * @param o
     * @return
     * @throws Exception
     */
    public static Object convert(Object o) throws Exception {
        if (o == null) {
            return null;
        }
        Object target = getOpposingObject(o);
        BeanUtils.copyProperties(target, o);
        return target;
    }
}
