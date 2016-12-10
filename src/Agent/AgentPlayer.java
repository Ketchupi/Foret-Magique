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
	private int newTaille = taille + lvl;
	
	
	//BOUSSOLE
	private boolean droite = false;
	private boolean bas = false;
	private boolean gauche= false;
	private boolean haut = false;
	private Memoire memoire;
	
	public void afficherPlayer() {

		
		//On recupère le tab de cellule de fenetre a des changement
		this.cellules = fenetre.getCelluleFenetre();
		// Par précaution je vire tout
		for (int y = 0; y < cellules.length ; y++) {
			for (int x = 0; x < cellules.length; x++) {
				cellules[x][y].setPersonne(false);	
			}
		}
		// Une fois la map vide, on ecrit le robot au bon endroit
		cellules[this.positionX][this.positionY].setPersonne(true);
		//On redéfinit la taille + le niveau ou on en est
		this.newTaille = taille+lvl;
		
	}
	
	//Méthode de départ de kevin, lors d'un echec + mémoire clean
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
			this.newTaille = taille+lvl;
			System.out.println(lvl);
			this.alive =true;
			cellules = fenetre.initCellule(newTaille);
			generator.generatePlace(cellules, newTaille);
			fenetre.updateFenetre(cellules, newTaille);
			
			//On définit la mémoire de Kevin
			this.memoire = new Memoire(newTaille);
			memoire.initMemoire();
			
			
		}this.cellules[positionX][positionY].setGate(false);
	}
	
	public boolean findMonstre(){
		//Obligé de faire ce test car lorsqu'on rapetisse on garde encore un tour le truc en mémoire et ça plante
		if(positionX<newTaille && positionX<newTaille){
			
			if (cellules[positionX][positionY].getMonstre()==true){
				this.mort++;	
				this.lvl=0;
				this.alive = false;
				this.cellules[0][0].setPersonne(true);
				
				cellules = fenetre.initCellule(taille);
				generator.generatePlace(cellules, taille);
				fenetre.updateFenetre(cellules, taille);
				
				//On définit la mémoire de Kevin
				this.memoire = new Memoire(taille);
				memoire.initMemoire();
				
				System.out.println("mort");
				return true;
			}
		}
		return false;
	}
	
	public boolean findPit(){
		//Obligé de faire ce test car lorsqu'on rapetisse on garde encore un tour le truc en mémoire et ça plante
		if(positionX<newTaille && positionX<newTaille){
			
			if (cellules[positionX][positionY].getTrou()==true){
				this.mort++;	
				this.lvl=0;
				this.alive = false;
				
				cellules = fenetre.initCellule(taille);
				generator.generatePlace(cellules, taille);
				fenetre.updateFenetre(cellules, taille);
				this.cellules[0][0].setPersonne(true);
				
				//On définit la mémoire de Kevin
				this.memoire = new Memoire(taille);
				memoire.initMemoire();
				
				
				System.out.println("mort");
				return true;
			}
			
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

			return position;
		}
		
<<<<<<< HEAD
		//SI X DIFFERENT BORD DROIT
		if(positionX!=(newTaille-1)){	
			if(testEndDroite(positionX, positionY)==true){
				if(Grille[positionX+1][positionY].getConnu()==false){
					position = droite(positionX, positionY);
				}
				// ? 
			}else{
				position = bas(positionX, positionY);
			}
			
		}
		if(positionX==newTaille-1){
			if(testEndBas(positionX, positionY)==true){
				if(Grille[positionX][positionY+1].getConnu()==false){
					position = bas(positionX, positionY);
				}
			}
			else{
				position = gauche(positionX, positionY);
			}
		}
		if(positionY==newTaille-1){
			if(testEndGauche(positionX, positionY)==true){
				if(Grille[positionX-1][positionY].getConnu()==false){
					position = gauche(positionX, positionY);
				}
			}
			else{
				position = haut(positionX, positionY);
			}
		}
=======
		position = droiteKev(Grille, positionX, positionY);
>>>>>>> 626a1d531b09a5913e901a90b42a0a2426745577
		
		System.out.println( positionX + " , " + positionY + " = "+ Grille[positionX][positionY].getConnu());
		
		if(position==null){
			position = surplace(positionX, positionY);
			return position;
		}
		
		//System.out.println("ma m�moire me dis que la prochaine case {"+ position[0] + ","+ position[1] +"} connue : " + this.KnownPlace(Grille, position[0], position[1]));

		return position;
	}

	
