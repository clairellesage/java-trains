public class Route {

	public String name;
	public Town origin;
	public Town dest;
	public int distance;

	public Route(String name, Town origin, Town dest, int distance) {
		this.name = name;
		this.origin = origin;
		this.dest = dest;
		this.distance = distance;
	}

	public String getName() {
	    return name;
	}
	
	public Town getDest() {
	    return dest;
	}

	public Town getOrigin() {
	    return origin;
	}

	public int getDistance() {
		return distance;
	}
}