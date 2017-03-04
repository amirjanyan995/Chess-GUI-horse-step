package Frame;

import java.awt.Color;

public interface Constants {
	/**
	 * Colors
	 */
	final  Color BG_START_COLOR=Color.WHITE;			//1
	final  Color BG_FINISH_COLOR=Color.YELLOW;			//2
	final  Color BG_WALL_COLOR=Color.BLUE;				//3
	final  Color BG_FON_COLOR=new Color(17,89,20);		//4
	final  Color BG_ROAD_COLOR=Color.RED;				//5
	/**
	 * Color Index
	 */
	final int MIN_INDEX=1,MAX_INDEX=5;
	final int START_INDEX=1;	//1
	final int FINISH_INDEX=2;	//2
	final int WALL_INDEX=3;		//3
	final int FON_INDEX=4;		//4
	final int ROAD_INDEX=5;		//5
	/**
	 * Array lenghts
	 */
	final int VERTICAL_LENGTH=30;
	final int HORIZONTAL_LENGTH=30;
	//==============================//
	final int WIDTH = VERTICAL_LENGTH;
    final int HEIGHT = HORIZONTAL_LENGTH;
}
