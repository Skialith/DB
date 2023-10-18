<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 导入标签库 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SHOW RECORD</title>
    <link rel="stylesheet" href="css/public.css">
    <link rel="stylesheet" href="css/layout.css">
    <style>
        .content{
            padding: 0 13px;
        }
        table{
            width: 100%;
            border-collapse: collapse;
        }

        table caption{
            font-size: 2em;
            font-weight: bold;
            margin: 1em 0;
        }

        th,td{
            border: 1px solid #999;
            text-align: center;
            padding: 20px 0;
        }

        table thead tr{
            background-color: #008c8c;
            color: #fff;
        }

        table tbody tr:nth-child(odd){
            background-color: #eee;
        }

        table tbody tr:hover{
            background-color: #ccc;
        }

        table tbody tr td:first-child{
            color: #f40;
        }

        table tfoot tr td{
            text-align: right;
            padding-right: 20px;
        }
        .img {
        	position: relative;
			background-size: 100% 100%;
			overflow: hidden;
        }
        
        .img > img {
        	position: absolute;
        top: 50%;
        left: 50%;
        display: block;
        min-width: 100%;
        min-height: 100%;
        transform:translate(-50%,-50%);
        }
        

    </style>
</head>
<body>
<%Integer serialnumber = (Integer)session.getAttribute("serialnumber");%>
<%String path = (String) session.getAttribute("path");%>

<div class="app">
    <div class="header">
        <div class="title h3-d">ROBOT CONTROL SYSTERM</div>
    </div>
    <div class="main">
        <div class="nav">
            <ul>
                <li onclick="toPage('welcome')">WELCOME</li>
                <li onclick="toPage('RobotInfo')">MODIFY INFORMATION</li>
                <li onclick="toPage('reconnaissanceRecord')" class="active">SHOW RECORD</li>
                <li onclick="toPage('environmentRecord')">ENVIRONMENT SHOTS</li>
            </ul>
        </div>
     
        <div class="content">
        <div class="alert">
            The images recorded by your robot during the survey will be saved to the path:
              "<%= path %>"<br>
            OR, you can change your image address  <a href="updatedAddress.jsp">></a>
        </div>
            <div class="record-info">ROBOT RECORD INFORMATION</div>
            <% int i = 0;%>
            <table border="1">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Count</th>
                    <th>Login_time</th>
                    <th>Start_time</th>
                    <th>End_time</th>
                </tr>
                </thead>
                <tbody>
                <!--这里开始循环输出list对象中的信息-->
                <c:forEach items="${list2}" var="record">
                    <tr>
                        <th scope="row"><%=++i %>
                        <th>${record.count}</th>
                        <th>${record.login_time}</th>
                        <th>${record.start_time}</th>
                        <th>${record.end_time}</th>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            
            <% int j = 0;%>
           <div class="record-imgs">RECORDED IMAGES</div>
           <!--这里开始循环输出list对象中的信息-->
                <div class="imgs-wrapper">
                <c:forEach items="${list1}" var="base64str">
                <div class="img">
                	<img src="data:image/png;base64,${base64str}">
                </div>
                </c:forEach>
                <c:forEach items="${list1}" var="base64str">
                <img src="data:image/png;base64,${base64str}">
                </c:forEach>
				</div>
        </div>
    </div>
    <div class="footer">

    </div>
</div>


</body>
</html>
