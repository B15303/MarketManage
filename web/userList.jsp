﻿<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>

    <%
        String username = (String) session.getAttribute("UserName");
        if (null == username){
            response.sendRedirect("login.jsp");
        }
    %>

    <%
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String now = sdf.format(date);
        session.setAttribute("date",now);
        session.setAttribute("sdf",sdf);
    %>
    
    <script type="text/javascript">
        function sendname() {
            var sendname = $("#sendname").val();
            window.location.href="selectuser?name="+sendname;
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
                    <li><a href="providerList?bill=true">账单管理</a></li>
                    <li><a href="providerList">供应商管理</a></li>
                    <li  id="active"><a href="userList">用户管理</a></li>
                    <li><a href="password.jsp">密码修改</a></li>
                    <li><a href="logout">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
                <span>用户名：</span>
                <input type="text" id="sendname" placeholder="请输入用户名"/>
                <input type="button" value="查询" onclick="sendname()"/>
                <a href="userAdd.jsp">添加用户</a>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户类型</th>
                    <th width="30%">操作</th>
                </tr>
                <c:forEach var="userList" items="${userList}">
                    <tr>
                        <td>${userList.userCode}</td>
                        <td>${userList.userName}</td>
                        <td>
                            <c:if test="${userList.gender == 1}">女</c:if>
                            <c:if test="${userList.gender == 2}">男</c:if>
                        </td>
                        <td>${date - sdf.format(userList.birthday)}</td>
                        <td>${userList.phone}</td>
                        <td>
                            <c:if test="${userList.userRole == 1}">系统管理员</c:if>
                            <c:if test="${userList.userRole == 2}">经理</c:if>
                            <c:if test="${userList.userRole == 3}">普通员工</c:if>
                        </td>
                        <td>
                            <a href="userView?id=${userList.id}"><img src="img/read.png" alt="查看" title="查看"/></a>
                            <a href="userUpdate?id=${userList.id}&modify=true"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                            <a href="userDelete?id=${userList.id}" class="removeUser"><img src="img/schu.png" alt="删除" title="删除"/></a>
                        </td>
                    </tr>
                </c:forEach>
<%--                <tr>--%>
<%--                    <td>hanlu</td>--%>
<%--                    <td>韩露</td>--%>
<%--                    <td>女</td>--%>
<%--                    <td>20</td>--%>
<%--                    <td>15918230478</td>--%>
<%--                    <td>经理</td>--%>
<%--                    <td>--%>
<%--                        <a href="userView.jsp"><img src="img/read.png" alt="查看" title="查看"/></a>--%>
<%--                        <a href="userUpdate.jsp"><img src="img/xiugai.png" alt="修改" title="修改"/></a>--%>
<%--                        <a href="#" class="removeUser"><img src="img/schu.png" alt="删除" title="删除"/></a>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td>PRO-CODE—001</td>--%>
<%--                    <td>测试供应商001</td>--%>
<%--                    <td>韩露</td>--%>
<%--                    <td>15918230478</td>--%>
<%--                    <td>15918230478</td>--%>
<%--                    <td>2015-11-12</td>--%>
<%--                    <td>--%>
<%--                        <a href="userView.jsp"><img src="img/read.png" alt="查看" title="查看"/></a>--%>
<%--                        <a href="userUpdate.jsp"><img src="img/xiugai.png" alt="修改" title="修改"/></a>--%>
<%--                        <a href="#" class="removeUser"><img src="img/schu.png" alt="删除" title="删除"/></a>--%>
<%--                    </td>--%>
<%--                </tr>--%>
            </table>

        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

    <footer class="footer">
    </footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>