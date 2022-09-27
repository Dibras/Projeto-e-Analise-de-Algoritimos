
public class Main<T extends Comparable<T>>{
	 /**
	* Método que recebe um array de inteiros e dois inteiros referentes ao início e ao fim
	* da ordenação desse array, o que nos garante o poder de escolher uma faixa do array
	* para ser ordenado.
	*
	* @param array
	* @param indiceInicio
	* @param indiceFim
	*/
	
	public static void main(String[] args){
	    int[] v = {17, 8, 19, 1, 31, 2, 11};
		System.out.println("Vetor desordenado: ");
	    printVetor(0, v.length, v);
	    System.out.println();
	    
		ordena(v, 0, v.length-1);
		
		System.out.println("Vetor Ordenado: ");
		printVetor(0, v.length, v);

	}
	
	public static void printVetor(int i, int f, int[] v){
	    for(int cont = i; cont < f; cont++)
	        System.out.print(v[cont]+", ");
	    System.out.println();
	    
	}

	
	public static void ordena(int[] array, int indiceInicio, int indiceFim) {

		// Condicional que verifica a validade dos parâmetros passados.
		if (array != null && indiceInicio < indiceFim && indiceInicio >= 0 &&
		 indiceFim < array.length && array.length != 0) {
			int meio = ((indiceFim + indiceInicio) / 2);
            
			ordena(array, indiceInicio, meio);
			ordena(array, meio + 1, indiceFim);
            

            System.out.print("Item 1: ");
			printVetor(indiceInicio, meio + 1, array);
			
			System.out.print("Item 2: ");
            printVetor(meio + 1, indiceFim + 1, array);
            
			merge(array, indiceInicio, meio, indiceFim);
			
			System.out.print("Merge: ");
			printVetor(indiceInicio, indiceFim + 1, array);
			System.out.println();

		}

	}

	/**
	* O merge consiste na junção de duas listas já ordenadas.
	* Usa um array auxiliar.
	*
	* @param array
	* @param indiceInicio
	* @param meio
	* @param indiceFim
	*/
	public static void merge(int[] array, int indiceInicio, int meio, int indiceFim) {
       
		int[] auxiliar = new int[array.length];
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
}
