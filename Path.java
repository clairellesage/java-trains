import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Path {
	
	private int stops;

	// there is a problem with when towns is empty, getting index is out of bounds error!
	public int getDistance(List<Town> towns) {
    	List<Town> townsClone = new ArrayList<Town>(towns);
    	towns.remove(towns.get(0));
    	Town first = townsClone.get(0);
    	Town second = townsClone.get(1);
    	List<Route> filteredRoutes = filterDests(first, second);

	    if (filteredRoutes.size() == 0) {
	    	return 0;
	    } else {
	    	// System.out.println(filteredRoutes.size());
	    	Route filteredRoute = filteredRoutes.get(0);
	    	System.out.println(filteredRoute.name);
	    	System.out.println(filteredRoute.distance);
	    	return 0;
	    	// return filteredRoute.distance + getDistance(towns);
	    }		// } else {
		// 	return filteredRoutes.distance;
		// }

	}

	private List<Route> filterDests(Town first, Town second) {
		return first.dests.stream().filter(outgoingRt -> outgoingRt.getDest().equals(second)).collect(Collectors.toList());
	}

	// The number of trips starting at C and ending at C with a maximum of 3 stops.  
	// In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).

	// public int numberOfTrips(Town origin, int stops) {
	// 	return routesToOrigin(origin, origin.dests, stops);	
	// }

	public int numberOfTrips(Town origin, Town destination, List<Route> outgoing, int remainingStops, int trips) {
		if (remainingStops == 1){
			return trips;
		} else {
			List<Route> successors = new ArrayList<Route>();

			for (Route rt : outgoing) {
				System.out.printf("\noutgoing route: %s", rt.name);
				for (Route dt : rt.dest.dests) {
					System.out.printf("\nSuccessors: %s", dt.name);
					successors.add(dt);
				}
			}

			trips = successors.stream()
				.filter(ogRoute -> ogRoute.dest.equals(destination))
				.collect(Collectors.toList()).size() + trips;

			System.out.printf("\ntrips : %s\n", trips);

			// successors.stream()
			// 	.filter(ogRoute -> ogRoute.dest.equals(destination))
			// 	.collect(Collectors.toList())
			// 	.forEach(t -> System.out.printf("trip %s\n", t.name));

			return numberOfTrips(origin, destination, successors, remainingStops - 1, trips);
			// return 0;
		}
	}

	public int exactNumberOfTrips(Town origin, Town destination, List<Route> outgoing, int remainingStops) {
			List<Route> successors = new ArrayList<Route>();

			for (Route rt : outgoing) {
				System.out.printf("\noutgoing route: %s", rt.name);
				for (Route dt : rt.dest.dests) {
					System.out.printf("\nSuccessors: %s", dt.name);
					successors.add(dt);
				}
			}

			if (remainingStops == 1){
				int trips = successors.stream()
					.filter(ogRoute -> ogRoute.dest.equals(destination))
					.collect(Collectors.toList()).size();
				System.out.printf("\ntrips : %s\n", trips);
				successors.stream()
					.filter(ogRoute -> ogRoute.dest.equals(destination))
					.collect(Collectors.toList())
					.forEach(t -> System.out.printf("trip %s\n", t.name));
				return trips;
			} else {


				return exactNumberOfTrips(origin, destination, successors, remainingStops - 1);
			// return 0;
		}
	}
}
