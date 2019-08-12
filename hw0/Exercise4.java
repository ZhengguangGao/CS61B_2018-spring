public class Exercise4 {
  public static void windowPosSum(int[] a, int n) {
    for (int i=0;i<a.length;i+=1){
      if(a[i] <= 0){
        continue;
      }else{
        int sum=0;
        for (int j = i;j<=i+n;j+=1){
          if(j<a.length){
            sum += a[j];
          }else{
            break;
          }
        }
        a[i] = sum;
      }
    }


    /** your code here */ 
  }

  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}