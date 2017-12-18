import java.util.ArrayList;
import java.util.List;
public class Path {
	
	// public List<Town> towns = new ArrayList<Town>();
	public Town origin;
	// public ArrayList<Route> routes = new ArrayList<Town>();

	public void getDistance(Town[] towns) {
		int distanceSum = 0;

		for (Town town : towns) {
			System.out.printf("\ntown: %s", town.name);
			for (Route rt : town.dests) {
				// System.out.printf("\ntown: %s", town.dests.size());
				if (town.dests.size() > 1) {
					// System.out.printf("\ndests: %s", rt.name);
					for (Route r2 : town.dests) {
						System.out.printf("\nr2 name: %s", r2.name);
					}
				} else {
					distanceSum += rt.distance;
				}
			}
			// for (Town ot : origin) {
			// 	System.out.printf("\norigisn: %s", ot.name);
			// }
		}
		// for (Town town : towns) {
		// 	System.out.printf("\ntown: %s", town.name);
		// 	for (Route rt : town.origins) {
		// 		if (rt.origin == origin) {
		// 			System.out.printf("\nroute: %s, origin: %s, distance: %s", rt.name, rt.origin.name, rt.distance);
		// 			distanceSum += rt.distance;
		// 		}
		// 	}
		// 	for (Route rt2 : town.dests) {
		// 		System.out.printf("\n")
		// 		if (rt2.dest == town) {
		// 			System.out.printf("\nrt2name %s, rt2destname %s, towns %s, distance %s", rt2.name, rt2.dest.name, town.name, rt2.distance);
		// 			distanceSum += rt2.distance;
		// 		}
				// System.out.printf("\ndests %s", rt2.dest.name)

		if (distanceSum != 0) {
			System.out.printf("\ndistanceSum: %s", distanceSum);
		} else {
			System.out.printf("\nNO SUCH ROUTE");
		}
	}

	public Path(Town t) {
		origin = t;
	}
}