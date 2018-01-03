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

	// public boolean equals(Object obj) {
	// 	if (obj instanceof Town){
	// 	    return true;
	// 	}
	// 	return false;
	// }

	public boolean equals(Object object2) {
	    if (name.equals(((Town)object2).name)){
	    	return true;
	    }
	    return false;
	}

	public int hashcode(){
		return this.name.hashCode();
	}

	public String getName() {
	    return name;
	}

	public List<Route> getDests(){
		return this.dests;
	}

	public void setDistanceFromOrigin(int distanceFromOrigin){
		this.distanceFromOrigin = distanceFromOrigin;
	}

	public int getDistanceFromOrigin(){
		return distanceFromOrigin;
	}

} 