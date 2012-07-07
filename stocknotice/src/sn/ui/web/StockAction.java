package sn.ui.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.base.web.servlet.BaseServlet;

public class StockAction extends BaseServlet {

	private static final long serialVersionUID = 7390505620657933671L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		String method = (null == req.getPathInfo()) ? null : req.getPathInfo().substring(1);

		if ("/stocks".equalsIgnoreCase(path)) {
			stocks(req, resp);// 股票列表
		} else if ("/stock".equalsIgnoreCase(path)) {
			if ("save".equalsIgnoreCase(method)) {
				save(req, resp); // 增加股票
			} else if ("delete".equalsIgnoreCase(method)) {
				delete(req, resp); // 删除股票
			} else {
				get(req, resp); // 查询股票
			}
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	/**
	 * 股票列表
	 */
	private void stocks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward("/pages/stock/stockList.jsp", req, resp);
	}

	/**
	 * 增加股票
	 */
	private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward("/pages/stock/stockEdit.jsp", req, resp);
	}

	/**
	 * 删除股票
	 */
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward("/pages/user/login.jsp", req, resp);
	}

	/**
	 * 查询股票
	 */
	private void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stockId = (null == req.getPathInfo()) ? null : req.getPathInfo().substring(1);
		try {
			Integer.parseInt(stockId);

		} catch (Exception e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
