<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="${ctx }" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="tinymce/jscripts/tiny_mce/tiny_mce.js"></script>
		<script type="text/javascript" src="scripts/tinymce/config.js"></script>
	</head>

	<body>
		<form action="postData.jsp" method="post">
			<p>
				My Editor:
				<br />
				<input name="test" value="123" />
				<textarea name="editor1" cols="50" rows="15">This is some content that will be editable with TinyMCE.</textarea>
			</p>
			<p>
				<input type="submit" value="提交" />
			</p>
		</form>
	</body>
</html>
