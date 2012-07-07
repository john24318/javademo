<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="${ctx }" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
	</head>

	<body>
		<form action="postData.jsp" method="post">
			<p>
				My Editor:
				<br />
				<input name="test" value="123" />
				<textarea name="editor1">&lt;p&gt;Initial value.&lt;/p&gt;</textarea>
				<script type="text/javascript">
					CKEDITOR.replace( 'editor1', {
				        customConfig : 'scripts/ckeditor/config.js'
				    });
				</script>
			</p>
			<p>
				<input type="submit" />
			</p>
		</form>
	</body>
</html>
