<%@ page language="java" contentType="text/html ; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="type=text/html ; charset=UTF-8"/>
        <title>${titre}</title>
    </head>
    <body>

        <div class = "container">
            <p>Welcome, Astrid!!!</p>
            <p><a href = "${pageContext.request.contextPath}/login">login</a></p>
            <p><a href = "${pageContext.request.contextPath}/inscription">inscription</a></p>
        </div>

        <div class="row mt-4">
            <div class="col-3">
                <ul class="list-group">
                    <c:forEach items="${cats}" var="cat">
                        <li class="list-group-item d-flex justify-content-between align-items-center">


                            <a href="${pageContext.request.contextPath}/home/categorie?categorie=${cat}" >${cat}</a>
                            <span class="badge badge-primary badge-pill">14</span>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <div class="col-lg-9">
                <%--<c:if test="${pizzas!= null  and  not empty pizzas}">--%>
                    <div class="row card-deck">
                        <c:forEach items="${pizzas}" var="pizza">
                            <div class="card text-white bg-warning mb-3 mr-3"
                                 style="max-width: 400px; max-height: 400px;">
                                <div class="card-header">${pizza.categorie}</div>
                                <div class="card-body">
                                    <h5 class="card-title">Description</h5>
                                    <div class="card-text">
                                        <p>${pizza.description}</p>
                                    </div>
                                    <div class="row">
                                        <div class="col-4">
                                            <input class="mr-sm-2" type="number" min="1" max="20"
                                                   value="1"/>
                                        </div>
                                        <div class="col-3">
                                            <p class="lead">
                                                    ${pizza.prix}</p>
                                        </div>
                                        <div class="col-4">
                                            <a href="${pageContext.request.contextPath}/panier" class="btn btn-outline-success btn-sm">
                                                Ajouter au panier
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <div class="row">
                                        <div class="col-4 offset-4">
                                            <a href="#" class="btn btn-danger btn-sm"></a>
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