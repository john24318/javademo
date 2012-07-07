package sn.ui.service;

import sn.core.persistence.model.SnUser;

public interface UserService {

    /**
     * 检测用户名是否存在
     * 
     * @param name
     * @return true已存在,flase不存在
     */
    public boolean checkName(String name);

    /**
     * 新增
     * 
     * @param user
     * @return
     */
    public boolean add(SnUser user);

    /**
     * 查询单个用户
     * 
     * @param userId 用户ID
     * @return
     */
    public SnUser get(Integer userId);

    /**
     * 查询单个用户
     * 
     * @param login 登录帐号
     * @return
     */
    public SnUser get(String login);

    /**
     * 激活用户
     * 
     * @param userId
     * @param activeCode
     * @return
     */
    public boolean activate(Integer userId, String activeCode);

    /**
     * 登录
     * 
     * @param login
     * @param password
     * @return
     */
    public SnUser login(String login, String password);
}
