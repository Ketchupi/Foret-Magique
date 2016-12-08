package Agent;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import Environement.Cellule;

public class Memoire {

	private Cellule[][] Grille = null;
	private int taille;
	
	public Memoire(int taille){
		this.taille = taille;
		this.Grille = new Cellule[taille][taille];
		
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				System.out.println(i+" "+ j);
				
				Grille[i][j].setConnu(false);
				Grille[i][j].setCaca(false);
				Grille[i][j].setVent(false);
				Grille[i][j].setMonstre(false);
				Grille[i][j].setTrou(false);
			}
		}
	}
	
	public void initMemoire(){
		System.out.println("grille de taille " + taille );
		
		System.out.println();
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				System.out.println(i+" "+ j);
				
				Grille[i][j].setConnu(false);
				Grille[i][j].setCaca(false);
				Grille[i][j].setVent(false);
				Grille[i][j].setMonstre(false);
				Grille[i][j].setTrou(false);
			}
		}
	}
	
	public void enregistrement(int i, int j, Cellule[][] cellules){
		
		this.Grille[i][j]= cellules[i][j];
		this.Grille[i][j].setConnu(true);
		System.out.println("je passe par " + i +" "+ j);
		System.out.println("je suis passé par " + Grille[i][j].getConnu());
		
	}
	
	public Cellule[][] getGrille() {
		return Grille;
	}
	
	public Cellule getCellule(int i, int j){
		return Grille[i][j];
	}
	public void setGrille(Cellule[][] grille) {
		Grille = grille;
	}
	
	public int getTaille() {
		return taille;
	}
	
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	
}
