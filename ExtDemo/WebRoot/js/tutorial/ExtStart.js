Ext.onReady(function() {

			// 检查配置是否正确:onReady方法会在DOM全部加载完毕后，保证页面内的所有元素能被Script引用（reference）之后调用。
			alert("Congratulations! You have Ext configured correctly!");

			/*
			 * Element：Ext的核心
			 * 包含了常见的DOM方法和属性，提供一个快捷的、统一的、跨浏览器的接口（若使用Element.dom的话，就可以直接访问底层DOM的节点。）；
			 * Element.get()方法提供内置缓存（Cache），多次访问同一对象效率上有极大优势；
			 * 内置常用的DOM节点的动作，并且是跨浏览器的定位的位置、大小、动画、拖放等等（添加/移除 CSS 类, 添加/移除事件处理程序,
			 * 定位, 改变大小, 动画, 拖放）。
			 */
			// 获取单个DOM元素
			var myDiv = Ext.get("myDiv");
			myDiv.highlight(); // 黄色高亮显示然后渐退
			myDiv.addClass("red"); // 添加自定义CSS类 (在ExtStart.css定义)
			myDiv.center(); // 在视图中将元素居中
			myDiv.setOpacity(0.25); // 使元素半透明
			// 获取多个DOM的节点：Element.select方法内部调用DomQuery选取元素。
			// DomQuery的选取参数可以是一段较长的数组，其中包括W3C CSS3 Dom选取器、基本XPatch、HTML属性和更多。
			Ext.select("p").highlight();// 每段高亮显示

			// 响应事件
			var btn = Ext.get("myButton");
			btn.on("click", function() {
						alert("2.你单击了按钮");
					});
			btn.on("click", function(e) {
						alert("1.你单击了按钮" + e.target.id);
					});

			// 使用Widgets
			Ext.select('p').on('click', function(e) {
						var paragraph = Ext.get(e.target);
						paragraph.highlight();
						Ext.MessageBox.show({
									title : 'Paragraph Clicked',
									msg : paragraph.dom.innerHTML,
									width : 400,
									buttons : Ext.MessageBox.OK,
									animEl : paragraph
								});
					});

		});
