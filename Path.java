import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Path {
	
	private int stops;

	// public int getDistance(List<Town> towns) {
	//     if (towns.size() != 0) {
	//     	List<Town> townsClone = new ArrayList<Town>(towns);
	//     	towns.remove(towns.get(0));
	//     	Town first = townsClone.get(0);
	//     	Town second = townsClone.get(1);
	//     	List<Route> filteredRoutes = filterDests(first, second);

	// 	    if (filteredRoutes.size() == 0) {
	// 	    	return 0;
	// 	    } else {
	// 	    	// System.out.println(filteredRoutes.size());
	// 	    	Route filteredRoute = filteredRoutes.get(0);
	// 	    	System.out.println(filteredRoute.name);
	// 	    	System.out.println(filteredRoute.distance);
	// 	    	return filteredRoute.distance + getDistance(towns);
	// 	    }
	// 	} else {

	// 	}
	// }

	// private List<Route> filterDests(Town first, Town second) {
	// 	return first.dests.stream().filter(outgoingRt -> outgoingRt.getDest().equals(second)).collect(Collectors.toList());
	// }

	// The number of trips starting at C and ending at C with a maximum of 3 stops.  
	// In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).

	public int numberOfTrips(Town origin, int stops) {
		// System.out.println(origin.origins.get(0).name);
		// System.out.println(origin.origins.get(1).name);
		// return 0;
		return routesToOrigin(origin, origin.dests, stops);	
	}

	// C, DC, BC
	public int routesToOrigin(Town origin, List<Route> outgoing, int remainingStops) {
		// return 0;
		if (remainingStops == 0){
			return 0;
		} else {
			System.out.printf("\n%s's outgoing routes: \n %s \n %s", outgoing, outgoing.get(0).name, outgoing.get(1).name);
			// List<Route> outgoingRoutes = outgoing.stream().filter(dest -> dest.equals(origin)).collect(Collectors.toList());
			// System.out.printf("\notr:", otr);
			// List<Route> outgoingRoutes = outgoing.getDest().filter(dest -> dest.equals(origin));
			
			// outgoingRoutes = [CD , CE];
			//for each of these, get the destination (D, E)
			// 		for D, its dests are DC and DE
			// 		for E, its dests are just EB

			// is this a list of list of routes?
			List<Route> successors = outgoing.forEach(rt -> System.out.println(rt.dest.dests));
			return successors.size() + routesToOrigin(origin, successors, remainingStops - 1);
		}
	}
}
