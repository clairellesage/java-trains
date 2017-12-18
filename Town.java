import java.util.List;
import java.util.ArrayList;

public class Town {
	
	public String name;
	public List<Route> origins = new ArrayList<Route>();
	public List<Route> dests = new ArrayList<Route>();

	public void addOriginRoute(Route r) {
		origins.add(r);
	}

	public void addDestRoute(Route r) {
		dests.add(r);
	}

	public Town(String name) {
		this.name = name;
	}
} 