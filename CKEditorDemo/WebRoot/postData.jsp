<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ include file="/pages/common/common.jsp"%>

<%!public String htmlspecialchars(String content) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);

            if (c > 0xFF) {
                i++;
                continue;
            }

            switch (c) {
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;

                case '&':
                    sb.append("&amp;");
                    break;
                case '"':
                    sb.append("&quot;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                default:
                    sb.append(c);
            }
        }

        return sb.toString();
    }

    public String htmlentities(String content) {
        content = content.replace("&", "&amp;");
        content = content.replace("<", "&lt;");
        content = content.replace(">", "&gt;");
        content = content.replace("\"", "&quot;");
        content = content.replace("'", "&apos;");

        return content;
    }%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="${ctx }" />
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	</head>

	<body>
		<table border="2">
			<tr>
				<th>
					Name
				</th>
				<th>
					Value
				</th>
			</tr>
			<%
			    request.setCharacterEncoding("UTF-8");
			    Enumeration names = request.getParameterNames();
			    while (names.hasMoreElements()) {
			        String parameterName = (String) names.nextElement();
			        String value = request.getParameter(parameterName);
			%>
			<tr>
				<td><%=parameterName%></td>
				<td><%=htmlentities(value)%></td>
			</tr>
			<%
			    }
			%>
			<tr>
				<td>
					test
				</td>
				<td>
					<c:out value="${param.editor1 }" escapeXml="true" />
				</td>
			</tr>
		</table>
	</body>
</html>
