package Environement;

import java.awt.Graphics;

import javax.swing.JPanel;


public class Grille extends JPanel {

	protected int tailleGrille;
	private int dimm;
	

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

	public void paintComponent(Graphics g) {
		for (int i = 0; i < dimm; i++) {
			for (int j = 0; j < dimm; j++) {
				// Nouvelle instance d'une celule
				
				g.drawRect(cellules[i][j].positionAbsolueX, cellules[i][j].positionAbsolueY, 60, 60);				
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
