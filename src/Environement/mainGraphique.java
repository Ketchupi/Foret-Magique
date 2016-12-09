package Environement;

import Agent.AgentPlayer;
import Agent.ThreadPlayer;
import Generation.*;


public class mainGraphique {

	static int dimmension = 4;
	protected static Cellule[][] cell = null;
	private static AgentPlayer player;
	
	public int getDimension(){
		return dimmension;
	}
	public static void main(String[] args)

	{
		//Constructeur du random en général (comme ça tout le monde l'a)
		RandomMagic generator = new RandomMagic();
		
		//Constructeur du player (même raison)
		player = new AgentPlayer();

		//Constructeur de la fenetre
		Fenetre fenetre = new Fenetre(dimmension);
		//On récupère la cellules créer par fenetre
		cell = fenetre.initCellule(dimmension);
		
		//Init des thread
		Thread thGraphique = new Thread(new ThreadGraphique(fenetre,generator,player,cell,200,dimmension));
		thGraphique.start();
		Thread thPlayer = new Thread(new ThreadPlayer(fenetre,generator,player,cell,500,dimmension));
		thPlayer.start();
		//On passe l'agent a la fenetre
		fenetre.iniThreadKevin(thPlayer);
		
	}

}
