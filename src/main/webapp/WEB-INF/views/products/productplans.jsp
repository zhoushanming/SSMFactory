<%--
  Created by IntelliJ IDEA.
  User: TremblingMoeNew
  Date: 2020/7/5
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>生产计划</title>
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
        .button{
            background-color:cornflowerblue;
            height:30px;
            width:100px;
            margin:5px;
            font-size:16px;
            border-radius:5px 5px;
            border-style: solid;
            border-width: 1px;
            border-color: gray;
            color: white;
        }
        .button:hover{
            background-color:rgb(146,183,250);
        }
    </style>
</head>
<body>
<div style="width:auto;padding:10px;overflow:hidden; center:'true'">
    <table id="grid"></table>
</div>
<div id="dialog-add" class="easyui-dialog" data-options="closed:true" title="生产计划"
     style="width:500px;height:400px;padding:20px 70px 20px 70px;text-align:center" >
    <br>
    <form id="form-add" method="post">
        <table>
            <tr style="margin-bottom:10px">
                <td width="20%">数量</td>
                <td>
                    <input class="easyui-textbox" name="amount" data-options="required:true" />
                </td>
            </tr>
            <tr style="margin-bottom:10px">
                <td width="20%">规格</td>
                <td>
                    <input type="hidden" name="spec" id="spec-add" />
                    <input type="button" class="button" data-options="required:true" value="选择" onclick="openDialogSelectMould('规格选择')">
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="dialog-edit" class="easyui-dialog" data-options="closed:true" title="生产计划"
     style="width:500px;height:400px;padding:20px 70px 20px 70px;text-align:center" >
    <br>
    <form id="form-edit" method="post">
        <table>
            <tr style="margin-bottom:10px"hidden >
                <td width="20%">序号</td>
                <td>
                    <input class="easyui-textbox" name="id" data-options="required:true" />
                </td>
            </tr>
            <tr style="margin-bottom:10px">
                <td width="20%">数量</td>
                <td>
                    <input class="easyui-textbox" name="amount" data-options="required:true" />
                </td>
            </tr>
            <tr style="margin-bottom:10px">
                <td width="20%">规格</td>
                <td>
                    <input type="hidden" name="spec">
                </td>
            </tr>

        </table>
    </form>
</div>
<div id="dialog-select-mould" class="easyui-dialog" data-options="closed:true" title="模具管理"
     style="width:500px;height:400px;padding:20px 70px 20px 70px;text-align:center" >
     <table id="mould-grid"></table>
</div>
<script type="text/javascript">
    $(function() {
        loadgrid();
    });

    function loadgrid(){
        $('#grid').datagrid({
            title : '生产计划列表',
            url:'../api/plan/list',
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
                {title : '数量', width : '150', field : 'amount', sortable : true},
                {title : '规格', width : '100', field : 'spec', sortable : true},
            ] ],

            toolbar: [
                "-", {id: 'add', text: '添加',	iconCls: 'icon-add', handler: function () { add(); }},
                "-", {id: 'edit', text: '修改',	iconCls: 'icon-edit',	 handler: function () {edit(); } },
                "-", {id: 'remove', text: '删除',iconCls: 'icon-remove', handler: function () {remove();} },
                "-", {id: 'refresh',  text: '刷新',iconCls: 'icon-reload', handler: function () {reload();} },
            ]
        });
        $('#mould-grid').datagrid({
            title : '模具列表',
            url:'../api/mould/list',
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
                {title : '半径', width : '150', field : 'radius', sortable : true},
                {title : '长度', width : '100', field : 'length', sortable : true},
            ] ]
        });
    }
    function openDialogadd(title){
        $("#dialog-add").dialog({
            resizable: false,
            modal: true,
            buttons: [{
                text: '保存',
                iconCls: 'icon-save',
                handler: function () {
                    save('#form-add');
                }
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    closeDialog();
                }
            }]
        });
        $("#dialog-add").dialog('setTitle', title);
        $("#dialog-add").dialog('open');
    }
    function closeDialog() {
        $("#form-add").form('clear');
        $("#dialog-add").dialog('close');
        $("#form-edit").form('clear');
        $("#dialog-edit").dialog('close');
    }
    function openDialogSelectMould(title){
        $("#spec-add").val(null);
        $("#dialog-select-mould").dialog({
            resizable: false,
            modal: true,
            buttons: [{
                text: '保存',
                iconCls: 'icon-save',
                handler: function () {
                    saveDialogSelectMould();
                }
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    closeDialogSelectMould();
                }
            }]
        });
        $("#dialog-select-mould").dialog('setTitle', title);
        $("#dialog-select-mould").dialog('open');
    }
    function closeDialogSelectMould() {
        $("#dialog-select-mould").dialog('close');
    }
    function saveDialogSelectMould(){
        var row = $('#mould-grid').datagrid('getSelected');
        if(row == null){
            $.messager.alert("提示", "请选择一条记录",'info');
            return;
        }
        $("#spec-add").val(row.id);
        closeDialogSelectMould();
    }
    function closeDialog() {
        $("#form-add").form('clear');
        $("#dialog-add").dialog('close');
        $("#form-edit").form('clear');
        $("#dialog-edit").dialog('close');
    }
    function openDialogedit(title){
        $("#dialog-edit").dialog({
            resizable: false,
            modal: true,
            buttons: [{
                text: '保存',
                iconCls: 'icon-save',
                handler: function () {
                    save('#form-edit');
                }
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    closeDialog();
                }
            }]
        });
        $("#dialog-edit").dialog('setTitle', title);
        $("#dialog-edit").dialog('open');
    }

    function add() {
        openDialogadd('添加生产计划');
        $("#form-add").form('clear');
        url = '../api/plan/new';
    }

    function edit() {
        var row = $('#grid').datagrid('getSelected');
        if(row == null){
            $.messager.alert("提示", "请选择一条记录",'info');
            return;
        }
        openDialogedit('修改生产计划');
        $("#form-edit").form('load', row);
        url = '../api/plan/update';
    }

    /* 保存数据*/
    function save(id){
        $(id).form('submit',{
            url: url,						//提交地址
            onSubmit: function(){
                return $(this).form('validate'); //前台字段格式校验
            },
            success: function(result){
                var result = eval('('+result+')');
                if (result.success){
                    closeDialog();		// 调用closeDialog;
                    reload();			// 重新加载
                    $.messager.show({    //显示正确信息
                        title: '提示',
                        msg: '请求成功'
                    });
                } else {
                    $.messager.show({	//显示错误信息
                        title: '错误',
                        msg: '请求失败'
                    });
                }
            }
        });
    }

    function remove(){
        var row = $('#grid').datagrid('getSelected');
        if(row == null){
            $.messager.alert("提示", "请选择一条记录",'info');
            return;
        }
        $.messager.confirm('确认', '确定要删除吗？', function (r) {
            if (r) {
                $.post('../api/plan/delete', { id: row.id }, function (result) {
                    if (result.success) {
                        reload();
                        $.messager.show({
                            title: '提示',
                            msg: '请求成功'
                        });
                    } else {
                        $.messager.show({
                            title: '错误',
                            msg: '请求失败'
                        });
                    }
                }, 'json');
            }
        });

    }
    function reload(){
        $('#grid').datagrid('reload');
    }
</script>
</body>
</html>
