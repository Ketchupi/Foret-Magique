package Environement;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class Grille extends JPanel {

	protected int tailleGrille;
	private int dimm;
	
	protected Player personne = new Player();
	protected Monstre monstre = new Monstre();
	protected CacaMonstre caca = new CacaMonstre();
	protected Vent vent = new Vent();
	protected Gate gate = new Gate();
	protected Pit pit = new Pit();
	protected Cellule[][] cellules = new Cellule[5][5];

	/*
	 * Constructeurs
	 */

	public Grille(Cellule[][] cell, int dimm) {
		this.dimm=dimm;
		for (int i = 0; i < dimm; i++) {
			for (int j = 0; j < dimm; j++) {
				// Nouvelle instance d'une celule
				
				this.cellules[i][j] = cell[i][j];
				
			}
		}
		
	}
	
	/**
	 * Fonction pour dessiner dans la grille
	 * C'est ici qu'on vas faire les test pour dessiner si les 
	 * valeur dans un cellule sont true.
	 * Exemple : Si la cellule a monstre en true, on vas la dessiner
	 */

	public void paintComponent(Graphics g) {
		for (int i = 0; i < dimm; i++) {
			for (int j = 0; j < dimm; j++) {
				
				g.drawRect(cellules[i][j].positionAbsolueX, cellules[i][j].positionAbsolueY, 60, 60);
				
				
				//=== Debut des test des cellules
				
				if (cellules[i][j].getPersonne() == true) {
					personne.dessinerPlayer(g, cellules[i][j].positionAbsolueX,
							cellules[i][j].positionAbsolueY);
				}
				
				if (cellules[i][j].getMonstre() == true) {
					monstre.dessinerMonstre(g, cellules[i][j].positionAbsolueX,
							cellules[i][j].positionAbsolueY);
				}
				if (cellules[i][j].getCaca() == true) {
					caca.dessinerCaca(g, cellules[i][j].positionAbsolueX,
							cellules[i][j].positionAbsolueY);
				}
				if (cellules[i][j].getVent() == true) {
					vent.dessinerVent(g, cellules[i][j].positionAbsolueX,
							cellules[i][j].positionAbsolueY);
				}
				if (cellules[i][j].getGate() == true) {
					gate.dessinerGate(g, cellules[i][j].positionAbsolueX,
							cellules[i][j].positionAbsolueY);
				}
				if (cellules[i][j].getTrou() == true) {
					pit.dessinerPit(g, cellules[i][j].positionAbsolueX,
							cellules[i][j].positionAbsolueY);
				}
			}
		}
	}

	public Cellule[][] getCellules() {
		return cellules;
	}

	public void setCellules(Cellule[][] cellules) {
		this.cellules = cellules;
	}
}
