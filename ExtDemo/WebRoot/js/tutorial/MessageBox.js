Ext.onReady(function() {
	// Basic alert:
	Ext.Msg.alert('标题', '消息内容');

		// // Confirm
		// Ext.Msg.confirm('确认', '确定要xxx么？', function(btn) {
		// alert("你按下了 " + btn + " 按钮：）");
		// });

		// // Prompt for user data and process the result using a callback:
		// Ext.Msg.prompt('输入xxx', '请输入xxx：', function(btn, text) {
		// alert("btn=" + btn + " xxx=" + text);
		// });

		// //进度条
		// Ext.Msg.progress('标题', '消息内容', '进度条');
		// Ext.Msg.updateProgress(0.5, '进度条', '消息内容');
		// //假进度条
		// Ext.Msg.wait('消息内容', '假进度条');

		// // Show a dialog using config options:
		// Ext.Msg.show({
		// title : '看到自定义的消息对话框了吗？',
		// msg : '这个就是一个自定义的消息对话框，想关闭不？',
		// buttons : {
		// ok : '是',
		// yes : '是',
		// no : '否',
		// cancel : '取消'
		// },
		// fn : function(btn) {
		// alert("你按下了 " + btn + " 按钮：）");
		// },
		// animEl : 'elId',
		// icon : Ext.MessageBox.QUESTION
		// });

	});