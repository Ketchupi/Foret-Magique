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
	private boolean panic=false;
	private boolean alive=true;
	private int taille = 4;
	public boolean onGate;
	public boolean tempo=false;
	public Intuition kev;
	
	//MESURE
	private int roche=0;
	private int mouvement=0;
	private int mort=0;
	private boolean mortboolean=false;
	private boolean winboolean=false;
	private int nb_sortie=0;
	private int score=0;
	private RandomMagic generator;
	private Fenetre fenetre;
	private boolean panique = false;
	
	
	//BOUSSOLE
	private boolean droite = false;
	private boolean bas = false;
	private boolean gauche= false;
	private boolean haut = false;
	private Memoire memoire;
	
	public void afficherPlayer(Cellule[][] cellules) {
		// Pour toutes les cases possibles
		this.cellules = cellules;
		for (int y = 0; y < cellules.length ; y++) {
			for (int x = 0; x < cellules.length; x++) {
				// Si la case fait partie des cases de l'environnement et que le
				// robot y etait
				
				cellules[x][y].setPersonne(false);
				
			}
		}
		
		// Une fois la map vide, on ecrit le robot au bon endroit
		cellules[this.positionX][this.positionY].setPersonne(true);
		
	}
	
	public void initPositionPlayer(Fenetre fenetre,RandomMagic generator){
		this.fenetre = fenetre;
		this.generator=generator;
		this.lvl=0;
		this.positionX=0;
		this.positionY=0;
		this.memoire = new Memoire(taille);
		memoire.initMemoire();
	}
	public void initPositionPlayer(int x, int y){
		this.positionX=x;
		this.positionY=y;
	}
	
	public void findGate(){
		if (cellules[positionX][positionY].getGate()==true){
			this.lvl=lvl+1;
			System.out.println(lvl);
			this.alive =false;
			generator.generatePlace(cellules, taille+lvl);
			fenetre.updateFenetre(cellules, taille+lvl);
			
		}this.cellules[positionX][positionY].setGate(false);
	}
	
	public boolean findMonstre(){
		if (cellules[positionX][positionY].getMonstre()==true){
			this.mort++;	
			this.lvl=0;
			this.alive = false;
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
	
	//Convertis les valeurs compteurs en positions i,j pour parcourir la grille ligne par ligne 
	public int[] cptToXY( Cellule[][] Grille, int cpt){
		
		int[] position = null;
		
		if(cpt==0){
			position = droite(positionX, positionY);
			droite = true;
			System.out.println("la position demandée est : {"+position[0]+","+position[1]+"}");
			return position;
		}
		position = droiteKev(positionX, positionY);
		
		System.out.println( positionX + " , " + positionY + " = "+ Grille[positionX][positionY].getConnu());
		
		if(position==null){
			position = surplace(positionX, positionY);
			return position;
		}
		
		return position;
	}
	
	public boolean EndDroite(int i, int j){
		if (i+1<taille){
			return true;
		}
		return false;
	}
	public boolean EndGauche(int i, int j){
		if (i-1>=0){
			return true;
		}
		return false;
	}
	public boolean EndHaut(int i, int j){
		if (j-1>=0){
			return true;
		}
		return false;
	}
	public boolean EndBas(int i, int j){
		if (j+1<taille){
			return true;
		}
		return false;
	}
	
	public int[] droite(int i, int j){
		this.droite = true;
		int[] o = new int[] {i+1,j};
		return o;
	}
	
	public int[] gauche(int i, int j){
		this.gauche = true;
		int[] o = new int[] {i-1, j};
		return o;
	}
	
	public int[] bas(int i, int j){
		this.bas = true;
		int[] o = new int[] {i, j+1};
		return o;
	}
	
	public int[] haut(int i, int j){
		this.haut = true;
		int[] o = new int[] {i,j-1};
		return o;
	}
	
	public int[] droiteKev(int i, int j){
		
		int[] o = null;
		
		if(droite&&this.EndDroite(i, j)){
			o = droite(i,j);
			
		}else if(droite&&!this.EndDroite(i, j)){
			droite = false;
			o = bas(i,j);
			
		}else if(bas&&this.EndBas(i, j)){
			o = bas(i,j);
		}else if(bas&&!this.EndBas(i, j)){
			bas = false;
			o = gauche(i,j);
		}else if(gauche&&this.EndGauche(i, j)){
			o = gauche(i,j);
		}else if(gauche&&!this.EndGauche(i, j)){
			gauche = false;
			o = haut(i,j);
		}else if(haut&&this.EndHaut(i, j)){
			o = haut(i,j);
		}else if(haut&&!this.EndHaut(i, j)){
			haut = false;
			o = droite(i,j);
		}
				
		System.out.println("vecteur d'ordres : {droite, gauche, haut, bas} : {"+droite+","+gauche+","+haut+","+bas+"}" );
		
		return o;
	}
	
	public int[] surplace(int i, int j){
		int[] o = new int[] {i,j};
		return o;
	}
	
	public void bouger(Cellule[][] actuelle, int cpt){
		memoire.enregistrement(positionX, positionY, actuelle);
		Cellule[][] Grille = memoire.getGrille(); 
		int[] pos = cptToXY(Grille, cpt);
		this.setPositionX(pos[0]);
		this.setPositionY(pos[1]);
		System.out.println("cpt = "+cpt);
		/*
		if(cpt==6){
			System.out.println("x, y "+positionX +" "+positionY);
			System.out.println(taille);
			System.out.println((positionX!=taille));
			System.out.println((positionX==taille));
			Cellule[][] cells = memoire.getGrille();
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.println( i+ " , " + j + " = "+ cells[i][j].getConnu());
				}
				
			}
		}*/
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
	public boolean getAlive(){
		return alive;
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

	public boolean isMortboolean() {
		return mortboolean;
	}

	public void setMortboolean(boolean mortboolean) {
		this.mortboolean = mortboolean;
	}

	public boolean isWinboolean() {
		return winboolean;
	}

	public void setWinboolean(boolean winboolean) {
		this.winboolean = winboolean;
	}

}
