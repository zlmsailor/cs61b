public class NBody {
	
	public static double readRadius(String fileName) {
		In in = new In(fileName);
		in.readInt();
		double Radius = in.readDouble();
		return Radius;
	}
	
/** 
* num is the numbers of planets
*/		

	public static Planet [] readPlanets(String fileName) {
		In in = new In(fileName);
		int num = in.readInt();
		in.readDouble();
		
		Planet [] Planets = new Planet[num];
		
		int i = 0;
		while(i < num) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			Planets[i++] = new Planet(xP, yP, xV, yV, m, img);
		}
		
		return Planets;
	}
	
	public static void main(String[] args) {
	
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String fileName = args[2];
		double uniRadius = NBody.readRadius(fileName);
		Planet [] Planets = NBody.readPlanets(fileName);
	
		StdDraw.setScale(-uniRadius, uniRadius);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");
	
		for (Planet planet : Planets) {
			planet.draw();
		}
		
		StdDraw.enableDoubleBuffering();
		

		for(double t = 0; t <= T; t += dt) {
			double[] xForce = new double[Planets.length];
			double[] yForce = new double[Planets.length];
		
			for (int i = 0; i < Planets.length; i++) {
				xForce[i] = Planets[i].calcNetForceExertedByX(Planets);
				yForce[i] = Planets[i].calcNetForceExertedByY(Planets);
			}
			
			for (int i = 0; i < Planets.length; i++) {
				Planets[i].update(dt, xForce[i], yForce[i]);
			}
			
			StdDraw.picture(0, 0, "images/starfield.jpg");
			
			for (Planet planet : Planets) {
			planet.draw();
			}
			
			StdDraw.show();
			StdDraw.pause(10);
		
		}
		
	
		StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", uniRadius);
        for (int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel, Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);  
		}
	
	}
}











