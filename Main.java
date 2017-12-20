import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args){
		try {
			//add Towns and Routes
			//e.g. for Graph point AB5
			Town a = new Town("A");
			Town b = new Town("B");
			Route ab = new Route("AB", a, b, 5);
			a.addDestRoute(ab);
			b.addOriginRoute(ab);

			Town c = new Town("C");
			Route bc = new Route("BC", b, c, 4);
			b.addDestRoute(bc);
			c.addOriginRoute(bc);

			Town d = new Town("D");
			Route cd = new Route("CD", c, d, 8);
			c.addDestRoute(cd);
			d.addOriginRoute(cd);

			Route dc = new Route("DC", d, c, 8);
			d.addDestRoute(dc);
			c.addOriginRoute(dc);

			Town e = new Town("E");
			Route de = new Route("DE", d, e, 6);
			d.addDestRoute(de);
			e.addOriginRoute(de);

			Route ad = new Route("AD", a, d, 5);
			a.addDestRoute(ad);
			d.addOriginRoute(ad);

			Route ce = new Route("CE", c, e, 2);
			c.addDestRoute(ce);
			e.addOriginRoute(ce);

			Route eb = new Route("EB", e, b, 3);
			e.addDestRoute(eb);
			b.addOriginRoute(eb);

			Route ae = new Route("AE", a, e, 7);
			a.addDestRoute(ae);
			e.addOriginRoute(ae);

			// questions 1-5
			// addAll method?
			Path p1 = new Path();
			List<Town> abc = new ArrayList<Town>();
			abc.add(a);
			abc.add(b);
			abc.add(c);
			// System.out.println(p1.getDistance(abc));

			// The number of trips starting at C and ending at C with a maximum of 3 stops.  
			// In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).

			Path p2 = new Path();
			System.out.printf("\nNumber of trips: %s", p2.numberOfTrips(c, 4));



		} catch (Exception e) {
			System.out.println(e);
		}
	}
}