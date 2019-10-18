<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 超市账单管理系统</title>
    <link rel="stylesheet" href="css/style.css"/>

    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $("[name='userName']").blur(function () {
                $.ajax({
                    url:'user',  //请求的地址
                    type:'post',  //请求方式
                    dataType:'text',  //数据类型
                    data:'userName='+this.value,  //传到后台的参数
                    success:function (datas) {    //接收到的返回值
                        if (datas == 'true'){
                            $("[name='msg']").html("");
                        } else {
                            $("[name='msg']").html("用户名不存在");
                        }
                    },
                    error:function () {
                        alert("AJAX请求失败！");
                    }
                })
            })
        })
    </script>

    <%
        String flag = "true";
        flag = (String)request.getAttribute("flag");
        if ("false" == flag){
    %>
    <script>
        alert("用户名或密码错误!");
    </script>
    <%
        }
    %>

</head>
<body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>超市账单管理系统</h1>
        </header>
        <section class="loginCont">
            <form class="loginForm" action="login" method="post">

                <div class="inputbox">
                    <label for="user">用户名：</label>
                    <input type="text" name="userName" value="" id="user" placeholder="请输入用户名" required>
                    <div name="msg"></div><div name="wrong"></div>
                </div>
                <div class="inputbox">
                    <label for="mima">密码：</label>
                    <input id="mima" type="password" name="password" placeholder="请输入密码" required/>
                </div>
                <div class="subBtn">
                    <input type="submit" value="登录" />
                    <input type="reset" value="重置"/>
                </div>

            </form>
        </section>
    </section>

</body>
</html>