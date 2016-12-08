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
			
			
			System.out.println("{i,j} = {"+i+","+j+"}");
			int k = generator.nextInt(dimension-1);
			int l = generator.nextInt(dimension-1);
			int m = generator.nextInt(dimension-1);
			int n = generator.nextInt(dimension-1);
			
			do {
				k = generator.nextInt(dimension-1);
				l = generator.nextInt(dimension-1);
				m = generator.nextInt(dimension-1);
				n = generator.nextInt(dimension-1);
			} while ((k!=i)&&(l!=j)&&(m!=i)&&(n!=j));
			
			grille[k][l].setTrou(true);
			System.out.println("{k,l} = {"+k+","+l+"}");
			
			grille[m][n].setGate(true);
			
			//gestion du cas ou le monstre et le trou sont cote a cote
			if(((java.lang.Math.abs(k-i)+java.lang.Math.abs(l-j))==1)){
				this.generateBoth(grille, i,j,k,l, dimension);
			}else{
				generateSmell(grille, i, j, dimension-1);
				generateWind(grille, k, l, dimension);
			}
			
			System.out.println("{i,j,k,l} = {"+i+","+j+","+k+","+l+"}");
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
		grille[i][j].setCaca(true);
		grille[i][j].setVent(true);
	}
	
	public void generateBoth(Cellule[][] grille, int i, int j, int k, int l, int dimension){
		System.out.println("Both");
		int minRow = java.lang.Math.min(i, k);
		int minCol = java.lang.Math.min(j, l);
		
		//Both monster & pit are aligned in column
		if((j-l)==0){	
			//Generic case
			if((minCol!=0)&&(minCol!=(dimension-1))&&((minRow!=0)&&minRow!=(dimension-2))){
				
				this.setBoth(grille, minRow, minCol-1);
				this.setBoth(grille, minRow+1, minCol-1);
				this.setBoth(grille, minRow, minCol+1);
				this.setBoth(grille, minRow+1, minCol+1);
				this.setBoth(grille, minRow-1, minCol);
				this.setBoth(grille, minRow+2, minCol);
				
			}//stuck with the left border
			else if((minCol==0)&&(minCol!=(dimension-1))&&((minRow!=0)&&minRow!=(dimension-2))){
				
				this.setBoth(grille, minRow, minCol+1);
				this.setBoth(grille, minRow+1, minCol+1);
				this.setBoth(grille, minRow-1, minCol);
				this.setBoth(grille, minRow+2, minCol);
				
				
			}//stuck with the left upper corner
			else if((minCol==0)&&(minCol!=(dimension-1))&&((minRow==0)&&minRow!=(dimension-2))){
		
				this.setBoth(grille, minRow, minCol+1);
				this.setBoth(grille, minRow+1, minCol+1);
				this.setBoth(grille, minRow+2, minCol);		
				
			}//stuck with the right lower corner
			else if((minCol!=0)&&(minCol==(dimension-1))&&((minRow!=0)&&minRow==(dimension-2))){
				
				this.setBoth(grille, minRow, minCol-1);
				this.setBoth(grille, minRow+1, minCol-1);
				this.setBoth(grille, minRow-1, minCol);
				
			}//stuck with the right border
			else if((minCol!=0)&&(minCol==(dimension-1))&&((minRow!=0)&&minRow!=(dimension-2))){
				
				this.setBoth(grille, minRow, minCol-1);
				this.setBoth(grille, minRow, minCol+1);
				this.setBoth(grille, minRow-1, minCol);
				this.setBoth(grille, minRow+2, minCol);
				
			}//stuck with the right upper corner
			else if((minCol!=0)&&(minCol==(dimension-1))&&((minRow==0)&&minRow!=(dimension-2))){
				
				this.setBoth(grille, minRow, minCol-1);
				this.setBoth(grille, minRow+1, minCol-1);
				this.setBoth(grille, minRow+2, minCol);
				
			}//stuck with the top border
			else if((minCol!=0)&&(minCol!=(dimension-1))&&((minRow==0)&&minRow!=(dimension-2))){
				
				this.setBoth(grille, minRow, minCol-1);
				this.setBoth(grille, minRow+1, minCol-1);
				this.setBoth(grille, minRow, minCol+1);
				this.setBoth(grille, minRow+1, minCol+1);
				this.setBoth(grille, minRow+2, minCol);
				
			}//stuck with the bottom
			else if((minCol!=0)&&(minCol!=(dimension-1))&&((minRow!=0)&&minRow==(dimension-2)))
			{
				
				this.setBoth(grille, minRow, minCol-1);
				this.setBoth(grille, minRow+1, minCol-1);
				this.setBoth(grille, minRow, minCol+1);
				this.setBoth(grille, minRow+1, minCol+1);
				
			}
			
		}
		
		//Both monster & pit are aligned in line
		if((i-l)==0){
			
			//Generic case
			if((minCol!=0)&&(minCol!=(dimension-2))&&((minRow!=0)&&(minRow!=(dimension-1)))){
				
				this.setBoth(grille, minRow-1, minCol);
				this.setBoth(grille, minRow-1, minCol+1);
				this.setBoth(grille, minRow, minCol-1);
				this.setBoth(grille, minRow, minCol+2);
				this.setBoth(grille, minRow+1, minCol);
				this.setBoth(grille, minRow+1, minCol+1);
				
			}//stuck with the top border
			else if((minCol!=0)&&(minCol!=(dimension-2))&&((minRow==0)&&(minRow!=(dimension-1)))){
				
				this.setBoth(grille, minRow, minCol-1);
				this.setBoth(grille, minRow, minCol+2);
				this.setBoth(grille, minRow+1, minCol);
				this.setBoth(grille, minRow+1, minCol+1);
				
				
			}//stuck with the upper left corner
			else if((minCol==0)&&(minCol!=(dimension-2))&&((minRow==0)&&(minRow!=(dimension-1)))){
		
				this.setBoth(grille, minRow, minCol+2);
				this.setBoth(grille, minRow+1, minCol);
				this.setBoth(grille, minRow+1, minCol+1);	
				
			}//stuck with the upper right corner
			else if((minCol!=0)&&(minCol==(dimension-2))&&((minRow==0)&&minRow!=(dimension-1))){
				
				this.setBoth(grille, minRow, minCol-1);
				this.setBoth(grille, minRow+1, minCol);
				this.setBoth(grille, minRow+1, minCol+1);
				
			}//stuck with the bottom border
			else if((minCol!=0)&&(minCol==(dimension-2))&&((minRow!=0)&&minRow!=(dimension-1))){
				
				this.setBoth(grille, minRow-1, minCol);
				this.setBoth(grille, minRow-1, minCol+1);
				this.setBoth(grille, minRow, minCol-1);
				this.setBoth(grille, minRow, minCol+2);
				
			}//stuck with the bottom left corner
			else if((minCol==0)&&(minCol!=(dimension-2))&&((minRow!=0)&&minRow==(dimension-1))){
				
				this.setBoth(grille, minRow-1, minCol);
				this.setBoth(grille, minRow-1, minCol+1);
				this.setBoth(grille, minRow, minCol+2);
				
			}//stuck with the bottom right corner
			else if((minCol!=0)&&(minCol==(dimension-2))&&((minRow!=0)&&minRow==(dimension-1))){
				
				this.setBoth(grille, minRow-1, minCol);
				this.setBoth(grille, minRow, minCol-1);
				this.setBoth(grille, minRow, minCol+2);
				
			}//stuck with the left border
			else if((minCol==0)&&(minCol!=(dimension-2))&&((minRow!=0)&&minRow!=(dimension-1))){
				
				this.setBoth(grille, minRow-1, minCol);
				this.setBoth(grille, minRow-1, minCol+1);
				this.setBoth(grille, minRow, minCol+2);
				this.setBoth(grille, minRow+1, minCol);
				this.setBoth(grille, minRow+1, minCol+1);
				
			}//stuck with the right border
			else if((minCol!=0)&&(minCol==(dimension-2))&&((minRow!=0)&&minRow!=(dimension-1))){
				
				this.setBoth(grille, minRow-1, minCol);
				this.setBoth(grille, minRow-1, minCol+1);
				this.setBoth(grille, minRow+1, minCol);
				this.setBoth(grille, minRow+1, minCol+1);
				
			}
			
		}
	}
}	
