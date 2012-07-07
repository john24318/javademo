package com.younger.manager.persistence.dao;

import java.util.List;

import com.younger.base.persistence.dao.BaseDao;
import com.younger.manager.persistence.model.User;

@SuppressWarnings("unchecked")
public class UserDao extends BaseDao {

    /**
     * 查询用户
     * 
     * @param userLogin用户登录帐号
     * @return
     */
    public User get(String userLogin) {
        User user = null;
        String sql = "SELECT userId, userLogin, userPass, userNicename, userStatus, userRegistered, userLastlogin FROM users WHERE user_Login=?";
        user = (User) get(sql, new Object[] { userLogin }, User.class);
        return user;
    }

    /**
     * 查询所有用户
     * 
     * @return
     */
    public List all() {
        List ret = null;
        String sql = "SELECT userId, userLogin, userPass, userNicename, userStatus, userRegistered, userLastlogin FROM users";
        ret = find(sql, null, User.class);
        return ret;
    }

    /**
     * 新增用户
     * 
     * @param user
     * @return
     */
    public boolean add(User user) {
        boolean result = false;
        String sql = "INSERT INTO users (userLogin, userPass, userNicename, userStatus, userRegistered) VALUES(?, ?, ?, ?, ?)";
        Object[] params = { user.getUserLogin(), user.getUserPass(), user.getUserNicename(), user.getUserStatus(), user.getUserRegistered() };

        int count = update(sql, params);
        if (count > 0) {
            result = true;
        }

        return result;
    }

    /**
     * 修改用户
     * 
     * @param user
     * @return
     */
    public boolean update(User user) {
        boolean result = false;
        String sql = "UPDATE users SET userPass=?, userNicename=?, userStatus=?, userLastlogin=? WHERE userLogin=?";
        Object[] params = { user.getUserPass(), user.getUserNicename(), user.getUserStatus(), user.getUserLastlogin(), user.getUserLogin() };

        int count = update(sql, params);
        if (count > 0) {
            result = true;
        }

        return result;
    }

    public static void main(String[] args) {
        UserDao dao = new UserDao();
        System.out.println(dao.all().get(0));
    }
}
