package sn.base.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 4966447536819769396L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	protected abstract void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException;

	protected void forward(String path, HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		req.getRequestDispatcher(path).forward(req, resp);
	}

	protected void redirect(String location, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(location);
	}
}
