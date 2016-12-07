package Generation;

import java.lang.*;
import java.util.Random;

import Environement.Cellule;
import Environement.Grille;
import java.lang.*;

public class RandomMagic {

	private Grille grille;
	private static Boolean generated = false;
	
	public void generatePlace(Cellule[][] grille, int dimension){
		
		if(!generated){
			Random generator = new Random();
			int i = generator.nextInt(dimension+1);
			int j = generator.nextInt(dimension+1);
			
			grille[i][j].setMonstre(true);
			generateSmell(grille, i, j, dimension);
			
			int k = generator.nextInt(dimension+1);
			int l = generator.nextInt(dimension+1);
			
			do {
				k = generator.nextInt(dimension+1);
				l = generator.nextInt(dimension+1);
			} while ((k!=i)&&(l!=j));
			
			grille[k][l].setTrou(true);
			generateWind(grille, k, l, dimension);
			
			//gestion du cas ou le monstre et le trou sont cote a cote
			if(((java.lang.Math.abs(k-i)+java.lang.Math.abs(l-j))!=1)){
				
			}
			
			generated = true;
		}
		
		
	}
	
	public void generateWind(Cellule[][] grille, int i, int j, int dimension){
		
		Cellule[][] cells  = grille;
		
		if((i<dimension)&&(j<(dimension+1))&&(i!=0)&&(j!=0)){
			grille[i-1][j].setVent(true);
			grille[i+1][j].setVent(true);
			grille[i][j-1].setVent(true);
			grille[i][j+1].setVent(true);
		}else if((i==dimension)&&(j<(dimension+1))){
			grille[i-1][j].setVent(true);
			grille[i][j-1].setVent(true);
			grille[i][j+1].setVent(true);
		}else if((i<dimension)&&(j==dimension)){
			grille[i-1][j].setVent(true);
			grille[i+1][j].setVent(true);
			grille[i][j-1].setVent(true);
		}else if((i==0)&&(j!=0)){
			grille[i-1][j].setVent(true);
			grille[i+1][j].setVent(true);
			grille[i][j-1].setVent(true);
			grille[i][j+1].setVent(true);
		}else if((i!=0)&&(j==0)){
			grille[i-1][j].setVent(true);
			grille[i+1][j].setVent(true);
			grille[i][j+1].setVent(true);
		}else if((i==0)&&(j==0)){
			grille[i+1][j].setVent(true);
			grille[i][j+1].setVent(true);
		}else if((i==dimension)&&(j==dimension)){
			grille[i+1][j].setVent(true);
			grille[i][j+1].setVent(true);
		}	
	}
	
	public void generateSmell(Cellule[][] grille, int i, int j, int dimension){
		
		Cellule[][] cells  = grille;
		
		if((i<dimension)&&(j<(dimension+1))&&(i!=0)&&(j!=0)){
			grille[i-1][j].setCaca(true);
			grille[i+1][j].setCaca(true);
			grille[i][j-1].setCaca(true);
			grille[i][j+1].setCaca(true);
		}else if((i==dimension)&&(j<(dimension+1))){
			grille[i-1][j].setCaca(true);
			grille[i][j-1].setCaca(true);
			grille[i][j+1].setCaca(true);
		}else if((i<dimension)&&(j==dimension)){
			grille[i-1][j].setCaca(true);
			grille[i+1][j].setCaca(true);
			grille[i][j-1].setCaca(true);
		}else if((i==0)&&(j!=0)){
			grille[i-1][j].setCaca(true);
			grille[i+1][j].setCaca(true);
			grille[i][j-1].setCaca(true);
			grille[i][j+1].setCaca(true);
		}else if((i!=0)&&(j==0)){
			grille[i-1][j].setCaca(true);
			grille[i+1][j].setCaca(true);
			grille[i][j+1].setCaca(true);
		}else if((i==0)&&(j==0)){
			grille[i+1][j].setCaca(true);
			grille[i][j+1].setCaca(true);
		}else if((i==dimension)&&(j==dimension)){
			grille[i+1][j].setCaca(true);
			grille[i][j+1].setCaca(true);
		}	
	}
	
	public void setBoth(Cellule[][] grille, int i, int j){
		grille[i][j].setCaca(true);
		grille[i][j].setVent(true);
	}
	
	public void generateBoth(Cellule[][] grille, int i, int j, int k, int l, int n, int dimension){
		
		int minRow = java.lang.Math.min(i, k);
		int minCol = java.lang.Math.min(j, l);
		
		//Les deux mechants sont alignes en colonne
		if((j-l)==0){	
			
			if(((k-1)!=0)&&((k)!=(dimension+1))){
				this.setBoth(grille, i, minCol);
				this.setBoth(grille, i+1, minCol);
				this.setBoth(grille, i-1, minCol);
				this.setBoth(grille, minRow-1, j);
				this.setBoth(grille, minRow+2, j);
			}else if((k-1)==0&&((k)!=(dimension+1))){
				
				this.setBoth(grille, i, minCol+1);
				this.setBoth(grille, i+1, minCol+1);
				
				
			}else if((k)!=(dimension)){
				
				this.setBoth(grille, i, minCol-1);
				this.setBoth(grille, i+1, minCol-1);				
			}
		}
		
		//Les deux mechants sont alignes en ligne
		if((i-l)==0){
			if(((j-1)!=0)&&((j)!=(dimension+1))){
				this.setBoth(grille, minRow, minCol-1);
				this.setBoth(grille, minRow, minCol+2);
				this.setBoth(grille, minRow-1, j);
				this.setBoth(grille, minRow-1, l);
				this.setBoth(grille, minRow+1, j);
				this.setBoth(grille, minRow+1, l);

			}else if(((j-1)==0)&&((j)!=(dimension+1))){
				this.setBoth(grille, minRow, minCol-1);
				this.setBoth(grille, minRow, minCol+2);
				this.setBoth(grille, minRow+1, j);
				this.setBoth(grille, minRow+1, l);
			}else if(((j-1)!=0)&&((j)==(dimension+1))){
				this.setBoth(grille, minRow, minCol-1);
				this.setBoth(grille, minRow, minCol+2);
				this.setBoth(grille, minRow+1, j);
				this.setBoth(grille, minRow+1, l);
			}
			
		}
	}
}	
