<%--
  Created by IntelliJ IDEA.
  User: TremblingMoeNew
  Date: 2020/7/6
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>半成品</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/themes/default/easyui.css">

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/demo/demo.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/icon.css">
    <link rel="icon" href="<%=request.getContextPath()%> /images/icon.ico" />
    <script type="text/javascript" src="<%=request.getContextPath()%> /js/iepngfix_tilebg.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%> /js/iepngfix.js"></script>
    <style>
        body{
            background: linear-gradient(to bottom,rgb(137, 250, 205),rgb(249, 252, 165));
        }
    </style>
</head>
<body>
<div style="width:auto;padding:10px;overflow:hidden; center:'true'">
    <table id="grid"></table>
</div>
<script type="text/javascript">
    $(function() {
        loadgrid();
    });

    function loadgrid(){
        $('#grid').datagrid({
            title : '成品列表',
            url:'../api/item/end',
            method: 'get',
            loadMsg : '正在加载…',
            rownumbers: true,
            nowrap: false,
            fitColumns : true,
            singleSelect : true,
            sortName : 'id',
            sortOrder : 'asc',
            striped : true,
            pagination : false,
            idField : 'id',
            frozenColumns : [ [
                {title : '选择', width : '20', field : 'ck', checkbox : true},
                {title : '序号', width : '50', field : 'id', sortable : true},
            ] ],
            columns : [ [
                {title : '模具', width : '150', field : 'mouldId', sortable : true},
                {title : '重量', width : '100', field : 'weight', sortable : true},
                {title : '拉丝机台号', width : '100', field : 'drawingMachineId', sortable : true},
                {title : '包漆机台号', width : '100', field : 'coatingMachineId', sortable : true},
                {title : '完成时间', width : '100', field : 'date', sortable : true,
                    formatter:function(value,row,index){
                        var date = new Date(value);
                        return dateFormat("YYYY-mm-dd HH:MM:SS",date)
                    }},
            ] ],

            toolbar: [
                "-", {id: 'refresh',  text: '刷新',iconCls: 'icon-reload', handler: function () {reload();} },
            ]
        });
    }
    function reload(){
        $('#grid').datagrid('reload');
    }
    function dateFormat(fmt, date) {
        let ret;
        const opt = {
            "Y+": date.getFullYear().toString(),
            "m+": (date.getMonth() + 1).toString(),
            "d+": date.getDate().toString(),
            "H+": date.getHours().toString(),
            "M+": date.getMinutes().toString(),
            "S+": date.getSeconds().toString()
        };
        for (let k in opt) {
            ret = new RegExp("(" + k + ")").exec(fmt);
            if (ret) {
                fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
            };
        };
        return fmt;
    }
</script>
</body>
</html>