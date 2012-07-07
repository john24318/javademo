<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="${ctx }">
		<title>图片列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

		<script type="text/javascript">
			<c:if test="${null != msg}">
				alert('${msg }');
			</c:if>
			function add() {
				window.location = "${ctx}photo.do?method=edit";
			}
			
			//删除单个图片
			function del(id, name) {
				var r = confirm("确定要删除“"+ name +"”图片吗？");
				if (r) {
					window.location = "${ctx}photo.do?method=delete&ids=" + id;
				}
			}
			
			function selectAll() {
				var ids = document.getElementsByName("ids");
				
				for(var i=0; i < ids.length; i++) {
					ids[i].checked = true;
				}
			}
			
			function checkForm() {
				var f = document.forms[0];
				var ids = document.getElementsByName("ids");
				var isCheck = false;
				
				for(var i=0; i < ids.length; i++) {
					if(ids[i].checked) {
						isCheck = true;
						break;
					}
				}
				
				if (!isCheck) {
					alert("请选择要删除的图片！");
					return false;
				}
				
				var r = confirm("确定要删除选中的图片吗？");
				if (r) {
					f.submit();
				}
			}
		</script>
	</head>

	<body>
		<form action="photo.do?method=delete" method="post">
			<table style="text-align: center; width: 100%; border: 1px; border-style: solid;">
				<tr>
					<th>
						ID
					</th>
					<th>
						描述
					</th>
					<th>
						创建时间
					</th>
					<th>
						操作
					</th>
				</tr>

				<c:forEach var="photo" items="${photoList }">
					<tr>
						<td>
							<input name="ids" type="checkbox" value="${photo.id }" />
						</td>
						<td>
							<a href="photo.do?method=image&id=${photo.id }">${photo.name }</a>
						</td>
						<td>
							<fmt:formatDate value="${photo.createTime }" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td>
							<a href="photo.do?method=edit&id=${photo.id }">修改</a>
							<a onclick="del(${photo.id }, '${photo.name }');" style="cursor: hand;">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>

			<p align="center">
				共
				<b>${pageInfo.totalRows }</b> 个&nbsp;&nbsp;
				<a <c:if test="${pageInfo.pageNo > 1 }">href="photo.do?method=list&pageInfo.pageNo=1"</c:if>>首页</a>
				<a <c:if test="${pageInfo.pageNo > 1 }">href="photo.do?method=list&pageInfo.pageNo=${pageInfo.pageNo - 1 }"</c:if>>上一页</a>&nbsp;
				<a <c:if test="${pageInfo.pageNo < pageInfo.totalPages }">href="photo.do?method=list&pageInfo.pageNo=${pageInfo.pageNo + 1 }"</c:if>>下一页</a>&nbsp;
				<a <c:if test="${pageInfo.pageNo < pageInfo.totalPages }">href="photo.do?method=list&pageInfo.pageNo=${pageInfo.totalPages }"</c:if>>尾页</a>&nbsp;页次：
				<strong><font color="red">${pageInfo.pageNo }</font>/${pageInfo.totalPages }</strong>页 &nbsp;
				<b>${pageInfo.pageSize }</b>个/页
			</p>

			<input onclick="selectAll();" value="全选" type="button" />
			<input onclick="add();" value="新增" type="button" />
			<input onclick="checkForm();" value="删除" type="button" />
		</form>
	</body>
</html>
