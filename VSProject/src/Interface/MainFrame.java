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

public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public MainFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
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
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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


	MenuPanel menuP = new MenuPanel(null,this);
	OptionsPanel optionsP = new OptionsPanel(null,this);
	InitPanel initP = new InitPanel(null,this);
	GamePanel gameP = new GamePanel(null,this);
	CardLayout layout = new CardLayout();
	JPanel mainP = new JPanel(layout);
	MyGlassPanel glass = new MyGlassPanel(this);
	boolean existGame = false;
	BufferedImage back;
	Dimension dimension;
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame("VSProject");
		frame.setVisible(true);

//		Testy
		
//		int n = 900;
//		Body sun = new Body(0,0,0,0,100);
//		Body planet = new Body(1000,0,5,5,5);
//		ArrayList<Body> testA = new ArrayList<Body>();
//		testA.add(sun);
//		System.out.println(planet.getX()+","+planet.getY());
//		for(int i=0;i<n;i++)
//		{
//			RungeKutta4.RK4(planet, testA, 1);
//			System.out.println(planet.getX()+","+planet.getY());
//		}
		
		
	}

}
