<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:if test="${\"80\"==pageContext.request.serverPort}">
	<c:set var="ctx"
		value="${pageContext.request.scheme}://${pageContext.request.serverName}${pageContext.request.contextPath}/" />
</c:if>
<c:if test="${\"80\"!=pageContext.request.serverPort}">
	<c:set var="ctx"
		value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
</c:if>