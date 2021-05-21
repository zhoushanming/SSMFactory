<%--
  Created by IntelliJ IDEA.
  User: TremblingMoeNew
  Date: 2020/7/6
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background: linear-gradient(to bottom,rgb(137, 250, 205),rgb(249, 252, 165));
        }
        .frame-div{
            width: 260px;
            height: 350px;
            border-style: solid;
            border-width: 2px;
            border-color: rgb(200,200,200);
            border-radius: 10px;
            display: inline-block;
            background-color: rgba(255,255,255,0.5);
        }
        .machine-frame{
            width: 100%;
            height: 100%;
            border-style: hidden;
        }
    </style>
</head>
<body>
    <c:forEach var="i" begin="1" end="20">
        <div class="frame-div">
            <iframe src="/machine/drawing/${i}" class="machine-frame" >

            </iframe>
        </div>
    </c:forEach>
</body>
</html>
