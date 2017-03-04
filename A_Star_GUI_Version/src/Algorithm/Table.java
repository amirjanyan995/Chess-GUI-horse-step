package Algorithm;

import Frame.Constants;

public class Table<T extends Cell> implements Constants {
	private int width;
	private int height;
	private Cell[][] table;
	/*
	 * 
	 */
	public Table(int width,int heght){
		this.width=width;
		this.height=heght;
		this.table=new Cell[width][heght];
		
		for(int i=0;i<table.length;i++){
			for(int j=0;j<table[i].length;j++){
				table[i][j]=new Cell(0,0,false);
			}
		}
	}
	/*
	 * Add cell on table
	 */
	public void add(Cell cell){
		table[cell.getX()][cell.getY()]=cell;
	}
	/*
	 * get Cell 
	 */
	public T get(int x,int y){
		if (x < width && x >= 0 && y < height && y >= 0) {
            return (T)table[x][y];
        }
		return (T)(new Cell(0,0,true));
	}
	/*
	 * print all cells
	 */
	public void printCells(){
		for(int i=0;i<WIDTH;i++){
			for(int j=0;j<HEIGHT;j++){
				System.out.print(this.get(j,i));
			}
			System.out.println();
		}
		System.out.println();
	}
}

