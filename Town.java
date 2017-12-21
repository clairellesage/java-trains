import java.util.List;
import java.util.ArrayList;

public class Town {
	
	public String name;
	public List<Route> origins = new ArrayList<Route>();
	public List<Route> dests = new ArrayList<Route>();
	public int distanceFromOrigin = 999999;

	public void addOriginRoute(Route r) {
		origins.add(r);
	}

	public void addDestRoute(Route r) {
		dests.add(r);
	}

	public Town(String name) {
		this.name = name;
	}

	public String getName() {
	    return name;
	}

	public void setDistanceFromOrigin(int distanceFromOrigin){
		this.distanceFromOrigin = distanceFromOrigin;
	}

	public int getDistanceFromOrigin(){
		return distanceFromOrigin;
	}

} 