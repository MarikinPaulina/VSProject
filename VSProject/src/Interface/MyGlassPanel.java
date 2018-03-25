package Interface;
//Wykonanie: Paulina Marikin
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
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
		glass.add(pauzaL);
		pauzaL.setForeground(Color.white);
		pauzaL.setBounds(x+75,y,170,30);
	    glass.add(loadB);
	    loadB.setBounds(x+15,y+35,170,30);
	    glass.add(resetB);
	    resetB.setBounds(x+15,y+70,170,30);
	    glass.add(newB);
	    newB.setBounds(x+15,y+105,170,30);
	    glass.add(optionsB);
	    optionsB.setBounds(x+15,y+140,170,30);
	    glass.add(exitB);
	    exitB.setBounds(x+15,y+175,170,30);
		KeyListener glassListener = new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
				String key = e.getKeyText(e.getKeyCode());
				if(key == "Escape")
				{
					if(frame.gameP.isVisible == true)
					{
						if(isVisible == false)
						{
							isVisible = true;
							setVisible(true);
						}
						else
						{
							isVisible = false;
							setVisible(false);
						}
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
				frame.layout.show(frame.mainP, "options");
			}

		};
		optionsB.addActionListener(optionsListener);
		
		ActionListener loadListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				glass.setVisible(false);
			}

		};
		loadB.addActionListener(loadListener);
	}

//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub

//	}
//
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public void keyReleased(KeyEvent e) {
//		int key = e.getKeyCode();
//		setVisible(KeyEvent.getKeyText(key) == "VK_ESCAPE");
//		System.out.println(KeyEvent.getKeyText(key));
//

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
