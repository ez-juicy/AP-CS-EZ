import java.util.*;

class Lab8_CaeserCipher {
  
  static Scanner s = new Scanner(System.in);
  static final String encrypt = "e";
  static final String decrypt = "d";
    
  public static void main(String[] args) {
        
    System.out.println("Would you like to (E)ncrypt or (D)ecrypt a message?");
  	boolean doEncrypt = getEorD().equals("E");
    
    System.out.println("Enter your shift value: ");
    int shift = getShift();
    
    System.out.println("Enter your message: ");
    String message = s.nextLine();
    
    System.out.printf("Your %s message is: %n%s%n", 
                      doEncrypt ? "encrypted" : "decrypted", 
                      shiftMessage(message, shift, doEncrypt));   
                      
    s.close();
  }
    
 public static String shiftMessage(String message, int shift, boolean doEncrypt) {
   
   StringBuilder sb = new StringBuilder();

   for (char c : message.toCharArray()) {
     
     if (Character.isLetter(c)) {
       
       char shiftedChar = (char) (c + (doEncrypt ? shift : -shift));
       
       if ((Character.isLowerCase(c) && shiftedChar > 'z') || (Character.isUpperCase(c) && shiftedChar > 'Z')) {
         shiftedChar -= 26;
         
       } else if ((Character.isLowerCase(c) && shiftedChar < 'a') || (Character.isUpperCase(c) && shiftedChar < 'A')) {
         shiftedChar += 26;
       }
       
       sb.append(shiftedChar);
       
     } else {
       sb.append(c);
     }
     
   }
   
   return sb.toString();
}
  
  public static int getShift() {
    return dataValidation();
  }
  
  
  public static String getEorD() {
    String Char = "";
    boolean bool = false;
    while (!bool) {
      Char = s.nextLine().toUpperCase();
      if (Char.toLowerCase().equals("e") || Char.toLowerCase().equals("d")) {
        bool = true;
      } else {
        System.out.println("Your letter should be e or d");
      }
    }

    return Char;
  }
  
  public static int dataValidation() {
    
    int input = -1;
    boolean isInputInty = false;  
    while (!isInputInty) {
      try { 
        
        input = Integer.parseInt(s.nextLine());
        
        if (!(input >= -25 && input <= 25)) {
          throw new Exception("Your number should be valid integer"); 
       	} 
        
        isInputInty = true;
        
      } catch (Exception e) {
        System.out.println("Give me a valid integer");
      }
      
    }
    return input;
  }    
  
}




  
 