package Environement;

import Agent.AgentPlayer;
import Agent.ThreadPlayer;
import Generation.*;


public class mainGraphique {

	static int dimmension = 10;
	protected static Cellule[][] cell = null;
	private static AgentPlayer player;
	
	
	public static void main(String[] args)

	{
		RandomMagic generator = new RandomMagic();
		cell = new Cellule[dimmension][dimmension];
		
		// création de la fenêtre
		
		for (int i = 0; i < dimmension; i++) {
			for (int j = 0; j < dimmension; j++) {
				// Nouvelle instance d'une celule
				cell[i][j] = new Cellule(0, 0, 60, i, j);
			}
		}
		player = new AgentPlayer();
		
		//Creation emplacement monstre & trou
		//generator.generatePlace(cell, dimmension);

		/**
		 * TEST des boolean pour dessiner
		 */
		
		cell[2][2].setPersonne(true);
		cell[3][0].setMonstre(true);
		cell[3][1].setCaca(true);
		cell[3][2].setVent(true);
		cell[2][0].setGate(true);
		cell[0][0].setTrou(true);
		
		
		
		//Fenetre fenetre;
		/*
		 * TODO Mettre le thread environement
		 */
		
		Thread thGraphique = new Thread(new ThreadGraphique(player,cell,500,3));
		thGraphique.start();
		Thread thPlayer = new Thread(new ThreadPlayer(player,cell,500,3));
		thPlayer.start();
		//thGraphique.destroy();
		
	}

}
