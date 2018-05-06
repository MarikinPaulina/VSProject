package Map;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Simulation.*;

public abstract class Map {

	Planet sun;
	ArrayList<Planet> planets = new ArrayList<Planet>();
	Rocket rocket;
	
	public abstract void draw(Graphics2D g2d);
}
