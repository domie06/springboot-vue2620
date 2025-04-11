









<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>

<!-- 首页 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <link rel="stylesheet" href="../../xznstatic/css/bootstrap.min.css" />
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css"/>
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css"/>
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css"/>
</head>
<style>
    /*padding-bottom 属性设置元素的下内边距（底部空白）*/
    .pb-120 {
        padding-bottom: 50px;
    }
    /*padding-top 属性设置元素的上内边距（头部空白）*/
    .pt-120 {
        padding-top: 20px;
    }

    .cmn-accordion .card-header .acc-btn .plus-icon::after {
        position: absolute;
        content: '';
        top: 50%;
        left: 50%;
        height: 25px;
        width: 1px;
        background-color: #bec452;
        -webkit-transform: translate(-50%, -50%) rotate(90deg);
        -ms-transform: translate(-50%, -50%) rotate(90deg);
        transform: translate(-50%, -50%) rotate(90deg);
        -webkit-transition: all 0.3s;
        -o-transition: all 0.3s;
        transition: all 0.3s;
    }

    .cmn-accordion .card-body {
        padding: 0;
    }

    blockquote {
        padding: 0 50px;
    }

    @media (max-width: 767px) {
        blockquote {
            padding: 0 30px;
        }
    }

    blockquote p {
        font-size: 24px;
        font-style: italic;
        text-align: center;
        font-family: "Playfair Display", serif;
    }

    @media (max-width: 767px) {
        blockquote p {
            font-size: 20px;
        }
    }


    /* 评论样式 和文本框样式 */
    body {
        font-family: "Raleway", sans-serif;
        font-size: 16px;
        padding: 0;
        margin: 0;
        font-weight: 400;
        position: relative;
        overflow-x: hidden;
    }

    img {
        max-width: 100%;
        height: auto;
    }

    ul, ol {
        padding: 0;
        margin: 0;
        list-style: none;
    }

    button {
        border: none;
    }

    input, textarea {
        padding: 10px 20px;
        border: 1px solid #e5e5e5;
        width: 100%;
        background-color: #ffffff;
    }


    textarea {
        min-height: 150px;
        resize: none;
    }

    /* 标题下面的蓝色字体 删除就会换行 */

    .post-meta {
        display: -ms-flexbox;
        display: flex;
        -ms-flex-wrap: wrap;
        flex-wrap: wrap;
        margin: 0 -8px;
        margin-top: 5px;
    }

    .post-meta li {
        margin: 3px 8px;
    }

    .post-meta li a {
        font-size: 12px;
    }


    .blog-single-classic .content {
        margin-top: 25px;
    }



    /* 博客详情部分 css start */
    .blog-details-wrapper .blog-details-header {
        margin-top: 25px;
        padding-bottom: 15px;
        border-bottom: 1px solid #e5e5e5;
    }



    .comments-area {
        margin-top: 50px;
    }

    .comments-area .title {
        text-transform: capitalize;
        margin-bottom: 30px;
    }

    .comments-list .single-comment {
        display: flex;
        flex-wrap: wrap;
        padding: 30px 0;
        border-bottom: 1px solid #e5e5e5;
    }

    .comments-list .single-comment:first-child {
        padding-top: 0;
    }

    .comments-list .single-comment:last-child {
        padding-bottom: 0;
        border-bottom: none;
    }

    .comments-list .single-comment .thumb {
        flex: 0 0 80px;
        -ms-flex: 0 0 80px;
        max-width: 80px;
        height: 80px;
        border-radius: 50%;
        -webkit-border-radius: 50%;
        -moz-border-radius: 50%;
        -ms-border-radius: 50%;
        -o-border-radius: 50%;
        overflow: hidden;
    }

    .comments-list .single-comment .content {
        flex: 0 0 calc(100% - 80px);
        -ms-flex: 0 0 calc(100% - 80px);
        max-width: calc(100% - 80px);
        padding-left: 20px;
    }



    .comments-list .single-comment .content .date {
        font-size: 14px;
    }

    .comments-list .single-comment .content p {
        margin-top: 5px;
    }

    .comments-list .single-comment .content .comment-action {
        margin-top: 3px;
    }

    .comment-form-area {
        margin-top: 50px;
    }

    .comment-form-area .title {
        margin-bottom: 30px;
    }

    .comment-form-area .comment-form .form-group {
        margin-bottom: 30px;
    }

    .sidebar .widget + .widget {
        margin-top: 50px;
    }


    .sidebar .widget-title {
        font-size: 24px;
        text-transform: capitalize;
        margin-bottom: 30px;
        position: relative;
        padding-left: 15px;
    }

    .sidebar .widget-title::before {
        position: absolute;
        content: '';
        top: 4px;
        left: 0;
        width: 5px;
        height: 23px;
        background-color: var(--publicMainColor,orange);
    }

    .sidebar .category-list li {
        padding: 10px 0;
        border-bottom: 1px solid #e5e5e5;
    }

    /*位置为 Latest Blog Post 意思 最新博客 样式*/
    .small-post-list .small-post-single:first-child {
        padding-top: 0;
    }
    .small-post-list .small-post-single {
        display: -ms-flexbox;
        display: flex;
        -ms-flex-wrap: wrap;
        flex-wrap: wrap;
        padding: 20px 0;
        border-bottom: 1px solid #e5e5e5;
    }

    .small-post-list .small-post-single .content {
        width: calc(100% - 65px);
        padding-left: 15px;
    }



    /* 侧边栏 css end */

    .cmn-btn-border {
        padding: 13px 35px;
        font-size: 18px;
        text-transform: capitalize;
        color: #ffffff;
        background-color: var(--publicMainColor,orange);
        position: relative;
        z-index: 1;
        -webkit-transition: all 0.3s;
        -o-transition: all 0.3s;
        transition: all 0.3s;
        border-radius: 3px;
        -webkit-border-radius: 3px;
        -moz-border-radius: 3px;
        -ms-border-radius: 3px;
        -o-border-radius: 3px;
    }

    .cmn-btn-border:hover {
        color: #ffffff;
        box-shadow: 0 5px 10px 0 rgba(0, 0, 0, 0.15);
    }

    .cmn-btn-border:hover::before {
        top: 0;
        left: 0;
    }

    .cmn-btn-border::before {
        position: absolute;
        content: '';
        top: -5px;
        left: -5px;
        width: 100%;
        height: 100%;
        background-color: var(--publicMainColor,orange);
        z-index: -10;
        border: 2px solid #ffffff;
        -webkit-transition: all 0.3s;
        -o-transition: all 0.3s;
        transition: all 0.3s;
    }

    .cmn-btn-border::after {
        position: absolute;
        content: '';
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: var(--publicMainColor,orange);
        z-index: -10;
        border: 2px solid #ffffff;
    }

    .blog-details-wrapper .blog-details-footer {
        padding: 20px 20px;
        border: 1px solid #f2f2f2;
        margin-top: 40px;
        display: -ms-flexbox;
        display: flex;
        -ms-flex-wrap: wrap;
        flex-wrap: wrap;
        justify-content: space-between;
    }</style>
