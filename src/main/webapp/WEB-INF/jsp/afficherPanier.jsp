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
                        <th>Pizza</th>
                        <th>PrixUnitaire</th>
                        <th>Quantite</th>
                        <th>PrixTotal</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${panier.contenu!= null and not empty panier.contenu}">
                        <c:forEach items="${panier.contenu}" var="row">
                            <tr>
                                <td>
                                    <div class="card text-white bg-warning mb-3 "
                                         style="max-width: 300px; max-height: 350px;">
                                        <div class="card-header">${row.key.nom}</div>
                                        <div class="card-body">
                                            <h5 class="card-title">${row.key.description}</h5>
                                        </div>
                                        <div class="card-footer">
                                            <div class="row">
                                                <div class="col-4">

                                                    <a href="${pageContext.request.contextPath}/panier/supprimer?nomPizza=${row.key.nom}"
                                                       class="btn btn-danger btn-sm">Supprimer
                                                    </a>
                                                </div>
                                                <div class="col-4 offset-4">
                                                    <a href="#" class="btn btn-primary btn-sm">Promotion</a>
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

                                        <input type="number" size="4" min="1" max="200" value="${row.value}"/>

                                        <a href="${pageContext.request.contextPath}/panier/modifier?nomPizza=${row.key.nom}&amp;operation=moins"
                                           class="btn btn-danger btn-sm moins" disabled="true">-
                                        </a>
                                    </div>
                                </td>
                                <td>${row.value * row.key.prix }</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <tr>
                        <td colspan="3">Total</td>
                        <td>${panier.prixTotal}</td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center;">
                            <a href="${pageContext.request.contextPath}/panier/vider" class="btn btn-danger">Vider
                                Panier
                            </a>
                        </td>
                        <td colspan="2" style="text-align: center;">
                            <a href="${pageContext.request.contextPath}/panier/valider" class="btn btn-success">Valider Commande</a>
                            <div id="paypal-button-container"></div>
                            <script src="https://www.paypalobjects.com/api/checkout.js"></script>
                            <script>
                                // Render the PayPal button
                                paypal.Button.render({
                                // Set your environment
                                env: 'sandbox', // sandbox | production

                                // Specify the style of the button
                                style: {
                                layout: 'horizontal',  // horizontal | vertical
                                size:   'medium',    // medium | large | responsive
                                shape:  'rect',      // pill | rect
                                color:  'blue'       // gold | blue | silver | white | black
                                },

                                // Specify allowed and disallowed funding sources
                                //
                                // Options:
                                // - paypal.FUNDING.CARD
                                // - paypal.FUNDING.CREDIT
                                // - paypal.FUNDING.ELV
                                funding: {
                                allowed: [
                                paypal.FUNDING.CARD,

                                ],
                                disallowed: []
                                },

                                // PayPal Client IDs - replace with your own
                                // Create a PayPal app: https://developer.paypal.com/developer/applications/create
                                client: {
                                sandbox: 'AeUIdUt_fKw44_9GXgwOJ7nT_lLK968Rw9MNtfoYrbGCLY20YTqbUAaXuCApnj577Cd8SlkGVHKYe-DO',
                                production: 'damastrid02-facilitator@yahoo.fr'
                                },

                                payment: function (data, actions) {
                                return actions.payment.create({
                                payment: {
                                //         redirect_urls:{
                                //             return_url: 'http://localhost:8082/ACAPizza/panier/process',
                                //             cancel_url:'http://localhost:3000/ACAPizza/panier'
                                // },
                                transactions: [
                                {
                                amount: {
                                total: '${panier.prixTotal}',
                                currency: 'EUR'
                                }
                                }
                                ]
                                }
                                });
                                },

                                onAuthorize: function (data, actions) {
                                return actions.payment.execute()
                                .then(function () {
                                window.alert('Payment Complete!');
                                });
                                }
                                }, '#paypal-button-container');
                            </script>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>