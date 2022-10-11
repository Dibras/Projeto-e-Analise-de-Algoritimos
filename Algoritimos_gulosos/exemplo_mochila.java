
public class Main
{
	public static void main(String[] args) {
	    double[] w = {18,15,10};
	    double[] p = {25,24,15};
	    
	    double ganho = problemaMochila(w, p, 20);
		System.out.println("O ganho total foi: "+ganho);
	}
	
	public static double problemaMochila(double[] w, double[] p, double capacidadeMochila){
	    double[] mochila = new double[w.length];
	    double quantidadeAtual = 0;
	    double ganhoFinal = 0;
	    ordenarPorCustoBeneficio(w, p);
	    
	    for(int cont = 0; cont < w.length; cont++){
	        
	        double espacoMochila = capacidadeMochila - quantidadeAtual;
	        if(espacoMochila == 0)
	            return ganhoFinal;
	            
	        if(espacoMochila >= w[cont]){//cabe o peso total do item na mochila!
	        
	            mochila[cont] = w[cont];
		        quantidadeAtual = quantidadeAtual + w[cont];
		        ganhoFinal = ganhoFinal + p[cont];
		        
		        System.out.print("Item: ");
		        System.out.print(cont + 1);
		        
		        System.out.print(" peso:");
		        System.out.print(w[cont]);
		        
		        System.out.print(" valor:");
		        System.out.println(p[cont]);
		        
	        }
	        else{ //vamos adicionar apenas uma porção do item na mochila
	            mochila[cont] = espacoMochila;
		        quantidadeAtual = quantidadeAtual + espacoMochila; //ou seja: capacidade_mochila
		        ganhoFinal = ganhoFinal + (p[cont] / w[cont]) * espacoMochila;
		        
		        System.out.print("Item: ");
		        System.out.print(cont + 1 );
		        
		        System.out.print(" peso:");
		        System.out.print(espacoMochila);
		        
		        System.out.print(" valor:");
		        System.out.println((p[cont] / w[cont]) * espacoMochila);
	        }
	    }
	    return ganhoFinal;
	}
	
	public static void ordenarPorCustoBeneficio(double[] w, double[] p){
	     //cria vetor de custo beneficio:
	     double[] v = new double[w.length];
	     for(int c = 0; c < w.length; c++)
	        v[c] = p[c]/w[c];
	        
	     //Método da Bolha -> mais simples
	     // for utilizado para controlar a quantidade de vezes que o vetor será ordenado.
        for(int i = 0; i < v.length - 1; i++) {
          // for utilizado para ordenar o vetor.
          for(int j = 0; j < v.length - 1 - i; j++) {
            /* Se o valor da posição atual do vetor for maior que o proximo valor,
              então troca os valores de lugar no vetor. */
            if(v[j] < v[j + 1]) {
              double aux = v[j];
              v[j] = v[j + 1];
              v[j + 1] = aux;
              //muda tbm no vetor w:
              aux = w[j];
              w[j] = w[j + 1];
              w[j + 1] = aux;
              //muda tbm no vetor p:
              aux = p[j];
              p[j] = p[j + 1];
              p[j + 1] = aux;
            }
          }
        }
	}
}


