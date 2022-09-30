/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    int f = 100;
	    int i = 1;
	    System.out.print("Escolha um número de 1 à ");
		System.out.println(f);
		buscaNumero(i,f);
		
	}
	public static void buscaNumero(int i, int f){
	    Scanner in1 = new Scanner(System.in);
	    System.out.println(i);
	    System.out.println(f);
	    String entrada = "";
	    int meio = (f + i) /2;
	    //int meio2 = meio + i;
	    if((i + 2) == f ){
	        System.out.print("Seu numero é ");
            System.out.print(i);
	        System.exit(0);
	    }
        System.out.print("Seu numero é maior ou igual (>=) a ");
        System.out.print(meio);
        
        System.out.println("(s/n)?");
        entrada = in1.nextLine();
        
        if (entrada.equals("s")){
            
            buscaNumero(meio,f + 1);
        }
        if (entrada.equals("n")){
            
            buscaNumero(i,meio);
        }
        System.out.println(entrada);
	}
}
