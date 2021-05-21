<%--
  Created by IntelliJ IDEA.
  User: TremblingMoeNew
  Date: 2020/7/6
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>机台</title>
    <style>
        table{
            width: 100%;
        }
        tr{
            height:30px;
            line-height: 30px;
        }
        .machine-main{
            width: 90%;
            margin: auto;
        }
    </style>
</head>
<body onload="init()" >
<div class="machine-main">
    <table>
        <tr>
            <td>编号:</td>
            <td>${id}</td>
        </tr>
        <tr>
            <td>状态:</td>
            <td>${statusString}</td>
        </tr>

    <c:if test="${status>0}">
        <tr>
            <td>开始时间:</td>
            <td>${lastActionTime}</td>
        </tr>
    </c:if>
    <c:if test="${status==1}">
        <tr>
            <td>产品编号:</td>
            <td>${itemId}</td>
        </tr>
        <tr>
            <td>模具编号:</td>
            <td>${mouldId}</td>
        </tr>
        <tr>
            <td>  - 半径:</td>
            <td>${radius}</td>
        </tr>
        <tr>
            <td>  - 重量:</td>
            <td>${weight}</td>
        </tr>
        <tr>
            <td>速率:</td>
            <td>${productionRate}</td>
        </tr>
        <tr>
            <td>完成度:</td>
            <td>${progress}%</td>
        </tr>
    </c:if>
    </table>
</div>

<script>
    let timer=null;
    function init() {
        timer=setInterval('refresh()',2000);
    }
    function refresh() {
        clearInterval(timer);
        window.location.reload();
    }
</script>
</body>
</html>
