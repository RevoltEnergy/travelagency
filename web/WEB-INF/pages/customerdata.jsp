<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>UserData</title>
    <spring:url value="${pageContext.request.contextPath}/resources/css/elegant-aero-form.css" var="elegant_aero" />
    <spring:url value="${pageContext.request.contextPath}/resources/css/table-tg.css" var="table_tg" />
    <link href="${elegant_aero}" rel="stylesheet"/>
    <link href="${table_tg}" rel="stylesheet"/>

    <style>
        #body-userdata {
            background: url("${pageContext.request.contextPath}/resources/images/aurora_sky_695x295.jpg") no-repeat center;
            background-size: cover;
        }
    </style>
</head>
<body id="body-userdata">
<h1 align="center" style="color:#60f5ad;">Customer Details</h1>

<table class="tg">
    <tr>
        <th width="20">Customer ID</th>
        <th width="40">Name</th>
        <th width="70">Surname</th>
    </tr>
    <tr>
        <td>${customer.id}</td>
        <td>${customer.firstname}</td>
        <td>${customer.lastname}</td>
    </tr>
</table>
<br/>
<br/>
<br/>
<table class="tg">
    <tr>
        <th width="15">Order ID</th>
        <th width="100">Name</th>
        <th width="40">Date IN</th>
        <th width="40">Date OUT</th>
    </tr>
    <c:forEach items="${customer.orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>"${order.hotel.hotelname}", ${order.hotel.city}, ${order.hotel.country}</td>
            <td>${order.dateIn}</td>
            <td>${order.dateOut}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
