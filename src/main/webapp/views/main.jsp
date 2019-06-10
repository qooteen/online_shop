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
                        <button type="button" class="btn btn-primary btn" onclick="document.forms['logoutForm'].submit()">Logout</button>
                    </c:when>
                    <c:otherwise>
                        <button type="button" class="btn btn-primary btn" onclick="document.forms['SignIn'].submit()">Sign In</button>
                        <button type="button" class="btn btn-primary btn" onclick="document.forms['Registration'].submit()">Registration</button>
                    </c:otherwise>
                </c:choose>

                <button type="button" class="btn btn-primary btn" onclick="document.forms['Cart'].submit()">Cart</button>
            </h4>
        </div>
        <div class="container content">
            <div class="row">
                <div class="col-md-4">
                    <div class="list-group">
                        <c:forEach var="categories" items="${categories}">
                            <a href="/${categories.category_id}" class="list-group-item list-group-item-action">${categories.logo}</a>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-8 products">
                    <div class="row">
                        <c:forEach var="prod" items="${products}">
                        <div class="col-sm-4">
                            <div class="product">
                                <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
                                    <form id="Close${prod.product_id}" method="POST" action="/remove/${prod.product_id}">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <a class="close" onclick="document.forms['Close${prod.product_id}'].submit()"></a>
                                    </form>
                                </c:if>
                                <div class="product-img">
                                    <form id="Img${prod.product_id}" method="GET" action="/view/${prod.product_id}">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <a onclick="document.forms['Img${prod.product_id}'].submit()"><img src="/resources/img/${prod.image}"></a>
                                    </form>
                                </div>
                                <p class="product-title"><strong>${prod.title}</strong></p>
                                <p class="product-desc">${prod.short_description}</p>
                                <c:if test="${prod.quantity > 0 && prod.accessible}">
                                    <p class="product-price">${prod.price}</p>
                                    <p class="product-add"><a href="/cart/buy/${prod.product_id}">Buy Now</a></p>

                                </c:if>
                                <c:if test="${(prod.quantity == 0 || prod.quantity == null) && prod.accessible}">
                                    <p class="product-price">Is out of stock</p>
                                </c:if>
                                <c:if test="${!prod.accessible}">
                                    <p class="product-price">Unavailable</p>
                                </c:if>
                                <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
                                        <a class="product-price" href="/update/${prod.product_id}">Edit</a>
                                </c:if>
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