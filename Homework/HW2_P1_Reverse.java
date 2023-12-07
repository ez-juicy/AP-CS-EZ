import java.util.Scanner;

class HW2_P1_Reverse {
  
    public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in);
    
    System.out.println("Please say something");
    String x = s.nextLine();
        
    for (int i = x.length()-1; i >= 0; i--) { 
      System.out.print(x.charAt(i));
	}
  }
}
