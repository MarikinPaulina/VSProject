package Interface;
//Julia Winogrodzka
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

public class InitPanel extends JPanel {
	private JButton chooseMapB;
	private JButton createMapB;
	BufferedImage back;
	public InitPanel() {
		// TODO Auto-generated constructor stub
	}

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
		chooseMapB = new JButton("Wybor mapy");
		chooseMapB.setBounds(250,500,170,30);
		this.add(chooseMapB);
		ActionListener chooseMapListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				frame.layout.show(frame.mainP, "game");
				frame.gameP.isVisible = true;
			}

		};
		chooseMapB.addActionListener(chooseMapListener);
		
		createMapB = new JButton("Projektuj mapę");
		createMapB.setBounds(250,540,170,30);
		this.add(createMapB);
		ActionListener chooseCreateListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				//frame.layout.show(frame.mainP, "");
			}

		};
		createMapB.addActionListener(chooseCreateListener);
		
		
		// TODO Auto-generated constructor stub
	}

	public InitPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public InitPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	
	public void paintComponent(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g;
		 g2d.drawImage(back, 0, 0, this);
		 }
}
