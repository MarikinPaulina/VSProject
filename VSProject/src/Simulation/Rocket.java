package Simulation;

public class Rocket extends Body {

	protected double width;
	protected double height;
	
	public Rocket(double x, double y, double vx, double vy, double width, double height, double mass)
	{
		super(x, y, vx, vy, mass);
		this.height = height;
		this.width = width;
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
	
	
}
