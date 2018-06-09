package Simulation;

public class Collisions {

	public Collisions() {}

	public static void PvP(Planet p1, Planet p2)
	{
		double dx = p1.getX() - p2.getX();
		double dy = p1.getY() - p2.getY();
		double r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
		
		if(r < (p1.getRadius() + p2.getRadius()));
		{
			
		}
	}
	
	public static void RvP(Rocket r, Planet p)
	{
		double dx = p.getX() - r.getX();
		double dy = p.getY() - r.getY();
		double radius = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
		
		if(radius < (p.getRadius()));
		{
			
		}
	}
	
}
