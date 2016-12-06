package Generation;

import java.lang.*;
import java.util.Random;

import Environement.Cellule;
import Environement.Grille;



public class RandomMagic {

	private int n;
	private Grille grille;
	
	
	public int[] generatePlace(){
		
		Random generator = new Random();
		int i = generator.nextInt(n+1);
		int j = generator.nextInt(n+1);
		
		int[] list = new int[2];
		list[0] = i;
		list[1] = j;
		return list;
	}
	
	public void generateWind(int i, int j){
		
		Cellule[][] cells  = grille.getCellules();
		
		if((i<n)&&(j<n)&&(i!=0)&&(j!=0)){
			for(int i1=j-1;i1<(i+1);i1++){
				cells[i][i1].setVent(true);			
			}
			for(int i1=j-1;i1<(j+1);i1++){			
				cells[i1][j].setVent(true);		
			}
		}else if((i==n)&&(j<n)){
			for(int i1=j-1;i1<(i);i1++){				
				cells[i][i1].setVent(true);				
			}
			for(int i1=j-1;i1<(j+1);i1++){				
				cells[i1][j].setVent(true);				
			}
		}else if((i<n)&&(j==n)){
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
			for(int i1=j-1;i1<(i+1);i1++){				
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
		}else if((i==n)&&(j==n)){
			for(int i1=(i-1);i1<(i);i1++){				
				cells[i][i1].setVent(true);				
			}
			for(int i1=(j-1);i1<(j);i1++){				
				cells[i1][j].setVent(true);				
			}
		}	
	}
	
	public void generateSmell(int i, int j){
		
		Cellule[][] cells  = grille.getCellules();
		
		if((i<n)&&(j<n)&&(i!=0)&&(j!=0)){
			for(int i1=j-1;i1<(i+1);i1++){
				cells[i][i1].setCaca(true);			
			}
			for(int i1=j-1;i1<(j+1);i1++){			
				cells[i1][j].setCaca(true);		
			}
		}else if((i==n)&&(j<n)){
			for(int i1=j-1;i1<(i);i1++){				
				cells[i][i1].setCaca(true);				
			}
			for(int i1=j-1;i1<(j+1);i1++){				
				cells[i1][j].setCaca(true);				
			}
		}else if((i<n)&&(j==n)){
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
		}else if((i==n)&&(j==n)){
			for(int i1=(i-1);i1<(i);i1++){				
				cells[i][i1].setCaca(true);				
			}
			for(int i1=(j-1);i1<(j);i1++){				
				cells[i1][j].setCaca(true);				
			}
		}	
	}
}	
