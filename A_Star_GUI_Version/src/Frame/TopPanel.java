package Frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import Algorithm.Logica;

public class TopPanel extends JPanel implements Constants,ActionListener {
	/*
	 *  
	 */
	static final int TOP_PANEL_WIDTH=600;
	static final int TOP_PANEL_HEIGHT=50;
	static final Color TP_BG_COLOR=new Color(224,224,224);
	/**
	 * 
	 */
	private JCheckBox wall=new JCheckBox("Стена");
	private JCheckBox start=new JCheckBox("Начало");
	private JCheckBox finish=new JCheckBox("Конец");
	private JButton startButton=new JButton("Start");
	private JButton resteButton=new JButton("Clear");
	//=========================================================//
	private MainFrame mainFrame;
	/*
	 * 	Constructor
	 */
	public TopPanel(MainFrame mainFrame) {
		this.setMainFrame(mainFrame);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(TOP_PANEL_WIDTH, TOP_PANEL_HEIGHT);
		setBackground(TP_BG_COLOR);
		setLocation(0,0);

		checkBoxConfig();
	}
	/*
	 * check box initialization
	 * and configuration
	 */
	private void checkBoxConfig(){
		ButtonGroup group=new ButtonGroup();
		wall.setFocusPainted(false);
		wall.setBackground(TP_BG_COLOR);
		start.setFocusPainted(false);
		start.setBackground(TP_BG_COLOR);
		finish.setFocusPainted(false);
		finish.setBackground(TP_BG_COLOR);
		
		group.add(wall);
		group.add(start);
		group.add(finish);
		
		add(wall,FlowLayout.LEFT);
		add(start);
		add(finish);
		add(startButton);
		add(resteButton);
		startButton.setFocusPainted(false);
			startButton.addActionListener(this);
		resteButton.setFocusPainted(false);
			resteButton.addActionListener(this);
		// Wall listener
		wall.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SmallPanel.setBgColorR(WALL_INDEX);
			}
		});
		
		// Start listener
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SmallPanel.setBgColorR(START_INDEX);
			}
		});
		
		// Finish listener
		finish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SmallPanel.setBgColorR(FINISH_INDEX);
			}
		});
	}
	
	public boolean wallIsSelected() {
		return wall.isSelected();
	}
	
	public boolean startIsSelected(){
		return start.isSelected();
	}
	
	public boolean finishIsSelected() {
		return finish.isSelected();
	}
	
	public void startSetEnabled(boolean arg) {
		start.setEnabled(arg);
	}
	public void finishSetEnabled(boolean arg) {
		finish.setEnabled(arg);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startButton){
			Logica log=new Logica(mainFrame.getSouthPanel().getArray());
			log.start(mainFrame.getSouthPanel());
		}else if(e.getSource()==resteButton){
			mainFrame.getSouthPanel().smallPanelReset();
		}
		
	}
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
