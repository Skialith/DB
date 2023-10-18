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

    </style>
</head>
<body class="app">
<div class="content">
    <div class="content_header">
        <div class="title h5-u">Delete User</div>
        <div class="subTitle p-u">Please input the user name you want to delete</div>
    </div>
    <form method="post" action="./delete" class="content_form">
        <div class="form_item">
            <label for="name">delete user name :</label>
            <input type="text" name="username" id="name"/><br/>
        </div>

        <div class="form_item">
            <input type="submit" name="submit" value="submit">
        </div>
    </form>
    <div class="content_footer p-d">
        <span onclick="location.href='RobotInfo.jsp'">Go Back</span>
    </div>
</div>

<%--<div>
<h1>please input the username you want to delete</h1>
<form method="post" action="./delete">
deleteUsername : <input type="text" name="username"/>
<input type="SUBMIT" name="submit" value="Submit">

</form>
</div>--%>
</body>
</html>
