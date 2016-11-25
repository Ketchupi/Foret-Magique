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
	private JButton b1 = new JButton("Play/Pause");
	private JButton b2 = new JButton("Quitter");

	protected Cellule[][] cellules = new Cellule[5][5];
	protected Grille grille;


	protected Thread threadRobot;
	protected Thread threadEnvironnement;
	private int switchBouton = 0;
	/*
	 * Constructeurs
	 */

	public Fenetre(Cellule[][] cell) {
		this.cellules = cell;
		this.grille = new Grille(cell);
		this.setTitle("Animation");
		this.setSize(750, 300);
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
			threadRobot.suspend();
			threadEnvironnement.suspend();
			switchBouton = 1;
			break;

		case 1:
			threadRobot.resume();
			threadEnvironnement.resume();
			switchBouton = 0;
			break;
		}
	}

	// Classe écoutant notre premier bouton
	class Bouton1Listener implements ActionListener {
		// Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent arg0) {
			switch (switchBouton) {
			case 0:
				threadRobot.suspend();
				threadEnvironnement.suspend();
				switchBouton = 1;
				break;

			case 1:
				threadRobot.resume();
				threadEnvironnement.resume();
				switchBouton = 0;
				break;
			}
		}
	}

	// Classe écoutant notre second bouton
	class Bouton2Listener implements ActionListener {
		// Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
