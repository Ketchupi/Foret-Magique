package Environement;

import java.awt.Graphics;

import javax.swing.JPanel;


public class Grille extends JPanel {

	protected int tailleGrille;
	

	protected Cellule[][] cellules = new Cellule[5][5];

	/*
	 * Constructeurs
	 */

	public Grille(Cellule[][] cell) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// Nouvelle instance d'une celule
				
				this.cellules[i][j] = cell[i][j];
				
			}
		}
		
	}

	public void paintComponent(Graphics g) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// Nouvelle instance d'une celule
				
				g.drawRect(cellules[i][j].positionAbsolueX, cellules[i][j].positionAbsolueY, 60, 60);				
			}
		}
	}
}
