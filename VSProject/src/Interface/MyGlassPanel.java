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
		KeyListener glassListener = new KeyListener() {
			public void keyTyped(KeyEvent e) {
				String key = KeyEvent.getKeyText(e.getKeyCode());
				System.out.println("Typed " + key);
				}
			public void keyPressed(KeyEvent e) {
				String key = KeyEvent.getKeyText(e.getKeyCode());
				System.out.println("Pressed " + key);
				}
			public void keyReleased(KeyEvent e) {
				String key = KeyEvent.getKeyText(e.getKeyCode());
				System.out.println("Released " + key);
				if(frame.gameP.isVisible == true)
				{
					if(frame.gameP.gameOver)
					{
						frame.gameP.h = 0;
						glass.add(overL);
						glass.add(resetB);
						glass.add(newB);
						glass.add(optionsB);
						glass.add(exitB);
						isVisible = true;
						setVisible(true);
					}
					else if(key == "Escape")
					{
						if (isVisible == false)
						{
							frame.gameP.h = 0;
							glass.add(pauzaL);
							glass.add(loadB);
							glass.add(resetB);
							glass.add(newB);
							glass.add(optionsB);
							glass.add(exitB);
							isVisible = true;
							setVisible(true);
						}
						else
						{
							frame.gameP.h = 0.1;
							glass.remove(pauzaL);
							glass.remove(loadB);
							glass.remove(resetB);
							glass.remove(newB);
							glass.remove(optionsB);
							glass.remove(exitB);
							isVisible = false;
							setVisible(false);
						}
					}
					else if(key == "Up"){
						frame.gameP.mapCSS.rocket.setVx(frame.gameP.mapCSS.rocket.getVx()
								+ frame.gameP.mapCSS.rocket.getdV()*Math.cos(Math.toRadians(frame.gameP.mapCSS.rocket.getAngle())));
						frame.gameP.mapCSS.rocket.setVy(frame.gameP.mapCSS.rocket.getVy()
								- frame.gameP.mapCSS.rocket.getdV()*Math.sin(Math.toRadians(frame.gameP.mapCSS.rocket.getAngle())));
					}
					else if(key == "Down"){
						frame.gameP.mapCSS.rocket.setVx(frame.gameP.mapCSS.rocket.getVx()
								- frame.gameP.mapCSS.rocket.getdV()*Math.cos(Math.toRadians(frame.gameP.mapCSS.rocket.getAngle())));
						frame.gameP.mapCSS.rocket.setVy(frame.gameP.mapCSS.rocket.getVy()
								+ frame.gameP.mapCSS.rocket.getdV()*Math.sin(Math.toRadians(frame.gameP.mapCSS.rocket.getAngle())));
					}
					else if(key == "Left"){
						frame.gameP.mapCSS.rocket.setvAngle(frame.gameP.mapCSS.rocket.getvAngle() + frame.gameP.mapCSS.rocket.getdVAngle());
					}
					else if(key == "Right") {
						frame.gameP.mapCSS.rocket.setvAngle(frame.gameP.mapCSS.rocket.getvAngle() - frame.gameP.mapCSS.rocket.getdVAngle());
					}
					
				}
				
			}

		};
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
				frame.gameP.gameOver = false;
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
				frame.gameP.gameOver = false;
				frame.gameP.mapCSS = new ClassicSolarSystem();
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
				frame.gameP.gameOver = false;
				frame.gameP.mapCSS = new ClassicSolarSystem();
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
	int x = 575;
	int y = 100;
	Dimension dim = new Dimension(200,220);

}
