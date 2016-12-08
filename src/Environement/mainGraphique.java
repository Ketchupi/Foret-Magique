package Environement;

import Agent.AgentPlayer;
import Agent.ThreadPlayer;
import Generation.*;


public class mainGraphique {


	static int dimmension = 4;
	protected static Cellule[][] cell = null;
	private static AgentPlayer player;
	
	
	public static void main(String[] args)

	{
		RandomMagic generator = new RandomMagic();
		cell = new Cellule[dimmension+10][dimmension+10];
		
		// création de la fenêtre
		
		for (int i = 0; i < dimmension+10; i++) {
			for (int j = 0; j < dimmension+10; j++) {
				// Nouvelle instance d'une cellule
				cell[i][j] = new Cellule(0, 0, 60, i, j);
			}
		}
		player = new AgentPlayer();
		
		cell[3][0].setGate(true);
		
		

		

		
		
		
		//Fenetre fenetre;
		/*
		 * TODO Mettre le thread environement
		 */
		
		Fenetre fenetre = new Fenetre(cell, dimmension);
		
		Thread thGraphique = new Thread(new ThreadGraphique(fenetre,generator,player,cell,500,dimmension));
		thGraphique.start();
		Thread thPlayer = new Thread(new ThreadPlayer(fenetre,generator,player,cell,500,dimmension));
		thPlayer.start();
		//thGraphique.destroy();
		
	}

}
