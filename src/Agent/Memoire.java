package Agent;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import Environement.Cellule;

public class Memoire {

	private Cellule[][] Grille = null;
	private int taille;
	private boolean throwback;
	
	
	public Memoire(int taille){
		this.taille = taille;
		this.Grille = new Cellule[taille][taille];

	}
	
	public boolean ThrowBackPossible(int i, int j){
		int p=0;
		for (int j2 = 0; j2 < taille; j2++) {
			for (int k = 0; k < taille; k++) {
				if(Grille[j2][k].getConnu()){
					p+=1;
					//System.out.println("p = " + p + " " + (taille*taille-1));
					if(p>(taille*taille)){
						System.out.println("On est au bout");
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void initMemoire(){
		System.out.println("grille de taille " + taille );
		
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				System.out.println(i+" "+ j);
				//Obligé de définir un constructeur sinon la mémoire est nul est impossible de set apres
				Grille[i][j] = new Cellule(taille, i, j);
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
		
		System.out.println(cellules[i][j].isSafe());
		
		this.Grille[i][j].setConnu(true);
		
		System.out.println("dans la cellule i,j "+ i+ ","+j +" bools odeur, vent : " + cellules[i][j].getCaca() + " , " + cellules[i][j].getVent());
		
		Cellule cellule = cellules[i][j];
		if(cellule.getCaca()||cellule.getVent()){
			cellule.setSafe(false);
		}
		else{
			cellule.setSafe(true);
		}
		
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
	
	public boolean getConnu(int i, int j){
		boolean Known = this.Grille[i][j].getConnu();
		
		return Known;
	}
	
}
