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

    <link href="${contextPath}resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}resources/css/style.css">

</head>
<body>
<div class="container">
    <form id="SignIn" method="GET" action="${contextPath}login">
        </form>
    <form id="Registration" method="GET" action="${contextPath}registration">
    </form>
    <form id="Cart" method="GET" action="${contextPath}cart">
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
                    <a onclick="document.forms['logoutForm'].submit()">Logout</a> |
                </c:when>
                <c:otherwise>
                    <a onclick="document.forms['SignIn'].submit()">Sign In</a> |
                    <a onclick="document.forms['Registration'].submit()">Registration</a> |
                </c:otherwise>
            </c:choose>
            <a onclick="document.forms['Cart'].submit()">Cart</a>
        </h4>
</div>



<div class="container content">
    <div class="row">
        <div class="col-md-4">
            <div class="list-group">
                <c:forEach var="categories" items="${categories}">
                    <a href="/${categories.category_id}" class="list-group-item">${categories.logo}</a>
                </c:forEach>
            </div>
        </div>

        <div class="col-md-8 products">
            <div class="row">
                <c:forEach var="prod" items="${products}">
                    <div class="col-sm-4">
                        <div class="product">
                            <div class="product-img">
                                <a href="#"><img src="${contextPath}resources/img/${prod.image}" alt=""></a>
                            </div>

                            <p class="product-title"><a href="#">${prod.title}</a></p>
                            <p class="product-desc">${prod.short_description}</p>
                            <p class="product-price">${prod.price}</p>
                            <p class="product-add"><a href="/cart/buy/${prod.product_id}">Buy Now</a></p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${contextPath}resources/js/bootstrap.min.js"></script>
</body>
</html>