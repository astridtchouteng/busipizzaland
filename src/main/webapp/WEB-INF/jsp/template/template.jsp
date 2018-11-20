<%@ include file="../include/importTags.jsp" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="type=text/html; charset=UTF-8">
    <meta username="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    <link type="text/css" href="<spring:url value='/css/template.css' />" rel="stylesheet">
    <title>${titre}</title>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">PizzaLand</a>
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/home"><spring:message code="Home"/> <span class="sr-only">(current)</span></a>
                </li>
            </ul>

            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <span class="navbar-text " style="color: cadetblue">
                    <sec:authorize access="isAuthenticated()">
                        <sec:authentication property="principal.username"/>
                    </sec:authorize>
                </span>
            </ul>

            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <spring:url var="localeFr" value="">
                    <spring:param name="locale" value="fr" />
                </spring:url>

                <spring:url var="localeEn" value="">
                    <spring:param name="locale" value="en" />
                </spring:url>

                <li class="nav-item mr-2">
                    <a href="${localeFr}">Fr</a>
                </li>
                <li class="nav-item mr-2">
                    <a href="${localeEn}">En</a>
                </li>
            </ul>

            <ul class="navbar-nav navbar-right ">
                <li class="nav-item mr-2">
                    <sec:authorize access="isAuthenticated()">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/logout" class =" nav-link btn btn-warning btn-sm">
                                <spring:message code="Logout" />
                            </a>
                            </li>
                        </ul>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <ul class="navbar-nav">
                            <li class="nav-item mr-2">
                                <a href="${pageContext.request.contextPath}/login" class =" nav-link btn btn-outline-success btn-sm-mr-2">
                                    <spring:message code="Login"/>
                                </a>
                            </li>
                            <li class="nav-item mr-2"><span class="navbar-text"><spring:message code="or"/></span></li>
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/inscription" class=" nav-link btn btn-outline-success btn-sm-mr-2">
                                    <spring:message code="SignUp"/>
                                </a>
                            </li>
                        </ul>
                    </sec:authorize>
                </li>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/panier"  class =" nav-link btn btn-primary btn-sm">
                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                        <spring:message code="ShoppingCart"/>
                        <span class="badge">
          				<c:out value="${panier != null ? panier.quantiteTotal : 0}"></c:out>
          			</span>
                    </a>
                </li>
            </ul>
        </div>
    </nav>

<div class="container-fluid">
        <tiles:insertAttribute name="main-content"/>

</div>

</body>
</html>