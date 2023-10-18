<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/public.css">
    <link rel="stylesheet" href="css/login.css">
    <style type="text/css">
        .app{
            background: url('/img/bg.jpg') no-repeat;
            background-size: 100% 100%;
        }
    </style>
</head>
<body class="app">
<div class="content">
    <div class="content_header">
        <div class="title h5-u">Login</div>
        <div class="subTitle p-u">please input your username and password</div>
    </div>
    <form method="post" action="./login" class="content_form">
        <div class="form_item">
            <label for="name">username :</label>
            <input type="text" name="username" id="name"/><br/>
        </div>
        <div class="form_item">
            <label for="pwd">password :</label>
            <input type="password" id="pwd" name="password"/><br/>
        </div>
        <div class="form_item">
            <input type="submit" name="submit" value="submit">
        </div>
    </form>
    <div class="content_footer p-d">
        <a href="./register.jsp">register</a>
    </div>
</div>
</body>
</html>
