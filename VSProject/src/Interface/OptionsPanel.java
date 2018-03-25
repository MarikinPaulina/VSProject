package Interface;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionsPanel extends JPanel {

	public OptionsPanel(final MainFrame frame) {
		this.setBackground(Color.black);
		this.add(backB);
		ActionListener backListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				frame.layout.show(frame.mainP, "menu");
			}

		};
		backB.addActionListener(backListener);
	}

	public OptionsPanel(LayoutManager layout) {
		super(layout);
		
	}

	public OptionsPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public OptionsPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	JButton backB = new JButton("wróć");
	MainFrame frame;
}
