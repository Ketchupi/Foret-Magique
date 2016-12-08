package Environement;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Player {
	private int posX = 0;
	private int posY = 0;
	
	private String adresseRama = "C:/Users/rama/Documents/Foret-Magique/src/Environement/";
	private String adresseRemy = "/Users/remymaillot/Documents/SourceTreeFolder/Git/src/Environement/";

	private Image bg = Toolkit.getDefaultToolkit().getImage(adresseRemy.concat("player.png"));


	/*
	 * Méthodes
	 */

	public void dessinerPlayer(Graphics g, int x, int y) {

		g.drawImage(bg,x,y,59,59,null);
		
	}

	/*
	 * Getters et setters
	 */

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}