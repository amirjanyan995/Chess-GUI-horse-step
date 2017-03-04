package Algorithm;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import Frame.Constants;
import Frame.SouthPanel;

public class Logica implements Constants{
	int mas[][];
	public Logica(int [][] array) {
		this.mas=array;
	}
	public void start(SouthPanel southPanel){
		int start_I = 0,start_J = 0;
		int finish_I = 0,finish_J = 0;
		
		Table<Cell> cellList=new Table<Cell>(WIDTH, HEIGHT);
    	Table<Cell> blockList=new Table<Cell>(WIDTH, HEIGHT);
    	
    	List<Cell> openList=new LinkedList<Cell>();
    	List<Cell> closedList=new LinkedList<Cell>();
    	List<Cell> tempList=new LinkedList<Cell>();
    	
    	for(int i=0;i<mas.length;i++){
    		for(int j=0;j<mas[i].length;j++){
    			if(mas[i][j]==1){
    				blockList.add(new Cell(j,i,true));
    			}else if(mas[i][j]==7){
    				start_I=j;
    				start_J=i;
    			}else if(mas[i][j]==9){
    				finish_I=j;
    				finish_J=i;
    			}
    				
    		}
    	}
        
        for(int i=0;i<WIDTH;i++){
        	for(int j=0;j<HEIGHT;j++){
        		cellList.add(new Cell(j, i, blockList.get(j, i).isBlocked()));
        	}
        }
        
        cellList.get(start_I, start_J).setAsStart();//1-syun/0-tox  j-i
        cellList.get(finish_I, finish_J).setAsFinish();//i-j
        
        Cell start = cellList.get(start_I, start_J);
        Cell finish = cellList.get(finish_I, finish_J);
        
        cellList.printCells();
        
        boolean found=false;
        boolean noRoad=false;
        
        //	1
        openList.add(start);
        
        //	2
        while(!found&&!noRoad){
        	
        	// a
        	Cell current=openList.get(0);
        	
        	for(Cell cell:openList){
        		if(cell.getF()<current.getF())
        			current=cell;
        	}
        	// b
        	closedList.add(current);
        	openList.remove(current);
        	// c
        	tempList.clear();
        	
        	//hor-uxah
        	/*
        	tempList.add(cellList.get(current.getX(),  current.getY()+1));
        	tempList.add(cellList.get(current.getX()+1,current.getY()  ));
        	tempList.add(cellList.get(current.getX()-1,current.getY()  ));
        	tempList.add(cellList.get(current.getX(),  current.getY()-1));
        	*/
        	//ankyunagic
        	tempList.add(cellList.get(current.getX()-1,current.getY()-1));
        	tempList.add(cellList.get(current.getX()-1,current.getY()+1));
        	tempList.add(cellList.get(current.getX()+1,current.getY()+1));
        	tempList.add(cellList.get(current.getX()+1,current.getY()-1));
        	
        	for(Cell neighbour:tempList){
        		// *
        		if(neighbour.isBlocked()||closedList.contains(neighbour)){
        			continue;
        		}
        		// *
        		if(!openList.contains(neighbour)){
        			//southPanel.getSmallPanelByIndex(neighbour.getY(), neighbour.getX()).setBackground(BG_START_COLOR);
        			openList.add(neighbour);
        			
        			neighbour.setParent(current);
        			
        			neighbour.setH(neighbour.manDist(finish));
        			neighbour.setG(start.price(current));
        			neighbour.setF(neighbour.getH()+neighbour.getG());
        			continue;
        		}
        		// *
        		if(openList.contains(neighbour)){
	        		if(neighbour.getG()+neighbour.price(current)<current.getG()){
	        			neighbour.setParent(current);
	        			neighbour.setH(neighbour.manDist(finish));
	        			neighbour.setG(start.price(current));
	        			neighbour.setF(neighbour.getH()+neighbour.getG());
	        		}
        		}
        	}
        	//d
        	if(openList.contains(finish)){
        		found=true;
        	}
        	if(openList.isEmpty())
        		noRoad=true;
        	
        }
        
        int a=0;
        if(!noRoad){
        	Cell roadDown=finish.getParent();
        	while(!roadDown.equals(start)){
        		southPanel.getSmallPanelByIndex(roadDown.getY(), roadDown.getX()).setBackground(BG_ROAD_COLOR);
        		a++;
        		roadDown.setRoad(true);
        		roadDown=roadDown.getParent();
        		if(roadDown==null)
        			break;
        	}
        	cellList.printCells();
        }else{
        	System.out.println("chanaparh chka");
        }
        System.out.println("shagi-"+a);
        
    	
	}
}
