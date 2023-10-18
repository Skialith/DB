<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="css/public.css">
    <link rel="stylesheet" href="css/login.css">
    <style type="text/css">
        .app input{
            padding-top: 6px;
            padding-bottom: 6px;
            /*padding: 6px 40px;*/
        }
        .form_item{
            display: block;
            margin: 3px 0;
        }
        input[type="reset"] {
            width: 100%;
            opacity: 1;
            border-radius: 4px;
            border: 1px solid #f6f6f6;
            background: rgb(243, 243, 243);

            opacity: 1;
            /** 文本1 */
            font-size: 14px;
            font-weight: 400;
            letter-spacing: 0px;
            line-height: 26px;
            color: #464646;
            text-align: center;
            vertical-align: top;

        }
        .btn:hover, input[type='reset']:hover {
            background: rgb(253, 253, 253);
            border: 1px solid rgba(248, 248, 248, 0.69);
        }

        .btn:hover, input[type='reset']:focus {
            background: rgba(208, 208, 208,0.5);
        }
    </style>

<%
  
  String username = (String) session.getAttribute("username");
  String password = (String) session.getAttribute("password");
  String confirmpassword = (String) session.getAttribute("confirmpassword");
  String phonenum = (String) session.getAttribute("phonenum");
  String robotname = (String) session.getAttribute("robotname");
  if(username==null){
	  username = "";
  }
  if(password==null){
	  password = "";
  }
  if(confirmpassword==null){
	  confirmpassword = "";
  }
  if(phonenum==null){
	  phonenum = "";
  }
  if(robotname==null){
	  robotname = "";
  }
  
  %>
</head>
<%@ page import="java.util.*,java.io.*" %>
<body class="app">
<div class="content">
    <div class="content_header">
        <div class="title h5-u">Register</div>
        <div class="subTitle p-u">please input your user name and password</div>
    </div>
    <form method="post" action="./register" class="content_form">
        <div class="form_item">
            <label for="name">user name :</label>
            <input type="text" name="username" id="name" value="<%= robotname %>"/><br/>
        </div>
        <div class="form_item">
            <label for="pwd">password :</label>
            <input type="password" id="pwd" name="password" value="<%= password %>"/><br/>
        </div>
        <div class="form_item">
            <label for="pwd2">confirm password :</label>
            <input type="password" id="pwd2" name="confirmpassword" value="<%= confirmpassword %>"/><br/>
        </div>

        <div class="form_item">
            <label for="gender">gender :</label>
        </div>
        <div class="form_item" style="display: flex;justify-content: flex-start;align-content: center;flex-direction: row">
            <div class="radio_item" style="display: flex;flex-direction: row;width: 40%">
                <label for="gender">man :</label>
                <input type="radio" name="gender" value="0" checked id="gender" style="width: auto"/>
            </div>
            <div class="radio_item" style="display: flex;flex-direction: row;width: 40%">
                <label for="gender2">women :</label>
                <input type="radio" name="gender" value="1" checked id="gender2" style="width: auto"/>
            </div>
        </div>
        <div class="form_item">
            <label for="phonenum">phone number :</label>
            <input type="text" name="phonenum" id="phonenum" value="<%= phonenum %>"/><br/>
        </div>
        <div class="form_item">
            <label for="robotname">robot name :</label>
            <input type="text" name="robotname" id="robotname" value="<%= robotname %>"/><br/>
        </div>

        <div class="form_item" style="display: flex;flex-direction: row;gap: 16px">
            <input type="reset" value="reset"/>
            <input type="submit" name="submit" value="submit">
        </div>
    </form>
    <div class="content_footer p-d">
        <a href="./login.jsp">login</a>
    </div>
</div>
</body>
</html>
