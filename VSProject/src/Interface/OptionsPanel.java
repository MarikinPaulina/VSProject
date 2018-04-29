package Interface;
//Julia Winogrodzka
import java.awt.LayoutManager;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;




import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class OptionsPanel extends JPanel {
	
	static final int SLIDER_MIN = 0;
	static final int SLIDER_MAX = 100;
	static final int SLIDER_INIT = 0;
	private JLabel lSound, lEffects;
	private JSlider sSound, sEffects;
	private int soundLevel, effectsLevel;
	private JComboBox<String> cLanguage;
	String[] languages = {"polski", "english", "deutsch" };
	//private JComboBox<String> cLanguage;
	private JButton bBackMenu;
	MainFrame frame;
	BufferedImage back;
	
	public OptionsPanel() {
		// TODO Auto-generated constructor stub
	}

	public OptionsPanel(LayoutManager layout, final MainFrame frame) {
		
		super(layout);
		final OptionsPanel panel = this;
		URL resource = getClass().getResource("/pictures/background.jpg");
		try {
		back = ImageIO.read(resource);
		} catch (IOException e) {
		System.err.println("Blad odczytu obrazka");
		e.printStackTrace();
		}
		
		sSound = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
		sSound.setBounds(185, 500, 300, 30);
		sSound.setMajorTickSpacing(20);
		sSound.setMinorTickSpacing(5);
		sSound.setPaintTicks(true);
		sSound.setPaintLabels(true);
		this.add(sSound);
		lSound = new JLabel("Głośność dźwięku ");
		lSound.setBounds(500, 500, 300, 30);
		this.add(lSound);
		sSound.addChangeListener(new SliderSoundChangeListener() );
		
		
		sEffects = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
		sEffects.setBounds(185, 540, 300, 30);
		sEffects.setMajorTickSpacing(20);
		sEffects.setMinorTickSpacing(5);
		sEffects.setPaintTicks(true);
		sEffects.setPaintLabels(true);
		this.add(sEffects);
		lEffects = new JLabel("Głośność efektów ");
		lEffects.setBounds(500, 540, 300, 30);
		this.add(lEffects);
		
		sEffects.addChangeListener(new SliderEffectsChangeListener() );
		
		cLanguage = new JComboBox<String>(languages);
		cLanguage.setBounds(250, 580, 170, 30);
		//cLanguage.addItem("polski");
		//cLanguage.addItem("english");
		//cLanguage.addItem("deutsch");
		this.add(cLanguage);
		cLanguage.addItemListener(new ComboBoxItemListener());
		
		bBackMenu = new JButton("Powrot do menu glownego");
		bBackMenu.setBounds(240, 620, 180, 30);
		this.add(bBackMenu);
		ActionListener backMenuListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				frame.layout.show(frame.mainP, "menu");
			}

		};
		bBackMenu.addActionListener(backMenuListener);
	}

	public OptionsPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public OptionsPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	//Inner Classes for sliders
	public class SliderSoundChangeListener implements ChangeListener{

			@Override
			public void stateChanged(ChangeEvent arg0) {
				soundLevel = sSound.getValue();
				lSound.setText("Głośność dźwięku: " + soundLevel);
				
			}
		
	}
	
	public class SliderEffectsChangeListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent arg0) {
			effectsLevel = sSound.getValue();
			lEffects.setText("Głośność dźwięku: " + effectsLevel);
			
		}
	//Inner Class for ComboBox
	}
	public class ComboBoxItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			
			String language = cLanguage.getSelectedItem().toString();
			
			if(language.equals("polski")) {
				//language function
			}
			else if(language.equals("english")) {
				//language function
			}
			else if(language.equals("deutsch")) {
				//language function
			}
			
		}
		
	}
	
	public void paintComponent(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g;
		 g2d.drawImage(back, 0, 0, this);
	}
	
}
