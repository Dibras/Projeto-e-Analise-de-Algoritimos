
public class Main
{
	public static void main(String[] args) {
	    int w[] = {10 , 3};
	    int p[] = {1000, 200};
	    double[] cb = new double[w.length];
	    int bag[];
	    int capacidade_mochila = 20;
	    int quantidade_atual = 0;
	    double ganho_final = 0.0;
	    
 
	    custo_beneficio(w,p,cb);
	    printVetor(0, cb.length, cb);
	    ordena(cb,0,cb.length - 1);
	    printVetor(0, cb.length, cb);
	    
	    guloso(bag,capacidade_mochila,quantidade_atual,ganho_final,cb,w,p);
	    
	}
	public static double guloso(int bag[], int capacidade_mochila,int quantidade_atual,double ganho_final,double[] cb,int[] w,int[] p){
	    private int espaço_mochila = 0;
	    for(int cont=0;cb.length;cont++){
	        espaço_mochila = capacidade_mochila - quantidade_atual;
	        if(espaço_mochila==0){
	            printVetor(0,bag.length,bag);
	            System.out.println(ganho_final);
	        }
	        if(espaço_mochila>=w[cont]){
	            bag[cont] = bag[cont].Append w[cont]
	        }else{
	            
	        }
	    }
	}
	public static void printVetor(int i, int f, double[] v){
	    for(int cont = i; cont < f; cont++)
	        System.out.print(v[cont]+", ");
	    System.out.println();
	    
	}
	public static void ordena(double[] array, int indiceInicio, int indiceFim) {

		// Condicional que verifica a validade dos parâmetros passados.
		if (array != null && indiceInicio < indiceFim && indiceInicio >= 0 &&
		 indiceFim < array.length && array.length != 0) {
			int meio = ((indiceFim + indiceInicio) / 2);
            
			ordena(array, indiceInicio, meio);
			ordena(array, meio + 1, indiceFim);
			merge(array, indiceInicio, meio, indiceFim);
			
		}

	}
	public static void merge(double[] array, int indiceInicio, int meio, int indiceFim) {
       
		double[] auxiliar = new double[array.length];
		//Copiando o trecho da lista que vai ser ordenada
		for (int i = indiceInicio; i <= indiceFim; i++) {
			auxiliar[i] = array[i];
		}

		//Índices auxiliares
		int i = indiceInicio;
		int j = meio + 1;
		int k = indiceInicio;

		//Junção das listas ordenadas
		while (i <= meio && j <= indiceFim) {
			if (auxiliar[i] < auxiliar[j]) {
				array[k] = auxiliar[i];
				i++;
			} else {
				array[k] = auxiliar[j];
				j++;
			}
			k++;
		}

		//Append de itens que não foram usados na Junção
		while (i <= meio) {
			array[k] = auxiliar[i];
			i++;
			k++;
		}

		//Append de itens que não foram usados na Junção
		while (j <= indiceFim) {
			array[k] = auxiliar[j];
			j++;
			k++;
		}
	}
	
    public static void custo_beneficio(int[] w,int[] p,double[] cb){
        for(int i=0;w.length >i;i++){
            cb[i] = p[i]/w[i];
        }
    }
}

