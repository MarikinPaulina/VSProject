package Map;
//Wykonanie: Paulina Marikin
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import Simulation.*;

public class ClassicSolarSystem extends Map{

	public int centerX = 650;
	public int centerY = 350;
	public ArrayList<Double> rX = new ArrayList<>();
	public ArrayList<Double> rY = new ArrayList<>();

	public ClassicSolarSystem(int n, int cel) {
		Planet sun = new Planet(centerX,centerY,0,0,1000,0,1,75,true);
		rX.add(0.0);
		rY.add(0.0);

		this.n = n;
		this.cel = cel;

		rX.add(150.0);
		rY.add(0.0);
		Planet planet1 = new Planet(centerX+rX.get(1),centerY+rY.get(1),-0.75,2.5,10,0,1,10,false);

		rX.add(-190.0);
		rY.add(0.0);
		Planet planet2 = new Planet(centerX+rX.get(2),centerY+rY.get(2),0.5,-2.05,10,0,1,25,false);

		rX.add(350.0);
		rY.add(275.0);
		Planet planet3 = new Planet(centerX+rX.get(3),centerY+rY.get(3),0.45,-1,10,0,1,15,false);

		rX.add(150.0);
		rY.add(200.0);
		Planet planet4 = new Planet(centerX+rX.get(4),centerY+rY.get(4),-1,0.75,5,0,1,30,false);

		rX.add(-50.0);
		rY.add(200.0);
		Planet planet5 = new Planet(centerX+rX.get(5),centerY+rY.get(5),1.9,0,12,0,1,15,false);
		planets.add(sun);
		sources.add(sun);

		if(n == 0)
		{
			planets.add(planet1);
			planets.add(planet2);
			planets.add(planet3);

			targets.add(planet1);
			targets.add(planet2);
			targets.add(planet3);

			planets.get(cel).isTarget = true;
		}
		else if(n == 1)
		{
			planets.add(planet1);
			planets.add(planet3);
			planets.add(planet4);

			targets.add(planet1);
			targets.add(planet3);
			targets.add(planet4);

			planets.get(cel).isTarget = true;
		}
		else
		{
			planets.add(planet1);
			planets.add(planet2);
			planets.add(planet4);
			planets.add(planet5);

			targets.add(planet1);
			targets.add(planet2);
			targets.add(planet4);
			targets.add(planet5);

			planets.get(cel).isTarget = true;
		}

		rocket = new Rocket(planet1.getX(),planet1.getY()-planet1.getRadius(),0,0,0.005,120,
				0,15,30,false);
		targets.add(rocket);
	}

	public ClassicSolarSystem() {
		Planet sun = new Planet(centerX,centerY,0,0,1000,0,1,75,true);
		rX.add(0.0);
		rY.add(0.0);

		n = rand.nextInt(3);
		cel = 1 + rand.nextInt(n);

		rX.add(150.0);
		rY.add(0.0);
		Planet planet1 = new Planet(centerX+rX.get(1),centerY+rY.get(1),-0.75,2.5,10,0,1,10,false);
		
		rX.add(-190.0);
		rY.add(0.0);
		Planet planet2 = new Planet(centerX+rX.get(2),centerY+rY.get(2),0.5,-2.05,10,0,1,25,false);
		
		rX.add(350.0);
		rY.add(275.0);
		Planet planet3 = new Planet(centerX+rX.get(3),centerY+rY.get(3),0.45,-1,10,0,1,15,false);

		rX.add(150.0);
		rY.add(200.0);
		Planet planet4 = new Planet(centerX+rX.get(4),centerY+rY.get(4),-1,0.75,5,0,1,30,false);

		rX.add(-50.0);
		rY.add(200.0);
		Planet planet5 = new Planet(centerX+rX.get(5),centerY+rY.get(5),1.9,0,12,0,1,15,false);
		planets.add(sun);
		sources.add(sun);

		if(n == 0)
		{
			planets.add(planet1);
			planets.add(planet2);
			planets.add(planet3);

			targets.add(planet1);
			targets.add(planet2);
			targets.add(planet3);

			cel = 1 + rand.nextInt(3);
			planets.get(cel).isTarget = true;
		}
		else if(n == 1)
		{
			planets.add(planet1);
			planets.add(planet3);
			planets.add(planet4);

			targets.add(planet1);
			targets.add(planet3);
			targets.add(planet4);

			cel = 1 + rand.nextInt(3);
			planets.get(cel).isTarget = true;
		}
		else
		{
			planets.add(planet1);
			planets.add(planet2);
			planets.add(planet4);
			planets.add(planet5);

			targets.add(planet1);
			targets.add(planet2);
			targets.add(planet4);
			targets.add(planet5);

			cel = 1 + rand.nextInt(4);
			planets.get(cel).isTarget = true;
		}

		rocket = new Rocket(planet1.getX(),planet1.getY()-planet1.getRadius(),0,0,0.005,120,
				0,15,30,false);
		targets.add(rocket);
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.yellow);
//		g2d.fillRect(200, 200, 200, 200); //Test
		for (Planet planet : planets)
		{
			if(planet.isTarget) {g2d.setColor(Color.green);}
			planet.drawPlanet(g2d);
		}

		rocket.drawRocket(g2d);
	}
	
}
