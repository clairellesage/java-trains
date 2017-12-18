import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
public class Path {
	
	// public List<Town> towns = new ArrayList<Town>();
	public Town origin;
	// public ArrayList<Route> routes = new ArrayList<Town>();

	public void getDistance(List<Town> towns) {
		int distanceSum = 0;

		for (Town town : towns) {

		}
		
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

// List<Person> beerDrinkers = persons.stream()
//     .filter(p -> p.getAge() > 16).collect(Collectors.toList());