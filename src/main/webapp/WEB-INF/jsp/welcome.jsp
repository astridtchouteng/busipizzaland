<%@ page language="java" contentType="text/html ; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="type=text/html ; charset=UTF-8"/>
        <title>${titre}</title>
    </head>
    <body>
        <div class="row mt-4">
            <div class="col-3">
                <ul class="list-group">
                    <c:forEach items="${categories}" var="cat">
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <a href="${pageContext.request.contextPath}/categorie?categorie=${cat.categorie}" >${cat.categorie}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-lg-9">
                <%--<c:if test="${pizzas!= null  and  not empty pizzas}">--%>
                    <div class="row card-deck">
                        <c:forEach items="${pizzas}" var="pizza">
                            <div class="card-deck">
                                <div class="card mb-3 mr-5 bg-warning" style="max-width: 18rem; max-height: 350px;">
                                    <div class="card-header"><a href="${pageContext.request.contextPath}/pizzaDetails">${pizza.nom}</a></div>
                                    <div class="card-body">
                                        <h5 class="card-title">Card title</h5>
                                        <div class="card-text">
                                            <p>${pizza.description}</p>
                                        </div>

                                    </div>
                                    <div class="card-footer">
                                        <div class="row">
                                            <div class="col-3 mr-my-0">
                                                <p class="lead">${pizza.prix}</p>
                                            </div>
                                            <div class="col-9">
                                                <div class="2">
                                                    <a href="${pageContext.request.contextPath}/panier?nomPizza=${pizza.nom}" class="btn btn-outline-success my-2 my-sm-0 btn-sm">
                                                        Ajouter au panier</a>
                                                </div>
                                                                <%--<div class="row">--%>
                                                    <%--<form:form cssClass="form-inline" action="pizzaland/home/panier" method="post" modelAttribute="commande">--%>
                                                        <%--<div class=" form-row">--%>
                                                            <%--<div class="col-3">--%>
                                                                <%--<form:input path="quantite" cssClass="form-control" type="number" min="1" max="20" value="1"/>--%>
                                                            <%--</div>--%>
                                                            <%--<div class="col-2">--%>
                                                                <%--<form:input path="nom" type="hidden" cssClass="form-control" value="${pizza.nom}"/>--%>
                                                            <%--</div>--%>
                                                            <%--<div class="col-3- offset-2">--%>
                                                                <%--<form:button type="submit" cssClass="btn btn-primary">Add</form:button>--%>
                                                            <%--</div>--%>
                                                        <%--</div>--%>

                                                    <%--</form:form>--%>
                                                <%--</div>--%>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                <%--</c:if>--%>
            </div>
        </div>
    </body>
</html>