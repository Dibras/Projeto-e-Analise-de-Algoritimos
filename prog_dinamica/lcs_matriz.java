

public class Main
{
	public static void main(String[] args) {
	    String [] x = "guistavo".split("");
	    String [] y = "gustavci".split("");
		int[][] l = new int [x.length + 1][y.length + 1];
		lcs(l,x,y);
	}
	public static void lcs (int[][] l,String[] x, String[] y ){
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
	    System.out.println(l[x.length][y.length]);
	}
}
