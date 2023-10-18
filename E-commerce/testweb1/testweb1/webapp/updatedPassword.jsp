<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="css/public.css">
    <link rel="stylesheet" href="css/login.css">
    <style type="text/css">
        .content{
            width: 23%;
        }
        .content_header{
            width: 100%;
        }
    </style>
</head>

<body class="app">
<div class="content">
    <div class="content_header">
        <div class="title h5-u">Update Password</div>
        <div class="subTitle p-u">Please update your password</div>
    </div>
    <form method="post" action="./updatedPassword" class="content_form">
        <div class="form_item">
            <label for="name">updated user name :</label>
            <input type="text" name="updatedUsername" id="name"/><br/>
        </div>
        <div class="form_item">
            <label for="pwd">updated password :</label>
            <input type="password" name="updatedPassword" id="pwd"/><br/>
        </div>
        <div class="form_item">
            <input type="submit" name="submit" value="submit">
        </div>
    </form>
    <div class="content_footer p-d">
        <span onclick="location.href='RobotInfo.jsp'">Go Back</span>
    </div>
</div>
</body>
</html>
