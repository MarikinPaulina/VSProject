package Simulation;

import java.awt.*;

//Wykonanie: Paulina Marikin
public class Planet extends Body {

	public Planet(double x, double y, double vx, double vy, double mass, double angle,double vAngle, double r, boolean isSun)
	{
		super(x, y, vx, vy, mass,isSun);
		this.radius = r;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public  void drawPlanet(Graphics2D g2d)
	{
		g2d.fillOval((int) (x-radius), (int) (y-radius), (int) (radius * 2), (int) (radius * 2));
		g2d.setColor(Color.LIGHT_GRAY);
	}
}
