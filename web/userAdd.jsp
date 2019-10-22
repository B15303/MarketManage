<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.8.3.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $("[name='userId']").blur(function () {

                $.ajax({
                    url:'user',  //请求的地址
                    type:'post',  //请求方式
                    dataType:'text',  //数据类型
                    data:'userName='+this.value,  //传到后台的参数
                    success:function (datas) {    //接收到的返回值
                        if (datas == 'true'){
                            $("[name='msg']").html("用户编码已存在");
                        } else {
                            $("[name='msg']").html("");
                        }
                    },
                    error:function () {
                        alert("AJAX请求失败！");
                    }
                })
            })
        })
    </script>

    <script type="text/javascript">
        function renew() {   //确认密码
            var newp = document.getElementById("userpassword").value;
            var renew = document.getElementById("userRemi").value;
            if (newp == renew){
                $("#msg1").html("√");
            }else {
                $("#msg1").html("两次密码不一致");
            }
        }
    </script>

</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span id="hours">下午好！</span><span style="color: #fff21b"> <%out.print(session.getAttribute("UserName"));%></span> , 欢迎你！</p>
        <a href="logout">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="billList">账单管理</a></li>
                <li ><a href="providerList">供应商管理</a></li>
                <li id="active"><a href="userList">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="logout">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="userAdd" method="get">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="userId">用户编码：</label>
                    <input type="text" name="userId" id="userId" value="${user.userCode}"/>
                    <span>*请输入用户编码，且不能重复</span>
                    <div name="msg"></div>
                </div>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value="${user.userName}"/>
                    <span >*请输入用户名称</span>
                </div>
                <div>
                    <label for="userpassword">用户密码：</label>
                    <input type="password" name="userpassword" id="userpassword" value="${user.userPassword}"/>
                    <span>*密码长度必须大于6位小于20位</span>

                </div>
                <div>
                    <label for="userRemi">确认密码：</label>
                    <input type="password" name="userRemi" id="userRemi" onblur="renew()"/>
                    <span id="msg1">*请输入确认密码</span>
                </div>
                <div>
                    <label >用户性别：</label>
                    <select name="gender">
                        <option <c:if test="${user.gender == 2}">selected="selected"</c:if> value="2">男</option>
                        <option <c:if test="${user.gender == 1}">selected="selected"</c:if> value="1">女</option>
                    </select>
                    <span></span>
                </div>
                <div>
                    <label for="data">出生日期：</label>
                    <input type="text" name="data" id="data" value="${user.birthday}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="userphone" id="userphone" value="${user.phone}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="userAddress" id="userAddress" value="${user.address}"/>
                </div>
                <div>
                    <label >用户类别：</label>
                    <input type="radio" name="userlei" value="1" <c:if test="${user.userRole == 1}">checked="checked" </c:if>/>管理员
                    <input type="radio" name="userlei" value="2" <c:if test="${user.userRole == 2}">checked="checked" </c:if>/>经理
                    <input type="radio" name="userlei" value="3" <c:if test="${user.userRole == 3}">checked="checked" </c:if>/>普通用户

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.jsp">返回</a>-->
                    <input type="submit" value="保存" />
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
                <input type="hidden" name="id" value="${user.id}">
                <input type="hidden" name="modify" value="${modify}">
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>