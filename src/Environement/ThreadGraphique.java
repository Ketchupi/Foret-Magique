package Environement;

import Agent.AgentPlayer;

public class ThreadGraphique implements Runnable {

	private Cellule[][] cellules;
	private int timer;
	private int dimm;
	static int cpt = 0;
	static int cpt1 = 0;
	private AgentPlayer player;
	/*
	 * Constructeurs
	 */

	public ThreadGraphique(AgentPlayer player,Cellule[][] cellules, int timer, int dim) {
		this.player = player;
		this.cellules = cellules;
		this.timer = timer;
		this.dimm = dim;
	}

	/**
	 * Méthode principale du thread
	 */
	@Override
	public void run() {

		// On crée la fenêtre avec les valeurs des cellules
		Fenetre fenetre = new Fenetre(cellules, dimm);

		// Boucle qui actualise l'interface graphique
		while (true) {

			// On actualise la fenêtre
			fenetre.repaint();	
			cpt++;
			
			if(player.findGate() == 1) fenetre.updateFenetre(cellules, 4);
			// Timer
			try {
				Thread.sleep(timer);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

}
