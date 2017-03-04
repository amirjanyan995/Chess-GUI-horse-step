package Frame;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SouthPanel extends JPanel implements Constants{
	static final int SOUTH_PANEL_WIDTH=600;
	static final int SOUTH_PANEL_HEIGHT=600;
	
	private Color bgColor=Color.black;
	
	private MainFrame mainFrame;
	private TopPanel topPanel;
	
	private SmallPanel [][]smallPanel=new SmallPanel[VERTICAL_LENGTH][HORIZONTAL_LENGTH];
	private int [][]gameArray=new int[VERTICAL_LENGTH][HORIZONTAL_LENGTH];
	public SouthPanel(MainFrame mainFrame){
		this.mainFrame=mainFrame;
		this.topPanel=mainFrame.getTopPanel();
		setSize(SOUTH_PANEL_WIDTH, SOUTH_PANEL_HEIGHT);
		setLocation(0,TopPanel.TOP_PANEL_HEIGHT);
		setLayout(new GridLayout(VERTICAL_LENGTH, HORIZONTAL_LENGTH));
		smalPanelInit();
	}
	/**
	 * 
	 */
	public void smalPanelInit(){
		for(int i=0;i<smallPanel.length;i++){
			for(int j=0;j<smallPanel[i].length;j++){
				smallPanel[i][j]=new SmallPanel(mainFrame);
				add(smallPanel[i][j]);
			}
		}
	}
	/**
	 * 
	 */
	public void smallPanelReset(){
		for(int i=0;i<smallPanel.length;i++){
			for(int j=0;j<smallPanel[i].length;j++){
				smallPanel[i][j].resetpanel();
			}
		}
	}
	/**
	 * 
	 */
	public SmallPanel getSmallPanelByIndex(int i, int j){
		return smallPanel[i][j];
	}
	/**
	 * 
	 * @return
	 */
	public int[][] getArray(){
		for(int i=0;i<gameArray.length;i++){
			for(int j=0;j<gameArray[i].length;j++){
				if(smallPanel[i][j].getBackground()==BG_FON_COLOR){
					//gameArray[i][j]=FON_INDEX;
					gameArray[i][j]=0;
				}else if(smallPanel[i][j].getBackground()==BG_WALL_COLOR){
					//gameArray[i][j]=WALL_INDEX;
					gameArray[i][j]=1;
				}else if(smallPanel[i][j].getBackground()==BG_START_COLOR){
					//gameArray[i][j]=START_INDEX;
					gameArray[i][j]=7;
				}else if(smallPanel[i][j].getBackground()==BG_FINISH_COLOR){
					//gameArray[i][j]=FINISH_INDEX;
					gameArray[i][j]=9;
				}
				System.out.print(gameArray[i][j]+" ");
			}
			System.out.println();
		}
		return gameArray;
	}
	/**
	 * 
	 * @return
	 */
	public Color getBgColor() {
		return bgColor;
	}
	/**
	 * 
	 * @param bgColor
	 */
	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
		setBackground(bgColor);
	}

}
