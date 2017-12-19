import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Path {
	
	// public List<Town> towns = new ArrayList<Town>();
	public Town origin;
	// public ArrayList<Route> routes = new ArrayList<Town>();

	public void getDistance(List<Town> towns) {
		int distanceSum = 0;
		for (Town town : towns) {
			System.out.printf("\nname: %s ", town.name);
			// town.dests.forEach(rt -> rt.forEach(orig -> orig.equals(town)
				// System.out.printf("\ndest routes: %s", rt.name));
				// rt.dest.filter(dtown -> System.out.printf(dtown.name)));
				// (System.out.printf("\ndest routes: %s", r.name));
		}
		
		List validTowns = towns.stream()
			.filter(town -> town.dests.forEach(dest -> dest.origin.equals(town).toList()));
			// ) == origin).forEach(e -> e.dests.forEach(d -> System.out.printf("\ndests: %s", d.name)));
		
		// if (distanceSum != 0) {
		// 	System.out.printf("\ndistanceSum: %s", distanceSum);
		// } else {
		// 	System.out.printf("\nNO SUCH ROUTE");
		// }
	}

	public Path(Town t) {
		origin = t;
	}
}