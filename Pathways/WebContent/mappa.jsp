<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>Pathways - Map</title>
<meta name="description"
	content="Mappa con localizzazione delle attrazioni">
<meta name="author" content="Pathways">
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="icon" href="img/logo.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="./css/styles.css" />

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAXcsTlD8ARR47szaFywPJ18zASD-hIBTE&callback=initMap&libraries=marker,places&v=beta"
	defer></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>

<script src="https://kit.fontawesome.com/9b5234d401.js"
	crossorigin="anonymous"></script>

<script type="module" src="./js/map.js"></script>
</head>

<body>
	<header id="header" style="position: relative;">
		<nav id="target-navbar" class="navbar navbar-expand-lg">
			<div class="col-3"></div>

			<div class="col">
				<div class="container-fluid">
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<a class="navbar-brand " href="home.jsp"> <img
							src="./img/logo.png" alt="Bootstrap" width="100" height="100"
							style="border-radius: 50%; opacity: 0.9;">
						</a>
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item"><a class="nav-link" href="home.jsp">Home</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="mappa.jsp">Percorsi</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="percorsiUtente.jsp">I tuoi percorsi</a></li>
							<li class="nav-item"><a class="nav-link" href="chiSiamo.jsp">Chi
									Siamo</a></li>
							<li class="nav-item" data-bs-toggle="modal"
								data-bs-target="#logindemo"><a class="nav-link" href="#">Login</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-2"></div>
		</nav>
	</header>

	<main id="main">
		<form id="getPercorso" method="POST">
			<div class="row mr-0">
				<div class="filters col">
					<div class="col">
						<div id="percorso" class="row container">
							<div class="row" style="padding-top: 2em;">
								<h4>Cosa vuoi visitare?</h4>
							</div>
						</div>

						<div class="row m-2 ps-3">
							<input id="submit" type="submit" class="btn btn-primary"
								value="Calcola il percorso">
						</div>
					</div>
				</div>
				<div id="map-container" class="col-10 map-div">
					<div id="map" style="width: 100%; height: 80vh;"></div>
				</div>
			</div>
		</form>
	</main>

	<%@ include file="footer.jsp"%>