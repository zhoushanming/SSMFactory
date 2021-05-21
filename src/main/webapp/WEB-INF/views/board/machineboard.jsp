<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TremblingMoeNew
  Date: 2020/7/8
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,cn.edu.usts.cs2018.entity.MachineResult" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .machine-list{
            margin: 0 30px;
            width: calc(50% - 70px);
            display: inline-block;
        }
        .machine-list-title{
            width: 100px;
            height: 30px;
            border-style: solid;
            border-width: 2px 2px 0 2px;
            border-color: rgb(200,200,200);
            border-radius: 5px 5px 0 0;
            margin: 0 auto 0 auto;
            text-align: center;
        }
        .translucent{
            background-color: rgba(255,255,255,0.2);
        }
        .machine-list-title p{
            margin: 0;
            height: 30px;
            line-height: 30px;
        }
        .machine-list-main{
            width:100%;
            text-align: center;
            border-style: solid;
            border-width: 2px;
            border-color: rgb(200,200,200);
            border-radius: 10px;
        }
        table{
            width: 100%;
            text-align: center;
            border-collapse: collapse;
        }
        td{
            border-style: solid;
            height: 30px;
            border-width: 1px 0 0 0;
            border-color: rgb(200,200,200);
            margin: 0;
        }
    </style>
</head>
<body onload="init()">
    <div id="dm-list" class="machine-list">
        <div id="dm-list-title" class="machine-list-title translucent">
            <p>拉丝车间</p>
        </div>
        <div id="dm-list-main" class="machine-list-main translucent">
            <table>
                <tr>
                    <td>机台</td>
                    <td>状态</td>
                    <td>产品编号</td>
                    <td>生产日期</td>
                </tr>
                <c:forEach items="${dmList}" var="next" varStatus="status">
                    <tr>
                        <td>${next.id}</td>
                        <td>${next.statusStr}</td>
                        <td><c:if test="${next.status==1}">${next.itemId}</c:if></td>
                        <td><c:if test="${next.status>0}">${next.date}</c:if></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div id="cm-list" class="machine-list">
        <div id="cm-list-title" class="machine-list-title translucent">
            <p>包漆车间</p>
        </div>
        <div id="cm-list-main" class="machine-list-main translucent">
            <table>
                <tr>
                    <td>机台</td>
                    <td>状态</td>
                    <td>产品编号</td>
                    <td>生产日期</td>
                </tr>
                <c:forEach items="${cmList}" var="next" varStatus="status">
                    <tr>
                        <td>${next.id}</td>
                        <td>${next.statusStr}</td>
                        <td><c:if test="${next.status==1}">${next.itemId}</c:if></td>
                        <td><c:if test="${next.status>0}">${next.date}</c:if></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
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
