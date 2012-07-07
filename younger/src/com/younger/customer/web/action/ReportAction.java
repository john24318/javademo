package com.younger.customer.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.younger.base.web.action.BaseAction;

public class ReportAction extends BaseAction {

    /**
     * 查看报告
     */
    public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String no = null == request.getParameter("no") ? null : request.getParameter("no").trim();

        // 参数检测
        if (null == no || 0 == no.length()) {
            return mapping.findForward("index");
        }

        return mapping.findForward("reportView");
    }

}
