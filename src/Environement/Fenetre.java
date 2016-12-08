package Environement;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame implements ActionListener {

	private JPanel containeur = new JPanel();
	private JButton b1 = new JButton("Play/Avancer");
	private JButton b2 = new JButton("Quitter");

	protected Cellule[][] cellules = null;
	protected Grille grille;

	protected Thread threadKevin;
	private int switchBouton = 0;
	private int dimm;
	/*
	 * Constructeurs
	 */

	public void iniThreadKevin(Thread threadKevin){
		
		this.threadKevin = threadKevin;
	}
	
	
	public Fenetre(Cellule[][] cell, int dimm) {
		this.setDimm(dimm);
		this.dimm = dimm;
		this.cellules = cell;
		this.grille = new Grille(cell,dimm);
		
		this.setTitle("Animation");
		this.setSize(1000, 1000);
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

		this.getContentPane().add(grille, BorderLayout.CENTER);
		// this.getContentPane().add(robot,BorderLayout.CENTER);
		

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

	// Classe écoutant notre premier bouton
	class Bouton1Listener implements ActionListener {
		// Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent arg0) {
			
			
				threadKevin.resume();
				
			
		}
	}

	// Classe écoutant notre second bouton
	class Bouton2Listener implements ActionListener {
		// Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	public void updateFenetre(Cellule[][] cell,int dim){
		this.getContentPane().remove(grille);
		this.grille = new Grille(cell,dim);
		this.getContentPane().add(grille, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
