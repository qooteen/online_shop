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
    <link rel="stylesheet" href="/resources/css/close.css">

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
                <form id="helloForm" method="GET" action="${contextPath}/info">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <a onclick="document.forms['helloForm'].submit()"> Hello ${pageContext.request.userPrincipal.name} |</a>

                <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
                    <form id="adminForm" method="GET" action="${contextPath}/admin">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                    <a onclick="document.forms['adminForm'].submit()">Add New Item |</a>
                </c:if>
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
    <div class="row">
        <div class="col-md-8 products">
            <div class="row">
                    <div class="col-sm-4">
                        <form method="GET" action="/show/${products.product_id}" >
                            <div class="product-img">
                                <a><img src="/resources/img/${products.image}" alt=""></a>
                            </div>
                            <p class="product-title"><a>${products.title}</a></p>
                            <p class="product-desc">${products.short_description}</p>
                            <c:if test="${products.quantity > 0}">
                                <p class="product-price">${prod.price}</p>
                                <p class="product-add"><a href="/cart/buy/${products.product_id}">Buy Now</a></p>
                            </c:if>
                            <c:if test="${products.quantity == 0}">
                                <p class="product-price">Is out of stock</p>
                            </c:if>
                        <p class="product-desc">${products.description}</p>
                        <p class="product-desc">${products.quantity}</p>
                        <p class="product-desc">${products.manufacturer_id.title}</p>
                        <p class="product-desc">${products.manufacturer_id.site}</p>
                        </form>
                    </div>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="$/resources/js/bootstrap.min.js"></script>
</body>
</html>