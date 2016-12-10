package Environement;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Agent.AgentPlayer;


public class Fenetre extends JFrame implements ActionListener {

	private JPanel containeur = new JPanel();
	private JButton b1 = new JButton("Play/Avancer");
	private JButton b2 = new JButton("Quitter");

	protected Cellule[][] cellules = null;
	protected Grille grille;

	protected Thread threadKevin;
	private int switchBouton = 0;
	private int dimm;
	private AgentPlayer kevin;
	/*
	 * Constructeurs
	 */

	public void iniThreadKevin(Thread threadKevin){
		
		this.threadKevin = threadKevin;
	}
	
	/**
	 * On définit la cellule dynamiquement. 
	 * On l'utulisera pour redimensionner la grille lors de win ou defaites
	 * @param dimmension
	 * @return cellule[][]
	 */
	public Cellule[][] initCellule(int dimmension){
		
		
		cellules = new Cellule[dimmension][dimmension];
		
		// creation de la fenetre
		
		for (int i = 0; i < dimmension; i++) {
			for (int j = 0; j < dimmension; j++) {
				// Nouvelle instance d'une cellule
				cellules[i][j] = new Cellule(0, 0, 60, i, j);
			}
		}
		
		
		return cellules;
		
	}
	
	/*
	 * Getter de la cellules pour les autres classes
	 */
	public Cellule[][] getCelluleFenetre(){
		return cellules;
	}
	
	/*
	 * On definit la fenetre graphique ici
	 */
	
	public Fenetre(int dimm,AgentPlayer k) {
		this.setDimm(dimm);
		this.dimm = dimm;
		this.kevin = k;
		
		
		this.setTitle("Kevin le noob");
		this.setSize(1200, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		

		containeur.setLayout(new BorderLayout());

		Panel top = new Panel();
		top.add(b1);
		top.add(b2);
		b1.addActionListener(new Bouton1Listener());
		b2.addActionListener(new Bouton2Listener());
		containeur.add(top, BorderLayout.NORTH);

		this.setContentPane(containeur);

		//On construit la cellule
		cellules = initCellule(dimm);
		//On passe le tableau de cellule dans grille qui vas dessiner
		this.grille = new Grille(cellules,dimm,kevin);
		grille.setKevin(kevin);
		//On ajoute au Panel qui sera reactualise (remove puis add)
		this.getContentPane().add(grille, BorderLayout.CENTER);

		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) {
		switch (switchBouton) {
		case 0:
			//threadGeneration.suspend();
			
			switchBouton = 1;
			break;

		case 1:
			//threadGeneration.resume();
			switchBouton = 0;
			break;
		}
	}

	public int getDimm() {
		return dimm;
	}

	public void setDimm(int dimm) {
		this.dimm = dimm;
	}

	// Classe ecoutant notre premier bouton
	class Bouton1Listener implements ActionListener {
		// Redefinition de la methode actionPerformed()
		public void actionPerformed(ActionEvent arg0) {
			
			/*
			 * Thread de l'intelligence et du deplacememnt du personnage
			 * L'orsqu'on click on dévérouille la pause jusqu'a la prochaine itération
			 */
				threadKevin.resume();
				
			
		}
	}

	// Classe ecoutant notre second bouton
	class Bouton2Listener implements ActionListener {
		// Redefinition de la methode actionPerformed()
		public void actionPerformed(ActionEvent e) {
			//Exit propre
			System.exit(0);
		}
	}
	
	/**
	 * C'est ici qu'on redessine la fenetre lors d'une win/defaite
	 * On reprend les cellules modifier plus en haut, et on met la nouvelle dimension
	 * @param cell
	 * @param dim
	 */
	
	public void updateFenetre(Cellule[][] cell,int dim){
		this.cellules = cell;
		this.getContentPane().remove(grille);
		this.grille = new Grille(cellules,dim,kevin);
		this.getContentPane().add(grille, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
