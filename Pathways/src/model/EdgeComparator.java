package model;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge>{

	@Override
	public int compare(Edge o1, Edge o2) {
		if (o1.getPeso() < o2.getPeso()) return -1;
        if (o1.getPeso() > o2.getPeso()) return 1;
        return 0;
	}

}
