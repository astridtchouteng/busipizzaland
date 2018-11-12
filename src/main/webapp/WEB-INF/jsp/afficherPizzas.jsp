<%@ page language="java" contentType="text/html ; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="type=text/html ; charset=UTF-8"/>
        <title>${titre}</title>
    </head>
    <body>
        <div class = "container">
            <div class="row">
                <div class="col-3">
                    <div class="row">
                        <div class="col-4">
                            <div class="list-group" id="list-tab" role="tablist">
                                <a class="list-group-item list-group-item-action active" data-toggle="list" href="#" role="tab" aria-controls="home">Home</a>
                                <a class="list-group-item list-group-item-action"  data-toggle="list" href="#" role="tab" aria-controls="profile">Profile</a>
                                <a class="list-group-item list-group-item-action"  data-toggle="list" href="#" role="tab" aria-controls="messages">Messages</a>
                                <a class="list-group-item list-group-item-action"  data-toggle="list" href="#" role="tab" aria-controls="settings">Settings</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-6">

                </div>
            </div>
        </div>

    </body>
</html>