
<jsp:include page="header.jsp" />
<%@ page import="model.Percorso"%>
<%@ page import="model.AttrazioneNodo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="model.User"%>
<%@ page import="java.util.Random"%>


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
			<div class="row">



				<%
				Boolean loggato = (Boolean) session.getAttribute("loggato");
				Random r = new Random();

				if (loggato != null && loggato == true) {
					List<Percorso> percorso1 = new ArrayList<Percorso>();
					percorso1 = (ArrayList<Percorso>) request.getAttribute("percorso");

					if (percorso1 != null && percorso1.size() > 0) {
						for (int i = 0; i < percorso1.size(); i++) {

					Integer rInt = r.nextInt(15);
				%>
				<div class="col-md-4 mt-4">
					<div class="card border-0 shadow-sm">

						<img src="img/ImmagineItinerari
							<%=rInt.toString()%>.jpg"
							class="card-img-top" alt="Image">

						<div class="card-body" id="card-body-percorso">
							<h4 class="card-title mb-3">
								<i class="fa-regular fa-flag"></i>&nbsp;<%=percorso1.get(i).getOrdineNodi().get(0).getNomeAttrazione()%>

							</h4>
							<h4>
								<i class="fa-solid fa-flag-checkered"></i>
								<%=percorso1.get(i).getOrdineNodi().get(percorso1.get(i).getOrdineNodi().size() - 1).getNomeAttrazione()%>

							</h4>


							<%
							for (AttrazioneNodo nodo : percorso1.get(i).getOrdineNodi()) {
							%>


							<p>
								<i class="fa-solid fa-landmark">&nbsp;</i><%=nodo.getNomeAttrazione()%>
							</p>

							<p>
								<i class="fa-solid fa-location-dot">&nbsp;</i><%=nodo.getViaAttrazione()%></p>
							<hr>


							<%
							}
							%>
						</div>
					</div>
				</div>
				<%
				}
				} else {
				%>
				<h1>crea i tuoi percorsi</h1>
				<%
				}

				} else {
				%>
				<h1>Devi effettuare l'accesso per vedere questa pagina</h1>
				<%
				}
				%>
			</div>
		</div>


	</section>
	<!-- End Our Projects Section -->

</main>
<!-- End #main -->

<!--End modal-->
<%@ include file="footer.jsp"%>
