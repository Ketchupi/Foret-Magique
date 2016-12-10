package Environement;

import Agent.AgentPlayer;
import Generation.RandomMagic;

public class ThreadGraphique implements Runnable {

	private Cellule[][] cellules;
	private int timer;
	private int dimm;
	static int cpt = 0;
	static int cpt1 = 0;
	private AgentPlayer player;
	private RandomMagic generator;
	private Fenetre fenetre;
	/*
	 * Constructeurs
	 */

	public ThreadGraphique(Fenetre fenetre, RandomMagic generator,AgentPlayer player,Cellule[][] cellules, int timer, int dim) {
		this.fenetre = fenetre;
		this.generator = generator;
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

		// On cree la fenetre avec les valeurs des cellules
		
		
		generator.generatePlace(cellules, dimm);
		
		// Boucle qui actualise l'interface graphique
		while (true) {

			// On actualise la fenetre
			fenetre.repaint();	
			
			// Timer
			try {
				Thread.sleep(timer);
				
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

}
