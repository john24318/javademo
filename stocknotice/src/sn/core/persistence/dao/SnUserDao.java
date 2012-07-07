package sn.core.persistence.dao;

import sn.base.persistence.dao.Dao;
import sn.core.persistence.model.SnUser;

/**
 * 用户数据接口
 * 
 * @author 王耀
 * 
 */
public interface SnUserDao extends Dao {

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
     * 修改状态
     * 
     * @param userId
     * @param state
     * @return
     */
    public boolean updateState(Integer userId, Short state);

}
