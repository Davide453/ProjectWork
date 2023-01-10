
<jsp:include page="header.jsp" />
<%@ page import="model.Percorso"%>
<%@ page import="model.AttrazioneNodo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.User"%>
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
				%>
				<%
				ArrayList<Percorso> percorso2;
				if (loggato != null && loggato == true) {

					percorso2 = (ArrayList<Percorso>) session.getAttribute("percorso");

					if (percorso2 != null && percorso2.size() > 0) {
						for (int i = 0; i < percorso2.size(); i++) {
				%>
				<div class="col-md-4 mt-4">
					<div class="card" style="margin: 40px">
						<div class="card-body" id="card-body-percorso">
							<h4 class="card-title mb-3"><%=percorso2.get(i).getNome()%></h4>
							<%
							for (AttrazioneNodo nodo : percorso2.get(i).getOrdineNodi()) {
							%>

							<ul>
								<li><%=nodo.getOrdine()%></li>
								<li><%=nodo.getNomeAttrazione()%></li>
								<li><%=nodo.getViaAttrazione()%></li>
							</ul>




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
