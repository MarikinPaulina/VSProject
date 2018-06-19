package Simulation;

import Interface.*;

public class Collisions {

	//	https://physics.stackexchange.com/questions/107648/what-are-the-general-solutions-to-a-hard-sphere-collision

	public static double COLLISION_THRESHOLD = 10;
	public Collisions() {}

	public static double impactTime(Body p1, Body p2)
	{
		double dx = p1.getX() - p2.getX();
		double dy = p1.getY() - p2.getY();
		double dvx = p1.getVx() - p2.getVx();
		double dvy = p1.getVy() - p2.getVy();
		double r0_rprime = dx*dvx + dy*dvy;
		double r0_r0 = dx*dx + dy*dy;
		double rprime_rprime = dvx*dvx + dvy*dvy;
		double t = -(r0_rprime + Math.sqrt(Math.pow(r0_rprime, 2)-rprime_rprime*(r0_r0-Math.pow(p1.getRadius()+p2.getRadius(), 2)))) / rprime_rprime;
		return t;
	}
	
	public static void PvP(Body p1, Body p2, double h, MainFrame frame)
	{
		double t = impactTime(p1,p2);
		if((0 <= t) && ( t < h))
		{
			System.out.println("KOLIZJAAAAAAAAAAAAAAAAAAAAAAAAAA za " + t);
			double dx = p1.getX() - p2.getX();
			double dy = p1.getY() - p2.getY();
			double dvx = p1.getVx() - p2.getVx();
			double dvy = p1.getVy() - p2.getVy();

			if ((p1 instanceof Planet) && (p2  instanceof Planet))
			{
				System.out.println("wow, planety");
				double jx = dx + dvx*t;
				double jy = dy + dvy*t;
				double jabs = Math.sqrt(jx * jx + jy * jy);
				jx /= jabs;
				jy /= jabs;

				double J = 2 *(jx*dvx + jy*dvy) / (1/p1.getMass() + 1/p2.getMass());

				p1.setVx(p1.getVx() - J*jx/p1.getMass());
				p1.setVy(p1.getVy() - J*jy/p1.getMass());
				p2.setVx(p2.getVx() + J*jx/p2.getMass());
				p2.setVy(p2.getVy() + J*jy/p2.getMass());
			}
			else
			{
				if (p1.isSun || p2.isSun)
				{
					frame.gameP.gameOver = true;
				}
				double magnitude_velocity_difference = Math.sqrt(Math.pow(dvx,2) + Math.pow(dvy,2));
				if (magnitude_velocity_difference <= COLLISION_THRESHOLD)
				{
					System.out.println("Lądowanie");
					if (p1 instanceof Rocket)
					{
						p1.setVx(p2.getVx());
						p1.setVy(p2.getVy());
					}
					else if (p2 instanceof Rocket)
					{
						p2.setVx(p1.getVx());
						p2.setVy(p1.getVy());
					}
				}
//				else if (magnitude_velocity_difference)
			}
		}
	}
	public static void theLastBoundary(Rocket r, MainFrame frame)
	{
		if((r.getX() < 0) || (r.getX() > frame.dimension.getWidth()) || (r.getY() < 0) || (r.getY() > frame.dimension.getHeight()))
		{
			frame.gameP.gameOver = true;
		}
	}
}
