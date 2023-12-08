import java.util.Scanner;

class Lab0915 {
  public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in);
    
    System.out.println("Please input a number:");
    int x = s.nextInt();
    
    if ((x % 3 == 0) && (x % 4 ==0) && (x % 5 ==0)) { 
      System.out.println("This number is divisible by 3 and 4 and 5.");
    } else if ((x % 3 == 0) && (x % 4 ==0)) {
      System.out.println("This is number is divisible by 3 and 4.");
    } else if ((x % 4 ==0) && (x % 5 ==0)) {
      System.out.println("This number is divisble by 4 and 5.");
    } else if ((x % 5 == 0) && (x % 3 ==0)) {
          System.out.println("This number is divisble by 3 and 5.");
    } else if (x % 3 ==0){
            System.out.println("This number is divisble by 3.");
    } else if (x % 4 ==0) {
            System.out.println("This number is divisble by 4.");
    } else if (x % 5 ==0){
            System.out.println("This number is divisble by 5.");
    } else {
      System.out.println("This number is not divisible by 3 or 4 or 5.");
    }   

    s.close();
  }
}

