package Simulation;

public class Rocket extends Body {

	protected double width;
	protected double height;
	protected double angle;
	
	public Rocket(double x, double y, double vx, double vy, double mass, double width, double height, double angle)
	{
		super(x, y, vx, vy, mass);
		this.height = height;
		this.width = width;
		this.angle = angle;
	}
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	
}
