/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author Gustavo VIlela e Ellen
 */

public class Sudoku_simplificado
{
	public static void main(String[] args) {
            
            int tabuleiro [][] = {{0,0,0},
		                   {0,1,0},
		                   {0,0,2}};

            tentativa(tabuleiro,0,0);
            
            for(int i = 0; i < 3;i++){
                 for(int j = 0; j < 3;j++){
                     System.out.print(tabuleiro[i][j]);
                 }
                  System.out.println("");
            }
	}
	
	
	public static int tentativa(int[][] tabuleiro, int li, int ci){
            int numero_coluna = 3;
	    int numero_linha = 3;
	    for(int l = li; l < 3; l++){
	        for(int c = ci; c < numero_coluna; c++){
	            if(tabuleiro[l][c]!=0){
	                continue;
	            }
	            boolean sem_saida = true;
	            for(int n = 1; n <= numero_coluna; n++){
	                boolean pode_add = checa(tabuleiro,l,c,n);
	                if (pode_add){
	                    tabuleiro[l][c] = n;
	                    sem_saida = false;
                            
	                    System.out.print("Linha: ");
                            System.out.print(l + 1);
                            System.out.print(" Coluna: ");
                            System.out.print(c + 1);
                            System.out.print(" Valor: ");
                            System.out.println(n);
                            
	                    int nc = c;
	                    int nl = l;
	                    if (c < numero_coluna - 1){
	                        nc = nc + 1;
	                    }else{
	                        nl = nl + 1;
	                        nc = 0;
	                    }
	                    tentativa(tabuleiro,nl,nc);
	                }
	            }
	            if(sem_saida){
                        System.out.println(" passou ");
	                break;
	            }
                    
	        }
	    }
	    return 0;
	}
	
	public static boolean checa(int [][] tabuleiro, int ln, int cn, int n){
            int numero_coluna = 3;
	    int numero_linha = 3;
	    for(int l = 0; l < numero_linha;l++){
	        if (tabuleiro[l][cn] == n){
	            return false;
	        }
	    }
	    for(int c = 0; c < numero_coluna; c++){
	        if(tabuleiro[ln][c] == n){
	            return false;
	        }
	    }
	    return true;
	}
	
}
