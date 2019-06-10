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

    <title>Admin</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/common.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/style.css">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>


</head>

<body style="padding-top: 0">
<div class="container">
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

<form:form method="POST" modelAttribute="product" class="form-signin" enctype="multipart/form-data" action="/admin">
    <h2 class="form-signin-heading">Add product</h2>
    <spring:bind path="title">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="title" class="form-control" placeholder="Title"
                        autofocus="true"></form:input>
            <form:errors path="title"></form:errors>
        </div>

    </spring:bind>
    <spring:bind path="price">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input  type="number" min="1" path="price" class="form-control" placeholder="Price"></form:input>
            <form:errors path="price"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="description">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input  type="text" path="description" class="form-control" placeholder="Description"></form:input>
            <form:errors path="description"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="short_description">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="short_description" class="form-control" placeholder="Short description"></form:input>
            <form:errors path="short_description"></form:errors>

        </div>
    </spring:bind>
    <spring:bind path="quantity">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="number" min="0" path="quantity" class="form-control" placeholder="Quantity"></form:input>
            <form:errors path="quantity"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="accessible">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <p>Accessible
                <form:checkbox path="accessible"  placeholder="Accessible"></form:checkbox>
                <form:errors path="accessible"></form:errors>
            </p>
        </div>
    </spring:bind>
    <div>
            <p>Categories <form:select class="form-control" path="categories" items="${map}"/></p>
        </div>
    <div>
        <p>Manufacture <form:select  class="form-control" path="manufacturer" items="${map2}"/>
        </p>
    </div>
    <div class="form-group">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <form:input  type="file" id="upp" name="upp" accept=".jpg, .jpeg, .png" onchange="previewFile()" path="upload" class="form-control-file" ></form:input>
        <form:errors path="upload"></form:errors>
        <img src="" id="image" height="200" alt="Image preview...">
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
</form:form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>

<script>
    function previewFile() {
        var preview = document.querySelector('img');
        var file = document.getElementById("upp").files[0];
        var reader  = new FileReader();

        reader.onloadend = function () {
            preview.src = reader.result;
        };

        if (file) {
            reader.readAsDataURL(file);
        } else {
            preview.src = "";
        }
    }
</script>
</body>
</html>