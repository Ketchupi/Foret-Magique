package Agent;

import Environement.Cellule;

public class AgentPlayer {
	
	private int positionX;
	private int positionY;
	private int positionABSX;
	private int positionABSY;
	private Cellule[][] cellules;
	
	public void afficherPlayer(Cellule[][] cellules) {
		// Pour toutes les cases possibles
		this.cellules = cellules;
		for (int y = 0; y < cellules.length ; y++) {
			for (int x = 0; x < cellules.length; x++) {
				// Si la case fait partie des cases de l'environnement et que le
				// robot y était
				
				cellules[x][y].setPersonne(false);
				
			}
		}
		// Une fois la map vide, on écrit le robot au bon endroit
		cellules[this.positionX][this.positionY].setPersonne(true);
	}
	
	public void initPositionPlayer(){
		this.positionX=1;
		this.positionY=0;
	}
	public void initPositionPlayer(int x, int y){
		this.positionX=x;
		this.positionY=y;
	}
	
	public int findGate(){
		if (cellules[positionX][positionY].getGate()==true){
			return 1;
		}
		return 0;
	}
	
	
	
	
	
	
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public int getPositionABSX() {
		return positionABSX;
	}
	public void setPositionABSX(int positionABSX) {
		this.positionABSX = positionABSX;
	}
	public int getPositionABSY() {
		return positionABSY;
	}
	public void setPositionABSY(int positionABSY) {
		this.positionABSY = positionABSY;
	}

}
