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
}