package Agent;

import Environement.Cellule;

public class AgentPlayer {
	
	private int positionX;
	private int positionY;
	private int positionABSX;
	private int positionABSY;
	private Cellule[][] cellules;
	private int lvl;
	private boolean onGate;
	public boolean tempo=false;
	
	//MESURE
	private int roche=0;
	private int mouvement=0;
	private int mort=0;
	private int nb_sortie=0;
	private int score=0;
	
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
		this.lvl=0;
		this.positionX=1;
		this.positionY=0;
	}
	public void initPositionPlayer(int x, int y){
		this.positionX=x;
		this.positionY=y;
	}
	
	public int findGate(){
		if (cellules[positionX][positionY].getGate()==true && tempo == false){
			lvl++;
			System.out.println(lvl);
			tempo = true;
			this.nb_sortie++;
			return lvl;
		}
		return lvl;
	}
	
	public boolean findMonstre(){
		if (cellules[positionX][positionY].getMonstre()==true){
			this.mort++;	
			System.out.println(mort);
			return true;
		}
		return false;
	}
	
	/**
	 * MESURE DE PERFORMANCE
	 * @return
	 */
	
	public int scoreAgentPlayer(){
		
		return score;
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

	public boolean isOnGate() {
		return onGate;
	}

	public void setOnGate(boolean onGate) {
		this.onGate = onGate;
	}

	public int getRoche() {
		return roche;
	}

	public void setRoche(int roche) {
		this.roche = roche;
	}

	public int getMouvement() {
		return mouvement;
	}

	public void setMouvement(int mouvement) {
		this.mouvement = mouvement;
	}

	public int getMort() {
		return mort;
	}

	public void setMort(int mort) {
		this.mort = mort;
	}

	public int getNb_sortie() {
		return nb_sortie;
	}

	public void setNb_sortie(int nb_sortie) {
		this.nb_sortie = nb_sortie;
	}

}
