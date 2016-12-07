package Environement;



public class ThreadGraphique implements Runnable {

	private Cellule[][] cellules;
	private int timer;
	private int dimm;
	static int cpt = 0;
	static int cpt1 = 0;
	/*
	 * Constructeurs
	 */

	public ThreadGraphique(Cellule[][] cellules, int timer, int dim) {
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
			
			if(cpt == 10) fenetre.updateFenetre(cellules, 6);
			// Timer
			try {
				Thread.sleep(timer);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

}
