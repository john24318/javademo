<%@ page language="java" pageEncoding="UTF-8"%>
<%
    request.getRequestDispatcher("photo.do?method=list").forward(request, response);
%>