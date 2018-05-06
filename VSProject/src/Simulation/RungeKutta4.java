package Simulation;

import java.util.ArrayList;

public class RungeKutta4 {

	public static void step(ArrayList<Body> targets, ArrayList<Body> sources)
	{
		
	}
	
	public void RK4(double yn, double h)
	{
		
	}
	
	public double[] acceleration(Body target, ArrayList<Body> sources)
	{
		double  a[] = new double[2];
				
//		double ax = 0;
//		double ay = 0;
		for(Body source : sources)
		{
			double dx = Math.abs((source.getX()-target.getX()));
			double dy = Math.abs((source.getY()-target.getY()));
			double r = Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
			
			a[0] += source.getMass() * dx /Math.pow(r, 3);
			a[1] += source.getMass() * dy /Math.pow(r, 3);
		}
		a[0] *= target.getMass();
		a[1] *= target.getMass();
		return a;
	}
}
