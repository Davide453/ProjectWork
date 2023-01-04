package model;

public class testDijkstra {

	class Node {
		double latitude;
		double longitude;
		// altri attributi e metodi...

		double distanceTo(Node other) {
			double lat1 = Math.toRadians(latitude);
			double lon1 = Math.toRadians(longitude);
			double lat2 = Math.toRadians(other.latitude);
			double lon2 = Math.toRadians(other.longitude);

			double dlon = lon2 - lon1;
			double dlat = lat2 - lat1;

			double a = Math.pow(Math.sin(dlat / 2), 2)
					+ Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

			double R = 6371; // raggio della Terra in chilometri

			return R * c;
		}
	}

}
