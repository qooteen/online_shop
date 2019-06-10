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
    <link rel="stylesheet" href="/resources/css/style.css">

</head>

<body>
<div class="container">

    <form id="ShopLogo" method="GET" action="/">
    </form>
    <h1>
        <a onclick="document.forms['ShopLogo'].submit()">Market Place</a>
    </h1>
</div>

<div class="container content">

<form:form method="POST" modelAttribute="product" class="form-signin" enctype="multipart/form-data" action="/admin">
    <h2 class="form-signin-heading">Add product</h2>
    <spring:bind path="title">
        <div>
            <form:input type="text" path="title" class="form-control" placeholder="Title"
                        autofocus="true"></form:input>
        </div>

    </spring:bind>
    <spring:bind path="price">
        <div>
            <form:input  type="number" min="1" path="price" class="form-control" placeholder="Price"></form:input>
        </div>
    </spring:bind>
    <spring:bind path="description">
        <div>
            <form:input  type="text" path="description" class="form-control" placeholder="Description"></form:input>
        </div>
    </spring:bind>
    <spring:bind path="short_description">
        <div>
            <form:input type="text" path="short_description" class="form-control" placeholder="Short description"></form:input>
        </div>
    </spring:bind>
    <spring:bind path="quantity">
        <div>
            <form:input type="number" min="0" path="quantity" class="form-control" placeholder="Quantity"></form:input>
        </div>
    </spring:bind>
    <spring:bind path="accessible">
        <div>
            <p>Accessible <form:checkbox path="accessible"  placeholder="Accessible"></form:checkbox></p>
        </div>
    </spring:bind>
        <div>
            <p>Categories <form:select class="form-control" path="categories" items="${map}"/></p>
        </div>
    <div>
        <p>Manufacture <form:select  class="form-control" path="manufacturer" items="${map2}"/></p>
    </div>
    <div class="form-group">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <form:input  type="file" id="upp" name="upp" accept=".jpg, .jpeg, .png" onchange="previewFile()" path="upload" class="form-control-file" ></form:input>
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