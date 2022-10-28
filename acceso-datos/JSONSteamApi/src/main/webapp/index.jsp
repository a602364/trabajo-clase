<%@page import="model.Apps" %>
    <%@page import="dao.DaoMaster" %>
        <%@page import="model.ResultMaster" %>
            <%@page import="com.google.gson.Gson" %>

                <%@page import="java.net.URL" %>
                    <%@page import="org.apache.commons.io.IOUtils" %>
                        <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
                            %>
                            <!doctype html>
                            <html lang="en">

                            <head>
                                <title>Title</title>
                                <!-- Required meta tags -->
                                <meta charset="utf-8">
                                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

                                <!-- Bootstrap CSS -->
                                <link rel="stylesheet"
                                    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                                    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                                    crossorigin="anonymous">
                            </head>

                            <body>
                                <% ResultMaster result=DaoMaster.getData(); %>
                                    <header class="bg-dark py-2">
                                        <div class="container">
                                            <h1><img src="https://store.akamai.steamstatic.com/public/shared/images/header/logo_steam.svg?t=962016"
                                                    alt=""></h1>
                                        </div>
                                    </header>
                                    <div class="container">
                                        <div class="row my-3 flex-fill">

                                            <% for (Apps apps: result.getApplist().getApps()) { %>
                                                <div class="col-md-4 my-3 d-flex">
                                                    <div class="card shadow flex-fill">

                                                        <div class="card-body text-center">

                                                            <a
                                                                href="detail.jsp?appname=<%=apps.getName()%>&appid=<%=apps.getAppid()%>">
                                                                <h2 class="card-title">
                                                                    <%=apps.getName()%>
                                                                </h2>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <% } %>
                                        </div>

                                    </div>

                                    <!-- Optional JavaScript -->
                                    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
                                    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                                        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                                        crossorigin="anonymous"></script>
                                    <script
                                        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                                        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                                        crossorigin="anonymous"></script>
                                    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                                        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                                        crossorigin="anonymous"></script>
                            </body>

                            </html>