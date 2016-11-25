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
