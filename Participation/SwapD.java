
class SwapD {
  
  static int a;
  static int b;
  
  public static void main(String[] args) {
      
    a = 5;
    b = 10;
    System.out.printf("Before swap: a=%d, b=%d %n", a, b);
    swapWithTemp();
    System.out.printf("After swap: a=%d, b=%d %n", a, b);
    
    
    System.out.println();
    
    a = 5;
    b = 10;
    System.out.printf("Before swap: a=%d, b=%d %n", a, b);
    swapNoTemp();
    System.out.printf("After swap: a=%d, b=%d %n", a, b);
    
    
  }
  
  public static void swapWithTemp() {
    int temp = a;
    a = b;
    b = temp;
    // swap a and b. you MAY use a new variable to temporarily 
    // store a value. 
  }
  
  public static void swapNoTemp() {
    a = a + b; // a = 15
    b = a - b; // b = 5
    a = a - b; // a = 10
    // swap a and b WITHOUT initializing a new variable
  }
}
