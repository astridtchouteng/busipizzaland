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
            <form:form method="post" action="${pageContext.request.contextPath}/pizza" modelAttribute="pizza">
                <div class="form-group">
                    <form:label path="categorie"><label>Categorie</label></form:label>
                    <form:select path="categorie">
                        <form:options items="${categories}" itemValue="name" itemLabel="name" />
                    </form:select>
                </div>
                <div class="form-group">
                    <form:label path="description">Description</form:label>
                    <form:input path="description" cssClass="form-control"></form:input>
                </div>
                <div class="form-group">
                    <form:label path="prix">Prix</form:label>
                    <form:input path="prix"  cssClass="form-control"></form:input>
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