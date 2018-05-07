package Simulation;

public class Planet extends Body {

	protected double radius;
	
	public Planet(double x, double y, double vx, double vy, double mass, double angle,double vAngle, double r)
	{
		super(x, y, vx, vy, mass, angle, vAngle);
		this.radius = r;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
}
