package sn.ui.service.impl;

import java.util.Date;

import sn.base.util.Constants;
import sn.base.util.RandomUtil;
import sn.base.util.StringUtil;
import sn.core.persistence.dao.SnUserDao;
import sn.core.persistence.dao.impl.SnUserDaoImpl;
import sn.core.persistence.model.SnUser;
import sn.ui.service.UserService;

public class UserServiceImpl implements UserService {

    private SnUserDao userDao = new SnUserDaoImpl();

    /**
     * 检测用户名是否存在
     */
    public boolean checkName(String name) {
        return userDao.checkName(name);
    }

    /**
     * 新增
     */
    public boolean add(SnUser user) {
        boolean result = false;

        if (null == user || null == user.getLogin() || null == user.getPassword() || null == user.getEmail()
                || null == user.getMobilePhoneNumber()) {
            return result;
        }

        user.setPassword(StringUtil.encodePassword(user.getPassword(), Constants.ALGORITHM));
        user.setRegistered(new Date());
        user.setActiveCode(RandomUtil.generatorNumber(Constants.ACTIVE_CODE_LENGTH));
        user.setState(Constants.USER_STATE_LOCK);

        result = userDao.add(user);
        return result;
    }

    /**
     * 查询单个用户
     */
    public SnUser get(Integer userId) {
        return userDao.get(userId);
    }

    /**
     * 查询单个用户
     */
    public SnUser get(String login) {
        return userDao.get(login);
    }

    /**
     * 激活用户
     */
    public boolean activate(Integer userId, String activeCode) {
        boolean result = false;
        SnUser user = userDao.get(userId);
        if (null != user && user.getActiveCode().equals(activeCode)) {
            result = userDao.updateState(userId, Constants.USER_STATE_ACTIVE);
        }
        return result;
    }

    /**
     * 登录
     */
    public SnUser login(String login, String password) {
        String encodePassword = StringUtil.encodePassword(password, Constants.ALGORITHM);
        SnUser user = userDao.get(login);

        if (null != user && user.getPassword().equals(encodePassword)) {
            return user;
        }

        return null;
    }

}
