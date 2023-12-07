import java.util.*;

class Lab_sortingA {
  public static void main(String[] args) {
    
    int [] arr1 = initRandomArray(20);
    int [] arr2 = initRandomArray(20);
    int [] arr3 = initRandomArray(20);    
    System.out.println("Initial array: ");
    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
    System.out.println(Arrays.toString(arr3));


    System.out.println("\n After sorting: ");
    bubbleSort(arr2);
    System.out.println(Arrays.toString(arr2));
    insertionSort(arr1);
    System.out.println(Arrays.toString(arr1));
    SelectionSort(arr3);
    System.out.println(Arrays.toString(arr3));


  }

  public static void insertionSort(int [] arr1) {
    for (int idxToSort = 1; idxToSort < arr1.length; idxToSort++) {
      int i = idxToSort;
      int j = i-1;
      
      while (j >= 0) {
        if (arr1[i] < arr1[j]) {
          int temp = arr1[i];
          arr1[i] = arr1[j];
          arr1[j] = temp;
        } else {
          break;
        }
        i--; j--;
      }
      
    }
    
  }
  
  public static void bubbleSort(int [] arr2) {
      for (int i = 0; i < arr2.length-1; i++){
        for (int j = 0; j < arr2.length - i -1; j++){
          if (arr2[j + 1] < arr2[j]) {
            int temp = arr2[j];
            arr2[j] = arr2[j+1];
            arr2[j+1] = temp;
          }
        }
      }
  }
  
  public static void SelectionSort(int [] arr3) {
    for (int i = 0; i < (arr3.length -1); i++){
      int min= i;
      for (int j = i+1; j<= (arr3.length - 1); j++){
        if (arr3[min] > arr3[j]){
          min = j;
        }
      }
      int temp = arr3[i];
      arr3[i] = arr3 [min];
      arr3[min] = temp;
    }
  }
  
  public static int [] initRandomArray(int len) {
    int [] arr = new int[len];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random()*100);
    }
    return arr;
  }
}
