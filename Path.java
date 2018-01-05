import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.function.*;
import java.util.stream.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Path {

	private List<Route> pathRoutes = new ArrayList<Route>();
	private static HashSet<Path> allPaths = new HashSet<Path>();

	public int length(){
		int totalDistance = 0;
		for (Route rt : pathRoutes){
			totalDistance += rt.getDistance();
		}
		return totalDistance;
	}

	public String name(){
		String pathName = "";
		if (pathRoutes.size() > 0) {
			pathName = pathRoutes.get(0).getOrigin().getName();
			for (Route pth : pathRoutes) {
				pathName += pth.getDest().getName();
			}
		}
		return pathName;
	}

	public void initializeRoutes(List<Route> rts){
		List<Route> newList = new ArrayList<Route>();
		for (Route rt : rts){
			newList.add(rt);
		}
		this.setRoutes(newList);
	}

	public void setRoutes(List<Route> rts){
		pathRoutes = rts;
	}

	public List<Route> getRoutes(){
		return this.pathRoutes;
	}

	public Town getFinalDest(){
		return pathRoutes.get(pathRoutes.size() - 1).dest;
	}

	public void addRoute(Route rt){
		pathRoutes.add(rt);
	}


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
			int routeDistance = rt.distance;
			int newDistance = evaluationTown.getDistanceFromOrigin() + routeDistance;
			if (newDistance < rt.dest.getDistanceFromOrigin()){
				rt.dest.setDistanceFromOrigin(newDistance);
				untravelledTowns.add(rt.dest);
			} else if (rt.dest.getDistanceFromOrigin() < 1) {
				rt.dest.setDistanceFromOrigin(newDistance);
			}	
		}
	}

	private boolean originMatchesDest(Town origin){
		return this.getFinalDest().equals(origin);
	}

	public int numberOfTripsLessThanN(Town origin, Town destination, int maxDistance){	
		for (Route rt : origin.getDests()){
			Path newPath = new Path();
			newPath.initializeRoutes(this.getRoutes());
			newPath.addRoute(rt);
			if (newPath.length() < maxDistance && newPath.originMatchesDest(newPath.getRoutes().get(0).origin)){
				allPaths.add(newPath);
			}
			if (newPath.length() < maxDistance){
				newPath.numberOfTripsLessThanN(rt.dest, destination, maxDistance);
			} 
		}
		return allPaths.size();
	}
}