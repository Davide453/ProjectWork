<%@ include file="header.jsp"%>

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
<link rel="icon" href="/Pathways/WebContent/img/logo.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="./css/mappa.css" />
<script type="module" src="./js/mappa.js"></script>
</head>

<body>
	<header>
		<nav class="navbar navbar-expand-lg bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Pathways</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="home.html">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Percorsi
								Salvati</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Chi
								Siamo</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Login</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<main id="main">
		<div class="row mr-0">
			<div class="filters col bg-white">
				<div class="col">
					<div id="percorso" class="row container">
						<div class="row">
							<h4>Cosa vuoi visitare?</h4>
						</div>
					</div>
					<div class="row m-2">
						<input type="text"></input>
					</div>
					<div class="row m-2">
						<input type="text"></input>
					</div>
					<div class="row m-2">
						<button type="submit" class="btn btn-primary" value="percorso"
							onclick="getPercorso()">Calcola il percorso</button>
					</div>
				</div>
			</div>
			<div id="map-container" class="col-10">
				<div id="map"></div>
			</div>
		</div>

	</main>

	<footer id="footer" class="dark" style="background-color: #1c1b25;">

		<div class="container">
	
		  <!-- Footer Widgets
		  ============================================= -->
		  <div class="footer-widgets-wrap row clearfix">
	
			<!-- Footer Widget 3
			============================================= -->
			<div class="col-lg-3 col-sm-6 mb-5 mb-sm-0">
			  <div class="widget widget_links clearfix">
				<h4 class="mb-3 mb-sm-4">Link Utili</h4>
				<ul>
				  <li><a href="https://codex.wordpress.org/">Documentation</a></li>
				  <li><a href="https://wordpress.org/support/forum/requests-and-feedback">Feedback</a></li>
				  <li><a href="https://wordpress.org/extend/plugins/">Plugins</a></li>
				  <li><a href="https://wordpress.org/support/">Support Forums</a></li>
				  <li><a href="https://wordpress.org/extend/themes/">Themes</a></li>
				  <li><a href="https://wordpress.org/news/">Canvas Blog</a></li>
				  <li><a href="https://planet.wordpress.org/">Customer Reviews</a></li>
				  <li><a href="https://planet.wordpress.org/">Get Licence</a></li>
				</ul>
			  </div>
			</div>
	
			<!-- Footer Widget 4
			============================================= -->
			<div class="col-lg-3 col-sm-6 mb-0">
			  <div class="widget widget_links clearfix">
				<h4 class="mb-3 mb-sm-4">Scarica sul Telefono</h4>
				<p>Scarica subito la nostra app sul tuo telefono e inizia a visitare le attrazioni!
				</p>
				<a href="#"
				  class="button button-light text-dark w-100 text-center bg-white nott ls0 button-rounded button-xlarge ms-0"><i
					class="icon-apple"></i>App Store</a>
				<a href="#"
				  class="button button-light text-dark w-100 text-center bg-white nott ls0 button-rounded button-xlarge ms-0"><i
					class="icon-googleplay"></i>Google Play</a>
			  </div>
			</div>
	
		  </div>
	
		</div>
	
		<!-- Copyrights
		============================================= -->
		<div id="copyrights">
	
		  <div class="container clearfix">
	
			<div class="row justify-content-center">
			  <div class="col-md-6 align-self-center">
				Copyrights © 2023 All Rights Reserved by Pathways.<br>
				<div class="copyright-links"><a href="#">Terms of Use</a> / <a href="#">Privacy Policy</a></div>
			  </div>
	
			  <div class="col-md-6 align-self-center">
				<div class="copyrights-menu float-end copyright-links m-0 clearfix">
				  <a href="#">Home</a>/<a href="#">Su Di Noi</a>/<a
					href="#">FAQs</a>/<a href="#">Contatti</a>
				</div>
			  </div>
			</div>
	
		  </div>
	
		</div><!-- #copyrights end -->
	
	  </footer>
	

	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAXcsTlD8ARR47szaFywPJ18zASD-hIBTE&callback=initMap&libraries=marker,places&v=beta"
		defer></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>

</html>