<body>

    <div id="app">
        <section class="blog-details-section pt-120 pb-120">
            <div class="data-detail-breadcrumb" style="width: 1110px; padding: 0px 10px; box-shadow: rgba(255, 0, 0, 0.3) 0px 0px 0px; margin: 20px auto; border-color: rgb(135, 206, 250); border-radius: 4px; border-width: 0px; border-style: solid; height: 54px;">
                <span class="layui-breadcrumb">
                    <a href="../home/home.jsp">首页</a>
                    <a><cite>{{detail.jijinName}}</cite></a>
                </span>

                <!-- 自选 -->
                <a onclick="addJijinCollection()" href="javascript:void(0)">
                    <i class="layui-icon" style="font-size: 20px;color: red;">&#xe67a;</i>添加自选
                </a>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="blog-details-wrapper">
                            <div><img :src="detail.jijinPhoto" alt="image" style="width: 80%;height: auto" ></div>
                            <div class="blog-details-header">
                                <h3 class="blog-details-title">{{title}}</h3>
                                    <button @click="check1111()" style="height:auto;" :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(255,0,0,.3)","margin":"0 5px","borderColor":"rgba(0,0,0,.3)","backgroundColor":"rgba(23, 124, 176, 1)","color":"rgba(255, 255, 255, 1)","borderRadius":"6px","borderWidth":"0","width":"auto","lineHeight":"40px","fontSize":"16px","borderStyle":"solid"}' type="button" class="layui-btn btn-submit">
                                        查看当前基金的基金经理
                                    </button>
                                <ul class="post-meta">
                                    <li v-if="detail.jijinUuidNumber">基金代码：
                                        {{detail.jijinUuidNumber}}
                                    </li>
                                    <li v-if="detail.jijinTypes">基金类型：
                                        {{detail.jijinValue}}
                                    </li>
                                    <li v-if="detail.jijinFengxianTypes">基金风险类型：
                                        {{detail.jijinFengxianValue}}
                                    </li>
                                    <li v-if="detail.jijinClicknum">点击次数：
                                        {{detail.jijinClicknum}}
                                    </li>
                                    <li v-if="detail.jijinTuijianTypes">首页推荐：
                                        {{detail.jijinTuijianValue}}
                                    </li>
                                    <li v-if="detail.jingzhiList != null && detail.jingzhiList.length > 0">最新净值：
                                        {{(detail.jingzhiList)[detail.jingzhiList.length-1].insertTime}} --> {{detail.jingzhiList[detail.jingzhiList.length-1].jingzhiMoney}}
                                    </li>
                                </ul>
        
        
                                <ul class="post-meta">
                                    <li>
                                    </li>
                                </ul>
                                <div style="padding: 20px;border: 1px solid #f2f2f2;margin-top: 20px;display: flex">
                                    <div class="num-picker">
                                        份数:
                                        <button type="button" onclick="reduceBuynumber()" class="layui-btn layui-btn-primary">
                                            -
                                        </button>
                                        <input type="text" id="buyNumber" name="buyNumber" class="layui-input" disabled="disabled" />
                                        <button type="button" onclick="plusBuynumber()" class="layui-btn layui-btn-primary">
                                            +
                                        </button>
                                        <button onclick="addJijinChiyou()" style="height:auto;" :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(255,0,0,.3)","margin":"0 5px","borderColor":"rgba(0,0,0,.3)","backgroundColor":"rgba(23, 124, 176, 1)","color":"rgba(255, 255, 255, 1)","borderRadius":"6px","borderWidth":"0","width":"auto","lineHeight":"40px","fontSize":"16px","borderStyle":"solid"}' type="button" class="layui-btn btn-submit">
                                            立即购买
                                        </button>
                                    </div>
                                </div>
								<div id="main" style="width: 900px;height:600px;"></div>
                            </div>
                            <div class="blog-details-content"v-html="myFilters(detail.jijinContent)">
                            </div>
                        </div>
                    <%--<div class="col-lg-4" v-if="jijinRecommendList">--%>
                        <%--<div class="sidebar">
        
                            <div class="widget">
                                <h3 class="widget-title">系统推荐</h3>
        
                                <ul class="small-post-list">
                                    <li class="small-post-single" v-for="(item,index) in jijinRecommendList" v-bind:key="index" @click="jump('../jijin/detail.jsp?id='+item.id)">
                                        <div class="thumb"><img width="65px" :src="item.jijinPhoto"  alt="image"></div>
                                        <div class="content">
                                            <a class="main_color" class="date">{{item.jijinName}}</a>
                                            <h6 class="post-title"><a style="color: red">{{item.jijinNewMoney}}</a>RMB</h6>
                                        </div>
                                    </li>
                                </ul>
                            </div>
        
                        </div>--%><!-- sidebar end -->
                    <%--</div>--%>
        
                        </div>
                    </div>
                </section>
            </div>

