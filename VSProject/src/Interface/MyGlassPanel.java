package Interface;
//Wykonanie: Paulina Marikin
import Map.ClassicSolarSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyGlassPanel extends JComponent  {
//	implements KeyListener
	public MyGlassPanel(final MainFrame frame) {
		final MyGlassPanel glass = this;
		glass.setLayout(null);
		pauzaL.setForeground(Color.white);
		pauzaL.setBounds(x+75,y,170,30);
		overL.setForeground(Color.white);
		overL.setBounds(x+55,y,170,30);
	    loadB.setBounds(x+15,y+35,170,30);
	    resetB.setBounds(x+15,y+70,170,30);
	    newB.setBounds(x+15,y+105,170,30);
	    optionsB.setBounds(x+15,y+140,170,30);
	    exitB.setBounds(x+15,y+175,170,30);
		OKeyListener glassListener = new OKeyListener(frame,this);
		frame.addKeyListener(glassListener);
		ActionListener exitListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}

		};
		exitB.addActionListener(exitListener);
		
		ActionListener optionsListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				glass.setVisible(false);
				frame.gameP.h = 0.1;
				glass.remove(pauzaL);
				glass.remove(overL);
				glass.remove(loadB);
				glass.remove(resetB);
				glass.remove(newB);
				glass.remove(optionsB);
				glass.remove(exitB);
				frame.gameP.isVisible = false;
				frame.layout.show(frame.mainP, "options");
			}

		};
		optionsB.addActionListener(optionsListener);
		
		ActionListener loadListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				glass.setVisible(false);
				frame.gameP.h = 0.1;
				glass.remove(pauzaL);
				glass.remove(overL);
				glass.remove(loadB);
				glass.remove(resetB);
				glass.remove(newB);
				glass.remove(optionsB);
				glass.remove(exitB);
				System.out.println(frame.requestFocusInWindow());
			}

		};
		loadB.addActionListener(loadListener);

		ActionListener newListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				glass.setVisible(false);
				frame.gameP.h = 0.1;
				glass.remove(pauzaL);
				glass.remove(overL);
				glass.remove(loadB);
				glass.remove(resetB);
				glass.remove(newB);
				glass.remove(optionsB);
				glass.remove(exitB);
				frame.gameP.mapCSS = new ClassicSolarSystem();
				System.out.println(frame.requestFocusInWindow());
			}

		};
		newB.addActionListener(newListener);

		ActionListener resetListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				glass.setVisible(false);
				frame.gameP.h = 0.1;
				glass.remove(pauzaL);
				glass.remove(overL);
				glass.remove(loadB);
				glass.remove(resetB);
				glass.remove(newB);
				glass.remove(optionsB);
				glass.remove(exitB);
				frame.gameP.mapCSS = new ClassicSolarSystem();
				System.out.println(frame.requestFocusInWindow());
			}

		};
		resetB.addActionListener(resetListener);
	}
	
	
//	public class MyDispatcher implements KeyEventDispatcher
//	{
//		@Override
//		public boolean dispatchKeyEvent(KeyEvent e)
//		{
//			
//		}
//	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Color kolor = new Color(20,20,20,90);
		g2d.setColor(kolor);
		g2d.fillRect(0, 0, 2000, 1000);
		g2d.setPaint(new GradientPaint(x,y,new Color(20,20,20),x,y+dim.height,new Color(50,50,50)));
		g2d.fillRect(x, y, dim.width, dim.height);
	}

	JLabel pauzaL = new JLabel("Pauza");
	JLabel overL = new JLabel("Przegrałeś");
	JButton loadB = new JButton("Kontynuj");
	JButton resetB = new JButton("Reset");
	JButton newB = new JButton("Nowa gra");
	JButton optionsB = new JButton("Opcje");
	JButton exitB = new JButton("Wyjście");
	boolean isVisible = false;
	MainFrame frame;
	private int x = 575;
	private int y = 100;
	private Dimension dim = new Dimension(200,220);

}
