import java.util.Scanner;

class Lab3_PrimeNumber {
  
  static Scanner s = new Scanner(System.in);
  //share by all the classes
  
  public static void main(String[] args) {
    
    System.out.println("Please tell me how many Prime Number do u want");
    int input = dataValidation();
    //input will check by the dataValidation
    
    int [] arr = new int [input];
    //let the length of an array equal to the input
    
    int n = 0;
    int primeTest = 2;
    while (n < input) {
      if (primeNumber(primeTest)){
          arr[n] = primeTest;
          n++;
      }
      primeTest++;
      /*primeTest increment when the while test become ture.
      when the boolean become true, then increase*/
    }
    
    printNeat(arr);

  }  
 
  public static int dataValidation() {
    
    int input = -1;
    boolean isInputInty = false;  
    while (!isInputInty) {
      try { 
        input = Integer.parseInt(s.nextLine());
        
        if (input < 0) {
          throw new Exception("Your number should be positive integer"); 
       	} 
        isInputInty = true;
      } catch (Exception e) {
        System.out.println("Your number is not a positive integer");
      }
  }
    return input;
  }    
  
  public static boolean primeNumber (int primeTest) {
    
    for (int j = 2; j <= Math.sqrt(primeTest); j++) {
      if (primeTest % j == 0) {
        return false;
      }
    }
    return true;
  }
  
  public static void printNeat(int [] arr){
    
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    } 
    
  } 
}

 
