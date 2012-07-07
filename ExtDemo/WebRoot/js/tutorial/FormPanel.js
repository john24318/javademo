Ext.onReady(function() {
			var top = new Ext.FormPanel({
						labelAlign : 'top',
						frame : true,
						title : 'Multi Column, Nested Layouts and Anchoring',
						bodyStyle : 'padding:5px 5px 0',
						width : 600,
						items : [{
									layout : 'column',
									items : [{
												columnWidth : .5,
												layout : 'form',
												items : [{
															xtype : 'textfield',
															fieldLabel : '名',
															name : 'first',
															anchor : '95%'
														}, {
															xtype : 'textfield',
															fieldLabel : '公司',
															name : 'company',
															anchor : '95%'
														}]
											}, {
												columnWidth : .5,
												layout : 'form',
												items : [{
															xtype : 'textfield',
															fieldLabel : '姓',
															name : 'last',
															anchor : '95%'
														}, {
															xtype : 'textfield',
															fieldLabel : '电子邮箱',
															name : 'email',
															vtype : 'email',
															anchor : '95%'
														}]
											}]
								}, {
									xtype : 'htmleditor',
									id : 'bio',
									fieldLabel : '简介',
									height : 200,
									anchor : '98%'
								}],

						buttons : [{
									id : 'btnSave',
									text : '保存'
								}, {
									id : 'btnCancel',
									text : '取消'
								}]
					});

			top.render(document.body);
		});