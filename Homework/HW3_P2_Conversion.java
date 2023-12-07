import java.util.*;

class HW3_P2_Conversion {
    
  static Scanner s = new Scanner(System.in);
  static String result;
  static String ss;
  
  public static void main(String[] args) {
    
    System.out.println("Enter the starting number system (binary/octal/decimal/hexadecimal): ");
    ss = SValidation(s).toLowerCase();
    
    String input = NValidation();
    
    System.out.println("Enter the ending number system (binary/octal/decimal/hexadecimal): ");
    String es = SValidation(s).toLowerCase();
    
    result = Conversion(input, ss, es);
    System.out.println("result is " + result);
  }
  
  public static String Conversion(String input, String ss, String es) {
    String result = "0";
    if (es.equals("binary")) {
      result = Integer.toBinaryString(Integer.parseInt(input));
    } else if (es.equals("hexadecimal")) {
      result = Integer.toHexString(Integer.parseInt(input));
    } else if (es.equals("octal")) {
      result = Integer.toOctalString(Integer.parseInt(input));
    } else if (es.equals("decimal")) {
      result = input;
    }
    return result;
  }
  
  public static String NValidation (){
    
    int x = 1;
    System.out.println("please enter a number between 0 to 15");
    
    String input = s.nextLine();
    
    boolean isInputInt = false;
    while (!isInputInt) {
      try { 
        
        if (ss.equals("binary")) {
          x = Integer.parseInt(input, 2);
        } else if (ss.equals("octal")) {
          x = Integer.parseInt(input, 8);
        } else if (ss.equals("hexadecimal")) {
          x = Integer.parseInt(input, 16);
        } else if (ss.equals("decimal")) {
          x = Integer.parseInt(input);
        }
        
        if (x < 0 || x > 15) throw new Exception("Your number should be 0-15");
        isInputInt = true;
        
      } catch (Exception e) {
        System.out.println("Wrong number, please try again");
        input = s.nextLine();
      }      
    }
    return Integer.toString(x);       
  }
  
  public static String SValidation(Scanner s) {
	String sVala = " ";
    boolean isInput = false;
    while (!isInput) {
      System.out.println("pls gimme dType");
      sVala = s.nextLine();
        if (!((sVala.equals("binary") || sVala.equals("decimal") || sVala.equals("octal") || sVala.equals("hexadecimal")))) {
            System.out.println("the system input is wrong, please try again");
        } else {
            isInput = true;
        }
    }
    return sVala;
  }
}
 

