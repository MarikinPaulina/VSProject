package Interface;
//Julia Winogrodzka
import Map.ClassicSolarSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class InitPanel extends JPanel {
	private JButton chooseMapB;
	private BufferedImage back;
	private int x = 500;
	private int y = 100;
	private Dimension dim = new Dimension(350,200);
	public InitPanel() {}

	public InitPanel(LayoutManager layout, final MainFrame frame) {
		super(layout);
		final InitPanel panel = this;
		URL resource = getClass().getResource("/pictures/background.jpg");
		try {
		back = ImageIO.read(resource);
		} catch (IOException e) {
		System.err.println("Blad odczytu obrazka");
		e.printStackTrace();
		}
		JLabel instructionL = new JLabel("<html>"+ "Celem gry jest wylądowanie na zielonej planecie <br><br>" +
				"Używając strzałek zmieniasz prędkość statku <br><br>"+
				"Strzałki góra/dół wpływają na twoją prędkość w kierunku w jakim jest zwrócony dziób statku  <br><br>  " +
				"Strzałki lewo/prawo zmieniają prędkość kątową<br> statku" + "</html>");
		instructionL.setForeground(Color.white);
		instructionL.setBounds(x+5,y,400,150);
		this.add(instructionL);
		chooseMapB = new JButton("Zaczynamy");
		chooseMapB.setBounds(x+75,y+160,170,30);
		this.add(chooseMapB);
		ActionListener chooseMapListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				frame.gameP.mapCSS = new ClassicSolarSystem();
				frame.layout.show(frame.mainP, "game");
				frame.gameP.isVisible = true;
				frame.requestFocusInWindow();
			}

		};
		chooseMapB.addActionListener(chooseMapListener);
		

	}

	public InitPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public InitPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(back, 0, 0, this);
		Color kolor = new Color(20,20,20,90);
		g2d.setColor(kolor);
		g2d.fillRect(0, 0, 2000, 1000);
		g2d.setPaint(new GradientPaint(x,y,new Color(20,20,20),x,y+dim.height,new Color(50,50,50)));
		g2d.fillRect(x, y, dim.width, dim.height);
 		}

}
