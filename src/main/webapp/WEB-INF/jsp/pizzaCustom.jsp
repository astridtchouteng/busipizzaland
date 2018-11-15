<%@ page language="java" contentType="text/html ; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="type=text/html ; charset=UTF-8"/>
        <link type="text/css" href="<spring:url value='/css/pizzacustom.css'/>" rel="stylesheet">
        <title>${titre}</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>


        <div class="row mt-4">
            <h2>Et si vous la personnalisez ? </h2> <span>Customiser !!!!</span>

        </div>
        <form:form method="post" action="${pageContext.request.contextPath}/pizzaCustom"
                   modelAttribute="pizza">

            <div class="row mt-4">
                <div class="col-5">
                    <div>
                        <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/400x200" alt="" />
                    </div>
                </div>

                <%--<div class="col-4">--%>
                    <%--<div class="form-group">--%>
                        <%--<form:label path="nom">Nom</form:label>--%>
                        <%--<form:input path="nom" cssClass="form-control"></form:input>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<form:label path="description">Description</form:label>--%>
                        <%--<form:input path="description" cssClass="form-control"></form:input>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <div class="col-3">
                    <h1>PANIER</h1>
                </div>
            </div>


            <div class="row mt-4">
                <h3>Ingrédients </h3>
                <br/>
                <div >
                    <%--<c:set var="sessionMap" value="${ingredientsPizza}" scope="request" ></c:set>--%>
                    <%--<% Object maps = request.getAttribute("ingredientsPizza") ;--%>
                        <%--request.getSession().setAttribute("map",maps); %>--%>
                    <c:forEach var="map" items="${ingredientsPizza}">
                        <%--<a href="${pageContext.request.contextPath}/pizzaDetails/plus?idPizza=${pizza.id}&amp;idIngredient=${map.key.id}"--%>
                           <%--class="btn btn-danger btn-sm plus">+</a>--%>

                            ${map.key.nom}
                            ${map.value}
                        <%--<a href="${pageContext.request.contextPath}/pizzaDetails/moins?idPizza=${pizza.id}&amp;idIngredient=${map.key.id}"--%>
                           <%--class="btn btn-danger btn-sm plus">-</a>--%>
                    </c:forEach>
                </div>
            </div>


            <div class="row mt-4">
                <h3> Ingredients Disponible en stock</h3>
                <br/>
                <div >
                    <c:forEach var="ingredient" items="${ingredients}">
                        <span><a  href="${pageContext.request.contextPath}/pizzaCustom?idIngredient=${ingredient.id}">${ingredient.nom}</a></span>
                    </c:forEach>
                </div>

            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </body>

</html>