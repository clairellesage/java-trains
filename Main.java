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

			// questions 1-5

			Path p1 = new Path(a);
			List<Town> abc = new ArrayList<Town>();
			abc.add(a);
			abc.add(b);
			abc.add(c);
			p1.getDistance(abc);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}