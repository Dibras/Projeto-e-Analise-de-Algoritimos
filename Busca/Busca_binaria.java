/******************************************************************************


public class Main
{
	public static void main(String[] args) {
		int[] v = {3,5,6,7,8,9};
		BuscaBinaria(5,0,v.length,v);
	}
	public static void BuscaBinaria(int busca,int i, int f, int[] vetor){
	    if(i >=f ){
	        
	        System.out.println("Nao encontrei! ");
	        System.exit(0);
	    }
	    int Indice_meio = (i + f) / 2 ;
	    int meio = vetor[Indice_meio] ;
	    
	    if(meio==busca){
	        System.out.println("Encontrei " + busca +" na posiçao: "+Indice_meio);
	    }
	    if(meio<busca){
	        BuscaBinaria(busca,Indice_meio+1,f,vetor);
	    }
	    if(meio>busca){
	        BuscaBinaria(busca,i,Indice_meio,vetor);
	    }
	}
	
}
