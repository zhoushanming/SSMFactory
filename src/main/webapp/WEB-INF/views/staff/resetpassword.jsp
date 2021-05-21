<%--
  Created by IntelliJ IDEA.
  User: TremblingMoeNew
  Date: 2020/7/5
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/themes/default/easyui.css">

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui/demo/demo.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/icon.css">
    <link href="<%=request.getContextPath()%> /css/styles.css" rel="stylesheet" type="text/css" />
    <link rel="icon" href="<%=request.getContextPath()%> /images/icon.ico" />
    <script type="text/javascript" src="<%=request.getContextPath()%> /js/iepngfix_tilebg.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%> /js/iepngfix.js"></script>
</head>
<body>
<div id="resetPassword" class="easyui-window" title="修改密码"
     data-options="modal:true,closed:false,iconCls:'Lockgo',minimizable:false"
     style="width:400px;padding:20px 70px 20px 70px;">
        <div style="text-align: center;color: red;" id="showMsg"></div>
        <table>
            <tr>
                <td width="20%">
                    <div style="margin-bottom:10px">
                        新密码
                    </div>
                </td>
                <td width="80%">
                    <div style="margin-bottom:10px">
                        <form id="resetPasswordForm" action="../api/staff/resetPassword" method="post">
                        <input class="easyui-passwordbox easyui-validatebox" id="password" name="password" prompt="新密码" iconWidth="38"
                               style="height:30px;padding:12px" data-options="required:true"/>
                        </form>
                    </div>
                </td>
            </tr>
            <tr>
                <td width="20%">
                    <div style="margin-bottom:10px">
                        重复新密码
                    </div>
                </td>
                <td width="80%">
                    <div style="margin-bottom:10px">
                        <input class="easyui-passwordbox easyui-validatebox" id="rpassword" name="rpassword" prompt="重复新密码" iconWidth="38"
                               style="height:30px;padding:12px" data-options="required:true"/>
                    </div>
                </td>
            </tr>
        </table>
</div>
<script type="text/javascript">
    $(function() {
        $("#resetPassword").dialog({
            title : '找回密码',
            backcolor:'#00f',
            iconCls : 'icon-lock',
            width : '600',
            height : '200',
            closable : false,
            minimizable : false,
            maximizable : false,
            resizable : false,
            modal : true,
            closed : false
            ,
            buttons : [ {
                text : '重设密码',
                iconCls : 'icon-ok',
                handler:function(){
                    doFindPassword();
                }},
                {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        window.history.back();
                    }

                } ]
        });

    });
    function doFindPassword(){
        if ($("input[name='password']").val()!=$("input[name='rpassword']").val())
        {
            $("#showMsg").html("两次输入的密码不同");
            $("input[name='password']").focus();
        }else
        {
            $("#resetPassword").dialog("close");
            $("#resetPasswordForm").get(0).submit();
        }
    }
</script>
</body>
</html>
