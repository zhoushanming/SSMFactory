<%--
  Created by IntelliJ IDEA.
  User: TremblingMoeNew
  Date: 2020/7/8
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>今日状态</title>
    <style>
        table{
            text-align: center;
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body onload="init()">
    <table>
        <tr>
            <td>已申请数量: </td>
            <td>${totalCount}</td>
        </tr>
        <tr>
            <td>进行中数量: </td>
            <td>${processingCount}</td>
        </tr>
        <tr>
            <td>已完成数量: </td>
            <td>${finishedCount}</td>
        </tr>
        <tr>
            <td>完成率: </td>
            <td>${rate}%</td>
        </tr>
    </table>
    <script>
        let timer=null;
        function init() {
            timer=setInterval('refresh()',5000);
        }
        function refresh() {
            clearInterval(timer);
            window.location.reload();
        }
    </script>
</body>
</html>
