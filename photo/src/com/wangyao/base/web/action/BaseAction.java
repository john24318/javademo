package com.wangyao.base.web.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.wangyao.base.util.ConvertUtil;
import com.wangyao.base.util.DateConverter;

public class BaseAction extends DispatchAction {
    protected final Log log = LogFactory.getLog(getClass());

    private static final Object defaultValue = null;

    // 注册转换器
    static {
        ConvertUtils.register(new DateConverter(defaultValue), Date.class);
        ConvertUtils.register(new ShortConverter(defaultValue), Short.class);
        ConvertUtils.register(new LongConverter(defaultValue), Long.class);
        ConvertUtils.register(new IntegerConverter(defaultValue), Integer.class);
    }

    /**
     * 转换form到pojo或者把pojo转成form
     * 
     * @param o
     * @return
     * @throws Exception
     */
    protected Object convert(Object o) throws Exception {
        return ConvertUtil.convert(o);
    }

    /**
     * 获取国际化消息资源 Convenience method to initialize messages in a subclass.
     */
    public ActionMessages getMessages(HttpServletRequest request) {
        ActionMessages messages = null;
        HttpSession session = request.getSession();

        if (request.getAttribute(Globals.MESSAGE_KEY) != null) {
            messages = (ActionMessages) request.getAttribute(Globals.MESSAGE_KEY);
            saveMessages(request, messages);
        } else if (session.getAttribute(Globals.MESSAGE_KEY) != null) {
            messages = (ActionMessages) session.getAttribute(Globals.MESSAGE_KEY);
            saveMessages(request, messages);
            session.removeAttribute(Globals.MESSAGE_KEY);
        } else {
            messages = new ActionMessages();
        }

        return messages;
    }

    /**
     * 获得FormBean
     * 
     * @param mapping
     * @param request
     * @return
     */
    protected ActionForm getActionForm(ActionMapping mapping, HttpServletRequest request) {
        ActionForm actionForm = null;

        // Remove the obsolete form bean
        if (mapping.getAttribute() != null) {
            if ("request".equals(mapping.getScope())) {
                actionForm = (ActionForm) request.getAttribute(mapping.getAttribute());
            } else {
                HttpSession session = request.getSession();
                actionForm = (ActionForm) session.getAttribute(mapping.getAttribute());
            }
        }

        return actionForm;
    }

    /**
     * 删除FormBean
     * 
     * @param mapping
     * @param request
     */
    protected void removeFormBean(ActionMapping mapping, HttpServletRequest request) {
        // Remove the obsolete form bean
        if (mapping.getAttribute() != null) {
            if ("request".equals(mapping.getScope())) {
                request.removeAttribute(mapping.getAttribute());
            } else {
                HttpSession session = request.getSession();
                session.removeAttribute(mapping.getAttribute());
            }
        }
    }

    /**
     * 更新FormBean
     * 
     * @param mapping
     * @param request
     * @param form
     */
    protected void updateFormBean(ActionMapping mapping, HttpServletRequest request, ActionForm form) {
        // Remove the obsolete form bean
        if (mapping.getAttribute() != null) {
            if ("request".equals(mapping.getScope())) {
                request.setAttribute(mapping.getAttribute(), form);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute(mapping.getAttribute(), form);
            }
        }
    }
}
