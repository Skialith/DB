<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detailed Information</title>
    <link rel="stylesheet" href="css/public.css">
    <link rel="stylesheet" href="css/layout.css">
    <style>
    .content {
    	background-color: #b4dce6;
    	background: no-repeat url(./img/bg.jpg);
    	background-size: 100% 100%;
    }
    
        .w-8 {
            width: 8rem;
        }

        .form_box {
            width: 33%;
            padding: 10px 14px;
            border: #abafb25F solid 1px;
            margin: 0.75rem 0.75rem;
            border-radius: 8px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: #fff;
            width: 600px;

        }

        .item {
            font-size: 24px;
            font-weight: 400;
            letter-spacing: 0px;
            line-height: 24px;
            color: rgba(15, 27, 65, 1);
            margin: 20px 10px;
            display: flex;
            width: 600px;
        }

        .item_label {
            display: inline-block;
            width: 200px;
            text-align: right;
            margin-right: 20px;
        }

        .item_value {
			flex: 1;
        }
    </style>
</head>
<body>
<div class="app">
    <div class="header">
        <div class="title h3-d">ROBOT CONTROL SYSTERM</div>
    </div>
    <div class="main">
        <div class="nav">
            <ul>
                <li onclick="toPage('welcome')">WELCOME</li>
                <li onclick="toPage('RobotInfo')" class="active">MODIFY INFORMATION</li>
                <li onclick="toPage('reconnaissanceRecord')">SHOW RECORD</li>
                <li onclick="toPage('environmentRecord')">ENVIRONMENT SHOTS</li>
            </ul>
        </div>
        <div class="content">
            <div class="form_box">

                <div class="item">
                <span class="item_label">
                    Robot Picture:
                </span>
                    <span class="item_value">
                    <a href="uploadImg.jsp">></a>
                </span>
                </div>
                <div class="item">
                    <!-- 修改机器人姓名 -->
                    <span class="item_label">
                    Robot Name:
                </span>
                    <span class="item_value">
                    <a href="updatedRobotname.jsp">></a>
                </span>
                </div>
                <div class="item">
                <span class="item_label">
                    User Name:
                </span>
                    <span class="item_value">
                    <a href="updatedUsername.jsp">></a>
                </span>
                </div>
                <div class="item">
                <span class="item_label">
                    Password:
                </span>
                    <span class="item_value">
                    <a href="updatedPassword.jsp">></a>
                </span>
                </div>
                <div class="item">
                <span class="item_label">
                    Record Address:
                </span>
                    <span class="item_value">
                    <a href="updatedAddress.jsp">></a>
                </span>
                </div>
                     <div class="item">
                <span class="item_label">
                    Environment Address:
                </span>
                    <span class="item_value">
                    <a href="updatedAddress2.jsp">></a>
                </span>
                </div>
                <div class="item">
                <span class="item_label">
                    User Delete:
                </span>
                    <span class="item_value">
                    <a href="delete.jsp">></a>
                </span>
                </div>
                
            </div>
        </div>
    </div>
    <div class="footer">

    </div>

</div>
</body>
</html>
