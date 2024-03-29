﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li id="active"><a href="providerList?bill=true">账单管理</a></li>
                <li><a href="providerList">供应商管理</a></li>
                <li><a href="userList">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="logout">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>账单管理页面 >> 订单添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="billUpdated">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <input type="hidden" name="id" value="${Bill.id}"/>
                    <label for="providerId">订单编码：</label>
                    <input type="text" name="providerId" id="providerId" value="${Bill.billCode}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="providerName">商品名称：</label>
                    <input type="text" name="providerName" id="providerName" value="${Bill.productName}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="people">商品单位：</label>
                    <input type="text" name="people" id="people" value="${Bill.productUnit}"/>
                    <span>*</span>

                </div>
                <div>
                    <label for="phone">商品数量：</label>
                    <input type="text" name="phone" id="phone" value="${Bill.productCount}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="address">总金额：</label>
                    <input type="text" name="address" id="address" value="${Bill.totalPrice}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="fax">供应商：</label>
                    <%--<input type="text" name="fax" id="fax" value=""/>--%>
                    <select name = "fax" id = "fax">
                        <c:forEach var="providers" items="${Providers}">
                        <option value="${providers.id}" <c:if test="${providers.id == Bill.providerId}">selected</c:if>>
                                ${providers.id}${providers.proName}
                        </option>
                        </c:forEach>
                    </select>
                    <span>*</span>
                </div>
                <div>
                    <label >是否付款：</label>
                        <input type="radio" name="zhifu" value="1" <c:if test="${Bill.isPayment == 1}">checked</c:if>/>未付款
                        <input type="radio" name="zhifu" value="2" <c:if test="${Bill.isPayment == 2}">checked</c:if>/>已付款
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="billList.jsp">返回</a>-->
                    <input type="submit" value="保存" />
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>