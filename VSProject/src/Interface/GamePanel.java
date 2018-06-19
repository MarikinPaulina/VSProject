package Interface;
//Wykonanie: Paulina Marikin
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Map.*;
import Simulation.Collisions;
import Simulation.Planet;
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
	ClassicSolarSystem mapCSS;
	public boolean gameOver = false;
	
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
		KeyListener moveListener = new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				int gameKey = e.getKeyCode();
//				System.out.println(gameKey); //Testy
//				if(gameKey == upKey){
//					mapCSS.rocket.setVx(mapCSS.rocket.getVx() + mapCSS.rocket.getdV()*Math.cos(mapCSS.rocket.getAngle()*Math.PI/180));
//					mapCSS.rocket.setVy(mapCSS.rocket.getVy() + mapCSS.rocket.getdV()*Math.sin(mapCSS.rocket.getAngle()*Math.PI/180));
//					if(yLoc < 0)
//						yLoc = 0;
////					repaint();
//					}
//				if(gameKey == downKey){
//					mapCSS.rocket.setVx(mapCSS.rocket.getVx() - mapCSS.rocket.getdV()*Math.cos(mapCSS.rocket.getAngle()));
//					mapCSS.rocket.setVy(mapCSS.rocket.getVy() - mapCSS.rocket.getdV()*Math.sin(mapCSS.rocket.getAngle()));
//					if(yLoc > frame.dimension.height)
//						yLoc = frame.dimension.height;
////					repaint();
//					}
//				if(gameKey == leftKey){
//					mapCSS.rocket.setvAngle(mapCSS.rocket.getvAngle() + mapCSS.rocket.getdVAngle());
//					if(xLoc < 0)
//						xLoc = 0;
//					}
//				if(gameKey == rightKey) {
//					mapCSS.rocket.setvAngle(mapCSS.rocket.getvAngle() - mapCSS.rocket.getdVAngle());
//					if (xLoc > frame.dimension.width)
//						xLoc = frame.dimension.width;
//				}

			}
			public void keyReleased(KeyEvent e) {}

		};
		frame.addKeyListener(moveListener);
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

	public void gameOver()
	{
		MyGlassPanel glass = frame.glass;
		frame.gameP.h = 0;
		glass.add(frame.glass.overL);
		glass.add(frame.glass.resetB);
		glass.add(frame.glass.newB);
		glass.add(frame.glass.optionsB);
		glass.add(frame.glass.exitB);
		glass.isVisible = true;
		glass.setVisible(true);
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
			RungeKutta4.step(mapCSS.targets, mapCSS.sources, h,frame);
			Collisions.theLastBoundary(mapCSS.rocket,frame);
			
			mapCSS.rocket.setAngle(mapCSS.rocket.getAngle() + mapCSS.rocket.getvAngle() * h);
			repaint();
		}

	}
}
