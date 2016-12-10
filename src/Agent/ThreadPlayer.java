package Agent;

import Environement.Cellule;
import Environement.Fenetre;
import Generation.RandomMagic;

public class ThreadPlayer implements Runnable {
	
	private Cellule[][] cellules;
	private int timer;
	private int dimm;
	private int cpt=0;
	private AgentPlayer player;
	private RandomMagic generator;
	private Fenetre fenetre;
	private Intuition intuition;
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
		//this.intuition = new Intuition(dimm, player);
	}

	/**
	 * Méthode principale du thread
	 */
	@Override
	public void run() {

		player.initPositionPlayer(fenetre,generator);
		while (true) {

			//player.afficherPlayer(cellules);
			//player.setMouvement(cpt);
			player.afficherPlayer();
			player.findGate();
			player.findMonstre();
			player.findPit();
			
			if(player.getAlive()){
				player.bouger(cpt);
			}
			else{
				player.initPositionPlayer(fenetre,generator);
				//player.afficherPlayer(cellules);
				player.afficherPlayer();
				player.setAlive(true);
			}
			
<<<<<<< HEAD
			//=====TEST====
			/*
			if(cpt >5){
				player.setPositionX(2);player.setPositionY(0);
			}
			if(cpt >10){
				player.setPositionX(3);player.setPositionY(0);
			}
			if(cpt >15){
				player.setPositionX(4);player.setPositionY(0);
			}
			*/
			
=======
			cpt ++;
>>>>>>> 626a1d531b09a5913e901a90b42a0a2426745577
			//Thread.sleep(timer);
			
			cpt ++;
			Thread.currentThread().suspend();
			
		}
	}

}
