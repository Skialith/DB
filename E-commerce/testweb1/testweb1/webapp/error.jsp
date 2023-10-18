<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="css/public.css">
 <style type="text/css">
  .box {
   position: absolute;
   top: 50%;
   left: 50%;
   transform: translate(-50%, -50%);
   padding: 2rem 3.5rem;
   border-radius: 16px;
   border: 1px solid red;

   background: rgba(255, 0, 0, 0.15);
   font-weight: 500;
   color: #ff0000;
  }
 </style>
</head>
<body class="app">
<div class="box" onclick="location.href='login.jsp'">
 <h1>There are something wrong with this code</h1>
</div>
</body>
<%--<body>--%>
<%-- <div>--%>
<%-- <h1>you have entered wrong user name or password or phonenum</h1>--%>
<%-- </div>--%>
<%--</body>--%>
</html>
