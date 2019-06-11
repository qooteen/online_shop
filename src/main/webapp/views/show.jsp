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
    <title>Show</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/close.css">

</head>
<body style="padding-top: 0">
<div class="container content">
    <form id="ShopLogo" method="GET" action="/">
    </form>
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
<form class="form-signin">
</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">

    $(document).ready(function() {

        $.get("http://localhost:8080/show/${id}", function(data) {

                $(".form-signin").append(
                "<div class=\u0022product3\u0022><img src=\u0022\n\u002F\nresources\u002F\nimg\u002F" + data.image + "\u0022><div>"+
                    "<p class=\u0022product-title\u0022><strong>" + data.title + "</strong></p>" +
                    "<p class=\u0022product-desc\u0022>" + data.short_description + "</p>" +
                    "<p class=\u0022product-price\u0022>" + data.price + " rub" +"</p>" +
                    "<p class=\u0022product-desc\u0022><strong>" + "Size:" + "</strong></p>" +
                    "<p class=\u0022product-desc\u0022>" + data.property.size_value + "</p>" +
                    "<p class=\u0022product-add\u0022><a href=\u0022\u002Fcart\u002Fbuy\u002F" + data.product_id  + "\u0022>Buy Now</a>" + "</p>" +
                    "<p class=\u0022product-desc\u0022><strong>" + "Manufacturer:" + "</strong></p>" +
                    "<p class=\u0022product-desc\u0022>" + data.manufacturer.logo + "</p>" +
                    "<p class=\u0022product-desc\u0022>" + data.manufacturer.site + "</p>" +
                    "<p class=\u0022product-desc\u0022><strong>" +" Description:"+ "</strong></p>" +
                    "<p class=\u0022product-desc\u0022>" + data.description + "</p>"
                );
        });
    });
</script>
</body>
</html>