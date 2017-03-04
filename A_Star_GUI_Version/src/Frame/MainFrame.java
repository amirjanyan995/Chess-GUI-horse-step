package Frame;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	static final int FRAME_WIDTH=616;
	static final int FRAME_HEIGHT=690;
	
	private  TopPanel topPanel;
	private  SouthPanel southPanel;
	/*
	 * Constructor
	 */
	public MainFrame() {
		super("A * star algorithm");
		setBounds(280, 15, FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		topPanel=new TopPanel(this);
		add(topPanel);
		
		southPanel=new SouthPanel(this);
		add(southPanel);
		
		setVisible(true);
	}

	/*
	 * get Top Panel Class Object
	 */
	public  TopPanel getTopPanel() {
		return topPanel;
	}
	/*
	 * get South panel class object
	 */
	public  SouthPanel getSouthPanel() {
		return southPanel;
	}

}
