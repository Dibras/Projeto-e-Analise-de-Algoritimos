/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author 0038160
 */
public class JavaApplication3 {
    public static void main(String[] args) {
          int[] esteira1 ={10,15,9,15};
          int[] esteira2 ={5,7,5,10};
          int[] esteira3 ={12,5,2,14};
          int[] resultado = new int [esteira1.length];
          int posi = 0;
           int maior = 2;
          
          for(int i = 0; i < esteira1.length; i++ ){

                if (esteira1[i] > maior && posi <= 2){
                    maior = esteira1[i] ;
                    posi = 1;
                }
                if (esteira2[i] > maior ){
                    maior = esteira2[i] ;
                    posi = 2;
                }

              if (esteira3[i] > maior && posi >= 2){
                  maior = esteira3[i] ;
                  posi = 3;
              }
              
              resultado[i] = maior;
          }
          for(int j =0; j<resultado.length;j++){
              System.out.println(resultado[j]);
          }
    }
}
