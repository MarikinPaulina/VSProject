package Map;

import java.awt.Color;
import java.awt.Graphics2D;

import Simulation.*;

public class ClassicSolarSystem extends Map {

	double r1 = 150;
	double fi1 = 20;
	
	public ClassicSolarSystem() {
		sun = new Planet(575,300,0,0,1000,100);
		
		Planet planet1 = new Planet(575+r1*Math.cos(fi1*Math.PI/180),300+r1*Math.sin(fi1*Math.PI/180),0,0,10,10);
		
		planets.add(sun);
		planets.add(planet1);
		
		rocket = new Rocket(planet1.getX(),planet1.getY()-planet1.getRadius(),0,0,0.5,2,5,0);
		
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.cyan);
		
		for (Planet planet : planets)
		{
			g2d.fillOval((int) (planet.getX()-planet.getRadius()), (int) (planet.getY()+planet.getRadius()), 
					(int) planet.getRadius() * 2, (int) planet.getRadius() * 2);
		}
		
		g2d.setColor(Color.red);
		g2d.fillRect((int) (rocket.getX()-rocket.getWidth()/2), (int) (rocket.getY()+rocket.getHeight()/2),
				(int) rocket.getWidth(), (int) rocket.getHeight());
		

	}
	
}
