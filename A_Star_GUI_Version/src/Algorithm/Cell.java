package Algorithm;

public class Cell {
	// Cordinats
	private int x = -1;
	private int y = -1;

	// Cell Information
	private Cell parent = this;
	private boolean blocked = false;
	private boolean start = false;
	private boolean finish = false;
	private boolean road = false;

	// Cell Data
	private int F = 0;
	private int G = 0;
	private int H = 0;

	/**
	 * Stexcum e nor vandak X,Y kordinatnerov
	 * 
	 * @param blocked
	 *            - hamarvum e vandak@ anancaneli
	 */
	public Cell(int x, int y, boolean blocked) {
		this.x = x;
		this.y = y;
		this.blocked = blocked;
	}

	/**
	 * Hashvum e MANXETENYAN heravorutyun@ Start -> Finish
	 * 
	 * @param finish
	 *            - verjnakan ket
	 * @return - heravorutyun
	 */
	public int manDist(Cell finish){
		return 10* (Math.abs(this.x-finish.x)+Math.abs(this.y-finish.y));
	}
	/**
	 * chanaparhi arjeq@ depi harevan vandak 
	 * 
	 * @param neighbor - harevan vandak 
	 * 
	 * @return 10 - ete harevan vandak@ horizonakan e
	 * 		   14 - ete harevan vandak@ ankyunagcov e
	 */
	public int price(Cell neighbor){
		if(this.x==neighbor.x||this.y==neighbor.y){
			return 10;
		} else {
			return 14;
		}
	}
	/**
	 * Nshanakum e vandak@ vorpes skizb
	 */
	public void setAsStart(){
		this.start=true;
	}
	/**
	 * nshankum e vorpes verj (Finish)
	 */
	public void setAsFinish(){
		this.finish=true;
	}
	/**
	 * Vandakneri hamematutyun
	 * 
	 * @param second - erkrord vandak 
	 * 
	 * @return true - ete kordinatner@ hamnknum en 
	 *         false - ete chen hamnknum
	 */
	public boolean equals(Cell second){
		return(this.x== second.x)&&(this.y==second.y);
	}
	/** 
	 * Tpum e gexecik :)
	 * -> * - chanaparh
	 * -> S - Start
	 * -> F - Finish
	 * -> # - anancaneli
	 * -> . - sovorakan
	 * 
	 * @return vandaki toxayin nerkayacum@
	 */
	public String toString(){
		
		if(this.road)
			return " * ";
		if(this.start){
			return " S ";
		}
		if(this.finish)
			return " F ";
		
		if(this.blocked)
			return " # ";
		
		return "   ";
	}
	/*
	 *  X
	 */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	/*
	 *  Y
	 */
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	/*
	 * Parent
	 */
	public Cell getParent() {
		return parent;
	}

	public void setParent(Cell parent) {
		this.parent = parent;
	}
	/*
	 * Blocked
	 */
	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	/*
	 * Start
	 */
	public boolean isStart() {
		return start;
	}
	/*
	 * Finish
	 */
	public boolean isFinish() {
		return finish;
	}
	/*
	 * F
	 */
	public int getF() {
		return F;
	}

	public void setF(int f) {
		F = f;
	}
	/*
	 * G
	 */
	public int getG() {
		return G;
	}

	public void setG(int g) {
		G = g;
	}
	/*
	 * H
	 */
	public int getH() {
		return H;
	}

	public void setH(int h) {
		H = h;
	}
	/*
	 * Road
	 */
	public boolean isRoad() {
		return road;
	}

	public void setRoad(boolean road) {
		this.road = road;
	}
}
