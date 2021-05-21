<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="./js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="./js/easyui/demo/demo.css">
<script type="text/javascript" src="./js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="./js/easyui/jquery.easyui.min.js"></script>

<link rel="stylesheet" type="text/css" href="./js/easyui/themes/material/easyui.css">

<link rel="stylesheet" type="text/css" href="./css/icon.css">
<body>
<div id="header">
    <p>智能生产信息系统</p>
</div>
<div id="left">
    <div class="easyui-panel" title="菜单列表" style="width:100%;height:100%;overflow-x:hidden;overflow-y:auto; " data-options="onOpen:onPanelOpen">
        <div id="LeftMenu">
        </div>
    </div>
</div>
<div id="main">
    <iframe src="" frameborder="0" name="mainframe" id="mainframe" style="width: 100%;height: 100%; ">

    </iframe>
</div>
</body>
<script>
    $(function () {
        $('#LeftMenu').sidemenu({
            data: [{
                text: '主页',
                iconCls: 'icon-more',
                state: 'open',
                children: [{
                    text: '公告栏',
                    url:'main'
                }]
            }, {
                text: '员工信息',
                iconCls: 'icon-more',
                children: [{
                    text: '登陆',
                    url:"./login"
                }, {
                    text: '修改密码',
                    url:"./staff/resetpassword"
                },{
                    text: '员工管理',
                    url:"./staff/management"
                }]
            },{
                text: '生产管理',
                iconCls: 'icon-more',
                children: [{
                    text: '生产计划',
                    url:'./products/plan'
                }, {
                    text: '模具管理',
                    url:'./products/mould'
                }, {
                    text: '原材料',
                    url:'./products/raw'
                } , {
                    text: '半成品',
                    url:'./products/semi'
                }, {
                    text: '成品',
                    url:'./products/end'
                }]
            }, {
                text: '车间实况',
                iconCls: 'icon-more',
                children: [ {
                    text: '拉丝车间',
                    url:"./machine/drawing"
                } , {
                    text: '包漆车间',
                    url:"./machine/coating"
                }]
            },],
            border: false,
            onSelect:onSideMenuSelect
        });

    });
    function onSideMenuSelect(item) {
        if(item.url=="main") {
            window.location.href = "./board";
        }else{
            mainframe.location.href=item.url;
        }
    }
</script>
<style>
    body{
        margin: 0 0 0 0;
        height: 100%;
        padding: 0;
    }
    #header{
        top:0;height:50px;line-height: 50px;width: 100%;
        position: fixed;background-color: rgba(142,199,255,20);z-index: 20;
        margin: 0;
        padding: 0;
        border-color:rgb(220, 220, 220);border-width :0;border-bottom-width: 1px;border-style:solid;
    }
    #header p{
        line-height: 50px;
        margin-top: 0;
        margin-left: 20px;
        font-size: 20px;
    }
    #left{
        top:50px;width: 200px;height:100%;
        position: fixed;display: inline-block;
        border-color:rgb(220, 220, 220);border-width :0;border-right-width: 1px;border-style:solid;
    }
    #main{
        display: inline-block; position:absolute;
        left:201px;top:52px;
        width: calc(100% - 201px);height: calc(100% - 55px);
    }
</style>
</html>
