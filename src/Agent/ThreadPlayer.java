package Agent;

import Environement.Cellule;
import Environement.Fenetre;
import Generation.RandomMagic;

public class ThreadPlayer implements Runnable {
	
	private Cellule[][] cellules;
	private int timer;
	private int dimm;
	int cpt;
	private AgentPlayer player;
	private RandomMagic generator;
	private Fenetre fenetre;
	/*
	 * Constructeurs
	 */

	public ThreadPlayer(Fenetre fenetre,RandomMagic generator,AgentPlayer player,Cellule[][] cellules, int timer, int dim) {
		this.fenetre = fenetre;
		this.generator=generator;
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

		player.initPositionPlayer(fenetre,generator);
		while (true) {

			player.afficherPlayer(cellules);
			player.findGate();
			player.findMonstre();
			player.findPit();
			//=====TEST====
			
			if(cpt >5){
				player.setPositionX(2);player.setPositionY(0);
			}
			if(cpt >10){
				player.setPositionX(3);player.setPositionY(0);
			}
			if(cpt >15){
				player.setPositionX(4);player.setPositionY(0);
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
