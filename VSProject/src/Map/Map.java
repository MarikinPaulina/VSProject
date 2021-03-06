package Map;
//Wykonanie: Paulina Marikin
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import Simulation.*;

public abstract class Map {

	public int n;
	public int cel;
	protected Random rand = new Random();

	public ArrayList<Planet> planets = new ArrayList<Planet>();
	public Rocket rocket;
	
	public ArrayList<Body> sources = new ArrayList<Body>();
	public ArrayList<Body> targets = new ArrayList<Body>();
	
	public abstract void draw(Graphics2D g2d);
}
