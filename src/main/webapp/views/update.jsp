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


<form class="form-signin" id = "myform">
        <div>
            <h2 class="form-signin-heading">UPDATE ITEM N: ${prod.product_id}</h2>
            <input type="text" id="title" name="title" class="form-control" placeholder="Title"  required  value="${prod.title}"/>
        </div>
        <div>
            <input type="number" min="1" id="price" name="price" class="form-control" placeholder="Price" required value="${prod.price}"/>
        </div>
        <div>
            <input  type="text" required id="description" name="description" class="form-control" placeholder="Description" value="${prod.description}"/>
        </div>
        <div>
            <input type="text" required id="short_description" name="short_description" class="form-control" placeholder="Short description" value="${prod.short_description}"/>
        </div>
        <div>
            <input type="number" required id="quantity" min="1" name="quantity" class="form-control" placeholder="Quantity" value="${prod.quantity}"/>
        </div>

        <div>
            <p>Accessible <input type = "checkbox" id="accessible" name="accessible" placeholder="Accessible" value="${prod.accessible}" checked/></p>
        </div>
    <div>
        <p>Categories<select required class="form-control" multiple="multiple" id="categories" name="name[]">
            <option disabled>Select Categories</option>
            <c:forEach items="${categories}" var="category">
                <option value="${category.category_id}">${category.logo}</option>
            </c:forEach>
        </select></p>
    </div>

    <div>
        <p>Manufacture<select required class="form-control"  id="manufacturer" >
            <option disabled>Select Manufacture</option>
            <c:forEach items="${manufacturers}" var="man">
                <option value="${man.manufacturer_id}">${man.logo}</option>
            </c:forEach>
        </select></p>
    </div>

    <div>
        <p>Size<select required class="form-control"  id="proper" >
            <option disabled>Select Size</option>
            <c:forEach items="${properties}" var="property">
                <option value="${property.products_property_id}">${property.size}</option>
            </c:forEach>
        </select></p>
    </div>
    <div class="form-group">
        <input type="file" name="file" accept=".jpg, .jpeg, .png" id="file" onchange="previewFile()" class="form-control-file"/>
        <img src="" id="image" height="200" alt="Image preview...">
    </div>
<input type="submit" id="btn" class="btn btn-lg btn-primary btn-block"/>
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>

<script>
    function previewFile() {
        var preview = document.querySelector('img');
        var file = document.querySelector('input[type=file]').files[0];
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

        $("#myform").submit(function(e) {
            e.preventDefault();
            var isChecked = $("#accessible:checkbox").is(":checked") ? true:false;
            var p = document.querySelector('img');
            var s = document.getElementById("manufacturer");
            var f = p.src;
            var a = document.getElementById("categories");
            var prop = document.getElementById("proper");
            var ar = a.selectedOptions;
            var res = [];
            for (var i = 0; i < ar.length; i++) {
                res[i] = ar[i].value;
            }
            if (p.src.indexOf("data") == -1) f = null;
            var modelObj = {
            title: $("#title").val(),
            price: $("#price").val(),
            description: $("#description").val(),
            short_description: $("#short_description").val(),
            accessible: isChecked,
            quantity: $("#quantity").val(),
            image : f,
            manufacturer: s.value,
            categories: res,
            property: prop.value
        };
        $.ajax({
            type: "POST",
            url: "/update/${prod.product_id}",
            headers: {
                "Content-Type": "application/json;charset=UTF-8"
            },
            data: JSON.stringify(modelObj),

            success: function (data) {
                console.log("POST API RESPONSE::"+data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
            }
        });
        });
</script>
</body>
</html>