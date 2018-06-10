package Map;
//Wykonanie: Paulina Marikin
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Simulation.*;

public class ClassicSolarSystem extends Map{

	public int centerX = 650;
	public int centerY = 350;
	public ArrayList<Double> rX = new ArrayList<Double>();
	public ArrayList<Double> rY = new ArrayList<Double>();
	
	
	public ClassicSolarSystem() {
		Planet sun = new Planet(centerX,centerY,0,0,1000,0,1,100);
		rX.add(0.0);
		rY.add(0.0);
		
		rX.add(150.0);
		rY.add(0.0);
		Planet planet1 = new Planet(centerX+rX.get(1),centerY+rY.get(1),-0,2.5,10,0,1,10);
		
		rX.add(-150.0);
		rY.add(0.0);
		Planet planet2 = new Planet(centerX+rX.get(2),centerY+rY.get(2),0,-2.5,10,0,1,25);
		
		rX.add(350.0);
		rY.add(300.0);
		Planet planet3 = new Planet(centerX+rX.get(3),centerY+rY.get(3),0,-1,10,0,1,15);
		
		planets.add(sun);
		planets.add(planet1);
		planets.add(planet2);
		planets.add(planet3);
		
		sources.add(sun);
		targets.add(planet1);
		targets.add(planet2);
		targets.add(planet3);

		rocket = new Rocket(planet1.getX(),planet1.getY()-planet1.getRadius(),planet1.getVx(),planet1.getVy(),0.005,45,0,15,30);
		targets.add(rocket);
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.yellow);
//		g2d.fillRect(200, 200, 200, 200); //Test
		for (Planet planet : planets)
		{
			planet.drawPlanet(g2d);
		}

		rocket.drawRocket(g2d);
	}
	
}
