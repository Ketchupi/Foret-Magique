package Generation;

import java.lang.*;
import java.util.Random;

import Environement.Cellule;
import Environement.Grille;
import java.lang.*;
import java.lang.Math;

public class RandomMagic {

	private Grille grille;
	
	
	public void generatePlace(Cellule[][] grille, int dimension){
		
		Random generator = new Random();
		int i = generator.nextInt(dimension+1);
		int j = generator.nextInt(dimension+1);
		
		grille[i][j].setMonstre(true);
		
		int k = generator.nextInt(dimension+1);
		int l = generator.nextInt(dimension+1);
		
		do {
			k = generator.nextInt(dimension+1);
			l = generator.nextInt(dimension+1);
		} while ((k!=i)&&(l!=j));
		
		grille[k][l].setTrou(true);
		
		//gestion du cas ou le monstre et le trou sont cote a cote
		if(((java.lang.Math.abs(k-i)+java.lang.Math.abs(l-j))!=1)){
			generateWind(grille,k,l, dimension);
			generateWind(grille,i,j, dimension);
		}
		
	}
	
	public void generateWind(Cellule[][] grille, int i, int j, int dimension){
		
		Cellule[][] cells  = grille;
		
		if((i<dimension)&&(j<dimension)&&(i!=0)&&(j!=0)){
			for(int i1=j-1;i1<(i+1);i1++){
				cells[i][i1].setVent(true);			
			}
			for(int i1=j-1;i1<(j+1);i1++){			
				cells[i1][j].setVent(true);		
			}
		}else if((i==dimension)&&(j<dimension)){
			for(int i1=j-1;i1<(i);i1++){				
				cells[i][i1].setVent(true);				
			}
			for(int i1=j-1;i1<(j+1);i1++){				
				cells[i1][j].setVent(true);				
			}
		}else if((i<dimension)&&(j==dimension)){
			for(int i1=j-1;i1<(i+1);i1++){				
				cells[i][i1].setVent(true);				
			}
			for(int i1=j-1;i1<(j);i1++){				
				cells[i1][j].setVent(true);				
			}
		}else if((i==0)&&(j!=0)){
			for(int i1=0;i1<(i+1);i1++){				
				cells[i][i1].setVent(true);				
			}
			for(int i1=j-1;i1<(j+1);i1++){				
				cells[i1][j].setVent(true);				
			}
		}else if((j==0)&&(i!=0)){
			for(int i1=j;i1<(i+1);i1++){				
				cells[i][i1].setVent(true);				
			}
			for(int i1=0;i1<(j);i1++){				
				cells[i1][j].setVent(true);				
			}
		}else if((i==0)&&(j==0)){
			for(int i1=0;i1<(i+1);i1++){				
				cells[i][i1].setVent(true);				
			}
			for(int i1=0;i1<(j+1);i1++){				
				cells[i1][j].setVent(true);				
			}
		}else if((i==dimension)&&(j==dimension)){
			for(int i1=(i-1);i1<(i);i1++){				
				cells[i][i1].setVent(true);				
			}
			for(int i1=(j-1);i1<(j);i1++){				
				cells[i1][j].setVent(true);				
			}
		}	
	}
	
	public void generateSmell(Cellule[][] grille, int i, int j, int dimension){
		
		Cellule[][] cells  = grille;
		
		if((i<dimension)&&(j<dimension)&&(i!=0)&&(j!=0)){
			for(int i1=j-1;i1<(i+1);i1++){
				cells[i][i1].setCaca(true);			
			}
			for(int i1=j-1;i1<(j+1);i1++){			
				cells[i1][j].setCaca(true);		
			}
		}else if((i==dimension)&&(j<dimension)){
			for(int i1=j-1;i1<(i);i1++){				
				cells[i][i1].setCaca(true);				
			}
			for(int i1=j-1;i1<(j+1);i1++){				
				cells[i1][j].setCaca(true);				
			}
		}else if((i<dimension)&&(j==dimension)){
			for(int i1=j-1;i1<(i+1);i1++){				
				cells[i][i1].setCaca(true);				
			}
			for(int i1=j-1;i1<(j);i1++){				
				cells[i1][j].setCaca(true);				
			}
		}else if((i==0)&&(j!=0)){
			for(int i1=0;i1<(i+1);i1++){				
				cells[i][i1].setCaca(true);				
			}
			for(int i1=j-1;i1<(j+1);i1++){				
				cells[i1][j].setCaca(true);				
			}
		}else if((j==0)&&(i!=0)){
			for(int i1=j-1;i1<(i+1);i1++){				
				cells[i][i1].setCaca(true);				
			}
			for(int i1=0;i1<(j);i1++){				
				cells[i1][j].setCaca(true);				
			}
		}else if((i==0)&&(j==0)){
			for(int i1=0;i1<(i+1);i1++){				
				cells[i][i1].setCaca(true);				
			}
			for(int i1=0;i1<(j+1);i1++){				
				cells[i1][j].setCaca(true);				
			}
		}else if((i==dimension)&&(j==dimension)){
			for(int i1=(i-1);i1<(i);i1++){				
				cells[i][i1].setCaca(true);				
			}
			for(int i1=(j-1);i1<(j);i1++){				
				cells[i1][j].setCaca(true);				
			}
		}	
	}
	
	public void generateBoth(Cellule[][] grille, int i, int j, int k, int l, int n, int dimension){
		
		int minRow = java.lang.Math.min(i, k);
		int minCol = java.lang.Math.min(j, l);
		
		//Les deux mechants sont alignes en colonne
		if((j-l)==0){	
			
			if(((k-1)!=0)&&((k+1)!=(dimension+1))){
				
				grille[i][minCol].setCaca(true);
				grille[i][minCol].setVent(true);
				grille[i+1][minCol].setCaca(true);
				grille[i+1][minCol].setVent(true);
				grille[i-1][minCol].setVent(true);
				grille[i-1][minCol].setCaca(true);
				grille[minRow-1][j].setVent(true);
				grille[minRow+2][j].setCaca(true);
				
			}else if((k-1)==0&&((k+1)!=(dimension+1))){
				
				grille[i][minCol+1].setCaca(true);
				grille[i+1][minCol+1].setVent(true);
				
			}else if((k+1)!=(dimension+1)){
				
				grille[i][minCol-1].setCaca(true);
				grille[i+1][minCol-1].setVent(true);
				
			}
		}
		
		//Les deux mechants sont alignes en ligne
		if((i-l)==0){
			grille[minRow][minCol].setCaca(true);
			grille[minRow][minCol].setVent(true);
			grille[minRow][minCol+1].setCaca(true);
			grille[minRow][minCol+1].setVent(true);
		}
	}
}	
