<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
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
    .error {
        color: red;
    }
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
                    <ul id="navUl" class="navbar-nav mr-auto">

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
                        <li class="breadcrumb-item active">编辑基金</li>
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
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6 aaaaaa jijinjingli">
                                        <label>基金经理</label>
                                        <div>
                                            <select style="width: 450px" id="jijinjingliSelect" name="jijinjingliSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 jijinjingli">
                                        <label>基金经理姓名</label>
                                        <input style="width: 450px" id="jijinjingliName" name="jijinjingliName" class="form-control"
                                               placeholder="基金经理姓名" readonly>
                                    </div>
                                    <div class="form-group col-md-6 jijinjingli">
                                        <label>基金经理照片</label>
                                        <img id="jijinjingliPhotoImg" src="" width="100" height="100">
                                    </div>
                                    <div class="form-group col-md-6 jijinjingli">
                                        <label>工作年限</label>
                                        <input style="width: 450px" id="jijinjingliGongzuo" name="jijinjingliGongzuo" class="form-control"
                                               placeholder="工作年限" readonly>
                                    </div>
                                    <div class="form-group col-md-6 jijinjingli">
                                        <label>性别</label>
                                        <input style="width: 450px" id="sexValue" name="sexValue" class="form-control"
                                               placeholder="性别" readonly>
                                    </div>
                                    <div class="form-group col-md-6 jijinjingli">
                                        <label>任期及回报</label>
                                        <input style="width: 450px" id="jijinjingliRenqiText" name="jijinjingliRenqiText" class="form-control"
                                               placeholder="任期及回报" readonly>
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="jijinjingliId" name="jijinjingliId" type="hidden">
                                    <div class="form-group col-md-6 jijinUuidNumberDiv">
                                        <label>基金代码</label>
                                        <input style="width: 450px" id="jijinUuidNumber" name="jijinUuidNumber" class="form-control"
                                               placeholder="基金代码">
                                    </div>
                                    <div class="form-group col-md-6 jijinNameDiv">
                                        <label>基金名称</label>
                                        <input style="width: 450px" id="jijinName" name="jijinName" class="form-control"
                                               placeholder="基金名称">
                                    </div>
                                    <div class="form-group col-md-6 jijinPhotoDiv">
                                        <label>基金照片</label>
                                        <img id="jijinPhotoImg" src="" width="100" height="100">
                                        <input name="file" type="file" id="jijinPhotoupload"
                                               class="form-control-file">
                                        <input name="jijinPhoto" id="jijinPhoto-input" type="hidden">
                                    </div>
                                    <div class="form-group col-md-6 jijinTypesDiv">
                                        <label>基金类型</label>
                                        <select style="width: 450px" id="jijinTypesSelect" name="jijinTypes" class="form-control">
                                        </select>
                                    </div>
                                    <div class="form-group col-md-6 jijinFengxianTypesDiv">
                                        <label>基金风险类型</label>
                                        <select style="width: 450px" id="jijinFengxianTypesSelect" name="jijinFengxianTypes" class="form-control">
                                        </select>
                                    </div>
                                    <div class="form-group col-md-6 jijinTuijianTypesDiv">
                                        <label>首页推荐</label>
                                        <select style="width: 450px" id="jijinTuijianTypesSelect" name="jijinTuijianTypes" class="form-control">
                                        </select>
                                    </div>
                                    <div class="form-group  col-md-6 jijinContentDiv">
                                        <label>基金档案</label>
                                        <input id="jijinContentupload" name="file" type="file">
                                        <script id="jijinContentEditor" type="text/plain"
                                                style="width:100%;height:230px;"></script>
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
                                        <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
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
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "jijin";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var jijinTypesOptions = [];
    var jijinFengxianTypesOptions = [];
    var jijinTuijianTypesOptions = [];
    var shangxiaTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var jijinjingliOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->
        $('#jijinPhotoupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                var photoUrl= baseUrl + 'file/download?fileName=' + data.result.file;
                document.getElementById('jijinPhotoImg').setAttribute('src',photoUrl);
                document.getElementById('jijinPhoto-input').setAttribute('value',photoUrl);
            }
        });


        $('#jijinContentupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                UE.getEditor('jijinContentEditor').execCommand('insertHtml', '<img src=\"' + baseUrl + 'upload/' + data.result.file + '\" width=900 height=560>');
            }
        });


    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
            if(window.sessionStorage.getItem('role') != '基金经理'){//当前登录用户不为这个
                if($("#jijinjingliId") !=null){
                    var jijinjingliId = $("#jijinjingliId").val();
                    if(jijinjingliId == null || jijinjingliId =='' || jijinjingliId == 'null'){
                        alert("基金经理不能为空");
                        return;
                    }
                }
            }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';

            }
            httpJson("jijin/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addjijin');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        function jijinTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=jijin_types", "GET", {}, (res) => {
                if(res.code == 0){
                    jijinTypesOptions = res.data.list;
                }
            });
        }
        function jijinFengxianTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=jijin_fengxian_types", "GET", {}, (res) => {
                if(res.code == 0){
                    jijinFengxianTypesOptions = res.data.list;
                }
            });
        }
        function jijinTuijianTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=jijin_tuijian_types", "GET", {}, (res) => {
                if(res.code == 0){
                    jijinTuijianTypesOptions = res.data.list;
                }
            });
        }
        function shangxiaTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=shangxia_types", "GET", {}, (res) => {
                if(res.code == 0){
                    shangxiaTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function jijinjingliSelect() {
            //填充下拉框选项
            http("jijinjingli/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    jijinjingliOptions = res.data.list;
                }
            });
        }

        function jijinjingliSelectOne(id) {
            http("jijinjingli/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                jijinjingliShowImg();
                jijinjingliShowVideo();
                jijinjingliDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationJijintypesSelect(){
            var jijinTypesSelect = document.getElementById('jijinTypesSelect');
            if(jijinTypesSelect != null && jijinTypesOptions != null  && jijinTypesOptions.length > 0 ){
                for (var i = 0; i < jijinTypesOptions.length; i++) {
                    jijinTypesSelect.add(new Option(jijinTypesOptions[i].indexName,jijinTypesOptions[i].codeIndex));
                }
            }
        }
        function initializationJijinfengxiantypesSelect(){
            var jijinFengxianTypesSelect = document.getElementById('jijinFengxianTypesSelect');
            if(jijinFengxianTypesSelect != null && jijinFengxianTypesOptions != null  && jijinFengxianTypesOptions.length > 0 ){
                for (var i = 0; i < jijinFengxianTypesOptions.length; i++) {
                    jijinFengxianTypesSelect.add(new Option(jijinFengxianTypesOptions[i].indexName,jijinFengxianTypesOptions[i].codeIndex));
                }
            }
        }
        function initializationJijintuijiantypesSelect(){
            var jijinTuijianTypesSelect = document.getElementById('jijinTuijianTypesSelect');
            if(jijinTuijianTypesSelect != null && jijinTuijianTypesOptions != null  && jijinTuijianTypesOptions.length > 0 ){
                for (var i = 0; i < jijinTuijianTypesOptions.length; i++) {
                    jijinTuijianTypesSelect.add(new Option(jijinTuijianTypesOptions[i].indexName,jijinTuijianTypesOptions[i].codeIndex));
                }
            }
        }
        function initializationShangxiatypesSelect(){
            var shangxiaTypesSelect = document.getElementById('shangxiaTypesSelect');
            if(shangxiaTypesSelect != null && shangxiaTypesOptions != null  && shangxiaTypesOptions.length > 0 ){
                for (var i = 0; i < shangxiaTypesOptions.length; i++) {
                    shangxiaTypesSelect.add(new Option(shangxiaTypesOptions[i].indexName,shangxiaTypesOptions[i].codeIndex));
                }
            }
        }

        function initializationjijinjingliSelect() {
            var jijinjingliSelect = document.getElementById('jijinjingliSelect');
            if(jijinjingliSelect != null && jijinjingliOptions != null  && jijinjingliOptions.length > 0 ) {
                for (var i = 0; i < jijinjingliOptions.length; i++) {
                        jijinjingliSelect.add(new Option(jijinjingliOptions[i].jijinjingliName, jijinjingliOptions[i].id));
                }

                $("#jijinjingliSelect").change(function(e) {
                        jijinjingliSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->

        var jijinTypesSelect = document.getElementById("jijinTypesSelect");
        if(jijinTypesSelect != null && jijinTypesOptions != null  && jijinTypesOptions.length > 0 ) {
            for (var i = 0; i < jijinTypesOptions.length; i++) {
                if (jijinTypesOptions[i].codeIndex == ruleForm.jijinTypes) {//下拉框value对比,如果一致就赋值汉字
                        jijinTypesSelect.options[i].selected = true;
                }
            }
        }

        var jijinFengxianTypesSelect = document.getElementById("jijinFengxianTypesSelect");
        if(jijinFengxianTypesSelect != null && jijinFengxianTypesOptions != null  && jijinFengxianTypesOptions.length > 0 ) {
            for (var i = 0; i < jijinFengxianTypesOptions.length; i++) {
                if (jijinFengxianTypesOptions[i].codeIndex == ruleForm.jijinFengxianTypes) {//下拉框value对比,如果一致就赋值汉字
                        jijinFengxianTypesSelect.options[i].selected = true;
                }
            }
        }

        var jijinTuijianTypesSelect = document.getElementById("jijinTuijianTypesSelect");
        if(jijinTuijianTypesSelect != null && jijinTuijianTypesOptions != null  && jijinTuijianTypesOptions.length > 0 ) {
            for (var i = 0; i < jijinTuijianTypesOptions.length; i++) {
                if (jijinTuijianTypesOptions[i].codeIndex == ruleForm.jijinTuijianTypes) {//下拉框value对比,如果一致就赋值汉字
                        jijinTuijianTypesSelect.options[i].selected = true;
                }
            }
        }

        var shangxiaTypesSelect = document.getElementById("shangxiaTypesSelect");
        if(shangxiaTypesSelect != null && shangxiaTypesOptions != null  && shangxiaTypesOptions.length > 0 ) {
            for (var i = 0; i < shangxiaTypesOptions.length; i++) {
                if (shangxiaTypesOptions[i].codeIndex == ruleForm.shangxiaTypes) {//下拉框value对比,如果一致就赋值汉字
                        shangxiaTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var jijinjingliSelect = document.getElementById("jijinjingliSelect");
            if(jijinjingliSelect != null && jijinjingliOptions != null  && jijinjingliOptions.length > 0 ) {
                for (var i = 0; i < jijinjingliOptions.length; i++) {
                    if (jijinjingliOptions[i].id == ruleForm.jijinjingliId) {//下拉框value对比,如果一致就赋值汉字
                        jijinjingliSelect.options[i+1].selected = true;
                        $("#jijinjingliSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
        if (ruleForm.jijinContent != null && ruleForm.jijinContent != 'null' && ruleForm.jijinContent != '' && $("#jijinContentupload").length>0) {

            var jijinContentUeditor = UE.getEditor('jijinContentEditor');
            jijinContentUeditor.ready(function () {
                var mes = '';
                if(ruleForm.jijinContent != null){
                    mes = ''+ ruleForm.jijinContent;
                    // mes = mes.replace(/\n/g, "<br>");
                }
                jijinContentUeditor.setContent(mes);
            });
        }
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
        if($("#jijinContentupload").length>0) {
            var jijinContentEditor = UE.getEditor('jijinContentEditor');
            if (jijinContentEditor.hasContents()) {
                $('#jijinContent-input').attr('value', jijinContentEditor.getContent());
            }
        }
    }
    //数字检查
        <!-- 当前表的数字检查 -->
        function jijinClicknumChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }
        function jijinDeleteChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addjijin');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                jijinjingliId: "required",
                jijinUuidNumber: "required",
                jijinName: "required",
                jijinPhoto: "required",
                jijinTypes: "required",
                jijinFengxianTypes: "required",
                jijinClicknum: "required",
                jijinTuijianTypes: "required",
                jijinContent: "required",
                shangxiaTypes: "required",
            },
            messages: {
                jijinjingliId: "基金经理不能为空",
                jijinUuidNumber: "基金代码不能为空",
                jijinName: "基金名称不能为空",
                jijinPhoto: "基金照片不能为空",
                jijinTypes: "基金类型不能为空",
                jijinFengxianTypes: "基金风险类型不能为空",
                jijinClicknum: "点击次数不能为空",
                jijinTuijianTypes: "首页推荐不能为空",
                jijinContent: "基金档案不能为空",
                shangxiaTypes: "是否上架不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addjijin = window.sessionStorage.getItem("addjijin");
        if (addjijin != null && addjijin != "" && addjijin != "null") {
            //注册表单验证
            $(validform());
            $("#jijinUuidNumber").val(new Date().getTime()+Math.ceil(Math.random()*10));//设置唯一号

            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("jijin/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 设置视频src
                    showVideo();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
        var insertTime = laydate.render({
            elem: '#insertTime-input'
            ,type: 'datetime'
        });
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        jijinjingliDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#jijinjingliId").val(ruleForm.jijinjingliId);
        $("#jijinUuidNumber").val(ruleForm.jijinUuidNumber);
        $("#jijinName").val(ruleForm.jijinName);
        $("#jijinClicknum").val(ruleForm.jijinClicknum);
        $("#jijinContent").val(ruleForm.jijinContent);

    }
    <!--  级联表的数据回显  -->
    function jijinjingliDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#jijinjingliId").val(ruleForm.id);

        $("#jijinjingliName").val(ruleForm.jijinjingliName);
        $("#jijinjingliGongzuo").val(ruleForm.jijinjingliGongzuo);
        $("#sexValue").val(ruleForm.sexValue);
        $("#jijinjingliRenqiText").val(ruleForm.jijinjingliRenqiText);
        $("#jijinjingliContent").val(ruleForm.jijinjingliContent);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->
        $("#jijinPhotoImg").attr("src",ruleForm.jijinPhoto);

        <!--  级联表的图片  -->
        jijinjingliShowImg();
    }


    <!--  级联表的图片  -->

    function jijinjingliShowImg() {
        $("#jijinjingliPhotoImg").attr("src",ruleForm.jijinjingliPhoto);
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        jijinjingliShowVideo();
    }


    <!--  级联表的视频  -->

    function jijinjingliShowVideo() {
        $("#jijinjingliPhotoV").attr("src",ruleForm.jijinjingliPhoto);
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            jijinTypesSelect();
            jijinFengxianTypesSelect();
            jijinTuijianTypesSelect();
            shangxiaTypesSelect();
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            jijinjingliSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationJijintypesSelect();
            initializationJijinfengxiantypesSelect();
            initializationJijintuijiantypesSelect();
            initializationShangxiatypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationjijinjingliSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
        window.sessionStorage.removeItem('addjijin');
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') == '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events:none;width:450px;');
        }
		else if (window.sessionStorage.getItem('role') == '用户') {
            // $(".aaaaaa").remove();
            $(".yonghu").remove();//删除当前用户的信息
        }
        else{
            // alert("未知情况.......");
            // var replyTextUeditor = UE.getEditor('replyTextEditor');
            // replyTextUeditor.ready(function () {
            //     replyTextUeditor.setDisabled('fullscreen');
            // });
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>
