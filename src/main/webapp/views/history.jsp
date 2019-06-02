<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<div class="container">
    <form id="SignIn" method="GET" action="${contextPath}login"></form>
    <form id="Registration" method="GET" action="${contextPath}registration"></form>
    <form id="Cart" method="GET" action="${contextPath}cart"></form>
    <form id="ShopLogo" method="GET" action="${contextPath}/"></form>
    <h1>
        <a onclick="document.forms['ShopLogo'].submit()">Market Place</a>
    </h1>
    <h4>
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name!= null}">
                <form id="logoutForm" method="POST" action="${contextPath}logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <c:choose>

                    <c:when test="${pageContext.request.isUserInRole('ADMIN')}">
                        <form id="adminForm" method="GET" action="${contextPath}/admin">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                        <a onclick="document.forms['adminForm'].submit()">Admin Page</a> |
                    </c:when>

                    <c:otherwise>
                        <form id="helloForm" method="GET" action="${contextPath}/info">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                        <a onclick="document.forms['helloForm'].submit()"> Hello ${pageContext.request.userPrincipal.name} |</a>
                    </c:otherwise>
                </c:choose>
                <a onclick="document.forms['logoutForm'].submit()">Logout |</a>
            </c:when>
            <c:otherwise>
                <a onclick="document.forms['SignIn'].submit()">Sign In |</a>
                <a onclick="document.forms['Registration'].submit()">Registration |</a>
            </c:otherwise>
        </c:choose>

        <a onclick="document.forms['Cart'].submit()">Cart</a>
    </h4>
</div>
<div class="container content">
    <c:forEach items="${orders}" var="order">
        <div class="row">
            <p class="product-price">Order Number: ${order.order_id} | Order date: ${order.order_date} | Order time: ${order.order_time}</p>
        </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Title</th>
            <th scope="col">Short Description</th>
            <th scope="col">Price</th>
            <th scope="col">Quantity</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${order.products_buys}" var="prod_buy">
        <tr>
            <td>${prod_buy.product_id.title}</td>
            <td>${prod_buy.product_id.short_description}</td>
            <td>${prod_buy.product_id.price}</td>
            <td>${prod_buy.quantity}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:forEach>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="$/resources/js/bootstrap.min.js"></script>
</body>
</html>