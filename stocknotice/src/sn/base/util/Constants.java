package sn.base.util;

/**
 * 系统常量定义
 * 
 * @author wangyao
 * 
 */
public class Constants {

    /** 配置文件路径 */
    public static final String CONFIG_FILE = "config.properties";

    /** 每次查询价格的股票数 */
    public static final int MAX_STOCK_QUERY_NUM = 100;

    /** 用户状态 */
    public static final short USER_STATE_LOCK = 0; // 未激活
    public static final short USER_STATE_ACTIVE = 1; // 已激活

    /** 股票标记 */
    public static final short STOCK_FLAG_DEFAULT = 0; // 未通知
    public static final short STOCK_FLAG_NOTICED = 1; // 已通知

    /** 通知标记 */
    public static final short NOTICE_FLAG_DEFAULT = 0; // 未发送
    public static final short NOTICE_FLAG_SENDED = 1; // 已发送

    /** 通知发送结果 */
    public static final boolean NOTICE_RESULT_FAILURE = false; // 发送失败
    public static final boolean NOTICE_RESULT_SUCCESS = true; // 发送成功

    /** 通知标题 */
    public static final String NOTICE_TITLE_BUY = "买入提示";
    public static final String NOTICE_TITLE_SELL = "卖出提示";

    /** 文件分割符 */
    public static final String FILE_SEP = System.getProperty("file.separator");

    /** 系统属性中的用户主目录 */
    public static final String USER_HOME = System.getProperty("user.home") + FILE_SEP;

    /** 加密算法 */
    public static final String ALGORITHM = "SHA";

    /** 激活码长度 */
    public static final int ACTIVE_CODE_LENGTH = 18;

    /** Cookie保存时间 */
    public static final int COOKIE_MAX_AGE = 30 * 24 * 60 * 60;

    /** 每页显示数据条数 */
    public static final int PAGE_SIZE = 10;

    /** 保存在session中的网站管理员信息key */
    public static final String SESSION_USER = "user";

}
