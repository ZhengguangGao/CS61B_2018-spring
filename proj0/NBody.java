public class NBody {

	public static double readRadius(String filename) {

		In in = new In(filename);

		int number = in.readInt(); // in.readInt(); more better

		double radius = in.readDouble();

		return radius;

	}

	public static Planet[] readPlanets(String filename) {

		In in = new In(filename);

		int number = in.readInt();

		in.readDouble();

		Planet[] ps = new Planet[number];

		for (int i = 0; i < number; i++) {

			double xxPos = in.readDouble();

			double yyPos = in.readDouble();

			double xxVel = in.readDouble();

			double yyVel = in.readDouble();

			double mass = in.readDouble();

			String img = in.readString();

			ps[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,img);
		}

		return ps;

	}

	public static void main(String[] args) {

		double T = Double.parseDouble(args[0]);

		double dt = Double.parseDouble(args[1]);

		String filename = args[2];

		Planet[] planets = readPlanets(filename);

		double radius = readRadius(filename);


		/// draw the background

		//public static String imageToDraw = "starfield.jpg";

		StdDraw.setScale(-radius, radius);

		StdDraw.clear();

		StdDraw.picture(0, 0, "images/starfield.jpg");

		// Drawing All of the Planets

		for (Planet P: planets){
			P.draw();
		}

		StdDraw.enableDoubleBuffering();

		for (double t = 0; t < T; t+=dt){

			double[] xForces = new double[planets.length];

			double[] yForces = new double[planets.length];

			for (int i = 0; i < planets.length; i++) {

				xForces[i] = planets[i].calcNetForceExertedByX(planets);

				yForces[i] = planets[i].calcNetForceExertedByY(planets);


			}

			for (int j = 0; j < planets.length; j++) {

				planets[j].update(dt, xForces[j], yForces[j]);				

			}

			StdDraw.picture(0, 0, "images/starfield.jpg");

			for (Planet P: planets) {

				P.draw();

			}

			StdDraw.show();

			StdDraw.pause(10);
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}

	}


}