public class Exercise1b {
   public static void main(String[] args) {
      
      drawTriangle(10);
      
      
      
   }
   
   public static void drawTriangle(int N) {
      
    	int n = 1;
    	while (n <= N) {
    		int i = 0;
    		while(i < n) {
    			System.out.print("*");
    			i = i + 1;
    		}
    		System.out.print("\n");
    		n = n + 1;
    	}
   
   
   }
}