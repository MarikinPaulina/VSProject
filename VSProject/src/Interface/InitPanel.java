package Interface;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InitPanel extends JPanel {

	public InitPanel(final MainFrame frame) {
		this.setBackground(Color.gray);
		this.add(startB);
		ActionListener startListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				frame.layout.show(frame.mainP, "game");
			}

		};
		startB.addActionListener(startListener);
	}

	public InitPanel(LayoutManager layout) {
		super(layout);
		this.setBackground(Color.gray);
	}

	public InitPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public InitPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	JButton startB = new JButton("Start");
	MainFrame frame;

}
