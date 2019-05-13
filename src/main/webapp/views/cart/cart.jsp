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
    <form id="ShopLogo" method="GET" action="${contextPath}/">
    </form>
    <h1>
        <a><a onclick="document.forms['ShopLogo'].submit()">Market Place</a>
        </a>
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
                        <a> Hello ${pageContext.request.userPrincipal.name} |
                        </a>
                    </c:otherwise>
                </c:choose>
                <a onclick="document.forms['logoutForm'].submit()">Logout</a>
            </c:when>
            <c:otherwise>
                <a onclick="document.forms['SignIn'].submit()">Sign In</a> |
                <a onclick="document.forms['Registration'].submit()">Registration</a>
            </c:otherwise>
        </c:choose>

    </h4>
</div>

<form action="/cart/update" method="POST">

<div class="container content">
    <div class="row">
        <div class="col-md-8 products">
            <div class="row">
                <c:forEach var="item" items="${sessionScope.cart}">
                    <div class="col-sm-4">
                        <div class="product2" >
                            <a class="close" href="/cart/remove/${item.products.product_id}"></a>
                            <div class="product-img">
                                <a href="#"><img src="/resources/img/${item.products.image}" alt=""></a>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                            <p class="product-title"><a href="#">${item.products.title}</a></p>
                            <p class="product-desc">${item.products.short_description}</p>
                            <p class="product-price">${item.products.price}</p>
                            <input type="number" value="${item.quantity}" name="quantity" height="50" size="100" style="width: 70px"/>
                            <p class="product-price">${item.products.price * item.quantity}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</form>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>