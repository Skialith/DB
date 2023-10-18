<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Img</title>
    <link rel="stylesheet" href="css/public.css">
    <link rel="stylesheet" href="css/layout.css">
    <style>
        img{
            max-height: 350px;
        }
        .fom_box {
            width: 35%;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;

            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
        .form_item{
            margin: 2px 0;
        }

    </style>
</head>
<body>
<div class="app">
    <div class="header">
        <div class="title h3-d">system</div>
    </div>
    <div class="main">
        <div class="nav">
            <ul>
                <li onclick="toPage('welcome')">Welcome</li>
                <li onclick="toPage('RobotInfo')" class="active">Robot Info</li>
                <li onclick="toPage('reconnaissanceRecord')">Reconnaissance Record</li>

<%--                <li onclick="toPage('login')">Login</li>--%>
<%--                <li onclick="toPage('register')">Register</li>--%>

<%--                <li onclick="toPage('updatedPassword')">Updated Password</li>--%>
<%--                <li onclick="toPage('updatedRobotname')">Updated Robotname</li>--%>
<%--                <li onclick="toPage('updatedUsername')">Updated Username</li>--%>
<%--                <li onclick="toPage('uploadImg')">Upload Img</li>--%>
<%--                <li onclick="toPage('delete')">Delete</li>--%>
<%--                <li onclick="toPage('success')">Success</li>--%>
<%--                <li onclick="toPage('error')">Error</li>--%>
            </ul>
        </div>
        <div class="content">
            <div class="fom_box">
                <div class="form_item">
                    <img width="200" src="data:image/jpeg;base64,${base64str}"/><br/>
                </div>
                <div class="form_item">
                    <form method="post" action="./upload" enctype="multipart/form-data">
                        <div class="form_item">
                            <label for="upload">Img : </label>
                            <input type="file" name="picture" value="browse..." id="upload"/><br/>
                        </div>
                        <div class="form_item">
                            <input type="SUBMIT" name="submit" value="upload"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">

    </div>
</div>

</form>
</body>
<script>
    function toPage(page){
        location.href = page+`.jsp`
    }
</script>
</html>
