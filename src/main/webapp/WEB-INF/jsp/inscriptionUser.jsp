<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<%--<%@include file="include/importLinks.jsp.jsp"%>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <link type="text/css" href="<spring:url value='/css/inscription.css' />" rel="stylesheet">
    <title>${titre}</title>
    <style>
        .error{
            color:red;
        }
    </style>
</head>
<body>
<div class="container">


    <div class="row">
        <div class="col-lg-6">
            <form:form method="post" action="/pizzaland/inscription" modelAttribute="currentUser">
                <div class="form-group">
                    <form:label path="username"><spring:message code="username"/></form:label>
                    <form:input path="username" cssClass="form-control" ></form:input>
                    <form:errors path="username" cssClass="error"></form:errors>
                </div>
                <div class="form-group">
                    <form:label path="firstname"><spring:message code="firstname"/></form:label>
                    <form:input path="firstname" cssClass="form-control" ></form:input>

                </div>
                <div class="form-group">
                    <form:label path="email"><spring:message code="email"/></form:label>
                    <form:input type = "email" path="email" cssClass="form-control"></form:input>
                    <form:errors path="email" cssClass="error"></form:errors>
                </div>
                <div class="form-group">
                    <form:label path="password"><spring:message code="password"/></form:label>
                    <form:password path="password" cssClass="form-control"></form:password>
                    <span class="erreur">${erreurs['password']}</span>
                    <form:errors path="password" cssClass="error"></form:errors>
                </div>
                <div class="form-group">
                    <spring:message code="confirmPassword"/>
                    <form:password path="confirmPassword" cssClass="form-control"></form:password>
                    <span class="erreur">${erreurs['passwordConfirm']}</span>
                    <form:errors path="confirmPassword" cssClass="error"></form:errors>
                </div>

                <div class="form-group">
                    <form:label path="adresse"><spring:message code="adresse"/></form:label>
                    <form:input path="adresse" cssClass="form-control" ></form:input>
                </div>

                <div class="form-check form-check-inline">
                    <form:radiobutton path="sexe" value="boy" label="Boy" checked="true"></form:radiobutton>
                    <form:radiobutton path="sexe" value="girl" label="Girl"></form:radiobutton>
                </div>


                <button type="submit" class="btn btn-primary"><spring:message code="submit"/></button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
</div>
</body>
</html>