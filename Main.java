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
			

			Path p2 = new Path();
			List<Town> listAD = new ArrayList<Town>();
			listAD.add(a);
			listAD.add(d);

			Path p3 = new Path();
			List<Town> listADC = new ArrayList<Town>();
			listADC.add(a);
			listADC.add(d);
			listADC.add(c);

			Path p4 = new Path();
			List<Town> listAEBCD = new ArrayList<Town>();
			listAEBCD.add(a);
			listAEBCD.add(e);
			listAEBCD.add(b);
			listAEBCD.add(c);
			listAEBCD.add(d);

			Path p5 = new Path();
			List<Town> listAED = new ArrayList<Town>();
			listAED.add(a);
			listAED.add(e);
			listAED.add(d);

			int q1 = p1.getDistance(listABC, 0);
			int q2 = p2.getDistance(listAD, 0);
			int q3 = p3.getDistance(listADC, 0);
			int q4 = p4.getDistance(listAEBCD, 0);
			int q5 = p5.getDistance(listAED, 0);
			int[] questions1to5 = {q1, q2, q3, q4, q5};
			int i = 0;
			for (int q : questions1to5) {
				if (q == 0) {
					System.out.printf("\nOutput #%s: NO SUCH ROUTE", i);
				}
				System.out.printf("\nOutput #%s: %s", i, q);
				i++;
			}

			Path p6 = new Path();
			System.out.printf("\nOutput #6: %s", p6.numberOfTrips(c, c, c.dests, 3, 0));
			System.out.printf("\nOutput #7: %s", p6.exactNumberOfTrips(a, c, a.dests, 4));
			System.out.printf("\nOutput #8: %s", p6.getShortestDistance(a, c));
			// System.out.printf("\nOutput #9: %s", p6.getShortestDistance(b, b));

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}