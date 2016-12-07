package Environement;

public class Cellule {

	protected int positionX;
	protected int positionY;
	protected int positionAbsolueX;
	protected int positionAbsolueY;
	protected int taille;
	protected boolean presencePersonne = false;
	protected boolean presenceVent = false;
	protected boolean presenceCaca = false;
	protected boolean presenceMonstre = false;
	protected boolean presenceTrou = false;
	protected boolean presenceGate = false;

	/*
	 * Constructeurs
	 */

	public Cellule(int largueurFenetre, int hauteurFenetre, int taille, int i, int j) {
		this.positionX = i;
		this.positionY = j;
		this.taille = taille;
		this.positionAbsolueX = largueurFenetre + (taille * i);
		this.positionAbsolueY = hauteurFenetre + (taille * j);
	}

	/*
	 * Getters et setters
	 */
	public void setTaille(int taille){
		this.taille = taille;
	}
	
	public int getTaille(){
		return taille;
	}

	public int getPositionAbsolueX() {
		return positionAbsolueX;
	}

	public int getPositionAbsolueY() {
		return positionAbsolueY;
	}

	public int getPositionMatriceX() {
		return positionX;
	}

	public int getPositionMatriceY() {
		return positionY;
	}

	public void setPersonne(boolean b) {
		this.presencePersonne = b;
	}

	public void setVent(boolean b) {
		this.presenceVent = b;
	}

	public void setCaca(boolean b) {
		this.presenceCaca = b;
	}
	
	public void setMonstre(boolean b) {
		this.presenceMonstre = b;
	}
	
	public void setTrou(boolean b) {
		this.presenceTrou = b;
	}
	
	public void setGate(boolean b) {
		this.presenceGate = b;
	}

	public boolean getPersonne() {
		return presencePersonne;
	}

	public boolean getVent() {
		return presenceVent;
	}

	public boolean getCaca() {
		return presenceCaca;
	}
	
	public boolean getMonstre() {
		return presenceMonstre;
	}
	
	public boolean getTrou() {
		return presenceTrou;
	}
	
	public boolean getGate() {
		return presenceGate;
	}

}
