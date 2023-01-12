<footer id="footer" class="dark" style="background-color: #1c1b25;">

	<div class="container">

		<!-- Footer Widgets
      ============================================= -->
		<div class="footer-widgets-wrap row clearfix">

			<!-- Footer Widget 3
        ============================================= -->
			<div class="col">
				<div class="widget widget_links clearfix">
					<h4 class="mb-3 mb-sm-4">Link Utili</h4>
					<ul class="footer-links">
						<li><a href="chiSiamo.jsp">Su Di Noi</a></li>
						<li><a
							href="#">Feedback</a></li>
						<li><a href="mappa.jsp">Percorsi</a></li>
						<li><a href="">Contatti</a></li>
						<li><a href="#">Blog</a></li>
						<li><a href="#">Recensioni</a></li>
					</ul>
				</div>
			</div>

			<!-- Footer Widget 4
        ============================================= -->

			<div class="col">
				<div>
					<h4 class="mb-3 mb-sm-4">Scarica sul Telefono</h4>
					<p>Scarica subito la nostra app sul tuo telefono e inizia a
						visitare le attrazioni!</p>
					<a href="#" class="btn btn-light me-3"><i class="fab fa-app-store"></i>
						App Store</a> <a href="#" class="btn btn-light"><i
						class="fab fa-google-play"></i> Google Play</a>
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
					Copyrights © 2023 Tutti I Diritti Riservati Da Pathways.<br>
					<div class="copyright-links">
						<a href="#">Termini di Utilizzo</a> / <a href="#">Privacy Policy</a>
					</div>
				</div>

				<div class="col-md-6 align-self-center">
					<div class="copyrights-menu float-end copyright-links m-0 clearfix">
						<a href="#">Home</a> / <a href="#">Su Di Noi</a> / <a href="#">FAQs</a>
						/ <a href="#">Contatti</a>
					</div>
				</div>
			</div>

		</div>

	</div>
	<!-- #copyrights end -->

</footer>

<!-- LOGIN MODAL -->
<div id="logindemo" class="modal fade">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-body">
				<button type="button" class="btn-close btn-close-white"
					data-bs-dismiss="modal"></button>
				<div class="my-form">
				
					<h1 class="text-center modal-h1">Login</h1>
					<form action="login" method="post">
					
						<div class="mb-3 mt-3">
							<label for="email">Email</label> <input name="email" type="text"
								class="form-control">
						</div>
						<div class="mb-3 mt-3">
							<label for="password">Password</label> <input name="password"
								type="password" class="form-control">
						</div>
						<button type="submit" class="btn btn-light mt-3">LOGIN</button>
						<p class="login-form-p">
							Non sei registrato?<a href="#"
								onclick="document.getElementById('id01').style.display='block'; $('#logindemo').modal('hide');">
								Registrati</a>
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- SIGNUP MODAL -->

<!-- The Modal (contains the Sign Up form) -->
<div id="id01" class="signup-modal">
	<span onclick="document.getElementById('id01').style.display='none'"
		class="close" title="Close Modal">X</span>
	<form class="signup-modal-content" action="Registrazione" method="post">
		<div class="container">
			<h1>Registrati</h1>
			<p>Compila tutti i campi per registrarti.</p>
			<hr>
			<label for="email"><b>Email</b></label> <input
				class="signup-form-input" type="text" placeholder="Inserisci Email"
				name="email" required> <label for="psw"><b>Password</b></label>
			<input class="signup-form-input" type="password"
				placeholder="Inserisci Password" name="password" required> <label
				for="password-repeat"><b>Ripeti la password</b></label> <input
				class="signup-form-input" type="password"
				placeholder="Reinserisci Password" name="password-repeat" required>

			<p>
				Creando un account confermi di aderire ai nostri <a href="#"
					style="color: rgb(68, 97, 126)">Termini & Privacy</a>.
			</p>

			<div class="clearfix">
				<button class="signup btn-signup-form" type="submit">REGISTRATI</button>
				<button class="btn-signup-form" type="button"
					onclick="document.getElementById('id01').style.display='none'"
					class="cancelbtn">ANNULLA</button>
			</div>
		</div>
	</form>
</div>

<script>
	// Get the modal
	var modal = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
</script>

</body>

</html>