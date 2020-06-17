public class Maxarray {
	   public static int max(int[] m) {
	      int i = 1;
	      int maxnum = m[0];
	      while (i < m.length) {
	         
	         if (m[i] > maxnum) 
	            maxnum = m[i]; 
	         i = i + 1;
	      }
	      return maxnum;
	   }
	   
	   public static void main(String[] args) {
	      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
	      System.out.print(max(numbers));    
	      }
	   }