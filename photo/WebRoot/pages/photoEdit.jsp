<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/pages/common/common.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="${ctx }">
		<title>图片上传</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="-1">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link href="styles/swfupload/swfupload.css" rel="stylesheet"
			type="text/css" />
		<script src="scripts/swfupload/swfupload.js" type="text/javascript"></script>
		<script src="scripts/swfupload/handlers.js" type="text/javascript"></script>
		<script type="text/javascript">
			function checkForm(obj) {
				var f = document.forms[0];
				var isOK = false;
				
				if (/^.+\.(jpe|jpg|jpeg|png|gif|bmp)$/i.test(f.image.value)) {
					isOK = true;
				}
				
				if (/^.+\.(jpe|jpg|jpeg|png|gif|bmp)$/i.test(f.netImage.value)) {
					isOK = true;
				}
			
				if (isOK) {
					obj.disabled=true;
					f.submit();
				} else {
					alert("请选择jpe，jpg，jpeg，png，gif，bmp格式图片！");
				}
			}
			
			function setName(file) {
				var name = document.getElementById("name");
				var filePath = file.value;
				
				if (!name.value) {
					if (filePath.lastIndexOf("\\") > 0)
						name.value = filePath.substring(filePath.lastIndexOf("\\") + 1, filePath.length);
					
					if (filePath.lastIndexOf("/") > 0)
						name.value = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length);
				}
			}
			
			var swfu;
			window.onload = function () {
				swfu = new SWFUpload({
					// Backend Settings
					upload_url: "photo.do?method=save", //请求路径
					file_post_name : "image", //默认值：Filedata，设置POST信息中上传文件的name值
					post_params: {
						"id": "${photo.id }"
					},
	
					// File Upload Settings
					file_size_limit : "3 MB", // 设置文件选择对话框的文件大小过滤规则
					file_types : "*.jpe;*.jpg;*.jpeg;*.png;*.gif;*.bmp", //设置文件选择对话框的文件类型过滤规则
					file_types_description : "图片", //设置文件选择对话框中显示给用户的文件描述
					file_upload_limit : "2", //设置SWFUpload实例允许上传的最多文件数量
	
					// Event Handler Settings - these functions as defined in Handlers.js
					//  The handlers are not part of SWFUpload but are part of my website and control how
					//  my website reacts to the SWFUpload events.
					file_queue_error_handler : fileQueueError,
					file_dialog_complete_handler : fileDialogComplete,
					upload_start_handler : uploadStart,
					upload_progress_handler : uploadProgress,
					upload_error_handler : uploadError,
					//upload_success_handler : uploadSuccess,
					upload_complete_handler : uploadComplete,
	
					// Button Settings
					button_image_url : "images/swfupload/SmallSpyGlassWithTransperancy_17x18.png",
					button_placeholder_id : "spanButtonPlaceholder",
					button_width: 124,
					button_height: 18,
					button_text : '<span class="button">选择文件 <span class="buttonSmall">(最大3M)</span></span>',
					button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 12pt; } .buttonSmall { font-size: 10pt; }',
					button_text_top_padding: 0,
					button_text_left_padding: 18,
					button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
					button_cursor: SWFUpload.CURSOR.HAND,
					
					// Flash Settings
					flash_url : "scripts/swfupload/swfupload.swf",
	
					custom_settings : {
						upload_target : "divFileProgressContainer"
					},
					
					// Debug Settings
					debug: false
				});
			};
	</script>
	</head>

	<body>
		<form action="photo.do?method=save" method="post"
			enctype="multipart/form-data">
			<input name="id" value="${photo.id }" type="hidden" />
			<fieldset>
				<legend align="center">
					添加图片
				</legend>
				<br />
				<label for="name">
					图片描述
				</label>
				<input id="name" name="name" value="${photo.name }" type="text" />
				<br />
				<br />
				<label for="image">
					本机图片
				</label>
				<input id="image" name="image" onchange="setName(this);" type="file" />
				<br />
				<br />
				<label for="netImage">
					网络图片
				</label>
				<input id="netImage" name="netImage" onchange="setName(this);"
					type="text" />
				<br />
				<br />
				<input onclick="checkForm(this);" type="button" value=" 提 交 "
					style="cursor: hand;" />
				<br />
				<br />
			</fieldset>
		</form>

		<div id="content">
			<form>
				<div
					style="display: inline; border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;">
					<span id="spanButtonPlaceholder"></span>
				</div>
			</form>
			<div id="divFileProgressContainer" style="height: 75px;"></div>
			<div id="thumbnails"></div>
		</div>
	</body>
</html>

