<%@ page language="java" contentType="text/html ; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="type=text/html ; charset=UTF-8"/>
        <title>${titre}</title>
    </head>
    <body>
        <div class="row mt-4">
            <table class="table">
                <thead>
                    <tr>
                        <th>Pizza</th>
                        <th>PrixUnitaire</th>
                        <th>Quantite</th>
                        <th>PrixTotal</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${pizzas!= null and not empty pizzas}">
                        <c:forEach items="${pizzas}" var="pizza">
                            <tr>
                                <td>
                                    <div class="card text-white bg-warning mb-3 "
                                         style="max-width: 300px; max-height: 250px;">
                                        <div class="card-header">${pizza.categorie}</div>
                                        <div class="card-body">
                                            <h5 class="card-title">${pizza.description}</h5>
                                            <%--<div class="card-text">--%>
                                                <%--<p>${pizza.description}</p>--%>
                                            <%--</div>--%>
                                        </div>
                                        <div class="card-footer">
                                            <div class="row">
                                                <div class="col-4">
                                                    <a href="#" class="btn btn-danger btn-sm">Supprimer</a>
                                                </div>
                                                <div class="col-4 offset-4">
                                                    <a href="#" class="btn btn-primary btn-sm">Promotion</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td>${pizza.prix}</td>
                                <td><input type="number" min="1" max="20" value="100" /></td>
                                <td>${pizza.prix * 10}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <tr>
                        <td colspan="3">Total</td>
                        <td>1500</td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center;"><a href="#" class="btn btn-danger">Vider Panier</a></td>
                        <td colspan="2" style="text-align: center;"><a href="#" class="btn btn-success">Valider Commande</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>