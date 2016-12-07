package Environement;

import Generation.*;


public class mainGraphique {

	static int dimmension = 5;
	protected static Cellule[][] cell = null;
	
	
	public static void main(String[] args)

	{
		RandomMagic generator = new RandomMagic();
		cell = new Cellule[dimmension][dimmension];
		
		// création de la fenêtre
		
		for (int i = 0; i < dimmension; i++) {
			for (int j = 0; j < dimmension; j++) {
				// Nouvelle instance d'une cellule
				cell[i][j] = new Cellule(0, 0, 60, i, j);
			}
		}
		
		//Creation emplacement monstre & trou
		generator.generatePlace(cell, dimmension);

		
		//Fenetre fenetre;		
		Thread thGraphique = new Thread(new ThreadGraphique(cell,500,dimmension));
		thGraphique.start();
		//thGraphique.destroy();
		
	}

}
