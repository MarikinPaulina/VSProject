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
			Body buffer = new Body(target);
			buffers.remove(target);			
			RK4(target, buffers, h);	
			buffers.add(buffer);
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
		double[] step = new double[4];		
		double[] K = new double[4];
		double[]  a = acceleration(target, sources);
		
		Body buffor = new Body(target);
		
		for(int i = 0; i<4;i++)
		{
			if(i == 4)
			{
				buffor.setVx(buffor.getVx() + K[0]);
				buffor.setVy(buffor.getVy() + K[1]);
				buffor.setX(buffor.getX() + K[2]);
				buffor.setY(buffor.getY() + K[3]);
			}
			if(i == 2 || i == 3)
			{
				buffor.setVx(buffor.getVx() + K[0]/2);
				buffor.setVy(buffor.getVy() + K[1]/2);
				buffor.setX(buffor.getX() + K[2]/2);
				buffor.setY(buffor.getY() + K[3]/2);
			}
			K = new double[4];
			a = acceleration(buffor, sources);
			K[0] = a[0];
			K[1] = a[1];
			K[2] = buffor.getVx();
			K[3] = buffor.getVy();
			for (int j = 0; j < 4; j++) {
				if(i == 2 || i == 3)
				{
					step[j] += K[j];
				}
				step[j] += K[j];
			}
		}
		
		for (int j = 0; j < 4; j++)
		{
			step[j] *= h/6;
		}
		
		target.setDvx(step[0]);
		target.setDvy(step[1]);
		target.setDx(step[2]);
		target.setDy(step[3]);
	}
	
	
	public static double[] acceleration(Body target, ArrayList<Body> sources)
	{
		double a[] = new double[2];
		
		for(Body source : sources)
		{
			double dx = source.getX() - target.getX();
			double dy = source.getY() - target.getY();
			double r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
			
			a[0] += source.getMass() * dx/ Math.pow(r, 3) * G;
			a[1] += source.getMass() * dy/ Math.pow(r, 3) * G;
			
		}
		a[0] *= target.getMass();
		a[1] *= target.getMass();
		return a;
	}
}
