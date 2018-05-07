package Interface;
//Wykonanie: Paulina Marikin
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Map.*;
import Simulation.Planet;
import Simulation.RungeKutta4;

public class GamePanel extends JPanel implements Runnable{

	double dv = 0.5;
	double dfi = 0.05;
	int upKey = KeyEvent.VK_UP;
	int downKey = KeyEvent.VK_DOWN;
	int leftKey = KeyEvent.VK_LEFT;
	int rightKey = KeyEvent.VK_LEFT;
	double h = 0.1;
	ClassicSolarSystem mapCSS;
	
	public GamePanel() {
		// TODO Auto-generated constructor stub
	}

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
		mapCSS = new ClassicSolarSystem();
		KeyListener moveListener = new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				int gameKey = e.getKeyCode();
				if(gameKey == upKey){
					yLoc -= 5;
					if(yLoc < 0)
						yLoc = 0;
					repaint();
					}
				if(gameKey == downKey){
					yLoc += 5;
					if(yLoc > frame.dimension.height)
						yLoc = frame.dimension.height;
					repaint();
					}
				if(gameKey == leftKey){
					xLoc -= 5;
					
					if(xLoc < 0)
						xLoc = 0;
					repaint();
					}
				if(gameKey == rightKey){
					xLoc += 5;
					if(xLoc > frame.dimension.width)
						xLoc = frame.dimension.width;
					repaint();
					}
			}
			public void keyReleased(KeyEvent e) {}

		};
		frame.addKeyListener(moveListener);
	}

	public GamePanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public GamePanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	public void paintComponent(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g;
		 g2d.drawImage(back, 0, 0, this);
//		 g2d.setColor(Color.red);
//		 g2d.fillRect(xLoc, yLoc, 5, 5);
		 mapCSS.draw(g2d);
		 }

	BufferedImage back;
	Dimension dimension;
	MainFrame frame;
	int xLoc = 575;
	int yLoc = 300;
	boolean isVisible = false;

	@Override
	public void run() {
		if(isVisible==true)
		{
			RungeKutta4.step(mapCSS.targets, mapCSS.sources, h);
			mapCSS.fi1 += mapCSS.dfi1;
			mapCSS.planets.get(1).setX(mapCSS.centerX+mapCSS.r1*Math.cos(mapCSS.fi1*Math.PI/180));
			mapCSS.planets.get(1).setY(mapCSS.centerY+mapCSS.r1*Math.sin(mapCSS.fi1*Math.PI/180));		
			repaint();
		}

	}
}
