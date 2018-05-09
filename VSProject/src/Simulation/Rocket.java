package Simulation;
//Wykonanie: Paulina Marikin
public class Rocket extends Body {

	protected double width;
	protected double height;
	protected double angle;
	
	public Rocket(double x, double y, double vx, double vy, double mass, double angle,double vAngle, 
			double width, double height)
	{
		super(x, y, vx, vy, mass, angle, vAngle);
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

	public double getHalfWidth() {
		return width/2;
	}
	public void setHalfWidth(double halfWidth) {
		this.width = 2*halfWidth;
	}
	public double getHalfHeight() {
		return height/2;
	}
	public void setHalfHeight(double halfHeight) {
		this.height = halfHeight;
	}
	
	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	
}
