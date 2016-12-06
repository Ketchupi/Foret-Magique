package Environement;



public class mainGraphique {

	protected static Cellule[][] cell = new Cellule[5][5];

	public static void main(String[] args)

	{
		// création de la fenêtre
		int cpt = 0;
		int sens = 0;
		int dimmension = 4;
		for (int i = 0; i < dimmension; i++) {
			for (int j = 0; j < dimmension; j++) {
				// Nouvelle instance d'une celule
				cell[i][j] = new Cellule(0, 0, 60, i, j);

			}
		}
		
		/**
		 * TEST des boolean pour dessiner
		 */
		cell[2][2].setPersonne(true);
		cell[1][2].setMonstre(true);
		cell[3][1].setCaca(true);
		cell[3][2].setVent(true);
		cell[0][1].setGate(true);
		cell[0][0].setTrou(true);
		Fenetre fenetre;

		
		fenetre = new Fenetre(cell,dimmension);
		while (true) {

			
			fenetre.repaint();
			long start = System.currentTimeMillis();
			while ((System.currentTimeMillis() - start) < 500)
				;
			

			switch (sens) {
			case 0:
				cpt++;
				if (cpt == 2) {
					sens = 1;
				}
				break;

			case 1:
				cpt--;
				if (cpt == 0) {
					sens = 0;
				}
				break;
			}

		}
	}

}
