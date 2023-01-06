// Note: This example requires that you consent to location sharing when
// prompted by your browser. If you see the error "The Geolocation service
// failed.", it means you probably did not give permission for the browser to
// locate you.
let map, infoWindow, posizioneAttuale;
let tuttiMarker = [];
let percorso = [];
let myJsonString;

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

					// PERSONALIZZAZIONE MARKER AVANZATO
					const pinViewBackground = new google.maps.marker.PinView({
						background: '#6899C7',
						borderColor: '#5D89B3',
						glyphColor: '#415F7D',
						scale: 1.2,
					});

					// AGGIUNTA MARKER AVANZATO CON PERSONALIZZAZIONE COLORI
					let markerPosizione = new google.maps.marker.AdvancedMarkerView({
						position: pos,
						content: pinViewBackground.element,
						map,
					});

					let posizioneAttuale = {
						"geometry": { "location": { "lat": pos.lat, "lng": pos.lng } },
						"place_id": "posizioneAttuale",
						"name": "posizioneAttuale",
						"vicinity": "placeholder" // va fatta la geocodifica
					};

					percorso.push(posizioneAttuale);

					//aggiungere geocodifica di google per convertire coordinate in via per la propria posizione

					let divPercorso = document.getElementById("percorso");
					let row = document.createElement("div");
					let label = document.createElement("label");
					label.innerText = nome;
					row.className = "row mt-3 px-4";
					row.appendChild(label);

					//console.log(percorso);
					divPercorso.appendChild(row);

					infoWindow = new google.maps.InfoWindow();
					infoWindow.setPosition(pos);
					infoWindow.setContent("La tua posizione");
					infoWindow.open({
						shouldFocus: false,
						anchor: markerPosizione,
						map,
						title: nome,
					});

					nearbySearch(pos);

					map.setCenter(pos);

					markerPosizione.addListener("click", () => {
						infoWindow.open({
							position: pos,
							anchor: markerPosizione,
							title: nome,
							map,
						});
					});

					google.maps.event.addListener(map, "click", function (event) {
						infoWindow.close();
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

	//Funzione che stampa sulla console la posizione del marker (Uso window. perché devo dichiararlo come variabile globale)

	window.addNodo = function (nodoID) {

		for (let i = 0; i < tuttiMarker.length; i++) {
			//console.log(tuttiMarker[i].place_id);
			//console.log(nodoID);
			if (tuttiMarker[i].place_id == nodoID) {

				percorso.push(tuttiMarker[i]);
				let divPercorso = document.getElementById("percorso");
				let row = document.createElement("div");
				let label = document.createElement("label");
				label.innerText = tuttiMarker[i].name;
				row.className = "row mt-3 px-4";
				row.appendChild(label);


				divPercorso.appendChild(row);
			}
		}

	}

	currentLocationButton();

}

// FUNZIONE PER GESTIRE L'ERRORE DI GEOLOCALIZZAZIONE
function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	infoWindow.setPosition(pos);
	infoWindow.setContent(
		browserHasGeolocation
			? "Errore: Il servizio di geolocazione è fallito."
			: "Errore: Il tuo browser non supporta la geolocalizzazione."
	);
	infoWindow.open(map);
}


// FUNZIONE PER RICERCARE NEI DINTORNI DI RAGGIO "radius" GLI PLACES DI TIPO "type"
function nearbySearch(pos) {
	// GOOGLE PLACES API

	let posizioneAttuale = new google.maps.LatLng(pos.lat, pos.lng); //VARIABILE PER TENERE TRACCIA DELLA POSIZIONE LAT E LNG

	// VARIABILE RICHIESTA
	let request = {
		location: posizioneAttuale,
		radius: '5000',
		type: ['tourist_attraction'],
		fields: ['formatted_address', 'geometry', 'place_id']
	};

	// RICHIESTA DI SERVIZIO NEARBYSEARCH
	let service = new google.maps.places.PlacesService(map);
	service.nearbySearch(request, callback);

	// FUNZIONE PER CONTROLLARE SE IL SERVIZIO E' AGIBILE
	function callback(results, status) {
		if (status == google.maps.places.PlacesServiceStatus.OK) {
			for (let i = 0; i < results.length; i++) {


				creaMarker(results[i]);
				//console.log(results[i].place_id);
			}
		}
	}
}

// FUNZIONE CREA MARKER CHE PRENDE COME PARAMETRO D'INPUT UN NODO
function creaMarker(nodo) {

	tuttiMarker.push(nodo); // AGGIUNGE ALL'ARRAY tuttiMarker IL nodo PRESO DA INPUT

	let markerAttrazione = new google.maps.Marker({
		position: nodo.geometry.location,
		map,
		title: nodo.name,
	})

	//console.log(tuttiMarker);
	//console.log(nodo.place_id);

	const contentString =
		'<div id="content">' +
		'<div id="siteNotice">' +
		"</div>" +
		'<h1 id="firstHeading" class="firstHeading">' + nodo.name + '</h1>' +
		'<div id="bodyContent">' +
		'<p>lorem ipsum dolores </p>' +
		//bottone info marker

		`<button type="button" class="btn btn-primary" onclick="addNodo('${nodo.place_id}')">Aggiungi al tuo percorso</button>` //Richiamo la funzione getMarkerPosition
		+

		"</div>" +
		"</div>";


	const infoWindow_attrazioni = new google.maps.InfoWindow({
		content: contentString,
		ariaLabel: nodo.name,
	});

	markerAttrazione.addListener("click", () => {
		infoWindow_attrazioni.open({
			position: nodo.geometry.location,
			anchor: markerAttrazione,
			map,
		});
	});

	google.maps.event.addListener(map, "click", function (event) {
		infoWindow_attrazioni.close();
	});
}

// FUNZIONE CREA BOTTONE CHE OTTIENE LA POSIZIONE ATTUALE DELL'UTENTE
function currentLocationButton() {

	const locationButton = document.createElement("button");

	locationButton.textContent = "La tua posizione";
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

					infoWindow.setPosition(pos);
					infoWindow.open(map);
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
	});
}


// INVIAMO IL FILE JSON DEI NOSTRI PERCORSI SULLA SERVLET DI JAVA IN MODO TALE DA CALCOLARE L'ALGORITMO DI DIJKSTRA
$(document).ready(function () {

	$('#getPercorso').submit(function () {
		myJsonString = JSON.stringify(percorso);
		//console.log(myJsonString);
		$.ajax({

			url: 'update', // URL DELLA SERVLET
			type: 'POST', // TIPO POST
			dataType: 'json', // TIPO DEI DATI CHE TORNANO
			contentType: 'application/json', // SETTA IL TIPO DI CONTENT A 'application/json'
			data: myJsonString, // I DATI DA INVIARE
		});

		return false;
	});
});


window.initMap = initMap;
























































	// ================================================================================================================================================================
/* CODICE VECCHIO NON UTILIZZATO | UTILE COME NOTE PER IL FUTURO */
	// ================================================================================================================================================================


	// ==========================================================================================================
/* RECUPERARE LE ATTRAZIONI DA FILE JSON */
	// ==========================================================================================================

/*
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
}*/

/*// Eseguiamo il fetch
fetch('./json/Attrazioni.json')
	.then((response) => response.json())
	.then((json) => {
		marker = json.attrazioni;
		//console.log(marker);

		for (let i = 0; i < marker.length; i++) {
			//console.log(marker[i]);
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
	//console.log(data);
});*/
