<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <form:form method="post" modelAttribute="user">
                <div class="form-group">
                    <form:label path="username"><label>Username</label></form:label>
                    <form:input path="username" cssClass="form-control"></form:input>
                </div>
                <div class="form-group">
                    <form:label path="password">Password</form:label>
                    <form:password path="password" cssClass="form-control"></form:password>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
</div>
</body>
</html>