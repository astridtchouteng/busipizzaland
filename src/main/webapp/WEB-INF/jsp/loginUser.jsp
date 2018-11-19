<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>${titre}</title>
    <link type="text/css" href="<spring:url value='/css/login.css' />" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row" id="pwd-container">
        <div class="col-md-4"></div>

        <div class="col-md-4">
            <section class="login-form">
                <form:form method="post" modelAttribute="user" role="login">
                    <img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive" alt="" />
                    <form:input path="username" placeholder="Email" cssClass="form-control input-lg" />
                    <form:errors path="username" />

                    <form:password path="password" class="form-control input-lg" placeholder="Password" required="true" />

                    <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button>
                    <div>
                        <a href="${pageContext.request.contextPath}/inscription">Create account</a>
                    </div>

                </form:form>
            </section>
        </div>

        <div class="col-md-4"></div>


    </div>


        <%--<div class="row">--%>
            <%--<div class="col-lg-6 offset-3">--%>
                <%--<form:form method="post"  modelAttribute="user">--%>
                    <%--<div class="form-group">--%>
                        <%--<form:label path="username"><label>Username</label></form:label>--%>
                        <%--<form:input path="username" cssClass="form-control"></form:input>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<form:label path="password">Password</form:label>--%>
                        <%--<form:password path="password" cssClass="form-control"></form:password>--%>
                    <%--</div>--%>
                    <%--<button type="submit" class="btn btn-primary">Submit</button>--%>
                <%--</form:form>--%>
            <%--</div>--%>
        <%--</div>--%>
</div>

</body>
</html>
</body>
</html>