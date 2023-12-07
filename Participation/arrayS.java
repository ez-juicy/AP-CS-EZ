import java.util.*;

class arrayS {

  public static void main(String[] args) {
    
    int [] arr = initRandomSortedArray(20);
    System.out.println(Arrays.toString(arr) + "\n");
    int x12 = arr[12];

    String isIn = linearSearch(arr, x12) ? "" : "NOT ";
    System.out.println("Linear search: " + x12 + " is " + isIn + "in arr.");
    isIn = linearSearch(arr, x12+1) ? "" : "NOT ";
    System.out.println("Linear search: " + (x12+1) + " is " + isIn + "in arr.");
    System.out.println();

    isIn = binarySearch(arr, x12) ? "" : "NOT ";
    System.out.println("Binary search: " + x12 + " is " + isIn + "in arr.");
    isIn = binarySearch(arr, x12+1) ? "" : "NOT ";
    System.out.println("Binary search: " + (x12+1) + " is " + isIn + "in arr.");
    
  }

  public static boolean linearSearch(int [] arr, int target) {
    for (int x : arr) {
      if (x == target) return true;
    }
    return false;
  }
  
  public static boolean binarySearch(int [] arr, int target) {
    //start from middle, then search, depend if it is first or second. and repeat
    int start = 0;
    int end = arr.length -1;
    
    while (start != end) {
      
      int middle = (start + end) / 2; 
    
      if (arr[middle] == target) {
        return true;
      } else if (arr[middle] > target) {
        end = middle - 1;
      } else if (arr[middle] < target) {
        start = middle + 1;}
    }
    return false;
  }
  
  public static int [] initRandomSortedArray(int len) {
    int [] arr = new int[len];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random()*100);
    }
    Arrays.sort(arr);
    return arr;
  }
}
