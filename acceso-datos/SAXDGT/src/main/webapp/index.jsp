<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="model.Noticia" %>
  <%@page import="java.util.ArrayList" %>
    <%@page import="manejador.ManejadorWeb" %>
      <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
          <%String cca[] = {"Andalucia",
                  "Aragón",
                  "Asturias",
                  "Islas Baleares",
                  "Islas Canarias",
                  "Cantabria","Castilla y León",
                  "Castilla la Mancha",
                  "Cataluña","Valencia",
                  "Extremadura",
                  "Galicia",
                  "Madrid",
                  "Murcia",
                  "Navarra",
                  "Pais Vasco",
                  "La Rioja",
                  "Ceuta",
                  "Melilla"}; %>


                  
          <html lang="en">

          <head>
            <title>DGT Incidencias</title>
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

            <!-- Bootstrap CSS -->
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
          </head>

          <body>
            <div class="container">
              <div class="jumbotron mt-3">
                <h1 class="display-3">DGT Noticias</h1>
                

              </div>
			
              <div class="row justify-content-center">
                <div class="col-md-4 lg-3 my-3">
                <form action="index.jsp" method="post">
                  <div class="form-group">
                    <label for="">Comunidad:</label>
                    <select class="form-control" name="ca" id="" onchange="this.form.submit()">
                      <option value = "" disable selected>Seleccione comunidad</option>
                      <%
                      	for (int i = 0; i < cca.length;i++) {%>
                      		<option value = "<%= i+1 %>"><%=cca[i]%></option>
                      	<%}%>
                    </select>
                  </div>
                  </form>
                </div>

              </div>
              
			<%
			String ca = request.getParameter("ca");
			if (ca != null){
				ManejadorWeb manejador=new ManejadorWeb("https://infocar.dgt.es/etraffic/rss_ca_"+ca+".xml"); 
				ArrayList<Noticia> noticias = manejador.parsear(); 
				int caint = Integer.parseInt(ca);
			%>
			<h2 class = "text-center">Incidencias en la comunidad de <%= cca[caint - 1] %></h2>
             <div class="row justify-content-center">
              <% for (Noticia noticia : noticias) {%>
                <div class="col-md-4 lg-3 my-3 d-flex">
                  
                    <div class="card flex-fill">
                      <div class="card-body">
                        <h4 class="card-title"><%= noticia.getTitulo() %></h4>
                        <h5 class="card-title">El dia: <%= noticia.getFechaPub().substring(0,8) %> de <%= noticia.getFechaPub().substring(8,16) %></h5>
                        <p class="card-text"><%= noticia.getDescrip().replace("src='", "src='http://infocar.dgt.es/etraffic/") %></p>
                      </div>

                    </div>

                  

                </div>
                <%}%>
              </div>
              <%}%>

            </div>
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