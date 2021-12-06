package algo.graph.shortestPath;

public class Vertex implements Comparable<Vertex> {

	public String name;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Edge[] adjancies;

	// track of previous node
	public Vertex previous;

	// constructor
	public Vertex(String argname) {
		name = argname;
	}

	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Vertex other) {
		// -1 or <0 if this < other
		// =0 if this= other
		// 1 or >0 if this > other
		return Double.compare(this.minDistance, other.minDistance);
	}
}
