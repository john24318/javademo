package sn.core.persistence.dao.impl;

import sn.base.persistence.dao.BaseDao;
import sn.core.persistence.dao.SnUserDao;
import sn.core.persistence.model.SnUser;

public class SnUserDaoImpl extends BaseDao implements SnUserDao {

    /**
     * 检测用户名是否存在
     */
    public boolean checkName(String name) {
        boolean result = true;
        String sql = "SELECT user_id AS userId FROM sn_user WHERE login=?";
        SnUser user = (SnUser) get(sql, new Object[] { name }, SnUser.class);
        if (null == user) {
            result = false;
        }
        return result;
    }

    /**
     * 新增
     */
    public boolean add(SnUser user) {
        boolean result = false;
        String sql = "INSERT INTO sn_user(user_id, login, PASSWORD, email, mobile_phone_number, registered, active_code, state) SELECT IFNULL(MAX(user_id), 0)+1, ?, ?, ?, ?, ?, ?, ? FROM sn_user;";
        int rows = update(sql, new Object[] { user.getLogin(), user.getPassword(), user.getEmail(), user.getMobilePhoneNumber(),
                user.getRegistered(), user.getActiveCode(), user.getState() });
        if (rows > 0) {
            result = true;
        }

        return result;
    }

    /**
     * 查询单个用户
     */
    public SnUser get(Integer userId) {
        SnUser user = null;
        String sql = "SELECT user_id AS userId, login, PASSWORD, email, mobile_phone_number AS mobilePhoneNumber, registered, active_code AS activeCode, state, last_login_time AS lastLoginTime, last_login_ip AS lastLoginIp FROM sn_user WHERE user_id=?";
        user = (SnUser) get(sql, new Object[] { userId }, SnUser.class);
        return user;
    }

    /**
     * 查询单个用户
     */
    public SnUser get(String login) {
        SnUser user = null;
        String sql = "SELECT user_id AS userId, login, PASSWORD, email, mobile_phone_number AS mobilePhoneNumber, registered, active_code AS activeCode, state, last_login_time AS lastLoginTime, last_login_ip AS lastLoginIp FROM sn_user WHERE login=?";
        user = (SnUser) get(sql, new Object[] { login }, SnUser.class);
        return user;
    }

    /**
     * 修改状态
     */
    public boolean updateState(Integer userId, Short state) {
        boolean result = false;
        String sql = "UPDATE sn_user SET state=? WHERE user_id=?";
        int rows = update(sql, new Object[] { state, userId });

        if (rows > 0) {
            result = true;
        }

        return result;
    }

    public static void main(String[] args) {
        SnUserDaoImpl dao = new SnUserDaoImpl();
        System.out.println(dao.checkName("micstart"));
    }

}
