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

    <title>Update</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/common.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/style.css">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body style="
      padding-top: 0">

<div class="container">

    <form id="ShopLogo" method="GET" action="/">
    </form>
    <h1>
        <a onclick="document.forms['ShopLogo'].submit()">Market Place</a>
    </h1>
</div>


<form:form method="POST" modelAttribute="prod" class="form-signin" enctype="multipart/form-data" >
    <h2 class="form-signin-heading">Update product</h2>
    <spring:bind path="title">
        <div>
            <form:input type="text" path="title" id="title" name="title" class="form-control" placeholder="Title"
                        autofocus="true"></form:input>
        </div>

    </spring:bind>

    <spring:bind path="price">
        <div>
            <form:input  type="text" id="price" name="price" path="price" class="form-control" placeholder="Price"></form:input>
        </div>
    </spring:bind>

    <spring:bind path="description">
        <div>
            <form:input  type="text" id="description" name="description" path="description" class="form-control" placeholder="Description"></form:input>
        </div>
    </spring:bind>

    <spring:bind path="short_description">
        <div>
            <form:input type="text" id="short_description" name="short_description" path="short_description" class="form-control" placeholder="Short description"></form:input>
        </div>
    </spring:bind>

    <spring:bind path="quantity">
        <div>
            <form:input type="number" id="quantity" min="1" name="quantity" path="quantity" class="form-control" placeholder="Quantity"></form:input>
        </div>
    </spring:bind>

    <spring:bind path="accessible">
        <div>
            <p>Accessible <form:checkbox id="accessible" name="accessible" path="accessible"  placeholder="Accessible"></form:checkbox></p>
        </div>
    </spring:bind>

    <div>
        <p>Categories <form:select class="form-control" path="categories" items="${map}"/></p>
    </div>
    <div>
        <p>Manufacture <form:select class="form-control" path="manufacturer_id" items="${map2}"/></p>
    </div>

    <div class="form-group">
        <form:input type="file" name="file"  id="file" path="upload"  class="form-control-file" ></form:input>
    </div>
    <button class="btn btn-lg btn-primary btn-block" onclick="postDataFromAPI();" type="submit">Submit</button>
</form:form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}resources/js/bootstrap.min.js"></script>

<script type="application/javascript">

    function postDataFromAPI() {

        var modelObj = {
            title: $("#title").val(),
            price: $("#price").val(),
            description: $("#description").val(),
            short_description: $("#short_description").val(),
            accessible: $("#accessible:checkbox:checked").val(),
            quantity: $("#quantity").val()
        };

        console.log("post data:"+modelObj);

        $.ajax({
            type: "POST",
            url: "/update/${prod.product_id}",
            headers: {
                "Content-Type": "application/json"
            },
            data: JSON.stringify(modelObj),
            success: function (data) {
                console.log("POST API RESPONSE::"+data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
            }
        });
    }
</script>
</body>
</html>