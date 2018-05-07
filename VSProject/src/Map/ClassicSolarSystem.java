package Map;

import java.awt.Color;
import java.awt.Graphics2D;

import Simulation.*;

public class ClassicSolarSystem extends Map {

	int centerX = 650;
	int centerY = 330;
	double r1 = 150;
	double fi1 = 20;
	
	public ClassicSolarSystem() {
		sun = new Planet(centerX,centerY,0,0,1000,0,1,100);
		
		Planet planet1 = new Planet(centerX+r1*Math.cos(fi1*Math.PI/180),centerY+r1*Math.sin(fi1*Math.PI/180),0,0,10,0,1,10);
		
		planets.add(sun);
		planets.add(planet1);
		
		rocket = new Rocket(planet1.getX(),planet1.getY()-planet1.getRadius(),0,0,0.5,0,0,2,5);
		
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.yellow);
//		g2d.fillRect(200, 200, 200, 200); //Test
		for (Planet planet : planets)
		{
			g2d.fillOval((int) (planet.getX()-planet.getRadius()), (int) (planet.getY()-planet.getRadius()), 
					(int) (planet.getRadius() * 2), (int) (planet.getRadius() * 2));
			g2d.setColor(Color.black);
		}
		
		g2d.setColor(Color.red);
		g2d.fillRect((int) (rocket.getX()-rocket.getHalfWidth()), (int) (rocket.getY()-rocket.getHalfHeight()),
				(int) rocket.getWidth(), (int) rocket.getHeight());
		

	}
	
}
