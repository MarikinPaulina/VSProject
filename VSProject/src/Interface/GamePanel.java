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

public class GamePanel extends JPanel {

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
		KeyListener moveListener = new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				int gameKey = e.getKeyCode();
				if(gameKey == KeyEvent.VK_UP){
					yLoc -= 5;
					if(yLoc < 0)
						yLoc = 0;
					repaint();
					}
				if(gameKey == KeyEvent.VK_DOWN){
					yLoc += 5;
					if(yLoc > frame.dimension.height)
						yLoc = frame.dimension.height;
					repaint();
					}
				if(gameKey == KeyEvent.VK_LEFT){
					xLoc -= 5;
					if(xLoc < 0)
						xLoc = 0;
					repaint();
					}
				if(gameKey == KeyEvent.VK_RIGHT){
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
		 g2d.setColor(Color.red);
//		 g2d.fillRect(loc.width, loc.height, 5, 5);
		 g2d.fillRect(xLoc, yLoc, 5, 5);
		 }

	BufferedImage back;
	Dimension dimension;
	MainFrame frame;
	int xLoc = 575;
	int yLoc = 300;
	boolean isVisible = false;
}
