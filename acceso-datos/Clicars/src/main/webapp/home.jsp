<%@page import="model.entities.Marca"%>
<%@page import="model.entities.Coche"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
</head>

<body>

	<%
	ArrayList<Coche> coches = (ArrayList<Coche>) session.getAttribute("coche");
	ArrayList<Marca> marcas = (ArrayList<Marca>) session.getAttribute("marcas");
	%>
	<div class="container-fill">
		<nav class="navbar navbar-expand-sm navbar-light bg-dark d-flex">
			<div class="d-flex">
				<a class="navbar-brand" href=""><img src="img/logo.png" alt="" /></a>
			</div>

			<div class="d-flex ml-5">


				<form class="form-inline mr-2" action="Controller?op=vamarca"
					method="post">
					<div class="form-group">
						<select class="form-control" name="marca" id="marca"
							onchange="this.form.submit()">
							<option value="" disabled selected>Elija marca</option>
							<%
							for (Marca marca : marcas) {
							%>
							<option value="<%=marca.getId()%>">
								<%=marca.getNombre()%>
							</option>
							<%
							}
							%>
						</select>
					</div>
				</form>


				<form action="Controller?op=vaorder" method="post"
					class="form-inline mr-2">
					<div class="form-group">
						<select class="form-control" name="order" id="order"
							onchange="this.form.submit()">
							<option value="" disabled selected>Ordenada por</option>
							<option value="precio asc">Precio ascendente</option>
							<option value="precio desc">Precio descendente</option>
						</select>
					</div>
				</form>
				<form class="form-inline mr-2">
					<div class="form-group">
						<%
						String fav = (String) session.getAttribute("fav");
						if (fav.equals("%")) {
						%>
						<a href="Controller?op=vafav&fav=1"><span
							class="display-4 text-secondary">&#9733;</span></a>
						<%
						} else {
						%>
						<a href="Controller?op=vafav&fav=0"><span
							class="display-4 text-warning">&#9733;</span></a>
						<%
						}
						%>
					</div>
				</form>

			</div>



		</nav>

		<div class="row justify-content-center m-5 ">
			<%
			for (Coche coche : coches) {
			%>
			<div class="col-4 my-3">
				<div class="card border-dark rounded shadow flex-fill">
					<img class="card-img-top" src="<%=coche.getFoto()%>" alt="" />
					<div class="card-body bg-dark text-white">
						<h4 class="card-text">
							<%=coche.getNombre()%>
						</h4>
						<p class="card-text">
							Precio:
							<%=coche.getPrecio()%>&euro;
						</p>
						<p class="card-text">
							<%=coche.getAnio()%>
							|
							<%=coche.getKm()%>KMs |
							<%=coche.getCaballos()%>
							CV
						</p>
						<%
						if (coche.getFav() == 0) {
						%>
						<p class="text-right">
							<a
								href="Controller?op=changefav&bici=<%=coche.getId()%>&fav=<%=coche.getFav()%>"><span
								class="display-4 text-secondary">&#9733;</span></a>
						</p>
						<%
						} else {
						%>
						<p class="text-right">
							<a
								href="Controller?op=changefav&bici=<%=coche.getId()%>&fav=<%=coche.getFav()%>"><span
								class="display-4 text-warning">&#9733;</span></a>
						</p>
						<%
						}
						%>
					</div>
				</div>
			</div>
			<%
			}
			%>
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
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>

</html>