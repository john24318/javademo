
/*
使用定制的配置文件
*/
CKEDITOR.editorConfig = function (config) {
	config.language = "zh-cn"; //指定语言
	config.uiColor = "#AADC6E";//颜色
	config.skin = "kama";//皮肤office2003,v2,kama
	config.toolbar = "MyToolbar";//工具栏
	config.toolbar_MyToolbar = [["Bold", "Italic", "Underline", "Strike"], ["JustifyLeft", "JustifyCenter", "JustifyRight", "JustifyBlock"], ["NumberedList", "BulletedList"], ["Link", "Unlink", "Image", "Flash"], ["Font", "FontSize"], ["TextColor", "BGColor"], ["Maximize"], ["Source", "PasteFromWord", "Preview"]];//自定义工具栏
};

