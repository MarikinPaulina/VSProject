package Simulation;
//Wykonanie: Paulina Marikin
import java.util.ArrayList;

public class RungeKutta4 {

	double[] K1;
	double[] K2;
	double[] K3;
	double[] K4;
	public static final double G = 6.674*Math.pow(10, -1);
	
	
	
	public static void step(ArrayList<Body> targets, ArrayList<Body> sources, double h)
	{
		ArrayList<Body> buffers = new ArrayList<Body>();
		buffers.addAll(sources);
		buffers.addAll(targets);
//		System.out.println(buffers.size()); //Testy
		for (Body target : targets)
		{
			RK4(target, buffers, h);			
		}
		for (Body target : targets)
		{
			System.out.print(target.getX()+","+target.getY()+","); //Testy
			target.setX(target.getX()+target.getDx());
			target.setY(target.getY()+target.getDy());
			target.setVx(target.getVx()+target.getDvx());
			target.setVy(target.getVy()+target.getDvy());
			target.setDx(0);
			target.setDy(0);
			target.setDvx(0);
			target.setDvy(0);
		}
		System.out.println();
	}
	
	public static void RK4(Body target, ArrayList<Body> sources, double h)
	{
		double[] K1 = new double[4];
		double[]  a1 = acceleration(target, sources);
		K1[0] = a1[0];
		K1[1] = a1[1];
		K1[2] = target.getVx();
		K1[3] = target.getVy();
		for (int j = 0; j < 4; j++) {
			K1[j] *= h;
		}
		
		Body buffor = new Body(target);
//		System.out.println("Przed " + buffor.getVx()); //Testy
		buffor.setVx(buffor.getVx() + K1[0]/2);
		buffor.setVy(buffor.getVy() + K1[1]/2);
		buffor.setX(buffor.getX() + K1[2]/2);
		buffor.setY(buffor.getY() + K1[3]/2);
		double[] K2 = new double[4];
		double[]  a2 = acceleration(buffor, sources);
		K2[0] = a2[0];
		K2[1] = a2[1];
		K2[2] = buffor.getVx();
		K2[3] = buffor.getVy();
		for (int j = 0; j < 4; j++) {
			K2[j] *= h;
		}
		
		buffor = new Body(target);
//		System.out.println("Po " + buffor.getVx()); //Testy
		buffor.setVx(buffor.getVx() + K2[0]/2);
		buffor.setVy(buffor.getVy() + K2[1]/2);
		buffor.setX(buffor.getX() + K2[2]/2);
		buffor.setY(buffor.getY() + K2[3]/2);
		double[] K3 = new double[4];
		double[]  a3 = acceleration(buffor, sources);
		K3[0] = a3[0];
		K3[1] = a3[1];
		K3[2] = buffor.getVx();
		K3[3] = buffor.getVy();
		for (int j = 0; j < 4; j++) {
			K3[j] *= h;
		}
		
		buffor = new Body(target);
		buffor.setVx(buffor.getVx() + K3[0]);
		buffor.setVy(buffor.getVy() + K3[1]);
		buffor.setX(buffor.getX() + K3[2]);
		buffor.setY(buffor.getY() + K3[3]);
		double[] K4 = new double[4];
		double[]  a4 = acceleration(buffor, sources);
		K4[0] = a4[0];
		K4[1] = a4[1];
		K4[2] = buffor.getVx();
		K4[3] = buffor.getVy();
		for (int j = 0; j < 4; j++) {
			K4[j] *= h;
		}
		
		target.setDvx((K1[0] + 2*K2[0] + 2*K3[0] + K4[0])/6);
		target.setDvy((K1[1] + 2*K2[1] + 2*K3[1] + K4[1])/6);
		target.setDx((K1[2] + 2*K2[2] + 2*K3[2] + K4[2])/6);
		target.setDy((K1[3] + 2*K2[3] + 2*K3[3] + K4[3])/6);
	}
	
	public static double[] acceleration(Body target, ArrayList<Body> sources)
	{
		double  a[] = new double[2];
				
		for(Body source : sources)
		{
			if(source==target)
				continue;
			double dx = (source.getX() - target.getX());
			double dy = (source.getY() - target.getY());
			double r = Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
			
			a[0] += source.getMass() * dx /Math.pow(r, 3) * G;
			a[1] += source.getMass() * dy /Math.pow(r, 3) * G;
		}
		a[0] *= target.getMass();
		a[1] *= target.getMass();
		return a;
	}
}
