package Simulation;

public class Body 
{

	protected double mass;
	protected int x;
	protected int y;
	protected int vx;
	protected int vy;
	
	public double getMass() 
	{
		return mass;
	}
	
	public void setMass(double Mass)
	{
		mass = Mass;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}
	
	
}
