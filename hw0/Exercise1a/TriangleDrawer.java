public class TriangleDrawer {
   public static void drawTriangle(int N) {
      int x = 1;
      int y = 0;
	   while (x < N) { 
	   while (y < x) {
	   System.out.print('*');
	   y = y + 1;
	   }
	   System.out.println(); 
	   x = x + 1;
	   y = 0;
	   }       
   }
   
   public static void main(String[] args) {
   drawTriangle(11);
      
   }
}