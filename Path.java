import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Path {
	
	private int stops;

	public int getDistance(List<Town> towns) {
	    List<Town> townsClone = new ArrayList<Town>(towns);
	    towns.remove(towns.get(0));
	    Town first = townsClone.get(0);
	    Town second = townsClone.get(1);
	    List<Route> filteredRoutes = filterDests(first, second);

	    if (towns.size() == 0) {
	    	return 0;
	    } else {
	    	// System.out.println(filteredRoutes.size());
	    	Route filteredRoute = filteredRoutes.get(0);
	    	System.out.println(filteredRoute.name);
	    	System.out.println(filteredRoute.distance);
	    	return filteredRoute.distance + getDistance(towns);
	    }
	}

	private List<Route> filterDests(Town first, Town second) {
		return first.dests.stream().filter(outgoingRt -> outgoingRt.getDest().equals(second)).collect(Collectors.toList());
	}

	// The number of trips starting at C and ending at C with a maximum of 3 stops.  
	// In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).

	// public int numberOfTrips(Town origin, int stops) {
	// 	return routesToOrigin(origin, origin.dests, stops);	
	// }

	// public int routesToOrigin(Town origin, List<Route> outgoing, int remainingStops) {
	// 	if (remainingStops == 0){
	// 		return 0;
	// 	} else {
	// 		List<Route> outgoingRoutes = outgoing.getDest().filter(dest -> dest.equals(origin))
	// 		List<Route> successors = outgoingRoutes.dests.forEach(town -> town.getDest());
	// 		return outgoingRoutes.size() + routesToOrigin(origin, successors, remainingStops - 1);
	// }
}
