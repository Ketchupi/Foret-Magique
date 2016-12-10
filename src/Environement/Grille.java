package Environement;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Agent.AgentPlayer;



public class Grille extends JPanel {

	protected int tailleGrille;
	private int dimm;
	
	protected Player personne = new Player();
	protected Monstre monstre = new Monstre();
	protected CacaMonstre caca = new CacaMonstre();
	protected Vent vent = new Vent();
	protected Gate gate = new Gate();
	protected Pit pit = new Pit();
	protected Cellule[][] cellules = null;
	private AgentPlayer kevin;

	/*
	 * Constructeurs
	 */

	public Grille(Cellule[][] cell, int dimm, AgentPlayer kevin) {
		this.kevin = kevin;
		this.dimm=dimm;
		cellules = new Cellule[dimm][dimm];
		
		for (int i = 0; i < dimm; i++) {
			for (int j = 0; j < dimm; j++) {
				// Nouvelle instance d'une cellule
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
		
		
		int n0 = 800;
		int k0 = 25;
		int hauteurK = 50;
		int largueurN = 230;

		for (int n = 0; n < 2; n++) {
			for (int k = 0; k < 4; k++) {
				
				if (n == 0) {
					if (k == 0) {
						g.drawString("Nombre de bijoux ramasses :", n0 + largueurN * n + 10,
								k0 + hauteurK * (k + 1) - hauteurK / 2);
					}
					if (k == 1) {
						g.drawString("Nombre de saletes nettoyees :", n0 + largueurN * n + 10,
								k0 + hauteurK * (k + 1) - hauteurK / 2);
					}
					if (k == 2) {
						g.drawString("Cont d'electricite :", n0 + largueurN * n + 10,
								k0 + hauteurK * (k + 1) - hauteurK / 2);
					}
					if (k == 3) {
						g.drawString("Nombre d'erreurs :", n0 + largueurN * n + 10,
								k0 + hauteurK * (k + 1) - hauteurK / 2);
					}
				} else {
					if (k == 0) {
						if(kevin !=null)
						g.drawString(Integer.toString(kevin.getMouvement()), n0 + largueurN * n + 10,
								k0 + hauteurK * (k + 1) - hauteurK / 2);
					}
					if (k == 1) {
						g.drawString(Integer.toString(1), n0 + largueurN * n + 10,
								k0 + hauteurK * (k + 1) - hauteurK / 2);
					}
					if (k == 2) {
						g.drawString(Integer.toString(1), n0 + largueurN * n + 10,
								k0 + hauteurK * (k + 1) - hauteurK / 2);
					}
					if (k == 3) {
						g.drawString(Integer.toString(1), n0 + largueurN * n + 10,
								k0 + hauteurK * (k + 1) - hauteurK / 2);
					}
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


	public AgentPlayer getKevin() {
		return kevin;
	}


	public void setKevin(AgentPlayer kevin) {
		this.kevin = kevin;
	}
}
