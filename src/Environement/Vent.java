package Environement;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Vent {
	private int posX = 0;
	private int posY = 0;
	
	private Image bg = Toolkit.getDefaultToolkit().getImage("/Users/remymaillot/Documents/SourceTreeFolder/Git/src/Environement/vent.png");;

	/*
	 * Méthodes
	 */

	public void dessinerVent(Graphics g, int x, int y) {

		g.drawImage(bg,x+10,y+10,39,39,null);
		
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