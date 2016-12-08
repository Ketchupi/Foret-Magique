package Agent;

import Environement.Cellule;
import Environement.Fenetre;
import Generation.RandomMagic;

public class AgentPlayer {
	
	private int positionX;
	private int positionY;
	private int positionABSX;
	private int positionABSY;
	private Cellule[][] cellules;
	public int lvl=0;
	private int taille = 4;
	public boolean onGate;
	public boolean tempo=false;
	public Intuition kev;
	
	//MESURE
	private int roche=0;
	private int mouvement=0;
	private int mort=0;
	private int nb_sortie=0;
	private int score=0;
	private RandomMagic generator;
	private Fenetre fenetre;
	private boolean panique = false;
	
	private Memoire memoire;
	
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
	
	public void initPositionPlayer(Fenetre fenetre,RandomMagic generator){
		this.fenetre = fenetre;
		this.generator=generator;
		this.lvl=0;
		this.positionX=0;
		this.positionY=0;
		this.memoire = new Memoire(taille+lvl);
		
	}
	public void initPositionPlayer(int x, int y){
		this.positionX=x;
		this.positionY=y;
	}
	
	public void findGate(){
		if (cellules[positionX][positionY].getGate()==true){
			this.lvl=lvl+1;
			System.out.println(lvl);
			
			generator.generatePlace(cellules, taille+lvl);
			fenetre.updateFenetre(cellules, taille+lvl);
			
		}this.cellules[positionX][positionY].setGate(false);
	}
	
	public boolean findMonstre(){
		if (cellules[positionX][positionY].getMonstre()==true){
			this.mort++;	
			this.lvl=0;
			this.cellules[0][0].setPersonne(true);
			generator.generatePlace(cellules, taille);
			fenetre.updateFenetre(cellules, taille);

			System.out.println("mort");
			return true;
		}
		return false;
	}
	
	public boolean findPit(){
		if (cellules[positionX][positionY].getTrou()==true){
			this.mort++;	
			this.lvl=0;
			generator.generatePlace(cellules, taille);
			fenetre.updateFenetre(cellules, taille);
			this.cellules[0][0].setPersonne(true);
			System.out.println("mort");
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
	
	public void bouger(int cpt){
		int k = 0; 
		if(cpt<taille){
			
			this.setPositionX(cpt-k*taille);
			this.setPositionY(k);
			memoire.enregistrement(cpt, 0, cellules);
			
		}else if(cpt==k*taille)
		{
			k+=1;
			System.out.println("je suis au bout de la foret");
		}
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

	public boolean isPanique() {
		return panique;
	}

	public void setPanique(boolean panique) {
		this.panique = panique;
	}

}