<<<<<<< HEAD
	public boolean testEndDroite(int i, int j){
		if (i+1<newTaille){
=======
	public boolean NextBoxIsNew(Cellule[][] grille, int i, int j){
		
		int[] NextPosition = droiteKev(grille, i,j);
		
		if(KnownPlace(grille, NextPosition[0], NextPosition[1])){
			return false;
		}
		
		return true;
	}
	public boolean KnownPlace(Cellule[][] grille, int i, int j){
		
		if(grille[i][j].getConnu()){
			return true;
		}
		return false;
	}
	
	public boolean EndDroite(int i, int j){
		if (i+1<taille){
>>>>>>> 626a1d531b09a5913e901a90b42a0a2426745577
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
<<<<<<< HEAD
	public boolean testEndBas(int i, int j){
		if (j+1<newTaille){
=======
	
	public boolean EndBas(int i, int j){
		if (j+1<taille){
>>>>>>> 626a1d531b09a5913e901a90b42a0a2426745577
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
	
	public int[] toutDroitKev(int i, int j){
		int[] o = null;
		
		if(droite){

			o = droite(i,j);
			
		}else if(bas){
			
			o = bas(i,j);
			
		}else if(gauche){
			
			o = gauche(i,j);
			
		}else if(haut){
				o = haut(i,j);
		}
		
		return o;
	}
	
	public int[] droiteKev(Cellule[][] memoire, int i, int j){
		
		int[] o = null;
		
		if(droite&&this.EndDroite(i, j)){
			
			if(!NextBoxIsNew(memoire, toutDroitKev(i,j)[0], toutDroitKev(i,j)[1])){
				droite = false;
				o = bas(i,j);
			}else{
			o = droite(i,j);
			}
		}else if((droite&&!this.EndDroite(i, j))){
			droite = false;
			o = bas(i,j);
			
		}else if(bas&&this.EndBas(i, j)){
			
			if(!NextBoxIsNew(memoire, toutDroitKev(i,j)[0], toutDroitKev(i,j)[1])){
				
				bas = false;
				o = gauche(i,j);
			}else{
			o = bas(i,j);
			}
			
		}else if(bas&&!this.EndBas(i, j)){
			bas = false;
			o = gauche(i,j);
		}else if(gauche&&this.EndGauche(i, j)){
			
			if(!NextBoxIsNew(memoire, toutDroitKev(i,j)[0], toutDroitKev(i,j)[1])){
				
				gauche = false;
				o = haut(i,j);
			}else{
			o = gauche(i,j);
			}
			
		}else if(gauche&&!this.EndGauche(i, j)){
			
			gauche = false;
			o = haut(i,j);
			
		}else if(haut&&this.EndHaut(i, j)){

			if(!NextBoxIsNew(memoire, toutDroitKev(i,j)[0], toutDroitKev(i,j)[1])){
				
				haut = false;
				o = droite(i,j);
			}else{			
				o = haut(i,j);
			}
			
		}else if(haut&&!this.EndHaut(i, j)){
			haut = false;
			o = droite(i,j);
		}
		
		return o;
	}
	
	 
	
	public int[] surplace(int i, int j){
		int[] o = new int[] {i,j};
		return o;
	}
	
<<<<<<< HEAD
	public void bouger(int cpt){
		memoire.enregistrement(positionX, positionY, cellules);
=======
	public void bouger(Cellule[][] actuelle, int cpt){
		
>>>>>>> 626a1d531b09a5913e901a90b42a0a2426745577
		Cellule[][] Grille = memoire.getGrille(); 
		int[] pos = cptToXY(Grille, cpt);
		mouvement ++;
		this.setPositionX(pos[0]);
		this.setPositionY(pos[1]);
		memoire.enregistrement(pos[0], pos[1], actuelle);
		
		memoire.ThrowBackPossible(pos[0], pos[1]);
		
		System.out.println("cpt = "+cpt);
		
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
	
	public void setAlive(boolean a){
		this.alive = a;
	}

}
