package Simulation;

public class Body 
{

	protected double mass;
	protected double x;
	protected double y;
	protected double vx;
	protected double vy;
	
	public Body(double x, double y, double vx, double vy, double mass)
	{
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.mass = mass;
	}
	
	public double getMass() 
	{
		return mass;
	}
	
	public void setMass(double Mass)
	{
		mass = Mass;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	
	
	
}
