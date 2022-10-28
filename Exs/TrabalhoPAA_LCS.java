package trab;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Gustavo vilela e Ellen
 */
public class TrabalhoPAA_LCS {
    
    static ArrayList<String> tokens;
    
    public static void main(String[] args){
        tokens = lerPalavrasDicionario();
        Scanner scan = new Scanner(System.in);
        int max = 0;
        String semelhante = "";
        int parada = 1;
        
        String entrada = scan.nextLine();
        entrada = removeAcentos(entrada);
        entrada = entrada.toUpperCase();
        
        if (verificaPalavraChave(entrada)){
            for (int cont = 0; cont <tokens.size(); cont ++){
                if (verificaPalavraChave(tokens.get(cont))){
                    if(entrada.equals(tokens.get(cont).replace(",", ""))){
                        
                        System.out.print ("Achei sua palavra: ");
                        System.out.println (tokens.get(cont).replace(",", ""));
                        System.out.println ("Significado: ");
                        for (int z = cont + 1; z <tokens.size(); z++){
                            if (verificaPalavraChave(tokens.get(z))){
                                System.exit(0);
                            }
                            System.out.print(tokens.get(z));
                            System.out.print(" ");
                        }
                        System.exit(0);
                    }
                    int retorno = lcsProgamacaoDinamica(tokens.get(cont),entrada);
                    
                    if (retorno > max ){
                        max = retorno;
                        semelhante = tokens.get(cont);
                        parada = cont;
                    }
                    
                }
            }
            System.out.println ("Voce quis dizer: ");
            System.out.println (semelhante.replace(",", ""));
            System.out.println ("Nivel semelhança ");
            System.out.println (max);
            System.out.println ("Significado: ");
            for (int a = parada + 1; a <tokens.size(); a++){
                    if (verificaPalavraChave(tokens.get(a))){
                        System.exit(0);
                    }
                    System.out.print(tokens.get(a));
                    System.out.print(" ");
                    
                }
        }else{
            System.out.println ("Nao encontrada");
        }
    }

    //palavra chave deve possuir pelo menos três letras em maiúsculo
    public static boolean verificaPalavraChave(String palavra){
        int cont = 0;
        for(int i = 0; i < palavra.length(); i++){         
            if(Character.isUpperCase(palavra.charAt(i)))
                cont++;
            else
                break;
        }
        
        return cont >= 3;
    }
    
    //Implementar código para encontrar a palavra mais próxima no dicionário
    //e escrever o seu significado
   // public static void encontraPalavraChave(ArrayList<String> tokens, String busca){
        
       
   // }

    public static String removeAcentos(String value) {
        String normalizer = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("[^\\p{ASCII}]");
        return pattern.matcher(normalizer).replaceAll("");
    }
    
   //adicione o código do algoritmo LCS aqui
   public static int lcsProgamacaoDinamica(String y1, String x1){
       
       String [] x = x1.split("");
	   String [] y = y1.split("");
	   int[][] l = new int [y.length + 1][x.length + 1];
	   
	   for(int i = 1; i <= y.length; i++ ){
	        for(int j = 1 ; j <= x.length; j++){
	            if (y[i - 1].equals(x[j - 1])){
	                
	                l[i][j] = l[i - 1][j - 1]+ 1;
	            }else{
	                if(l[i - 1][j] > l[i][j - 1]){
	                    
	                    l[i][j] = l[i - 1][j];
	                }else{
	                   
	                    l[i][j] = l[i][j - 1];
	                }
	            }
	        }
	    }
	    
	    return l[y.length][x.length];
    }

    public static ArrayList<String> lerPalavrasDicionario() {
        try {
            Scanner in;
            in = new Scanner(new FileReader("C:\\Users\\0038160\\Documents\\NetBeansProjects\\trab\\src\\trab\\dicionario.txt"));
            ArrayList<String> tokens = new ArrayList<String>();
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] words = line.split(" ");
                for(String w : words)
                 tokens.add(w);
            }
            return tokens;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}
