package Frame;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SmallPanel extends JPanel implements Constants {
	static final int SMALL_PANEL_WIDTH=20;
	static final int SMALL_PANEL_HEIGHT=20;
	
	static boolean IS_PRESEED=false;
	/*
	private final static Color BG_START_COLOR=Color.BLACK;			//1
	private final static Color BG_FINISH_COLOR=Color.RED;			//2
	private final static Color BG_WALL_COLOR=new Color(80,90,250);	//3
	private final static Color BG_FON_COLOR=new Color(17,89,20);	//4
	private final static Color BG_ROAD_COLOR=Color.RED;				//5
	*/
	private static Color BG_COLOR=BG_FON_COLOR;
	private static TopPanel topPanel;
	public SmallPanel(MainFrame mainFrame) {
			this.topPanel=mainFrame.getTopPanel();
			setSize(SMALL_PANEL_WIDTH, SMALL_PANEL_HEIGHT);
			setBackground(BG_COLOR);
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			initListener();
	}
	
	private void initListener(){
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				IS_PRESEED=false;
				BG_COLOR=BG_FON_COLOR;
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				IS_PRESEED=true;
				if(getBackground()==BG_WALL_COLOR){
					BG_COLOR=BG_FON_COLOR;
				}else if(topPanel.wallIsSelected()){
					BG_COLOR=BG_WALL_COLOR;
				}
				setBackground(BG_COLOR);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(IS_PRESEED)
					setBackground(BG_COLOR);
				
			}
		});
	}
	public static void setBgColorR(int COLOR_INDEX) {
		if(COLOR_INDEX>=MIN_INDEX&&COLOR_INDEX<=MAX_INDEX){
			switch (COLOR_INDEX) {
				case START_INDEX:
					//System.out.println("start");
					BG_COLOR=BG_START_COLOR;
					break;
				case FINISH_INDEX:
					//System.out.println("Finish");
					BG_COLOR=BG_FINISH_COLOR;
					break;
				case WALL_INDEX:
					//System.out.println("Wall");
					BG_COLOR=BG_WALL_COLOR;
					break;
				case FON_INDEX:
					BG_COLOR=BG_FON_COLOR;
					break;
				case ROAD_INDEX:
					BG_COLOR=BG_ROAD_COLOR;
					break;
			}
		}
	}
	public void resetpanel(){
		BG_COLOR=BG_FON_COLOR;
		setBackground(BG_COLOR);
	}
}
