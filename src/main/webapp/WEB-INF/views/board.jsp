<%--
  Created by IntelliJ IDEA.
  User: TremblingMoeNew
  Date: 2020/7/8
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="cn.edu.usts.cs2018.entity.Staff" %>
<html>
<head>
    <title>公告栏</title>
    <style>
        body{
            background: linear-gradient(to bottom,rgb(64,132,254),rgb(162,253,252));
        }
        #left-container{
            width: 320px;
            height: 100%;
            float: left;
        }
        #main-container{
            width: calc(100% - 660px);
            height: 89%;
            float: left;
        }
        #right-container{
            width: 320px;
            height: 100%;
            float: left;
        }
        .task-board{
            width: 300px;
            height:200px;
            margin: 50% auto;
        }
        .user-board{
            width: 300px;
            height:130px;
            margin:50% auto;
        }
        .board-title{
            width: 150px;
            height: 40px;
            text-align: center;
            margin: auto auto 0 auto;
            border-style: solid;
            border-collapse: collapse;
            border-width: 2px 2px 0 2px;
            border-radius: 10px 10px 0 0;
            border-color: rgb(180,180,180);
        }
        .board-title p{
            margin: 0;
            line-height: 40px;
        }
        .board-main{
            margin-top: 0;
            border-collapse: collapse;
            border-style: solid;
            border-width: 2px;
            border-color: rgb(200,200,200);
            border-radius: 5px;
        }
        .translucent{
            background-color: rgba(255,255,255,0.2);
        }
        .board-main table{
            text-align: center;
            width: 100%;
            height: 100%;
        }
        .board-main table td{
            width: 50%;
        }
        iframe{
            border-style: hidden;
        }
    </style>
</head>
<body>
    <div class="container">
        <div id="left-container">
            <div class="task-board">
                <div class="board-title translucent">
                    <p>今日状态</p>
                </div>
                <div class="board-main translucent">
                    <iframe src="/board/taskboard" style="height: 100%;width: 100%">

                    </iframe>
                </div>
            </div>
        </div>
        <div id="main-container">
            <div class="machine-board">
                <div class="board-title translucent">
                    <p>工作台</p>
                </div>
                <div class="board-main">
                    <iframe src="/board/machineboard" style="height: 100%;width: 100%">

                    </iframe>
                </div>
            </div>

        </div>
        <div id="right-container">
            <div class="user-board ">
                <div class="board-title translucent">
                    <p>值班人员</p>
                </div>
                <div class="board-main translucent">
                    <table>
                        <tr>
                            <td>编号: </td>
                            <td>${sessionScope.user.id}</td>
                        </tr>
                        <tr>
                            <td>姓名: </td>
                            <td>${sessionScope.user.name}</td>
                        </tr>
                    </table>
                </div>
            </div>

        </div>
    </div>
</body>
</html>
