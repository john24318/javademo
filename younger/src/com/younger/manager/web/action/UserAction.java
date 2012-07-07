package com.younger.manager.web.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.younger.base.util.Constants;
import com.younger.base.util.StringUtil;
import com.younger.base.web.action.BaseAction;
import com.younger.manager.persistence.dao.UserDao;
import com.younger.manager.persistence.model.User;

public class UserAction extends BaseAction {

    /**
     * 用户登录
     */
    public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm df = (DynaActionForm) form;
        String userLogin = df.getString("userLogin").trim();
        String userPass = df.getString("userPass").trim();
        String encodePwd = StringUtil.encodePassword(userPass, Constants.ALGORITHM);
        UserDao dao = new UserDao();

        // 参数检测
        if (null == userLogin || null == userPass || "".equals(userLogin) || "".equals(userPass)) {
            return mapping.findForward("login");
        }

        // 查找用户
        User user = dao.get(userLogin);

        // 用户不存在或密码错误
        if (null == user || !encodePwd.equals(user.getUserPass())) {
            request.setAttribute("msg", "用户名或密码错误！");
            return mapping.findForward("login");
        }

        // 更新最后登录时间
        user.setUserLastlogin(new Date());
        dao.update(user);

        request.getSession().setAttribute(Constants.SESSION_USER, user);
        return mapping.findForward("login");
    }

    /**
     * 用户登出
     */
    public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.getSession().removeAttribute(Constants.SESSION_USER);
        return mapping.findForward("login");
    }

    /**
     * 编辑用户信息
     */
    public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm df = (DynaActionForm) form;
        String userNicename = df.getString("userNicename").trim();
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);

        // 修改用户信息
        UserDao dao = new UserDao();
        User updatedUser = (User) user.clone();
        updatedUser.setUserNicename(userNicename);
        boolean result = dao.update(updatedUser);

        if (!result) {
            request.setAttribute("msg", "修改用户信息失败！");
            return mapping.findForward("pwd");
        }

        // 更新session中用户信息
        request.getSession().setAttribute(Constants.SESSION_USER, updatedUser);
        request.setAttribute("msg", "修改用户信息成功！");
        return mapping.findForward("pwd");
    }

    /**
     * 修改密码
     */
    public ActionForward pwd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm df = (DynaActionForm) form;
        String userPass = df.getString("userPass").trim();
        String encodePwd = StringUtil.encodePassword(userPass, Constants.ALGORITHM);
        String newUserPass = df.getString("newUserPass").trim();
        String encodeNewPwd = StringUtil.encodePassword(newUserPass, Constants.ALGORITHM);
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);

        // 检测原密码
        if (!encodePwd.equals(user.getUserPass())) {
            request.setAttribute("msg", "原密码错误！");
            return mapping.findForward("pwd");
        }

        // 修改密码
        UserDao dao = new UserDao();
        User updatedUser = (User) user.clone();
        updatedUser.setUserPass(encodeNewPwd);
        boolean result = dao.update(updatedUser);

        if (!result) {
            request.setAttribute("msg", "修改密码失败！");
            return mapping.findForward("pwd");
        }

        // 更新session中用户信息
        request.getSession().setAttribute(Constants.SESSION_USER, updatedUser);
        request.setAttribute("msg", "修改密码成功！");
        return mapping.findForward("pwd");
    }
}
