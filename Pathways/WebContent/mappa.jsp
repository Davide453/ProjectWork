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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="./css/styles.css" />
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
							aria-current="page" href="home.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link"
							href="percorsiUtente.jsp">Percorsi Salvati</a></li>
						<li class="nav-item"><a class="nav-link" href="chiSiamo.jsp">Chi
								Siamo</a></li>
						<li class="nav-item" data-bs-toggle="modal"
							data-bs-target="#logindemo"><a class="nav-link" href="#">Login</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<main id="main">
		<form id="getPercorso">
			<div class="row mr-0">
				<div class="filters col">
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
							<input type="submit" class="btn btn-primary"
								value="Calcola il percorso">
						</div>
					</div>
				</div>
				<div id="map-container" class="col-10">
					<div id="map"></div>
				</div>
			</div>
		</form>
	</main>

	<%@ include file="footer.jsp"%>