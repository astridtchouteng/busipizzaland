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
                <div class="row card-deck">
                    <h3>Pizzas ${categorie}</h3>
                    <c:forEach items="${pizzas}" var="pizza">
                    <div class="card mb-3 mr-5 bg-warning" style="max-width: 18rem; max-height: 350px;">
                        <div class="card-header">${pizza.nom}</div>
                            <div class="card-body">
                                <h5 class="card-title">Description</h5>
                                <div class="card-text">
                                    <p>${pizza.description}</p>
                                </div>
                                    <div class="card-footer">
                                        <div class="row">
                                            <div class="col-3 mr-my-0">
                                                <p class="lead">${pizza.prix}</p>
                                            </div>
                                            <div class="col-9">
                                                <div class="col-2">
                                                    <a href="${pageContext.request.contextPath}/traiter?nomPizza=${pizza.nom}"
                                                       class="btn btn-outline-success my-2 my-sm-0 btn-sm">
                                                        Ajouter au panier
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>