package Simulation;

import java.awt.*;

//Wykonanie: Paulina Marikin
public class Rocket extends Body {

	protected double width;
	protected double height;
	protected double angle;
	protected double vAngle;
	protected double dVAngle;
	protected double dV;
	
	public Rocket(double x, double y, double vx, double vy, double mass, double angle,double vAngle, 
			double width, double height)
	{
		super(x, y, vx, vy, mass);
        this.angle = angle;
        this.vAngle = vAngle;
		this.height = height;
		this.width = width;
		this.dV = 1;
		this.dVAngle = 1;
		if(height > width)
			radius = height/2;
		else
			radius = width/2;
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

	public double getvAngle() {
		return vAngle;
	}

	public void setvAngle(double vAngle) {
		this.vAngle = vAngle;
	}

	public double getdVAngle() {
		return dVAngle;
	}

	public void setdVAngle(double dVAngle) {
		this.dVAngle = dVAngle;
	}

	public double getdV() {
		return dV;
	}

	public void setdV(double dV) {
		this.dV = dV;
	}

	public void drawRocket(Graphics2D graphics2D)
	{
		double xAlongL = height / 2 * Math.cos(angle);
		double yAlongL = height / 2 * Math.sin(angle);
		double xAlongW = width / 2 * Math.sin(angle);
		double yAlongW = width / 2 * Math.cos(angle);

		int xTable[] = {(int)(x + xAlongL), (int)(x - xAlongL - xAlongW), (int)(x - xAlongL/2), (int)(x - xAlongL + xAlongW)};
		int yTable[] = {(int)(y + yAlongL), (int)(y - yAlongL - yAlongW), (int)(y - yAlongL/2), (int)(y - yAlongL + yAlongW)};

		graphics2D.setColor(Color.blue);
		graphics2D.fillPolygon(xTable, yTable, 4);
	}
	
}
