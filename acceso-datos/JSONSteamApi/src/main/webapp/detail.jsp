<%@page import="model.Datos"%>
<%@page import="dao.DaoDetail"%>
<%@page import="model.ResultDetalle"%>
<%@page import="dao.DaoMaster"%>
<%@page import="model.ResultMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<%
	
	String appName =  request.getParameter("applist");
	String appid =  request.getParameter("appid");
	ResultDetalle result = DaoDetail.getData(appid);
	Datos datos = result.getData();
	
%>
    <header class="bg-dark py-2">
        <div class="container">
            <h1><img src="https://store.akamai.steamstatic.com/public/shared/images/header/logo_steam.svg?t=962016"
                    alt=""></h1>
        </div>
    </header>
    <div class="container">
        <div class="card my-3">
            <img class="card-img-top" src="<%= datos.getHeader_image() %>" alt="">
            <div class="card-body">
                <div class="row">
                    <div class="col-8 text-left">
                    <a href="<%= datos.getWebsite()%>">
                        <h4 class="card-title"><%=datos.getName()%></h4>
                    </a> 
                    </div>
                    <div class="col-4 text-right">
                        <h4 class="card-title"><%= (datos.getPrice_overview().getFinal_formatted())%></h4>
                    </div>
                </div>
                
                <p class="card-text"><%= datos.getAbout_the_game()%></p>
                
                
            </div>
        </div>
        
    </div>
    <footer class="bg-dark py-2">
        <div class="container text-white">
            <h1>&copy;</h1>
        </div>
    </footer>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>