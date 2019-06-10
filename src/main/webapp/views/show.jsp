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
<body>
<div id="welcome"></div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script>
    window.addEventListener("load",function() {
        var request = new XMLHttpRequest();
        request.open('GET','show/106',true);
        request.addEventListener('readystatechange', function() {
            if ((request.readyState==4) && (request.status==200)) {
                var welcome = document.getElementById('welcome');
                welcome.innerHTML = request.responseText;
            }
        });
        request.send();
    });
</script>
</body>
</html>