<script type="text/javascript" src="../../xznstatic/js/jquery.min.js"></script>
<script src="../../xznstatic/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../layui/layui.js"></script>
<script src="../../../resources/js/echarts.min.js"></script>
<script src="../../js/vue.js"></script>
<!-- 组件配置信息 -->
<script src="../../js/config.js"></script>
<!-- 扩展插件配置信息 -->
<script src="../../modules/config.js"></script>
<!-- 工具方法 -->
<script src="../../js/utils.js"></script>

<script>
    Vue.prototype.myFilters= function (msg) {
        if(msg != null){
            return msg.replace(/\n/g, "<br>");
        }else{
            return "";
        }
    };
    var vue = new Vue({
        el: '#app',
        data: {
            // 轮播图
            swiperList: [],
            // 数据详情
            detail: {
                id: 0
            },
            // 商品标题
            title: '',
            buyNumber: 1,
            //系统推荐
            jijinRecommendList: [],
            // 当前详情页表
            detailTable: 'jijin',
        },
        //  清除定时器
        destroyed: function () {
            // 不知道具体作用
            // window.clearInterval(this.inter);
        },
        /*mounted(){
            this.chartDialog();//调用绘制图标部分
        },*/
        beforeMount(){
            // alert(111)
            // this.chartDialog();//调用绘制图标部分
        },
        methods: {
            jump(url) {
                jump(url);
            },
            check1111 () {
                jump("../jijinjingli/detail.jsp?id="+vue.detail.jijinjingliId);
            },
            
        }
    });

    layui.use(['layer', 'form', 'element', 'carousel', 'http', 'jquery', 'laypage'], function () {
        var layer = layui.layer;
        var element = layui.element;
        var form = layui.form;
        var carousel = layui.carousel;
        var http = layui.http;
        var jquery = layui.jquery;
        var laypage = layui.laypage;

        var limit = 10;

        // 设置数量
        jquery('#buyNumber').val(vue.buyNumber);

        // 数据ID
        var id = http.getParam('id');
        vue.detail.id = id;
        // 当前详情
        http.request(`${vue.detailTable}/detail/` + id, 'get', {}, function (res) {
            // 详情信息
            vue.detail = res.data;
            chartDialog();
            vue.title = vue.detail.jijinName;
           // 轮播图片
            vue.swiperList = vue.detail.jijinPhoto ? vue.detail.jijinPhoto.split(",") : [];
            var swiperItemHtml = '';
            for (let item of vue.swiperList) {
                swiperItemHtml +=
                        '<div>' +
                        '<img class="swiper-item" src="' + item + '" style="margin-top: 50px;" >' +
                        '</div>';
            }
            jquery('#swiper-item').html(swiperItemHtml);
            // 轮播图
            carousel.render({
                elem: '#swiper',
                width: swiper.width, height: swiper.height,
                arrow: swiper.arrow,
                anim: swiper.anim,
                interval: swiper.interval,
                indicator: swiper.indicator
            });
        });

        // 系统推荐
        http.request(`jijin/list`, 'get', {
            page: 1,
            limit: 5,
            shangpinTypes: vue.detail.shangpinTypes,
            jijinDelete: 1,
            shangxiaTypes: 1,



                jijinTuijianTypes: vue.detail.jijinTuijianTypes,
                shangxiaTypes: vue.detail.shangxiaTypes,

        }, function (res) {
            vue.jijinRecommendList = res.data.list;
        });



        
    });



    // 自选
    function addJijinCollection(){
        layui.http.requestJson(`${vue.detailTable}Collection/add`, 'post', {
            yonghuId : localStorage.getItem('userid'),
            jijinId : vue.detail.id,
            tableName : localStorage.getItem('userTable')
        }, function (res) {
            if(res.code==0){
                layer.msg('添加自选成功', {
                    time: 2000,
                    icon: 6
                });
            }else{
                layer.msg(res.msg, {
                    time: 2000,
                    icon: 2
                });
            }
        });
    }

    // 添加数量
    function plusBuynumber() {
        vue.buyNumber++;
        layui.jquery('#buyNumber').val(vue.buyNumber);
    }
    // 减少数量
    function reduceBuynumber() {
        if(vue.buyNumber>1){
            vue.buyNumber--;
        }
        layui.jquery('#buyNumber').val(vue.buyNumber);
    }
    // 立即购买
    function addJijinChiyou(){
        localStorage.setItem("jijinId",vue.detail.id);
        localStorage.setItem("buyNumber",vue.buyNumber);
        window.location.href='../jijinChiyou/add.jsp';
    }
    
    function chartDialog() {
        var statistic = echarts.init(document.getElementById("main"), 'macarons');
        var seriesDataList=[];
        var xAxisDataList=[];
        if(vue.detail.jingzhiList != null && vue.detail.jingzhiList.length > 0){
            vue.detail.jingzhiList.forEach(function (item,index) {
                seriesDataList.push(item.jingzhiMoney);
                xAxisDataList.push(item.insertTime);
            });
            var option = {
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        crossStyle: {
                            color: '#999'
                        }
                    }
                },
                toolbox: {
                    feature: {
                        // dataView: { show: true, readOnly: false },  // 数据查看
                        magicType: { show: true, type: ['bar', 'line'] },//切换图形展示方式
                        // restore: { show: true }, // 刷新
                        saveAsImage: { show: true }//保存
                    }
                },
                legend: {
                    data: ['净值']//标题  可以点击导致某一列数据消失
                },
                xAxis: [
                    {
                        type: 'category',
                        name: '日期',
                        // data: xAxisDataList,
                        data: xAxisDataList,
                        axisPointer: {
                            type: 'shadow'
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'value',//不能改
                        name: '元',//y轴单位
                        axisLabel: {
                            formatter: '{value} 元' // 后缀
                        }
                    }
                ],
                series:[
                    {
                        name: '净值',
                        type: 'line',
                        data: seriesDataList,
                        lineStyle: {
                            color: 'red',
                        }
                    }
                ]//具体数据
            };
            // 使用刚指定的配置项和数据显示图表。
            statistic.setOption(option);
        }
    }

    $(document).ready(function () {

        // vue.chartDialog();
    });



</script>
</body>
</html>
