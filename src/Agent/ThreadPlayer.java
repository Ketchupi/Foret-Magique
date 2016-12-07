package Agent;

import Environement.Cellule;
import Environement.Fenetre;

public class ThreadPlayer implements Runnable {
	
	private Cellule[][] cellules;
	private int timer;
	private int dimm;
	int cpt;
	private AgentPlayer player;
	/*
	 * Constructeurs
	 */

	public ThreadPlayer(AgentPlayer player,Cellule[][] cellules, int timer, int dim) {
		this.player=player;
		this.cellules = cellules;
		this.timer = timer;
		this.dimm = dim;
	}

	/**
	 * Méthode principale du thread
	 */
	@Override
	public void run() {

		player.initPositionPlayer();
		while (true) {

			player.afficherPlayer(cellules);
			player.findGate();
			//=====TEST====
			if(cpt >8){
				player.setPositionX(2);player.setPositionY(0);
			}
			if(cpt >16){
				player.setPositionX(3);player.setPositionY(0);
			}
			if(cpt >24){
				player.setPositionX(3);player.setPositionY(0);
			}
			cpt ++;
			//=====FIN TEST====
			try {
				Thread.sleep(timer);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

}
