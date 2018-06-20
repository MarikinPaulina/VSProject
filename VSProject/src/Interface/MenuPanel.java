package Interface;
//Wykonanie: Paulina Marikin
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

	public MenuPanel() {
		
	}

	public MenuPanel(LayoutManager layout, final MainFrame frame) {
		super(layout);
		final MenuPanel panel = this;
		URL resource = getClass().getResource("/pictures/background.jpg");
		try {
		back = ImageIO.read(resource);
		} catch (IOException e) {
		System.err.println("Blad odczytu obrazka");
		e.printStackTrace();
		}
		this.add(startB);
		this.add(loadB);
//		this.add(optionsB);
		this.add(exitB);
		startB.setBounds(250,500,170,30);
		loadB.setBounds(260,540,170,30);
		loadB.setBackground(Color.gray);
		optionsB.setBounds(270,580,170,30);
		exitB.setBounds(280,620,170,30);
		ActionListener exitListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}

		};
		exitB.addActionListener(exitListener);
		
		ActionListener optionsListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				frame.layout.show(frame.mainP, "options");
			}

		};
		optionsB.addActionListener(optionsListener);
		ActionListener startListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				frame.layout.show(frame.mainP, "init");
			}

		};
		startB.addActionListener(startListener);
	}
	
	


	public MenuPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public MenuPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public void paintComponent(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g;
		 g2d.drawImage(back, 0, 0, this);
		 }
	
	JButton loadB  = new JButton("Wczytaj");
	JButton startB  = new JButton("Nowa gra");
	JButton optionsB  = new JButton("Opcje");
	JButton exitB  = new JButton("Wyjście");
	MainFrame frame;
	BufferedImage back;
	
}
