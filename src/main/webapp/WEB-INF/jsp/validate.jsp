<%@ include file="include/importTags.jsp" %>

<script src="https://use.fontawesome.com/c560c025cf.js"></script>
<div class="container">
    <div class="card shopping-cart">
        <div class="card-header bg-dark text-light">
            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
            <spring:message code="cart"/>

        </div>
        <div class="card-body">

            <c:forEach items="${panier.contenu}" var="pizza">

                <div class="row">
                    <div class="col-12 col-sm-12 col-md-2 text-center">
                        <img class="img-responsive" src="http://placehold.it/120x80" alt="preview" width="120"
                             height="80">
                    </div>
                    <div class="col-12 text-sm-center col-sm-12 text-md-left col-md-6">
                        <h4 class="product-name"><strong><spring:message code="${pizza.key.nom}"/></strong></h4>
                        <h5>
                            <c:set value="${row.key.description}" var="mots"/>
                            <c:forEach items="${mots}.split(\", \")" var="mot">
                                <spring:message code="${mot}"></spring:message>
                            </c:forEach>
                        </h5>
                    </div>
                    <div class="col-12 col-sm-12 text-sm-center col-md-4 text-md-right row">
                        <div class="col-3 col-sm-3 col-md-6 text-md-right" style="padding-top: 5px">
                            <h6><strong>${pizza.key.prix} euro <span class="text-muted">x</span></strong></h6>
                        </div>
                        <div class="col-4 col-sm-4 col-md-4">
                                ${pizza.value}
                        </div>

                    </div>
                </div>
                <hr>
            </c:forEach>

        </div>
        <div class="card-footer">

            <div class="pull-right" style="margin: 10px">
                <div class="pull-right" style="margin: 5px">
                    <spring:message code="total"/>: ${panier.prixTotal} euro
                    <br/>
                    Reduction: -${panier.reduction} euro
                    <br/>
                    <spring:message code="totalPrice"/>:
                    <b>${prixFinal} euro
                    </b>
                </div>

                <sec:authorize access="isAuthenticated()">
                    <div id="paypal-button-container"></div>
                    <script src="https://www.paypalobjects.com/api/checkout.js"></script>
                    <script>

                        paypal.Button.render({

                            env: 'sandbox', // sandbox | production

                            style: {
                                layout: 'horizontal',  // horizontal | vertical
                                size: 'medium',    // medium | large | responsive
                                shape: 'rect',      // pill | rect
                                color: 'blue'       // gold | blue | silver | white | black
                            },

                            funding: {
                                allowed: [
                                    paypal.FUNDING.CARD,

                                ],
                                disallowed: []
                            },

                            client: {
                                sandbox: 'ATUaJ2Nsk7scrAAUeZlmCt589Qzz81PwwS335PmtrlpnUb5tXfwr7T5Sc_WFzbVYV0wQ6bANv3EHgCUl',
                                production: 'konrad4595-facilitator@gmail.com'
                            },

                            payment: function (data, actions) {
                                return actions.payment.create({
                                    payment: {
                                        transactions: [
                                            {
                                                amount: {
                                                    total: '${prixFinal}',
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
                                        window.location.replace("http://localhost:8080/pizzaland/validerPanier/process");

                                    });
                            }
                        }, '#paypal-button-container');
                    </script>
                </sec:authorize>

            </div>
        </div>
    </div>
</div>