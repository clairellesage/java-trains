import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.function.*;
import java.util.stream.*;

public class Path {
	
	private int stops;

	public int getDistance(List<Town> towns, int pathDistance) {
	    if (towns.size() < 2) {
	    	return pathDistance;
	    } else {
	    	Town first = towns.get(0);
	    	towns.remove(first);
	    	Town second = towns.get(0);
	    	List<Route> filteredRoutes = filterDests(first, second);
	    	if (filteredRoutes.size() > 0) {
	    		Route filteredRoute = filteredRoutes.get(0);
	    		return getDistance(towns, pathDistance + filteredRoute.distance);
	    	} else {
	    		return 0;
	    	}
	    }
	}

	private List<Route> filterDests(Town first, Town second) {
		return first.dests.stream().filter(outgoingRt -> outgoingRt.getDest().equals(second)).collect(Collectors.toList());
	}

	public int numberOfTrips(Town origin, Town destination, int remainingStops, int trips) {
		List <Route> outgoing = origin.dests;
		if (remainingStops == 1){
			return trips;
		} else {
			List<Route> successors = new ArrayList<Route>();

			for (Route rt : outgoing) {
				for (Route dt : rt.dest.dests) {
					successors.add(dt);
				}
			}

			trips = successors.stream()
				.filter(ogRoute -> ogRoute.dest.equals(destination))
				.collect(Collectors.toList()).size() + trips;

			return numberOfTrips(origin, destination, remainingStops - 1, trips);
		}
	}

	public int exactNumberOfTrips(Town origin, Town destination, List<Route> outgoing, int remainingStops) {
			List<Route> successors = new ArrayList<Route>();

			for (Route rt : outgoing) {
				for (Route dt : rt.dest.dests) {
					successors.add(dt);
				}
			}

			if (remainingStops == 1){
				int trips = successors.stream()
					.filter(ogRoute -> ogRoute.dest.equals(destination))
					.collect(Collectors.toList()).size();
				successors.stream()
					.filter(ogRoute -> ogRoute.dest.equals(destination))
					.collect(Collectors.toList());
				return trips;
			} else {
				return exactNumberOfTrips(origin, destination, successors, remainingStops - 1);
			}
	}

	public int getShortestDistance(Town origin, Town destination) {

		List<Town> untravelledTowns = new ArrayList<Town>();
		List<Town> travelledTowns = new ArrayList<Town>();

		// add first town to untravelled towns
		untravelledTowns.add(origin);
		origin.setDistanceFromOrigin(0);
		
		while(untravelledTowns.size() > 0) {
			Town evaluationTown = getNodeWithLowestDistance(untravelledTowns);
			System.out.printf("\nevaluationTown: %s", evaluationTown.name);
			untravelledTowns.remove(evaluationTown);
			travelledTowns.add(evaluationTown);
			evaluatedNeighbors(evaluationTown, untravelledTowns, travelledTowns);
		}
		System.out.printf("\nreached end of loop");
		return destination.getDistanceFromOrigin();
	}

	private Town getNodeWithLowestDistance(List<Town> untravelledTowns){
		Town smallestDistanceFromOrigin = untravelledTowns.get(0);
		for (Town ft : untravelledTowns){
			if (ft.getDistanceFromOrigin() < smallestDistanceFromOrigin.getDistanceFromOrigin()){
				smallestDistanceFromOrigin = ft;
			}
		}
		System.out.printf("\nsmallestDistanceFromOrigin: %s", smallestDistanceFromOrigin.name);
		return smallestDistanceFromOrigin;
	}

	private void evaluatedNeighbors(Town evaluationTown, List<Town> untravelledTowns, List<Town> travelledTowns){
		for (Route rt : evaluationTown.dests) {
			System.out.printf("\nroute in evalTown dests: %s", rt.name);
			// if (!travelledTowns.contains(rt.dest)) {
				int routeDistance = rt.distance;
				int newDistance = evaluationTown.getDistanceFromOrigin() + routeDistance;
				System.out.printf("\nrouteDistance: %s\nnewDistance: %s", routeDistance, newDistance);
				if (newDistance < rt.dest.getDistanceFromOrigin()){
					rt.dest.setDistanceFromOrigin(newDistance);
					untravelledTowns.add(rt.dest);
					System.out.printf("\nadded %s to untravelledTowns", rt.dest.name);
				} else if (rt.dest.getDistanceFromOrigin() < 1) {
					rt.dest.setDistanceFromOrigin(newDistance);
					System.out.printf("\nrt.dest is < 1 : %s", rt.dest.getDistanceFromOrigin());
				}
			// }	
		}
	}
	// public int numberOfTripsLessThanN(Town origin, Town destination, int maxDistance){	
	// 	int tripsTotalDistance = 0;
	// 	// this needs to be an array of arrays
	// 	List<Route> allRoutes = new ArrayList<Route>();
	// 	// I want to be storing Routes + a running totalDistance for each path

	// 	while (tripsTotalDistance < maxDistance){
	// 		// loop through origin's routes
	// 		for (Route rt : origin.dests){
	// 			List<Route> routesList = new ArrayList<Route>();
	// 			System.out.printf("\noutgoing route: %s", rt.name);
	// 			tripsTotalDistance += rt.getDistance();
	// 			System.out.printf("\n%s's distance: %s", rt.name, rt.getDistance());
	// 			System.out.printf("\nnew total distance: %s", tripsTotalDistance);
	// 			routesList.add(rt);
	// 			allRoutes.add(routesList);
	// 		}
			
	// 	}
	// 	return tripsTotalDistance;
	// }
}
