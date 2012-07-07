
/* 基本配置 */
/*
tinyMCE.init({mode:"textareas"});
*/
/* 高级配置 */
/*
tinyMCE.init({theme:"advanced", mode:"textareas", plugins:"fullpage", theme_advanced_buttons3_add:"fullpage"});
*/
/* 自定义配置 */
tinyMCE.init({
    //General options
    mode:"exact",
    elements : "editor1",
	theme:"advanced",
	//skin:"o2k7",
	//skin_variant:"silver",
	language:"zh",
	plugins:"fullpage,fullscreen",
	
	// Theme options
	theme_advanced_buttons1 : "bold,italic,underline,strikethrough,justifyleft,justifycenter,justifyright,justifyfull,outdent,indent,blockquote,bullist,numlist,link,unlink,anchor,image,forecolor,backcolor,formatselect,fontselect,fontsizeselect,cleanup,code,fullscreen",
	theme_advanced_buttons2 : null,
	theme_advanced_buttons3 : null,
	//theme_advanced_buttons1 : "bold,italic,underline,strikethrough,justifyleft,justifycenter,justifyright,justifyfull,outdent,indent,blockquote,bullist,numlist,link,unlink,anchor,image",
	//theme_advanced_buttons2 : "forecolor,backcolor,formatselect,fontselect,fontsizeselect,cleanup,code",
	//theme_advanced_buttons3 : null,
	theme_advanced_toolbar_location : "top",
	theme_advanced_toolbar_align : "left",
	theme_advanced_statusbar_location : "bottom",
	theme_advanced_resizing : true
});