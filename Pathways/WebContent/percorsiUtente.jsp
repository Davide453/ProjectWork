<%@ include file="header.jsp"%>

<!-- SLIDER SECTION -->
<!-- ======================================================================== -->
<section class="slider">
	<div class="container" id="percorsiUtente" style="max-width: 100%;">
		<div class="col">
			<div class="row text-center">
				<h1>
					P<span class="auto-type"></span>
				</h1>
			</div>
			<div class="row text-center">
				<div class="row mb-5 pb-5">
					<h2>I Tuoi Percorsi</h2>
				</div>

			</div>
		</div>
	</div>
</section>



<!-- Main Section-->
<main id="main">
	<!-- ======= Our Projects Section ======= -->
	<section id="projects" class="projects">
		<div class="container" data-aos="fade-up">

			<div class="portfolio-isotope" data-portfolio-filter="*"
				data-portfolio-layout="masonry" data-portfolio-sort="original-order">



				<div class="row gy-4 portfolio-container">

					<div class="col-lg-4 col-md-6 portfolio-item filter-remodeling">
						<div class="portfolio-content h-100">
							<img src="./img/attrazione-1.jpg" class="img-fluid" alt="">
							<div class="portfolio-info">
								<h4>Percorso 1</h4>
								<%
								Percorso percorso = request.getAttribute("percorso");
								%>
								<a href="./img/attrazione-1.jpg" title="Remodeling 1"
									data-gallery="portfolio-gallery-remodeling"
									class="glightbox preview-link"><i class="bi bi-zoom-in"></i></a>
								<a href="project-details.html" title="More Details"
									class="details-link"><i class="bi bi-link-45deg"></i></a>
							</div>
						</div>
					</div>
					<!-- End Projects Item -->

					<div class="col-lg-4 col-md-6 portfolio-item filter-construction">
						<div class="portfolio-content h-100">
							<img src="./img/attrazione-1.jpg" class="img-fluid" alt="">
							<div class="portfolio-info">
								<h4>Percorso 2</h4>

								<a href="./img/attrazione-1.jpg" title="Construction 1"
									data-gallery="portfolio-gallery-construction"
									class="glightbox preview-link"><i class="bi bi-zoom-in"></i></a>
								<a href="project-details.html" title="More Details"
									class="details-link"><i class="bi bi-link-45deg"></i></a>
							</div>
						</div>
					</div>
					<!-- End Projects Item -->

					<div class="col-lg-4 col-md-6 portfolio-item filter-repairs">
						<div class="portfolio-content h-100">
							<img src="./img/attrazione-1.jpg" class="img-fluid" alt="">
							<div class="portfolio-info">
								<h4>Percorso 3</h4>

								<a href="./img/attrazione-1.jpg" title="Repairs 1"
									data-gallery="portfolio-gallery-repairs"
									class="glightbox preview-link"><i class="bi bi-zoom-in"></i></a>
								<a href="project-details.html" title="More Details"
									class="details-link"><i class="bi bi-link-45deg"></i></a>
							</div>
						</div>
					</div>
					<!-- End Projects Item -->

					<div class="col-lg-4 col-md-6 portfolio-item filter-design">
						<div class="portfolio-content h-100">
							<img src="./img/attrazione-1.jpg" class="img-fluid" alt="">
							<div class="portfolio-info">
								<h4>Design 1</h4>
								<p>Lorem ipsum, dolor sit amet consectetur</p>
								<a href="./img/attrazione-1.jpg" title="Repairs 1"
									data-gallery="portfolio-gallery-book"
									class="glightbox preview-link"><i class="bi bi-zoom-in"></i></a>
								<a href="project-details.html" title="More Details"
									class="details-link"><i class="bi bi-link-45deg"></i></a>
							</div>
						</div>
					</div>
					<!-- End Projects Item -->

					<div class="col-lg-4 col-md-6 portfolio-item filter-remodeling">
						<div class="portfolio-content h-100">
							<img src="./img/attrazione-1.jpg" class="img-fluid" alt="">
							<div class="portfolio-info">
								<h4>Remodeling 2</h4>

								<a href="./img/attrazione-1.jpg" title="Remodeling 2"
									data-gallery="portfolio-gallery-remodeling"
									class="glightbox preview-link"><i class="bi bi-zoom-in"></i></a>
								<a href="project-details.html" title="More Details"
									class="details-link"><i class="bi bi-link-45deg"></i></a>
							</div>
						</div>
					</div>
					<!-- End Projects Item -->

					<div class="col-lg-4 col-md-6 portfolio-item filter-construction">
						<div class="portfolio-content h-100">
							<img src="./img/attrazione-1.jpg" class="img-fluid" alt="">
							<div class="portfolio-info">
								<h4>Construction 2</h4>

								<a href="./img/attrazione-1.jpg" title="Construction 2"
									data-gallery="portfolio-gallery-construction"
									class="glightbox preview-link"><i class="bi bi-zoom-in"></i></a>
								<a href="project-details.html" title="More Details"
									class="details-link"><i class="bi bi-link-45deg"></i></a>
							</div>
						</div>
					</div>
					<!-- End Projects Item -->

					<div class="col-lg-4 col-md-6 portfolio-item filter-repairs">
						<div class="portfolio-content h-100">
							<img src="./img/attrazione-1.jpg" class="img-fluid" alt="">
							<div class="portfolio-info">
								<h4>Repairs 2</h4>

								<a href="./img/attrazione-1.jpg" title="Repairs 2"
									data-gallery="portfolio-gallery-repairs"
									class="glightbox preview-link"><i class="bi bi-zoom-in"></i></a>
								<a href="project-details.html" title="More Details"
									class="details-link"><i class="bi bi-link-45deg"></i></a>
							</div>
						</div>
					</div>
					<!-- End Projects Item -->

					<div class="col-lg-4 col-md-6 portfolio-item filter-design">
						<div class="portfolio-content h-100">
							<img src="./img/attrazione-1.jpg" class="img-fluid" alt="">
							<div class="portfolio-info">
								<h4>Design 2</h4>

								<a href="./img/attrazione-1.jpg" title="Repairs 2"
									data-gallery="portfolio-gallery-book"
									class="glightbox preview-link"><i class="bi bi-zoom-in"></i></a>
								<a href="project-details.html" title="More Details"
									class="details-link"><i class="bi bi-link-45deg"></i></a>
							</div>
						</div>
					</div>
					<!-- End Projects Item -->

					<div class="col-lg-4 col-md-6 portfolio-item filter-remodeling">
						<div class="portfolio-content h-100">
							<img src="./img/attrazione-1.jpg" class="img-fluid" alt="">
							<div class="portfolio-info">
								<h4>Remodeling 3</h4>
								> <a href="./img/attrazione-1.jpg" title="Remodeling 3"
									data-gallery="portfolio-gallery-remodeling"
									class="glightbox preview-link"><i class="bi bi-zoom-in"></i></a>
								<a href="project-details.html" title="More Details"
									class="details-link"><i class="bi bi-link-45deg"></i></a>
							</div>
						</div>
					</div>
					<!-- End Projects Item -->

					<div class="col-lg-4 col-md-6 portfolio-item filter-construction">
						<div class="portfolio-content h-100">
							<img src="./img/attrazione-1.jpg" class="img-fluid" alt="">
							<div class="portfolio-info">
								<h4>Construction 3</h4>

								<a href="./img/attrazione-1.jpg" title="Construction 3"
									data-gallery="portfolio-gallery-construction"
									class="glightbox preview-link"><i class="bi bi-zoom-in"></i></a>
								<a href="project-details.html" title="More Details"
									class="details-link"><i class="bi bi-link-45deg"></i></a>
							</div>
						</div>
					</div>
					<!-- End Projects Item -->

					<div class="col-lg-4 col-md-6 portfolio-item filter-repairs">
						<div class="portfolio-content h-100">
							<img src="./img/attrazione-1.jpg" class="img-fluid" alt="">
							<div class="portfolio-info">
								<h4>Repairs 3</h4>

								<a href="./img/attrazione-1.jpg" title="Repairs 2"
									data-gallery="portfolio-gallery-repairs"
									class="glightbox preview-link"><i class="bi bi-zoom-in"></i></a>
								<a href="project-details.html" title="More Details"
									class="details-link"><i class="bi bi-link-45deg"></i></a>
							</div>
						</div>
					</div>
					<!-- End Projects Item -->

					<div class="col-lg-4 col-md-6 portfolio-item filter-design">
						<div class="portfolio-content h-100">
							<img src="./img/attrazione-1.jpg" class="img-fluid" alt="">
							<div class="portfolio-info">
								<h4>Design 3</h4>

								<a href="./img/attrazione-1.jpg" title="Repairs 3"
									data-gallery="portfolio-gallery-book"
									class="glightbox preview-link"><i class="bi bi-zoom-in"></i></a>
								<a href="project-details.html" title="More Details"
									class="details-link"><i class="bi bi-link-45deg"></i></a>
							</div>
						</div>
					</div>
					<!-- End Projects Item -->

				</div>
				<!-- End Projects Container -->

			</div>

		</div>
	</section>
	<!-- End Our Projects Section -->

</main>
<!-- End #main -->

<!--End modal-->
<%@ include file="footer.jsp"%>
