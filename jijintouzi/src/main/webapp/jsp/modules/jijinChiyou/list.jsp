









<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <!-- font-awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">


    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <!-- layui -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
</head>
<style>

</style>
<body>


        
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">卖出</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <input id="maichuId" name="maichuId" type="hidden">
						<div class="layui-form-item" style="margin: 20px;background: #FFFFFF;border:3px dotted #EEEEEE;padding: 20px;">
							<label class="layui-form-label" style="width: 100px;">最新净值</label>
							<div class="layui-input-inline">
								<input type="number" id="zuixinjingzhi" style="width: 150px;" readonly lay-verify="required|integer" placeholder="最新净值" autocomplete="off" class="layui-input">
							</div>
						</div>
                        <div class="layui-form-item" style="margin: 20px;background: #FFFFFF;border:3px dotted #EEEEEE;padding: 20px;">
                            <label class="layui-form-label" style="width: 100px;">卖出份数</label>
                            <div class="layui-input-inline">
                                <input type="number" name="maiFenshu" style="width: 150px;" id="maiFenshu" lay-verify="required|integer" placeholder="卖出份数" autocomplete="off" class="layui-input">
                                <span style="color: red">现有总份数：<span id="sumFenshu"></span></span>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" onclick="submitMaichu()">提交更改</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>



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
                        <h3 class="block-title">持有基金管理</h3>
                    </div>
                    <div class="col-md-6">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">
                                <a href="${pageContext.request.contextPath}/index.jsp">
                                    <span class="ti-home"></span>
                                </a>
                            </li>
                            <li class="breadcrumb-item">持有基金管理</li>
                            <li class="breadcrumb-item active">持有基金列表</li>
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
                            <h3 class="widget-title">持有基金列表</h3>
                            <div class="table-responsive mb-3">
                                <div class="col-sm-12">
                                                                                                                                                 
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        持有份数
                                        <div class="layui-input-inline">
                                            <input type="text" id="fenshuStartSearch" style="width: 100px;" class="form-control form-control-sm" onchange="fenshuChickValue(this)"
                                                   placeholder="开始" aria-controls="tableId">
                                        </div>
                                    </div>
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        <div class="layui-input-inline">
                                            <input type="text" id="fenshuEndSearch" style="width: 100px;" class="form-control form-control-sm" onchange="fenshuChickValue(this)"
                                                   placeholder="结束" aria-controls="tableId">
                                        </div>
                                    </div>
                                                                                                                                                
                                                                                                                                                             
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        基金名称
                                        <div class="layui-input-inline">
                                            <input type="text" id="jijinNameSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="基金名称" aria-controls="tableId">
                                        </div>
                                    </div>
                                                                                                         
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        基金类型
                                        <div class="layui-input-inline">
                                            <select name="jijinTypesSelectSearch"  style="width: 150px;" id="jijinTypesSelectSearch" class="form-control form-control-sm"
                                                    aria-controls="tableId">
                                            </select>
                                        </div>
                                    </div>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        昵称
                                        <div class="layui-input-inline">
                                            <input type="text" id="yonghuNameSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="昵称" aria-controls="tableId">
                                        </div>
                                    </div>
                                                     
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        用户手机号
                                        <div class="layui-input-inline">
                                            <input type="text" id="yonghuPhoneSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="用户手机号" aria-controls="tableId">
                                        </div>
                                    </div>
                                                     
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        用户身份证号
                                        <div class="layui-input-inline">
                                            <input type="text" id="yonghuIdNumberSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="用户身份证号" aria-controls="tableId">
                                        </div>
                                    </div>
                                                                                                                                                                                                                
                                    <div class="layui-inline" style="margin-left: 30px;margin-bottom: 10px;">
                                        <button onclick="search()" type="button" class="btn btn-primary">查询</button>
                                        <button onclick="add()" type="button" class="btn btn-primary 新增">添加</button>
                                        <button onclick="graph()" type="button" class="btn btn-primary 报表">报表</button>
                                        <button onclick="deleteMore()" type="button" class="btn btn-danger 删除">批量删除</button>
                                    </div>
                                </div>
                                <table id="tableId" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th class="no-sort" style="min-width: 35px;">
                                            <div class="custom-control custom-checkbox">
                                                <input class="custom-control-input" type="checkbox" id="select-all"
                                                       onclick="chooseAll()">
                                                <label class="custom-control-label" for="select-all"></label>
                                            </div>
                                        </th>

                                        <th >基金代码</th>
                                        <th >基金名称</th>
                                        <%--<th >基金照片</th>--%>
                                        <th >基金类型</th>
                                        <%--<th >点击次数</th>--%>
                                        <%--<th >首页推荐</th>--%>
                                        <%--<th >是否上架</th>--%>
                                        <th >昵称</th>
                                        <th >用户手机号</th>
                                        <th >用户身份证号</th>
                                        <%--<th >用户头像</th>--%>
                                        <%--<th >电子邮箱</th>--%>
                                        <%--<th >余额</th>--%>
                                        <th >持有份数</th>
                                        <th >总购买金额</th>
                                        <th >总卖出金额</th>
                                        <th >盈利金额</th>
                                        <th >盈利率</th>
                                        <th >创建时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="thisTbody">
                                    </tbody>
                                </table>
                                <div class="col-md-6 col-sm-3">
                                    <div class="dataTables_length" id="tableId_length">

                                        <select name="tableId_length" aria-controls="tableId" id="selectPageSize"
                                                onchange="changePageSize()">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select>
                                        条 每页

                                    </div>
                                </div>
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination justify-content-end">
                                        <li class="page-item" id="tableId_previous" onclick="pageNumChange('pre')">
                                            <a class="page-link" href="#" tabindex="-1">上一页</a>
                                        </li>

                                        <li class="page-item" id="tableId_next" onclick="pageNumChange('next')">
                                            <a class="page-link" href="#">下一页</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
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
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
    <script>

        <%@ include file="../../utils/menu.jsp"%>
        <%@ include file="../../static/setMenu.js"%>
        <%@ include file="../../utils/baseUrl.jsp"%>
        <%@ include file="../../static/getRoleButtons.js"%>
        <%@ include file="../../static/crossBtnControl.js"%>
        var tableName = "jijinChiyou";
        var pageType = "list";
        var searchForm = {key: ""};
        var pageIndex = 1;
        var pageSize = 10;
        var totalPage = 0;
        var dataList = [];
        var sortColumn = '';
        var sortOrder = '';
        var ids = [];
        var checkAll = false;

        <!-- 级联表的级联字典表 -->
        var jijinTypesOptions = [];

        <!-- 本表的级联字段表 -->

        function init() {
            // 满足条件渲染提醒接口
        }

        // 改变每页记录条数
        function changePageSize() {
            var selection = document.getElementById('selectPageSize');
            var index = selection.selectedIndex;
            pageSize = selection.options[index].value;
            getDataList();
        }



        // 查询
        function search() {
            searchForm = {key: ""};

        <!-- 级联表的级联字典表 -->
                                                             
                            //基金名称
            var jijinNameSearchInput = $('#jijinNameSearch');
            if( jijinNameSearchInput != null){
                if (jijinNameSearchInput.val() != null && jijinNameSearchInput.val() != '') {
                    searchForm.jijinName = $('#jijinNameSearch').val();
                }
            }
                                         
            var jijinTypesSelectSearchInput = document.getElementById("jijinTypesSelectSearch");
            if(jijinTypesSelectSearchInput != null){
                var jijinTypesIndex = jijinTypesSelectSearchInput.selectedIndex;
                if( jijinTypesIndex  != 0){
                    searchForm.jijinTypes = document.getElementById("jijinTypesSelectSearch").options[jijinTypesIndex].value;
                }
            }
                                                                                                                                                                                     
                            //昵称
            var yonghuNameSearchInput = $('#yonghuNameSearch');
            if( yonghuNameSearchInput != null){
                if (yonghuNameSearchInput.val() != null && yonghuNameSearchInput.val() != '') {
                    searchForm.yonghuName = $('#yonghuNameSearch').val();
                }
            }
                     
                            //用户手机号
            var yonghuPhoneSearchInput = $('#yonghuPhoneSearch');
            if( yonghuPhoneSearchInput != null){
                if (yonghuPhoneSearchInput.val() != null && yonghuPhoneSearchInput.val() != '') {
                    searchForm.yonghuPhone = $('#yonghuPhoneSearch').val();
                }
            }
                     
                            //用户身份证号
            var yonghuIdNumberSearchInput = $('#yonghuIdNumberSearch');
            if( yonghuIdNumberSearchInput != null){
                if (yonghuIdNumberSearchInput.val() != null && yonghuIdNumberSearchInput.val() != '') {
                    searchForm.yonghuIdNumber = $('#yonghuIdNumberSearch').val();
                }
            }
                                                                                    <!-- 本表的查询条件 -->

                 
                //持有份数
            var fenshuStartSearchInput = $('#fenshuStartSearch');
            if(fenshuStartSearchInput != null){
                var fenshuStartSearchValue = fenshuStartSearchInput.val();
                if( fenshuStartSearchValue  != 0){
                    searchForm.fenshuStart = fenshuStartSearchValue;
                }
            }
            var fenshuEndSearchInput = $('#fenshuEndSearch');
            if(fenshuEndSearchInput != null){
                var fenshuEndSearchValue = fenshuEndSearchInput.val();
                if( fenshuEndSearchValue  != 0){
                    searchForm.fenshuEnd = fenshuEndSearchValue;
                }
            }
                            getDataList();
        }

        // 获取数据列表
        function getDataList() {
            http("jijinChiyou/page", "GET", {
                page: pageIndex,
                limit: pageSize,
                sort: sortColumn,
                order: sortOrder,
                jijinChiyouDelete: 1,
                //本表的
                fenshuStart: searchForm.fenshuStart,
                fenshuEnd: searchForm.fenshuEnd,
            //级联表的
                jijinName: searchForm.jijinName,
                jijinTypes: searchForm.jijinTypes,

                yonghuName: searchForm.yonghuName,
                yonghuPhone: searchForm.yonghuPhone,
                yonghuIdNumber: searchForm.yonghuIdNumber,


            }, (res) => {
                if(res.code == 0) {
                    clear();
                    $("#thisTbody").html("");
                    dataList = res.data.list;
                    totalPage = res.data.totalPage;
                    for (var i = 0; i < dataList.length; i++) { //遍历一下表格数据  
                        var trow = setDataRow(dataList[i], i); //定义一个方法,返回tr数据 
                        $('#thisTbody').append(trow);
                    }
                    pagination(); //渲染翻页组件
                    getRoleButtons();// 权限按钮控制
                }
            });
        }

        // 渲染表格数据
        function setDataRow(item, number) {
            //创建行 
            var row = document.createElement('tr');
            row.setAttribute('class', 'useOnce');
            //创建勾选框
            var checkbox = document.createElement('td');
            var checkboxDiv = document.createElement('div');
            checkboxDiv.setAttribute("class", "custom-control custom-checkbox");
            var checkboxInput = document.createElement('input');
            checkboxInput.setAttribute("class", "custom-control-input");
            checkboxInput.setAttribute("type", "checkbox");
            checkboxInput.setAttribute('name', 'chk');
            checkboxInput.setAttribute('value', item.id);
            checkboxInput.setAttribute("id", number);
            checkboxDiv.appendChild(checkboxInput);
            var checkboxLabel = document.createElement('label');
            checkboxLabel.setAttribute("class", "custom-control-label");
            checkboxLabel.setAttribute("for", number);
            checkboxDiv.appendChild(checkboxLabel);
            checkbox.appendChild(checkboxDiv);
            row.appendChild(checkbox)


                    //基金代码
            var jijinUuidNumberCell = document.createElement('td');
            jijinUuidNumberCell.innerHTML = item.jijinUuidNumber;
            row.appendChild(jijinUuidNumberCell);


                    //基金名称
            var jijinNameCell = document.createElement('td');
            jijinNameCell.innerHTML = item.jijinName;
            row.appendChild(jijinNameCell);


            //     //基金照片
            // var jijinPhotoCell = document.createElement('td');
            // var jijinPhotoImg = document.createElement('img');
            // var jijinPhotoImgValue = item.jijinPhoto;
            // if(jijinPhotoImgValue !=null && jijinPhotoImgValue !='' && jijinPhotoImgValue !='null'){
            //         jijinPhotoImg.setAttribute('src', jijinPhotoImgValue);
            //         jijinPhotoImg.setAttribute('height', 100);
            //         jijinPhotoImg.setAttribute('width', 100);
            //         jijinPhotoCell.appendChild(jijinPhotoImg);
            // }else{
            //         jijinPhotoCell.innerHTML = "暂无图片";
            // }
            // row.appendChild(jijinPhotoCell);

                        //基金类型
            var jijinTypesCell = document.createElement('td');
            jijinTypesCell.innerHTML = item.jijinValue;
            row.appendChild(jijinTypesCell);

                        //点击次数
            // var jijinClicknumCell = document.createElement('td');
            // jijinClicknumCell.innerHTML = item.jijinClicknum;
            // row.appendChild(jijinClicknumCell);

                        //首页推荐
            // var jijinTuijianTypesCell = document.createElement('td');
            // jijinTuijianTypesCell.innerHTML = item.jijinTuijianValue;
            // row.appendChild(jijinTuijianTypesCell);

                        //是否上架
            // var shangxiaTypesCell = document.createElement('td');
            // shangxiaTypesCell.innerHTML = item.shangxiaValue;
            // row.appendChild(shangxiaTypesCell);


                    //昵称
            var yonghuNameCell = document.createElement('td');
            yonghuNameCell.innerHTML = item.yonghuName;
            row.appendChild(yonghuNameCell);


                    //用户手机号
            var yonghuPhoneCell = document.createElement('td');
            yonghuPhoneCell.innerHTML = item.yonghuPhone;
            row.appendChild(yonghuPhoneCell);


                    //用户身份证号
            var yonghuIdNumberCell = document.createElement('td');
            yonghuIdNumberCell.innerHTML = item.yonghuIdNumber;
            row.appendChild(yonghuIdNumberCell);


                //用户头像
            // var yonghuPhotoCell = document.createElement('td');
            // var yonghuPhotoImg = document.createElement('img');
            // var yonghuPhotoImgValue = item.yonghuPhoto;
            // if(yonghuPhotoImgValue !=null && yonghuPhotoImgValue !='' && yonghuPhotoImgValue !='null'){
            //         yonghuPhotoImg.setAttribute('src', yonghuPhotoImgValue);
            //         yonghuPhotoImg.setAttribute('height', 100);
            //         yonghuPhotoImg.setAttribute('width', 100);
            //         yonghuPhotoCell.appendChild(yonghuPhotoImg);
            // }else{
            //         yonghuPhotoCell.innerHTML = "暂无图片";
            // }
            // row.appendChild(yonghuPhotoCell);


                    //电子邮箱
            // var yonghuEmailCell = document.createElement('td');
            // yonghuEmailCell.innerHTML = item.yonghuEmail;
            // row.appendChild(yonghuEmailCell);


                    //余额
            // var newMoneyCell = document.createElement('td');
            // newMoneyCell.innerHTML = item.newMoney;
            // row.appendChild(newMoneyCell);



            //持有份数
            var fenshuCell = document.createElement('td');
            fenshuCell.innerHTML = item.fenshu;
            row.appendChild(fenshuCell);


            //总购买金额
            var buySumMoneyCell = document.createElement('td');
            buySumMoneyCell.innerHTML = item.buySumMoney;
            row.appendChild(buySumMoneyCell);


            //总卖出金额
            var sellSumMoneyCell = document.createElement('td');
            sellSumMoneyCell.innerHTML = item.sellSumMoney;
            row.appendChild(sellSumMoneyCell);
            
            //盈利金额
            var yingliSumMoneyCell = document.createElement('td');
            //盈利金额为 （卖出金额 + 当前份数*当前净值 - item.buySumMoney）
            let v222 = (item.sellSumMoney + item.fenshu*item.zuixinjingzhi - item.buySumMoney).toFixed(2)+"元";
            // let v222 = String.valueOf((item.sellSumMoney + item.fenshu*item.zuixinjingzhi - item.buySumMoney).toFixed(2))+"元";
            yingliSumMoneyCell.innerHTML = v222;
            row.appendChild(yingliSumMoneyCell);
            
            //盈利率
            var yingliLvCell = document.createElement('td');
            //盈利金额为 （卖出金额 + 当前份数*当前净值 - 购买金额）/ 购买金额
            var v111 = (((item.sellSumMoney + item.fenshu*item.zuixinjingzhi - item.buySumMoney) / item.buySumMoney).toFixed(4))*100+"%";
            // var v111 =String.valueOf(((item.sellSumMoney + item.fenshu*item.zuixinjingzhi - item.buySumMoney) / item.buySumMoney).toFixed(4)*100)+"%";
            yingliLvCell.innerHTML = v111;
            row.appendChild(yingliLvCell);


            //创建时间
            var insertTimeCell = document.createElement('td');
            insertTimeCell.innerHTML = item.insertTime;
            row.appendChild(insertTimeCell);



            //每行按钮
            var btnGroup = document.createElement('td');

            //详情按钮
            var detailBtn = document.createElement('button');
            var detailAttr = "detail(" + item.id + ')';
            detailBtn.setAttribute("type", "button");
            detailBtn.setAttribute("class", "btn btn-info btn-sm 查看");
            detailBtn.setAttribute("onclick", detailAttr);
            detailBtn.innerHTML = "查看";
            btnGroup.appendChild(detailBtn);

            //修改按钮
            var editBtn = document.createElement('button');
            var editAttr = 'edit(' + item.id + ')';
            editBtn.setAttribute("type", "button");
            editBtn.setAttribute("class", "btn btn-warning btn-sm 修改");
            editBtn.setAttribute("onclick", editAttr);
            editBtn.innerHTML = "修改";
            btnGroup.appendChild(editBtn);

            if(window.sessionStorage.getItem('role') == '用户' && item.fenshu >0){
                //修改按钮
                var maichuBtn = document.createElement('button');
                var maichuAttr = 'maichu(' + item.id +',' + item.fenshu +',' + item.zuixinjingzhi +',' + ')';
                maichuBtn.setAttribute("type", "button");
                maichuBtn.setAttribute("class", "btn btn-warning btn-sm");
                maichuBtn.setAttribute("onclick", maichuAttr);
                maichuBtn.innerHTML = "卖出";
                btnGroup.appendChild(maichuBtn);
            }
            //删除按钮
            var deleteBtn = document.createElement('button');
            var deleteAttr = 'remove(' + item.id + ')';
            deleteBtn.setAttribute("type", "button");
            deleteBtn.setAttribute("class", "btn btn-danger btn-sm 删除");
            deleteBtn.setAttribute("onclick", deleteAttr);
            deleteBtn.innerHTML = "删除";
            btnGroup.appendChild(deleteBtn);
            row.appendChild(btnGroup);

            return row;
    }


            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            // 整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

            //整数
            function fenshuChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }


        // 翻页
        function pageNumChange(val) {
            if (val == 'pre') {
                pageIndex--;
            } else if (val == 'next') {
                pageIndex++;
            } else {
                pageIndex = val;
            }
            getDataList();
        }

        // 下载
        function download(url) {
            window.open(url);
        }
        // 打开新窗口播放媒体
        function mediaPlay(url){
            window.open(url);
        }

        // 渲染翻页组件
        function pagination() {
            var beginIndex = pageIndex;
            var endIndex = pageIndex;
            var point = 4;
            //计算页码
            for (var i = 0; i < 3; i++) {
                if (endIndex == totalPage) {
                    break;
                }
                endIndex++;
                point--;
            }
            for (var i = 0; i < 3; i++) {
                if (beginIndex == 1) {
                    break;
                }
                beginIndex--;
                point--;
            }
            if (point > 0) {
                while (point > 0) {
                    if (endIndex == totalPage) {
                        break;
                    }
                    endIndex++;
                    point--;
                }
                while (point > 0) {
                    if (beginIndex == 1) {
                        break;
                    }
                    beginIndex--;
                    point--
                }
            }
            // 是否显示 前一页 按钮
            if (pageIndex > 1) {
                $('#tableId_previous').show();
            } else {
                $('#tableId_previous').hide();
            }
            // 渲染页码按钮
            for (var i = beginIndex; i <= endIndex; i++) {
                var pageNum = document.createElement('li');
                pageNum.setAttribute('onclick', "pageNumChange(" + i + ")");
                if (pageIndex == i) {
                    pageNum.setAttribute('class', 'paginate_button page-item active useOnce');
                } else {
                    pageNum.setAttribute('class', 'paginate_button page-item useOnce');
                }
                var pageHref = document.createElement('a');
                pageHref.setAttribute('class', 'page-link');
                pageHref.setAttribute('href', '#');
                pageHref.setAttribute('aria-controls', 'tableId');
                pageHref.setAttribute('data-dt-idx', i);
                pageHref.setAttribute('tabindex', 0);
                pageHref.innerHTML = i;
                pageNum.appendChild(pageHref);
                $('#tableId_next').before(pageNum);
            }
            // 是否显示 下一页 按钮
            if (pageIndex < totalPage) {
                $('#tableId_next').show();
                $('#tableId_next a').attr('data-dt-idx', endIndex + 1);
            } else {
                $('#tableId_next').hide();
            }
            var pageNumInfo = "当前第 " + pageIndex + " 页，共 " + totalPage + " 页";
            $('#tableId_info').html(pageNumInfo);
        }

        // 跳转到指定页
        function toThatPage() {
            //var index = document.getElementById('pageIndexInput').value;
            if (index < 0 || index > totalPage) {
                alert('请输入正确的页码');
            } else {
                pageNumChange(index);
            }
        }

        // 全选/全不选
        function chooseAll() {
            checkAll = !checkAll;
            var boxs = document.getElementsByName("chk");
            for (var i = 0; i < boxs.length; i++) {
                boxs[i].checked = checkAll;
            }
        }

        // 批量删除
        function deleteMore() {
            ids = []
            var boxs = document.getElementsByName("chk");
            for (var i = 0; i < boxs.length; i++) {
                if (boxs[i].checked) {
                    ids.push(boxs[i].value)
                }
            }
            if (ids.length == 0) {
                alert('请勾选要删除的记录');
            } else {
                remove(ids);
            }
        }

        // 删除
        function remove(id) {
            var mymessage = confirm("真的要删除吗？");
            if (mymessage == true) {
                var paramArray = [];
                if (id == ids) {
                    paramArray = id;
                } else {
                    paramArray.push(id);
                }
                httpJson("jijinChiyou/delete", "POST", paramArray, (res) => {
                    if(res.code == 0){
                        getDataList();
                        alert('删除成功');
                    }
                });
            } else {
                alert("已取消操作");
            }
        }

        // 用户登出
        <%@ include file="../../static/logout.jsp"%>

        //修改
        function edit(id) {
            window.sessionStorage.setItem('updateId', id)
            window.location.href = "add-or-update.jsp"
        }
        //卖出
        function maichu(id,sumFenshu,zuixinjingzhi) {
            $("#maichuId").val(id);
            $("#zuixinjingzhi").val(zuixinjingzhi);
            $("#maiFenshu").val(1);
            $("#sumFenshu").html(sumFenshu);

            $('#myModal').modal('show');
        }

        //卖出提交
        function submitMaichu() {
            let val = $("#maichuId").val();
            let val2 = $("#maiFenshu").val();
            http("jijinChiyou/maichu", "GET", {
                maichuId: $("#maichuId").val(),
                maiFenshu: $("#maiFenshu").val()
            }, (res) => {
                if(res.code == 0) {
                    $('#myModal').modal('hide');
                    getDataList();
                }
            });
        }

        //清除会重复渲染的节点
        function clear() {
            var elements = document.getElementsByClassName('useOnce');
            for (var i = elements.length - 1; i >= 0; i--) {
                elements[i].parentNode.removeChild(elements[i]);
            }
        }

        //添加
        function add() {
            window.sessionStorage.setItem("addjijinChiyou", "addjijinChiyou");
            window.location.href = "add-or-update.jsp"
        }

        //报表
        function graph() {
            window.location.href = "graph.jsp"
        }

        // 查看详情
        function detail(id) {
            window.sessionStorage.setItem("updateId", id);
            window.location.href = "info.jsp";
        }


    //填充级联表搜索下拉框
                                                             
                                         
        function jijinTypesSelectSearch() {
            var jijinTypesSelectSearch = document.getElementById('jijinTypesSelectSearch');
            if(jijinTypesSelectSearch != null) {
                jijinTypesSelectSearch.add(new Option('-请选择-',''));
                if (jijinTypesOptions != null && jijinTypesOptions.length > 0){
                    for (var i = 0; i < jijinTypesOptions.length; i++) {
                            jijinTypesSelectSearch.add(new Option(jijinTypesOptions[i].indexName, jijinTypesOptions[i].codeIndex));
                    }
                }
            }
        }
                                                                                                                                                                                     
                     
                     
                                                                                
    //填充本表搜索下拉框
                 
                
    //查询级联表搜索条件所有列表
            function jijinTypesSelect() {
                //填充下拉框选项
                http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=jijin_types", "GET", {}, (res) => {
                    if(res.code == 0){
                        jijinTypesOptions = res.data.list;
                    }
                });
            }

    //查询当前表搜索条件所有列表













        $(document).ready(function () {
            //激活翻页按钮
            $('#tableId_previous').attr('class', 'paginate_button page-item previous')
            $('#tableId_next').attr('class', 'paginate_button page-item next')
            //隐藏原生搜索框
            $('#tableId_filter').hide()
            //设置右上角用户名
            $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
            //设置项目名
            $('.sidebar-header h3 a').html(projectName)
            setMenu();
            init();

            //查询级联表的搜索下拉框
            jijinTypesSelect();

            //查询当前表的搜索下拉框
            getDataList();

        //级联表的下拉框赋值
                                                                         
                                                 
            jijinTypesSelectSearch();
                                                                                                                                                                                                                         
                         
                         
                                                                                                
        //当前表的下拉框赋值
                                                 
                                                
        <%@ include file="../../static/myInfo.js"%>
    });
</script>
</body>

</html>
