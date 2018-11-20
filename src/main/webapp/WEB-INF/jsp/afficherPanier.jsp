<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                        <th><spring:message code="pizza"/></th>
                        <th><spring:message code="unitPrice"/></th>
                        <th><spring:message code="quantity"/></th>
                        <th><spring:message code="totalPrice"/></th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${panier.contenu!= null and not empty panier.contenu}">
                        <c:forEach items="${panier.contenu}" var="row" >
                            <tr>
                                <td>
                                    <div class="card text-white bg-warning mb-3 "
                                         style="max-width: 300px; max-height: 350px;">
                                        <div class="card-header"><spring:message code="${row.key.nom.replace(\" \", \"\").replace(\"é\",\"e\").toLowerCase()}"></spring:message></div>
                                        <div class="card-body">
                                            <h5 class="card-title"><spring:message code="description"></spring:message></h5>
                                            <div class="card-text">
                                                <%--<%--%>
                                                    <%--String[] mots =--%>
                                                            <%--((String)pageContext.getAttribute("row.key.description",PageContext.REQUEST_SCOPE)).split(", ");--%>
                                                    <%--request.setAttribute("mots",mots);--%>
                                                <%--%>--%>
                                                    <c:set value="${row.key.description}" var="mots"/>
                                                <c:forEach items="${mots}.split(\", \")" var="mot">
                                                    <spring:message code="${mot}"></spring:message>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div class="card-footer">
                                            <div class="row">
                                                <div class="col-4">

                                                    <a href="${pageContext.request.contextPath}/panier/supprimer?nomPizza=${row.key.nom}"
                                                       class="btn btn-danger btn-sm"><spring:message code="delete"/>
                                                    </a>
                                                </div>
                                                <div class="col-4 offset-4">
                                                    <a href="#" class="btn btn-primary btn-sm"><spring:message code="coupon"/></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td>${row.key.prix}</td>
                                <td>
                                    <div class="row">

                                        <a href="${pageContext.request.contextPath}/panier/modifier?nomPizza=${row.key.nom}&amp;operation=plus"
                                           class="btn btn-danger btn-sm plus">+
                                        </a>
                                        <input type="text" value="${row.value}"/>

                                        <a href="${pageContext.request.contextPath}/panier/modifier?nomPizza=${row.key.nom}&amp;operation=moins"
                                           class="btn btn-danger btn-sm moins" disabled="true">-
                                        </a>
                                        <div>
                                                ${panier.monStock}
                                        </div>
                                    </div>
                                </td>
                                <td>${row.value * row.key.prix }</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <tr>
                        <td colspan="3"><spring:message code="total"/></td>
                        <td>${panier.prixTotal}</td>
                    </tr>
                    <tr>
                        <c:if test="${panier.quantiteTotal != 0}">
                            <td colspan="2" style="text-align: center;">
                                <a href="${pageContext.request.contextPath}/panier/vider" class="btn btn-danger">
                                    <spring:message code="flushCart"/>
                                </a>
                            </td>
                            <td colspan="2" style="text-align: center;">
                                <a href="${pageContext.request.contextPath}/validerPanier" class="btn btn-success">
                                    <spring:message code="validateOrder"/>
                                </a>

                            </td>
                        </c:if>

                    </tr>
                    <%--<p>Click the button to display a confirm box.</p>--%>

                    <%--<button onclick="myFunction()">Try it</button>--%>

                    <%--<script>--%>
                    <%--function myFunction() {--%>
                        <%--if(${panier.prixTotal != 0})--%>
                            <%--confirm("Press a button!");--%>
                    <%--}--%>
                    <%--</script>--%>
                </tbody>
            </table>
        </div>
    </body>
</html>