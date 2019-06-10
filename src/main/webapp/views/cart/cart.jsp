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

    <title>Cart</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/close.css">

</head>
<body>
<div class="container">
    <form id="SignIn" method="GET" action="${contextPath}login">
    </form>
    <form id="Registration" method="GET" action="${contextPath}registration">
    </form>
    <form id="ShopLogo" method="GET" action="${contextPath}/">
    </form>
    <h1>
        <a><a onclick="document.forms['ShopLogo'].submit()">Market Place</a>
        </a>
    </h1>
    <h4>
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name!= null}">
                <form id="logoutForm" method="POST" action="/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <form id="helloForm" method="GET" action="/info">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
                    <form id="adminForm" method="GET" action="/admin">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                    <button type="button" class="btn btn-primary btn" onclick="document.forms['adminForm'].submit()">Add New Item</button>
                </c:if>
                <button type="button" class="btn btn-primary btn" onclick="document.forms['helloForm'].submit()"> Hello ${pageContext.request.userPrincipal.name}</button>
                <button type="button" class="btn btn-primary btn" onclick="document.forms['logoutForm'].submit()">Logout ${message}</button>
            </c:when>
            <c:otherwise>
                <button type="button" class="btn btn-primary btn" onclick="document.forms['SignIn'].submit()">Sign In</button>
                <button type="button" class="btn btn-primary btn" onclick="document.forms['Registration'].submit()">Registration</button>
            </c:otherwise>
        </c:choose>
        <c:choose>
        <c:when test="${total == 0}">
            <p class="title">Cart is empty</p>
        </c:when>
        <c:otherwise>
            <button type="button" class="btn btn-primary btn" onclick="document.forms['ContinueBuy'].submit()">Continue Buy</button>
            <p class="title">Total price:<p class="product-price"> ${total}</p></p>
        <form id="ContinueBuy" method="POST" action="/cart">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        </c:otherwise>
        </c:choose>

    </h4>
</div>

<div class="container content">
    <div class="row">
        <div class="col-md-8 products">
            <div class="row">
                <c:forEach var="item" items="${sessionScope.cart}">
                    <div class="col-sm-4">
                        <div class="product2" >
                            <a class="close" href="/cart/remove/${item.products.product_id}"></a>
                            <div class="product-img">
                                <a><img src="/resources/img/${item.products.image}" alt=""></a>
                            </div>

                            <p class="product-title"><strong>${item.products.title}</strong></p>
                            <p class="product-desc">${item.products.short_description}</p>
                            <p class="product-price">${item.products.price}</p>
                            <form action="/cart/update/${item.products.product_id}" method="POST">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <p>Quantity: <input type="number" min="1" max="${item.products.quantity}" name="quantity" value="${item.quantity}"></p>
                            </form>
                            <p class="product-price">${item.products.price * item.quantity}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>