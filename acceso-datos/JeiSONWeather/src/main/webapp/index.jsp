<%@page import="java.net.URL" %>
<%@page import="util.Util"%>
  <%@page import="org.apache.commons.io.IOUtils" %>
    <%@page import="model.Result" %>
      <%@page import="com.google.gson.Gson" %>
        <%@page import="model.Dia" %>
          <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
            <!doctype html>
            <html lang="en">

            <head>
              <title>Title</title>
              <!-- Required meta tags -->
              <meta charset="utf-8">
              <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

              <!-- Bootstrap CSS -->
              <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                crossorigin="anonymous">
            </head>

            <body>
              <% String jsonTxt=IOUtils.toString(new
                URL("https://api.darksky.net/forecast/21259f9de3537b4f719c53580fa39c3a/39.8710026,-4.0251675?lang=es&exclude=minutely,hourly,alerts,flags/r/n"
                + "" ),"utf-8"); Result result=new Gson().fromJson(jsonTxt, Result.class); %>
                <div class="container shadow p-0">
                  <header class="bg-primary text-white text-center py-3">
                    <h1>DarkSky</h1>
                  </header>

                  <div class="row justify-content-center">
                    <div class="col-md-6 mt-3">
                      <h3 class="text-primary text-center">Currently</h3>
                      <div class="card">
                        <div class="row">
                          <div class="col-4">
                            <img class="card-img-top"
                              src="https://darksky.net/images/weather-icons/<%=result.getCurrently().getIcon()%>.png"
                              alt="">
                          </div>
                          <div class="col-8">
                            <div class="card-body">
                              <h4 class="card-title">
                                <%= result.getCurrently().getSummary() %>
                              </h4>
                              <p class="card-text">Temperatura: <%=result.getCurrently().getTemperature() %>
                              </p>
                              <p class="card-text">Precipitacion: <%= result.getCurrently().getPrecipProbability() %>
                              </p>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <h3 class="text-primary text-center">Daily</h3>
                  <div class="row justify-content-center px-2">
                    <%for(Dia dia: result.getDaily().getData()) { %>
                      <div class="col-md-6 my-3 d-flex">
                        <div class="card flex-fill shadow">
                          <div class="row">
                            <div class="col-4">
                              <img class="card-img-top"
                                src="https://darksky.net/images/weather-icons/<%=dia.getIcon()%>.png"
                                alt="">
                            </div>
                            <div class="col-8">
                              <div class="card-body">
                                <h3 class="card-title">
                                  <%=Util.timeStampToDate(dia.getTime()) %>
                                </h3>
                                <h4 class="card-title">
                                  <%= dia.getSummary()%>
                                </h4>
                                <p class="card-text">Máxima: <%= Util.farToCel(dia.getTemperatureMax()) %>º - Mínima:
                                    <%=Util.farToCel(dia.getTemperatureMin()) %>º</p>
                                <p class="card-text">Precipitacion <%=dia.getPrecipProbability()%>%</p>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <% }%>


                  </div>

                  <footer class="bg-primary text-white text-center py-3">
                    <h1>Perico</h1>
                  </footer>
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