public class Main {
    public static void main(String[] args) {
         int[] arr = new int[] { 10, 3, 41, 54, 23, 76, 12 };
         int temp = arr[0];
 
         System.out.println("Before Sorting :");
         for (int i : arr) {
             System.out.print(i + "\t");
         }
         for (int i = 0; i < arr.length; i++) {
             for (int j = i + 1; j < arr.length; j++) {
                 if(arr[i] > arr[j]){
                   temp = arr[i];
                   arr[i] = arr[j];
                   arr[j] = temp;
                 }
             }
         }
 
         System.out.println("\nAfter Sorting :");
         for (int i : arr) {
             System.out.print(i + "\t");
         }
     }
 }
 