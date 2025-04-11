<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>

</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto" id="navUl">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑基金</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">基金管理</li>
                        <li class="breadcrumb-item active">基金登记</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">基金信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表所有字段 -->

                                        <div class="form-group col-md-6">
                                            <label>基金经理姓名</label>
                                            <input style="width: 450px" id="jijinjingliName" name="jijinjingliName" class="form-control"
                                                   v-model="ruleForm.jijinjingliName" readonly>
                                        </div>


                                    <div class="form-group col-md-6">
                                        <label>基金经理照片</label>
                                        <img id="jijinjingliPhotoImg" width="100" height="100">
                                    </div>

                                        <div class="form-group col-md-6">
                                            <label>工作年限</label>
                                            <input style="width: 450px" id="jijinjingliGongzuo" name="jijinjingliGongzuo" class="form-control"
                                                   v-model="ruleForm.jijinjingliGongzuo" readonly>
                                        </div>


                                    <div class="form-group col-md-6">
                                        <label>性别</label>
                                        <input style="width: 450px" id="sexValue" name="sexValue" class="form-control"
                                               v-model="ruleForm.sexValue" readonly>
                                    </div>


                                    <div class="form-group col-md-6">
                                         <label>任期及回报</label>
                                        <sapn html="jijinjingliRenqiText"></sapn>
                                    </div>

                                    <div>
                                        <label>基金经理档案</label>
                                        <script id="jijinjingliContentEditor" type="text/plain"
                                                style="width:800px;height:230px;"></script>
                                        <script type = "text/javascript" >
                                        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                        //相见文档配置属于你自己的编译器
                                        var jijinjingliContentUe = UE.getEditor('jijinjingliContentEditor', {
                                            toolbars: [
                                                [
                                                    'undo', //撤销
                                                    'bold', //加粗
                                                    'redo', //重做
                                                    'underline', //下划线
                                                    'horizontal', //分隔线
                                                    'inserttitle', //插入标题
                                                    'cleardoc', //清空文档
                                                    'fontfamily', //字体
                                                    'fontsize', //字号
                                                    'paragraph', //段落格式
                                                    'inserttable', //插入表格
                                                    'justifyleft', //居左对齐
                                                    'justifyright', //居右对齐
                                                    'justifycenter', //居中对
                                                    'justifyjustify', //两端对齐
                                                    'forecolor', //字体颜色
                                                    'fullscreen', //全屏
                                                    'edittip ', //编辑提示
                                                    'customstyle', //自定义标题
                                                ]
                                            ]
                                        });
                                        </script>
                                        <input type="hidden" name="jijinjingliContent" id="jijinjingliContent-input">
                                    </div>

                            <!-- 本表所有字段 -->



                                    <input id="updateId" name="id" type="hidden">
                                <input id="jijinjingliId" name="jijinjingliId" v-model="ruleForm.jijinjingliId" readonly type="hidden">

                                    <div class="form-group col-md-6">
                                        <label>基金代码</label>
                                        <input style="width: 450px" id="jijinUuidNumber" name="jijinUuidNumber" class="form-control"
                                               v-model="ruleForm.jijinUuidNumber" readonly>
                                    </div>


                                    <div class="form-group col-md-6">
                                        <label>基金名称</label>
                                        <input style="width: 450px" id="jijinName" name="jijinName" class="form-control"
                                               v-model="ruleForm.jijinName" readonly>
                                    </div>

                                <div class="form-group col-md-6">
                                    <label>基金照片</label>
                                    <img id="jijinPhotoImg" width="100" height="100">
                                </div>

                                <div class="form-group col-md-6">
                                    <label>基金类型</label>
                                    <input style="width: 450px" id="jijinValue" name="jijinValue" class="form-control"
                                           v-model="ruleForm.jijinValue" readonly>
                                </div>

                                <div class="form-group col-md-6">
                                    <label>基金风险类型</label>
                                    <input style="width: 450px" id="jijinFengxianValue" name="jijinFengxianValue" class="form-control"
                                           v-model="ruleForm.jijinFengxianValue" readonly>
                                </div>

                                    <div class="form-group col-md-6">
                                        <label>点击次数</label>
                                        <input style="width: 450px" id="jijinClicknum" name="jijinClicknum" class="form-control"
                                               v-model="ruleForm.jijinClicknum" readonly>
                                    </div>


                                <div class="form-group col-md-6">
                                    <label>首页推荐</label>
                                    <input style="width: 450px" id="jijinTuijianValue" name="jijinTuijianValue" class="form-control"
                                           v-model="ruleForm.jijinTuijianValue" readonly>
                                </div>

                                <div>
                                    <label>基金档案</label>
                                    <script id="jijinContentEditor" type="text/plain"
                                            style="width:800px;height:230px;"></script>
                                    <script type = "text/javascript" >
                                    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                    //相见文档配置属于你自己的编译器
                                    var jijinContentUe = UE.getEditor('jijinContentEditor', {
                                        toolbars: [
                                            [
                                                'undo', //撤销
                                                'bold', //加粗
                                                'redo', //重做
                                                'underline', //下划线
                                                'horizontal', //分隔线
                                                'inserttitle', //插入标题
                                                'cleardoc', //清空文档
                                                'fontfamily', //字体
                                                'fontsize', //字号
                                                'paragraph', //段落格式
                                                'inserttable', //插入表格
                                                'justifyleft', //居左对齐
                                                'justifyright', //居右对齐
                                                'justifycenter', //居中对
                                                'justifyjustify', //两端对齐
                                                'forecolor', //字体颜色
                                                'fullscreen', //全屏
                                                'edittip ', //编辑提示
                                                'customstyle', //自定义标题
                                            ]
                                        ]
                                    });
                                    </script>
                                    <input type="hidden" name="jijinContent" id="jijinContent-input">
                                </div>

                                <div class="form-group col-md-12 mb-3">
                                    <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>

