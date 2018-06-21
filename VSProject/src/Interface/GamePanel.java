package Interface;
//Wykonanie: Paulina Marikin
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Map.*;
import Simulation.Collisions;
import Simulation.RungeKutta4;

public class GamePanel extends JPanel implements Runnable{

	double dv = 0.5;
	double dfi = 0.05;
	int upKey = KeyEvent.VK_UP;
	int downKey = KeyEvent.VK_DOWN;
	int leftKey = KeyEvent.VK_LEFT;
	int rightKey = KeyEvent.VK_LEFT;
	int rKey = KeyEvent.VK_R;
	double h = 0.1;
	private int i = 0;

	public Map mapCSS;
	
	public GamePanel() {}

	public GamePanel(LayoutManager layout,final MainFrame frame) {
		super(layout);
		this.frame = frame;
		URL resource = getClass().getResource("/pictures/background.jpg");
		try {
		back = ImageIO.read(resource);
		} catch (IOException e) {
		System.err.println("Blad odczytu obrazka");
		e.printStackTrace();
		}
		dimension =	new Dimension(back.getWidth(), back.getHeight());
		setPreferredSize(dimension);
	}

	public GamePanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public GamePanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}
	

	
	public void paintComponent(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g;
		 g2d.drawImage(back, 0, 0, this);
//		 g2d.setColor(Color.red);
//		 g2d.fillRect(xLoc, yLoc, 5, 5);
		 mapCSS.draw(g2d);
		 }

	private BufferedImage back;
	private Dimension dimension;
	private MainFrame frame;
	int xLoc = 575;
	int yLoc = 300;
	boolean isVisible = false;

	@Override
	public void run() {
		if(isVisible)
		{
			RungeKutta4.step(mapCSS.targets, mapCSS.sources, h,frame);
			Collisions.theLastBoundary(mapCSS.rocket,frame);
			Collisions.galactus(mapCSS.planets,frame);
			
			mapCSS.rocket.setAngle(mapCSS.rocket.getAngle() + mapCSS.rocket.getvAngle() * h);
			repaint();
			i++;
		}

	}
}
