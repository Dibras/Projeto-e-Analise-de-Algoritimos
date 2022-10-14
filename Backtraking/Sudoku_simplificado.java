
public class Main
{
	public static void main(String[] args) {
		int tabuleiro [][] = {{0,2,3},
		                   {3,0,2},
		                   {2,3,0}};
		public static int numero_coluna = 3;
	    public static int numero_linha = 3;
		//System.out.print(tentativa(tabuleiro,0,0));
		//tentativa(tabuleiro,0,0);
		tentativa(tabuleiro,0,0);
	}
	
	
	public static int tentativa(int[][] tabuleiro, int li, int ci){
	   
	    for(int l = li; l < numero_linha; l++){
	        for(int c = ci; c < numero_coluna; c++){
	            if(tabuleiro[l][c]!=0){
	                continue;
	            }
	            boolean sem_saida = true;
	            for(int n = 1; n < numero_coluna; n++){
	                boolean pode_add = checa(tabuleiro,l,c,n);
	                if (pode_add){
	                    tabuleiro[l][c] = n;
	                    sem_saida = false;
	                    
	                    int nc = c;
	                    int nl = l;
	                    if (c < numero_coluna - 1){
	                        nc = nc + 1;
	                    }else{
	                        nl = nl + 1;
	                        nc = 0
	                    }
	                    tentativa(tabuleiro,nl,nc);
	                }
	            }
	            if(sem_saida){
	                return 0;
	            }
	        }
	    }
	    return 0;
	}
	
	public static boolean checa(int [][] tabuleiro, int ln, int cn, int n){
	    for(int l = 0; l < numero_linha;l++){
	        if (tabuleiro[l][cn]==n){
	            return false;
	        }
	    }
	    for(int c = 0; c < numero_coluna; c++){
	        if(tabuleiro[ln][c]==n){
	            return false;
	        }
	    }
	    return true;
	}
	
}

