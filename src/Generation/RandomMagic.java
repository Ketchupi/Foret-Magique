package Generation;

import java.lang.*;
import java.util.Random;

import Environement.Cellule;
import Environement.Grille;
import java.lang.*;

public class RandomMagic {

	private Grille grille = null;
	private static Boolean generated = false;
	
	public void generatePlace(Cellule[][] grille, int dimension){
		
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				grille[i][j].setMonstre(false);
				grille[i][j].setTrou(false);
				grille[i][j].setCaca(false);
				grille[i][j].setVent(false);
				grille[i][j].setGate(false);
				//grille[i][j].setPersonne(false);
			}
			generated = false;
		}
		
		if(!generated){
			
			Random generator = new Random();
			int i = generator.nextInt(dimension-1);
			int j = generator.nextInt(dimension-1);
			
			grille[i][j].setMonstre(true);
			
			int k = generator.nextInt(dimension-1);
			int l = generator.nextInt(dimension-1);
			int m = generator.nextInt(dimension-1);
			int n = generator.nextInt(dimension-1);
			
			do {
				k = generator.nextInt(dimension-1);
				l = generator.nextInt(dimension-1);
				m = generator.nextInt(dimension-1);
				n = generator.nextInt(dimension-1);
			} while (((i==k)&&(j==l))||((i==m)&&(j==n))||((k==m)&&(l==n)));
			
			
			grille[k][l].setTrou(true);
			grille[m][n].setGate(true);
			
			//gestion du cas ou le monstre et le trou sont cote a cote
			if(((java.lang.Math.abs(k-i)+java.lang.Math.abs(l-j))==1)){
				this.generateBoth(grille, i,j,k,l, dimension);
			}else{
				generateSmell(grille, i, j, dimension-1);
				generateWind(grille, k, l, dimension);
			}
			
			generated = true;	
		}
		
		
	}
	
	public void generateWind(Cellule[][] grille, int i, int j, int dimension){
		
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
		grille[i][j].setCaca(false);
		grille[i][j].setVent(false);
	}
	
	public void generateBoth(Cellule[][] grille, int i, int j, int k, int l, int dimension){
		System.out.println("Both");

		//Both monster & pit are aligned in column
		if((i-k)==0){	
			if(j<l){
				this.generateSmell(grille, i, j, dimension);
				this.generateWind(grille, k, l, dimension);
				this.setBoth(grille, i, j);
				this.setBoth(grille, k, l);
			}else{
				this.generateSmell(grille, i, j, dimension);
				this.generateWind(grille, k, l, dimension);
				this.setBoth(grille, i, j);
				this.setBoth(grille, k, l);
			}			
		}
		
		//Both monster & pit are aligned in line
		if((j-l)==0){
			if(i<k){
				this.generateSmell(grille, i, j, dimension);
				this.generateWind(grille, k, l, dimension);
				this.setBoth(grille, i, j);
				this.setBoth(grille, k, l);
			}else{
				this.generateSmell(grille, i, j, dimension);
				this.generateWind(grille, k, l, dimension);
				this.setBoth(grille, i, j);
				this.setBoth(grille, k, l);
			}
		}
	}
}	
