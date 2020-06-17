public class BreakContinueSecond {
  public static void windowPosSum(int[] a, int n) {   
    for (int i = 0; i < a.length; i += 1) {
        if (a[i] < 0) {
          continue;}
        for (int j = 1; j < n+1; j += 1){
            if (i + j < a.length) {
             a[i] = a[i] + a[i + j];
            } else {break;}    
        }
    }
  }

  public static void main(String[] args) {
    int[] a = {1, -1, -1, 10, 5, -1};
    int n = 2;
    windowPosSum(a, n);
    // Should print -1, -1, -1, 14, 4, -1
    System.out.println(java.util.Arrays.toString(a));
  }
}