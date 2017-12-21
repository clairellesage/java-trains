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
			Path p1 = new Path();
			List<Town> listABC = new ArrayList<Town>();
			listABC.add(a);
			listABC.add(b);
			listABC.add(c);
			System.out.printf("\nOutput #1: %s", p1.getDistance(listABC));

			Path p2 = new Path();
			List<Town> listAD = new ArrayList<Town>();
			listAD.add(a);
			listAD.add(d);
			System.out.printf("\nOutput #2: %s", p2.getDistance(listAD));

			Path p3 = new Path();
			List<Town> listADC = new ArrayList<Town>();
			listADC.add(a);
			listADC.add(d);
			listADC.add(c);
			System.out.printf("\nOutput #3: %s", p3.getDistance(listADC));

			Path p4 = new Path();
			List<Town> listAEBCD = new ArrayList<Town>();
			listAEBCD.add(a);
			listAEBCD.add(e);
			listAEBCD.add(b);
			listAEBCD.add(e);
			listAEBCD.add(d);
			System.out.printf("\nOutput #4: %s", p4.getDistance(listAEBCD));

			Path p5 = new Path();
			List<Town> listAED = new ArrayList<Town>();
			listAED.add(a);
			listAED.add(e);
			listAED.add(d);
			// System.out.printf("\nOutput #5: %s", p5.getDistance(listAED));

			Path p6 = new Path();
			// System.out.printf("\nOutput #6: %s", p6.numberOfTrips(c, c, c.dests, 3, 0));
			// System.out.printf("\nOutput #7: %s", p6.exactNumberOfTrips(a, c, a.dests, 4));
			// System.out.printf("\nOutput #8: %s", p6.getShortestDistance(a, c));
			// System.out.printf("\nOutput #9: %s", p6.getShortestDistance(b, b));

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}