<script>
    <%@ include file="../../utils/menu.jsp"%>
            <%@ include file="../../static/setMenu.js"%>
            <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "jijin";
    var pageType = "add-or-update";
    var updateId = "";

    var jijinTypesOptions = [];
    var jijinFengxianTypesOptions = [];
    var jijinTuijianTypesOptions = [];
    var shangxiaTypesOptions = [];

    var ruleForm = {};
    var vm = new Vue({
        el: '#addOrUpdateForm',
        data: {
            ruleForm: {},
        },
        beforeCreate: function () {
            var id = window.sessionStorage.getItem("updateId");
            if (id != null && id != "" && id != "null") {
                $.ajax({
                    type: "GET",
                    url: baseUrl + "jijin/info/" + id,
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader("token", window.sessionStorage.getItem('token'));
                    },
                    success: function (res) {
                        if (res.code == 0) {
                            vm.ruleForm = res.data;
                            ruleForm = res.data;
                            showImg();
                            setContent();
                        } else if (res.code == 401) {
                        <%@ include file="../../static/toLogin.jsp"%>
                        } else {
                            alert(res.msg)
                        }
                    },
                });
            }
        },
        methods: {}
    });


    // 填充富文本框
    function setContent() {

        if (ruleForm.jijinjingliContent != null && ruleForm.jijinjingliContent != 'null' && ruleForm.jijinjingliContent != '') {
            var jijinjingliContentUeditor = UE.getEditor('jijinjingliContentEditor');
                jijinjingliContentUeditor.ready(function () {
                    var mes = '';
                    if(ruleForm.jijinjingliContent != null){
                        mes = ''+ ruleForm.jijinjingliContent;
                        // mes = mes.replace(/\n/g, "<br>");
                    }
                    jijinjingliContentUeditor.setContent(mes);
                    jijinjingliContentUeditor.setDisabled('fullscreen');
            });
        }
        if (ruleForm.jijinContent != null && ruleForm.jijinContent != 'null' && ruleForm.jijinContent != '') {
            var jijinContentUeditor = UE.getEditor('jijinContentEditor');
                jijinContentUeditor.ready(function () {
                    var mes = '';
                    if(ruleForm.jijinContent != null){
                        mes = ''+ ruleForm.jijinContent;
                        // mes = mes.replace(/\n/g, "<br>");
                    }
                    jijinContentUeditor.setContent(mes);
                    jijinContentUeditor.setDisabled('fullscreen');
            });
        }
    }

    //图片显示
    function showImg() {
        $("#jijinjingliPhotoImg").attr("src", ruleForm.jijinjingliPhoto);
        $("#jijinPhotoImg").attr("src", ruleForm.jijinPhoto);
    }

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addjijin');
        window.location.href = "list.jsp";
    }

    // 下载
    function download(fileName) {
        var url = baseUrl+'file/download?fileName='+fileName;
        window.open(url);
    }

    //设置下载
    function setDownloadBtn() {

    }

    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });


    <%@ include file="../../static/myInfo.js"%>
    });
    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>
