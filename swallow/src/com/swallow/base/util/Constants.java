package com.swallow.base.util;

/**
 * 系统常量定义
 * 
 * @author wangyao
 * 
 */
public class Constants {

    /** 资源文件名 */
    public static final String BUNDLE_KEY = "ApplicationResources";

    /** 文件分割符 */
    public static final String FILE_SEP = System.getProperty("file.separator");

    /** 系统属性中的用户主目录 */
    public static final String USER_HOME = System.getProperty("user.home") + FILE_SEP;

    /** 加密算法 */
    public static final String ALGORITHM = "SHA";

    /** 每页显示数据条数 */
    public static final int PAGE_SIZE = 8;

    /** 保存在session中的网站管理员信息key */
    public static final String SESSION_USER = "user";

}
