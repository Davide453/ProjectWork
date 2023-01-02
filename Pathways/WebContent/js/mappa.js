// Note: This example requires that you consent to location sharing when
// prompted by your browser. If you see the error "The Geolocation service
// failed.", it means you probably did not give permission for the browser to
// locate you.
let map, infoWindow;
let percorso = [];
function initMap() {
	// The location of start

	const start = { lat: 45.477781673393366, lng: 9.186916132921075 };
	// The map, centered at start
	map = new google.maps.Map(document.getElementById("map"), {
		mapTypeControl: false,
		zoom: 12,
		center: start,
		zoomControl: true,
		zoomControlOptions: {
			position: google.maps.ControlPosition.LEFT_CENTER,
		},
		streetViewControl: true,
		streetViewControlOptions: {
			position: google.maps.ControlPosition.LEFT_TOP,
		},
		mapId: "ecdb3dce61875a18",
	});
	

	// ==========================================================================================================
	/* BOTTONE PER TROVARE LA TUA POSIZIONE */
	// ==========================================================================================================
	/*
	const locationButton = document.createElement("button");

	locationButton.textContent = "Trova la tua posizione";
	locationButton.classList.add("custom-map-control-button");
	map.controls[google.maps.ControlPosition.TOP_CENTER].push(locationButton);
	locationButton.addEventListener("click", () => {
		// Try HTML5 geolocation.
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(
				(position) => {
					const pos = {
						lat: position.coords.latitude,
						lng: position.coords.longitude,
					};

					let markerPosizione = new google.maps.Marker({
						position: pos,
						map,
					});

					infoWindow = new google.maps.InfoWindow();
					infoWindow.setPosition(pos);
					infoWindow.setContent("Posizione trovata");
					infoWindow.open({
						shouldFocus: false,
						anchor: markerPosizione,
						map,
					});
					map.setCenter(pos);
				},
				() => {
					handleLocationError(true, infoWindow, map.getCenter());
				}
			);
		} else {
			// Browser doesn't support Geolocation
			handleLocationError(false, infoWindow, map.getCenter());
		}
	}); */


	// ==========================================================================================================
	/* TROVA LA TUA POSIZIONE AL CARICAMENTO DELLA PAGINA */
	// ==========================================================================================================
	addEventListener("load", () => {
		// Try HTML5 geolocation.
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(
				(position) => {
					const pos = {
						lat: position.coords.latitude,
						lng: position.coords.longitude,
					};

					let nome = "La tua posizione";
					let markerPosizione = new google.maps.Marker({
						position: pos,
						map,
					});

					infoWindow = new google.maps.InfoWindow();
					infoWindow.setPosition(pos);
					infoWindow.setContent("La tua posizione");
					infoWindow.open({
						shouldFocus: false,
						anchor: markerPosizione,
						map,
						title: nome,
					});
					
					map.setCenter(pos);

					markerPosizione.addListener("click", () => {
						infoWindow.open({
							position: pos,
							anchor: markerPosizione,
							title: nome,
							map,
						});
					});
				},
				() => {
					handleLocationError(true, infoWindow, map.getCenter());
				}
			);
		} else {
			// Browser doesn't support Geolocation
			handleLocationError(false, infoWindow, map.getCenter());
		}
	});


	// ==========================================================================================================
	/* RECUPERARE LE ATTRAZIONI DA FILE JSON */
	// ==========================================================================================================

	let marker;

	function useMarkerData(callback) {
		if (marker) {
			// Se markerData è già stato assegnato, eseguiamo la callback
			callback(marker);
		} else {
			// Altrimenti, impostiamo un timer per controllare periodicamente se markerData è stato assegnato
			const intervalId = setInterval(() => {
				if (marker) {
					// Se markerData è stato assegnato, eseguiamo la callback e cancelliamo il timer
					callback(marker);
					clearInterval(intervalId);
				}
			}, 100);
		}
	}

	//Funzione che stampa sulla console la posizione del marker (Uso window. perché devo dichiararlo come variabile globale)

	window.addNodo = function(counter) {

		console.log(marker[counter]);
		percorso.push(marker[counter]); //aggiunge il marker selezionato a percorso[]

		let divPercorso = document.getElementById("percorso");
		let row = document.createElement("div");
		let label = document.createElement("label");
		label.innerText = marker[counter].nome;
		row.className = "row mt-3 px-4";
		row.appendChild(label);

		console.log(percorso);
		divPercorso.appendChild(row);

	}

	// Eseguiamo il fetch
	fetch('./json/Attrazioni.json')
		.then((response) => response.json())
		.then((json) => {
			marker = json.attrazioni;
			console.log(marker);

			for (let i = 0; i < marker.length; i++) {
				console.log(marker[i]);
				let posizione = { lat: marker[i].latitudine, lng: marker[i].longitudine };
				let nome = marker[i].nome;
				let markerAttrazione = new google.maps.Marker({
					position: posizione,
					map,
					title: nome,
				});

				const contentString =
					'<div id="content">' +
					'<div id="siteNotice">' +
					"</div>" +
					'<h1 id="firstHeading" class="firstHeading">' + nome + '</h1>' +
					'<div id="bodyContent">' +
					'<p>lorem ipsum dolores </p>' +
					//bottone info marker

					`<button type="button" class="btn btn-primary" onclick="addNodo(${marker[i].id})">Aggiungi al tuo percorso</button>` //Richiamo la funzione getMarkerPosition
					+

					"</div>" +
					"</div>";

				const infowindow = new google.maps.InfoWindow({
					content: contentString,
					ariaLabel: nome,
				});


				markerAttrazione.addListener("click", () => {
					infowindow.open({
						position: posizione,
						anchor: markerAttrazione,
						map,
					});
				});



			}


		});

	// Usiamo useMarkerData per accedere a markerData in modo sicuro
	useMarkerData((data) => {
		console.log(data);
	});


}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	infoWindow.setPosition(pos);
	infoWindow.setContent(
		browserHasGeolocation
			? "Errore: Il servizio di geolocazione è fallito."
			: "Errore: Il tuo browser non supporta la geolocalizzazione."
	);
	infoWindow.open(map);
}


window.initMap = initMap;