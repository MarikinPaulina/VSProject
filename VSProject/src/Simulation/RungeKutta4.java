package Simulation;

import java.util.ArrayList;

public class RungeKutta4 {

	double[] K1;
	double[] K2;
	double[] K3;
	double[] K4;
	
	
	
	public static void step(ArrayList<Body> targets, ArrayList<Body> sources, double h)
	{
		ArrayList<Body> buffors = sources;
		buffors.addAll(targets);
		for (Body target : targets)
		{
			Body buffor = target;
			buffors.remove(buffor);
			RK4(target, buffors, h);
			buffors.add(buffor);
		}
	}
	
	public static void RK4(Body target, ArrayList<Body> sources, double h)
	{
		double[] K1 = acceleration(target, sources);
		K1[0] *= h;
		K1[1] *= h;
		
		Body buffor = target;
		buffor.setVx(buffor.getVx() + K1[0]/2);
		buffor.setVy(buffor.getVy() + K1[1]/2);
		buffor.setX(buffor.getX() + buffor.getVx()*h/2);
		buffor.setY(buffor.getY() + buffor.getVy()*h/2);
		double[] K2 = acceleration(buffor, sources);
		K2[0] *= h;
		K2[1] *= h;
		
		buffor = target;
		buffor.setVx(buffor.getVx() + K2[0]/2);
		buffor.setVy(buffor.getVy() + K2[1]/2);
		buffor.setX(buffor.getX() + buffor.getVx()*h/2);
		buffor.setY(buffor.getY() + buffor.getVy()*h/2);
		double[] K3 = acceleration(buffor, sources);
		K3[0] *= h;
		K3[1] *= h;
		
		buffor = target;
		buffor.setVx(buffor.getVx() + K3[0]);
		buffor.setVy(buffor.getVy() + K3[1]);
		buffor.setX(buffor.getX() + buffor.getVx()*h);
		buffor.setY(buffor.getY() + buffor.getVy()*h);
		double[] K4 = acceleration(buffor, sources);
		K4[0] *= h;
		K4[1] *= h;
		
		buffor = target;
		buffor.setVx(buffor.getVx() + (K1[0] + 2*K2[0] + 2*K3[0] + K4[0])/6);
		buffor.setVy(buffor.getVy() + (K1[1] + 2*K2[1] + 2*K3[1] + K4[1])/6);
		buffor.setX(buffor.getX() + buffor.getVx()*h);
		buffor.setY(buffor.getY() + buffor.getVy()*h);
		
		target = buffor;
	}
	
	public static double[] acceleration(Body target, ArrayList<Body> sources)
	{
		double  a[] = new double[2];
				
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
