package Simulation;

public class Planet extends Body {

	protected double radius;
	
	public Planet(double x, double y, double vx, double vy, double r, double mass)
	{
		super(x, y, vx, vy, mass);
		this.radius = r;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
}
