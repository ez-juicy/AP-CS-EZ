import java.util.Scanner;

class dataV {
  
  static Scanner s = new Scanner(System.in);
  
  public static void main(String[] args) {
    
    System.out.println("This program will keep a running sum of numbers until you say 'done'. ");
    double sum = 0;
    String input = "temp";
    while (true) {
      input = getValidInput();
      if (input.equals("done")) break;
      sum += Double.parseDouble(input);

    }
    System.out.printf("Your sum was %f. %n", sum);
  }
  
  public static String getValidInput() {
    String input = s.nextLine();
    while (!validateInput(input)) {
      System.out.println("That was not a valid input");
      System.out.println("input a number or \"done\".");
      input = s.nextLine();
    }
    return input;
  }
  
  public static boolean validateInput(String input) {
    try{
      if (input.equals("done")){
        return true;
      } 
      Double.parseDouble(input);
      return true;
    } catch(Exception e){
      return false;
    }
  }

}

