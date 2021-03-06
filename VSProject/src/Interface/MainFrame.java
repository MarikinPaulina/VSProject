package Interface;
//Wykonanie: Paulina Marikin
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Simulation.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.*;

public class MainFrame extends JFrame {


	public MainFrame() throws HeadlessException {
	}

	public MainFrame(GraphicsConfiguration gc) {
		super(gc);
	}

	public MainFrame(String title) throws HeadlessException {
		super(title);

		
//		tło i rozmiar
		URL resource = getClass().getResource("/pictures/background.jpg");
		try {
		back = ImageIO.read(resource);
		} catch (IOException e) {
		System.err.println("Blad odczytu obrazka");
		e.printStackTrace();
		}
		dimension =	new Dimension(back.getWidth(), back.getHeight());
		setPreferredSize(dimension);
//		Ustawianie paneli i layoutu
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(dimension);
		final MainFrame frame = this;
		frame.add(mainP);
		mainP.add(menuP,"menu");
		mainP.add(optionsP,"options");
		mainP.add(initP,"init");
		mainP.add(gameP,"game");
//		layout.show(mainP, "game");
//		gameP.isVisible = true;
		frame.setGlassPane(glass);
		
		
	}

	public MainFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}


	private MenuPanel menuP = new MenuPanel(null,this);
	private OptionsPanel optionsP = new OptionsPanel(null,this);
	private InitPanel initP = new InitPanel(null,this);
	public GamePanel gameP = new GamePanel(null,this);
	CardLayout layout = new CardLayout();
	JPanel mainP = new JPanel(layout);
	public MyGlassPanel glass = new MyGlassPanel(this);
	boolean existGame = false;
	private BufferedImage back;
	public Dimension dimension;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				MainFrame frame = new MainFrame("VSProject");
				frame.setVisible(true);
				
				final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
				final ScheduledFuture<?> sc1 = scheduler.scheduleAtFixedRate(frame.gameP, 0, 5, TimeUnit.MILLISECONDS);
				
			}
		});
		
	}

}
