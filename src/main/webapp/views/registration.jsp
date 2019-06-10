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

    <title>Create an account</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/common.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/style.css">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body style="
      padding-top: 0">

<div class="container" >

    <form id="ShopLogo" method="GET" action="${contextPath}/">
    </form>
    <h1>
        <a onclick="document.forms['ShopLogo'].submit()">Market Place</a>
    </h1>
</div>

<div class="container content">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2>Create your account</h2>

        <spring:bind path="username">
            <label for="1">Username</label>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" id="1" path="username" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <label for="2">Password</label>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" id="2" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password2">
            <label for="3">Confirm Password</label>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" id="3" path="password2" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="password2"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="firstname">
            <label for="4">Name</label>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" id="4" path="firstname" class="form-control" placeholder="Firstname"
                            autofocus="true"></form:input>
                <form:errors path="firstname"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="lastname">
            <label for="5">Surname</label>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" id="5" path="lastname" class="form-control" placeholder="Lastname"
                            autofocus="true"></form:input>
                <form:errors path="lastname"></form:errors>
            </div>
        </spring:bind>


        <spring:bind path="email">
            <label for="6">Email</label>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="email" id="6" path="email" class="form-control" placeholder="Email"></form:input>
                <form:errors path="email"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="birthday">
            <label for="7">Birthday</label>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="date" id="7" path="birthday" class="form-control" placeholder="Birthday"></form:input>
                <form:errors path="birthday"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="phone">
            <label for="8">Phone</label>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="tel" id="8" pattern="8-[0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2}" path="phone" class="form-control" placeholder="8-xxx-xxx-xx-xx"></form:input>
                <form:errors path="phone"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="address">
            <label for="9">Address</label>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" id="9" path="address" class="form-control" placeholder="Address"></form:input>
                <form:errors path="address"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="index">
            <label for="10">Index</label>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="tel" id="10" pattern="[0-9]{2}-[0-9]{2}-[0-9]{2}" path="index" class="form-control" placeholder="xx-xx-xx"></form:input>
                <form:errors path="index"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}resources/js/bootstrap.min.js"></script>
</body>
</html>
