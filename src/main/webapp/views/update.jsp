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
<body>
<%--<div class="container content">--%>
<%--    <div class="col-md-4 col-md-offset-4 products" >--%>

<%--                    <div class="product">--%>
<%--                        <div class="product-img">--%>
<%--                            <a><img src="/resources/img/${prod.image}" alt=""></a>--%>
<%--                        </div>--%>
<%--                        <div>--%>
<%--                        <p class="product-title"><a>${prod.title}</a></p>--%>
<%--                        </div>--%>
<%--                        <div>--%>
<%--                        <p class="product-desc">${prod.short_description}</p>--%>
<%--                        </div>--%>
<%--                        <div>--%>
<%--                            <p class="product-price">${prod.price}</p>--%>
<%--                        </div>--%>
<%--&lt;%&ndash;                        <div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                       <a type="checkbox">${prod.accessible}</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--                    </div>--%>
<%--        <div>--%>
<%--            <p class="product-title"><a>${prod.description}</a></p>--%>
<%--            <select class="form-control" name="categories" multiple>--%>
<%--                <c:forEach items="${cat}" var="category">--%>
<%--                    <option>${category.title}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--            <select class="form-control" name="categories" >--%>
<%--                    <option>${man.title}</option>--%>
<%--            </select>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    </div>--%>

<%--</div>--%>

<%--<div class="container content">--%>
<%--    <form action="/update/${prod.product_id}" class="form-signin" enctype="multipart/form-data">--%>
<%--        <h2 class="form-signin-heading">Update product</h2>--%>

<%--        <div>--%>
<%--        <input type="text" class="form-control" name="title" id="title" placeholder="Title"/>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--        <input type="text" name="price" id="price" class="form-control" placeholder="Price"/>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--        <input type="text" name="description" id="description" class="form-control" placeholder="Description"/>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--        <input type="text" name="short_description" id="short_description" class="form-control" placeholder="Short_description"/>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--        <p>Avalible: <input type="checkbox" name="avalible" id="avalible" /></p>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--        <p>Categories<select class="form-control" id="categories" name="categories" multiple>--%>
<%--            <c:forEach items="${categories}" var="category">--%>
<%--                <option>${category.title}</option>--%>
<%--            </c:forEach>--%>
<%--        </select></p>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <p>Manufacturer<select class="form-control" id="manufacturer_id" name="manufacturer_id" >--%>
<%--            <c:forEach items="${manufacturers}" var="manufacturer">--%>
<%--                <option>${manufacturer.logo}</option>--%>
<%--            </c:forEach>--%>
<%--            </select></p>--%>
<%--        </div>--%>
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--        <div>--%>
<%--        <input type="file" name="upload" id="upload" class="form-control-file"/>--%>
<%--        </div>--%>

<%--        <button type="submit" class="btn btn-lg btn-primary btn-block" name="postData" id="postData" value="POST DATA" onclick="postDataFromAPI();">Submit</button>--%>
<%--    </form>--%>
<%--</div>--%>



<form:form method="POST" modelAttribute="prod" class="form-signin" action="/update/${prod.product_id}">
    <h2 class="form-signin-heading">Add product</h2>
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
            <form:input type="text" id="quantity" name="quantity" path="quantity" class="form-control" placeholder="Quantity"></form:input>
        </div>
    </spring:bind>
    <spring:bind path="accessible">
        <div>
            <p>Accessible <form:checkbox id="accessible" name="accessible" path="accessible"  placeholder="Accessible"></form:checkbox></p>
        </div>
    </spring:bind>
<%--    <div>--%>
<%--        <p>Categories <form:select id="categories" name="categories" class="form-control" path="categories" multiple="true" items="${map}"/></p>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <p>Manufacture <form:select id="manufacturer_id" name="manufacturer_id" class="form-control" path="manufacturer_id" items="${map2}"/></p>--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <form:input  type="file" name="upload"  id="upload" path="upload" class="form-control-file" ></form:input>--%>
<%--    </div>--%>

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
            quantity: $("#quantity").val.
            // manufacturer_id: $("#manufacturer_id").val
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