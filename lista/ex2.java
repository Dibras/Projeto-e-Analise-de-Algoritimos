
package javaapplication4;
/**
 *
 * @author 0038160
 */
public class JavaApplication4 {

    public static void main(String[] args) {
         int[] lista ={10,15,9,15};
        imprimeMeio(lista, 0, lista.length);
    }
    public static void imprimeMeio(int[] lista, int inicio, int fim) {
        if (lista.length%2==0 ){
            int meio = lista[lista.length/2];
            if (meio == 1){
                System.exit(0);
            }           
            System.out.println(meio);
            Imprime_x(lista);
            
           // New_list(lista,0,meio);
            //New_list(lista,meio,fim);
        }
        
        
    }
     public static void Imprime_x(int[] lista){
         for(int i = 0;i < lista.length;i++){
             if ( lista.length%2 == i){
                 System.out.print("x");
             }else{
                System.out.print(lista[i]);
                System.out.print(" ");
             }           
         }
     }
      public static int[] New_list(int[]lista, int inicio, int fim ){
          int[] nova = new int [fim - inicio + 1];
          for (int j = inicio; j< nova.length;j++){
              nova[j] = lista[j];
          }
          return nova;
      }
}
