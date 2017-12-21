import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.function.*;
import java.util.stream.*;

public class Path {
	
	private int stops;

	public int getDistance(List<Town> towns) {
		towns.forEach(t -> System.out.println(t.name));
	    if (towns.size() < 2) {
	    	return 0;
	    } else {
	    	Town first = towns.get(0);
	    	towns.remove(first);
	    	Town second = towns.get(0);
	    	System.out.printf("\nfirst and second: %s %s", first.name, second.name);
	    	List<Route> filteredRoutes = filterDests(first, second);
	    	System.out.printf("\nfiltered rt size %s", filteredRoutes.size());
	    	if (filteredRoutes.size() > 0) {
	    		Route filteredRoute = filteredRoutes.get(0);
	    		System.out.printf("\nilteredRoute %s", filteredRoute.name);
	    		System.out.printf("\ndist %s", filteredRoute.distance);
	    		return filteredRoute.distance + getDistance(towns);
	    	} else {
	    		return 0;
	    	}
	    }
	}

	private List<Route> filterDests(Town first, Town second) {
		first.dests.forEach(drt -> System.out.printf("\ndest route %s", drt.name));
		return first.dests.stream().filter(outgoingRt -> outgoingRt.getDest().equals(second)).collect(Collectors.toList());
	}

	public int numberOfTrips(Town origin, Town destination, List<Route> outgoing, int remainingStops, int trips) {
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

			return numberOfTrips(origin, destination, successors, remainingStops - 1, trips);
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

		List<Route> outgoing = origin.dests;
		Route shortestRoute = new Route("shortestRoute", origin, origin, 0);
		List<Town> untravelledTowns = new ArrayList<Town>();
		List<Town> travelledTowns = new ArrayList<Town>();

		untravelledTowns.add(origin);
		origin.setDistanceFromOrigin(0);
		
		while(untravelledTowns.size() > 0) {
			Town evaluationTown = getNodeWithLowestDistance(untravelledTowns);
			untravelledTowns.remove(evaluationTown);
			travelledTowns.add(evaluationTown);
			evaluatedNeighbors(evaluationTown, untravelledTowns, travelledTowns);
		}
		return destination.getDistanceFromOrigin();
	}

	private Town getNodeWithLowestDistance(List<Town> untravelledTowns){
		Town smallestDistanceFromOrigin = untravelledTowns.get(0);
		for (Town ft : untravelledTowns){
			if (ft.getDistanceFromOrigin() < smallestDistanceFromOrigin.getDistanceFromOrigin()){
				smallestDistanceFromOrigin = ft;
			}
		}
		return smallestDistanceFromOrigin;
	}

	private void evaluatedNeighbors(Town evaluationTown, List<Town> untravelledTowns, List<Town> travelledTowns){
		for (Route rt : evaluationTown.dests) {
			if (!travelledTowns.contains(rt.dest)) {
				int routeDistance = rt.distance;
				int newDistance = evaluationTown.getDistanceFromOrigin() + routeDistance;
				if (rt.dest.getDistanceFromOrigin() > newDistance){
					rt.dest.setDistanceFromOrigin(newDistance);
					untravelledTowns.add(rt.dest);
				}
			}	
		}
	}
}
