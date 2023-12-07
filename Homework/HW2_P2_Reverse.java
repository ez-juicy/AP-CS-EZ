import java.util.Scanner;

class HW2_P2_Reverse {

  static Scanner s = new Scanner(System.in);    

  public static void main(String[] args) {    
        
    int reversedNumber = 0;
    int temp = 0;
    int x = 1;
    
    System.out.println("please enter a posivite integer");
    
     boolean isInputInty = false;  
    while (!isInputInty) {
      try { 
        x = Integer.parseInt(s.nextLine());
        
        if (x < 0) {
          throw new Exception("Your number should be positive integer"); 
       	} 
        isInputInty = true;
      } catch (Exception e) {
        System.out.println("Your number is not a positive integer");
      }
    
  }
  
   while(x > 0){  
     
     temp = x%10;        
     reversedNumber = reversedNumber * 10 + temp;
     x = x/10;                        
                }   
   System.out.println("Reversed Number is: " + reversedNumber);

    }
  }
    
 

    
