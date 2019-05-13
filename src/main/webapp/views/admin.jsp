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

    <link href="${contextPath}resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}resources/css/style.css">

</head>

<body>



<div class="container">

    <form id="ShopLogo" method="GET" action="${contextPath}/">
    </form>
    <h1>
        <a onclick="document.forms['ShopLogo'].submit()">Market Place</a>
    </h1>
</div>

<%--<form class="form-horizontal">--%>
<%--    <form:form method="POST" modelAttribute="product" class="form-signin">--%>
<%--    <div class="form-group">--%>
<%--        <label for="inputTitle" class="col-xs-2 control-label">Title</label>--%>
<%--        <spring:bind path="title">--%>
<%--        <div class="col-xs-10">--%>
<%--        <form:input id="inputTitle" type="text" style="width: 50%" path="title" class="form-control" placeholder="Title"--%>
<%--                    autofocus="true"></form:input>--%>
<%--        </div>--%>
<%--        </spring:bind>--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <div class="col-xs-offset-2 col-xs-10">--%>
<%--            <div class="checkbox">--%>
<%--                <label><input class="title" type="checkbox"> Avalible </label>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <div class="col-xs-offset-2 col-xs-10">--%>
<%--            <button type="submit" class="btn btn-default">ADD</button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    </form:form>--%>
<%--</form>--%>
<div class="container content">

<form:form method="POST" modelAttribute="product" class="form-signin" action="${contextPath}/admin">
    <h2 class="form-signin-heading">Add product</h2>
    <spring:bind path="title">
        <div>
            <form:input type="text" path="title" class="form-control" placeholder="Title"
                        autofocus="true"></form:input>
            <form:errors path="title"></form:errors>
        </div>

    </spring:bind>
    <spring:bind path="price">
        <div>
            <form:input  type="text" path="price" class="form-control" placeholder="Price"></form:input>
            <form:errors path="price"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="description">
        <div>
            <form:input  type="text" path="description" class="form-control" placeholder="Description"></form:input>
            <form:errors path="description"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="short_description">
        <div>
            <form:input  type="text" path="short_description" class="form-control" placeholder="Short description"></form:input>
            <form:errors path="short_description"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="avalible">
        <div class="checkbox">
            <form:input  type="" path="avalible" class="checkbox" placeholder="Avalible"></form:input>
        </div>
    </spring:bind>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
</form:form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}resources/js/bootstrap.min.js"></script>

</body>
</html>