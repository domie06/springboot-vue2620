<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<!-- 充值 -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>充值</title>
		<link rel="stylesheet" href="../../layui/css/layui.css">
		<!-- 样式 -->
		<link rel="stylesheet" href="../../css/style.css" />
		<!-- 主题（主要颜色设置） -->
		<link rel="stylesheet" href="../../css/theme.css" />
		<!-- 通用的css -->
		<link rel="stylesheet" href="../../css/common.css" />
		<style type="text/css">
			.pay-type-list {
				display: flex;
				align-items: center;
				flex-wrap: wrap;
			}

			.pay-type-item {
				background: #FFFFFF;
				border: 3px dotted #EEEEEE;
				margin: 20px;
				padding: 20px;
				width: 200px;
			}
		</style>
	</head>
	<body style="background: #EEEEEE;">

		<div id="app">

			<form class="layui-form" lay-filter="myForm">
				<%--<div class="layui-form-item" style="margin: 20px;background: #FFFFFF;border:3px dotted #EEEEEE;padding: 20px;">
					<label class="layui-form-label">可提现金额</label>
					<div class="layui-input-block">
                        <input type="number" readonly style="width: 500px;" v-model="user.newMoney" lay-verify="required|double" placeholder="可提现金额" autocomplete="off" class="layui-input">
					</div>
				</div>--%>
				<div class="layui-form-item" style="margin: 20px;background: #FFFFFF;border:3px dotted #EEEEEE;padding: 20px;">
					<label class="layui-form-label">要提现金额</label>
					<div class="layui-inline">
                        <input style="width: 200px" type="number" name="newMoney" style="width: 500px;" id="newMoney" lay-verify="required|double" placeholder="要提现金额" autocomplete="off" class="layui-input"><span style="color: red">可提现金额:{{user.newMoney}}</span>
					</div>
				</div>
				<div class="layui-form-item" style="margin: 20px;background: #FFFFFF;border:3px dotted #EEEEEE;padding: 20px;">
					<label class="layui-form-label">账户名</label>
					<div class="layui-input-block">
                        <input type="text" style="width: 500px;" lay-verify="required" placeholder="账户名" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" style="margin: 20px;background: #FFFFFF;border:3px dotted #EEEEEE;padding: 20px;">
					<label class="layui-form-label">账户</label>
					<div class="layui-input-block">
                        <input type="text" style="width: 500px;" lay-verify="required" placeholder="账户" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" style="margin: 20px;background: #FFFFFF;border:3px dotted #EEEEEE;padding: 20px;">
					<label class="layui-form-label">平台</label>
					<div  class="layui-input-inline" style="width: 500px">
						<input type="radio" name="sex" value="nan" title="微信平台"  checked>
						<input type="radio" name="sex" value="nv" title="支付宝平台">
						<input type="radio" name="sex" value="nv" title="建设银行平台">
						<input type="radio" name="sex" value="nv" title="农业银行平台">
						<input type="radio" name="sex" value="nv" title="农业银行平台">
						<input type="radio" name="sex" value="nv" title="中国银行平台">
						<input type="radio" name="sex" value="nv" title="交通银行平台">
						<%--<select name="sexTypes" id="sexTypes">
							<option value="1" key="1">微信平台</option>
						</select>--%>
					</div>
				</div>
				<button style="margin-left: 20px;width:860px;height: 40px;line-height: 40px;" class="layui-btn btn-submit btn-theme"
				 lay-submit lay-filter="*">确认提现</button>
			</form>

		</div>
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
        </script>
        <%--<script src="../../../resources/js/jquery.min.js"></script>--%>
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
		<!-- layui -->
		<script src="../../layui/layui.js"></script>
		<!-- vue -->
		<script src="../../js/vue.js"></script>
		<!-- 组件配置信息 -->
		<script src="../../js/config.js"></script>
		<!-- 扩展插件配置信息 -->
		<script src="../../modules/config.js"></script>
		<!-- 工具方法 -->
		<script src="../../js/utils.js"></script>
		<!-- 校验格式工具类 -->
		<script src="../../js/validate.js"></script>

		<script>
			var vue = new Vue({
				el: '#app',
				data: {
					user: {}
				},
				filters: {
					newsDesc: function(val) {
						if (val) {
							if (val.length > 200) {
								return val.substring(0, 200).replace(/<[^>]*>/g).replace(/undefined/g, '');
							} else {
								return val.replace(/<[^>]*>/g).replace(/undefined/g, '');
							}
						}
						return '';
					}
				},
				methods: {
					jump(url) {
						jump(url)
					}
				}
			})

			layui.use(['layer', 'element', 'http', 'jquery', 'form'], function() {
				var layer = layui.layer;
				var element = layui.element;
				var http = layui.http;
				var jquery = layui.jquery;
				var form = layui.form;

				// 查询用户信息
				let table = localStorage.getItem("userTable");
				http.request(`${table}/session`, 'get', {}, function(data) {
					vue.user = data.data;
				});


                // 表单效验规则
                form.verify({
                    // 正整数效验规则
                    integer: [
                        /^[1-9][0-9]*$/
                        ,'必须是正整数'
                    ]
                    // 小数效验规则
                    ,double: [
                        /^[0-9]{0,6}(\.[0-9]{1,2})?$/
                        ,'最大整数位为6为,小数最大两位'
                    ]
                });
				
				// 提交表单
				form.on('submit(*)', function(data) {
					// 添加金额
					data = data.field;
					if(Number(data.newMoney)<=0 && String(data.newMoney).indexOf('.') != -1 &&(String(data.newMoney).length - (String(data.newMoney).indexOf('.') + 1))>2) {
						layer.msg('请输入正确金额，只能提现两位小数的正数金额', {
								time: 2000,
								icon:5
						});
						return false;
					}
                    let balance = Number(vue.user.newMoney)- Number(data.newMoney);
					if(balance <0){
                        layer.msg('提现金额大于余额，请检查', {
                            time: 2000,
                            icon:5
                        });
                        return false;
					}
                    vue.user.newMoney = balance;
					http.requestJson(`${table}/update`, 'post',vue.user, function(data) {
						layer.msg('提现成功', {
							time: 2000,
							icon: 6
						}, function() {
							window.parent.location.reload();
						});
					});
					return false
				});

			});
		</script>
	</body>
</html>
