<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WELCOME</title>
    <link rel="stylesheet" href="css/public.css">
    <link rel="stylesheet" href="css/layout.css">
    <style>
        .content {
            position: relative;
            background: url(data:image/jpeg;base64,${base64str}) no-repeat;
            background-size: 100% 100%;
        }

        .bgc {
            width: 100%;
            height: 100%;
            z-index: 0;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
        }

        .card_content, .go {
            display: flex;
            justify-content: flex-start;
            align-content: center;
        }

        .go {
            width: 1rem;
            margin: 0 0.5rem;
            padding: 3px;
        }

        .tag {
            margin: 0 0.75rem;
        }
        form *{
            margin: 2px 0;
        }

    </style>
</head>
<body>
<%
    String robotname = (String) session.getAttribute("robotname");
    String username = (String) session.getAttribute("username");
    String gender = (String) session.getAttribute("sex");
%>

<div class="app">
    <div class="header">
        <div class="title h3-d">ROBOT CONTROL SYSTERM</div>
        <form method="post" action="./Refresh" class="content_form">
            <input type="submit" name="submit" value="Refresh Page">
        </form>
    </div>
    <div class="main">
        <div class="nav">
            <ul>
                <li onclick="toPage('welcome')" class="active">WELCOME</li>
                <li onclick="toPage('RobotInfo')">MODIFY INFORMATION</li>
                <li onclick="toPage('reconnaissanceRecord')">SHOW RECORD</li>
                <li onclick="toPage('environmentRecord')">ENVIRONMENT SHOTS</li>
            </ul>
        </div>
        <div class="content">
            
            <%--            <img class="bgc" width="200" src="data:image/jpeg;base64,${base64str}"/><br/>--%>
         
            <div class="card">
                <div class="card_title h2-d">
                    <div class="robot_name">
                        <%= robotname %><br/>
                    </div>
                </div>
                <div class="card_content">
                  
                    <span class="label h5-u">
                        Owning:<span class="name"><%= username %>
                    </span>
                    </span>
                    <span class="tag success">
                        <%= gender %>
                    </span>
                    <span class="go">
                
                        <a href="RobotInfo.jsp">
                            <img src="./font/right.png" alt="查看">
                        </a>
                    </span>
                </div>
                <div class="card_footer">
                
                    <form method="post" action="./print">
                        Check Records of your Robot:<input type="SUBMIT" name="submit" value="enter">
                    </form>
                    <form method="post" action="./Environment">
                        Check the Environment of your Robot:<input type="SUBMIT" name="submit" value="enter">
                    </form>
                </div>
            </div>

        </div>
    </div>
    <div class="footer">

    </div>

</div>

</body>
<script>
    function toForm() {
        location.href = 'RobotInfo.jsp'
    }
</script>
</html>
