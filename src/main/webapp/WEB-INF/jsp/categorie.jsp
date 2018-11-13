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
                    <c:forEach items="${pizzas}" var="pizza">
                        <div class="card text-white bg-warning mb-3 mr-3"
                             style="max-width: 400px; max-height: 400px;">
                            <div class="card-header">${pizza.nom}</div>
                            <div class="card-body">
                                <h5 class="card-title">Description</h5>
                                <div class="card-text">
                                    <p>${pizza.description}</p>
                                </div>
                                <div class="row">
                                    <div class="col-xs-12 col-md-12 col-lg-12">
                                        <form class="form-row my-2 my-lg-0">
                                            <div class="col-4">
                                                <input class="form-control mr-sm-2" type="number" min="1" max="20"
                                                       value="1"/>
                                            </div>
                                            <div class="col-3 offset-1">
                                                <p class="lead">
                                                        ${pizza.prix}</p>
                                            </div>
                                            <div class="col-4">
                                                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                                                    Search
                                                </button>
                                            </div>
                                        </form>
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