import java.util.Scanner;

class HW1_P2_Vcylinder {
  
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Please give me a radius");
    int r = s.nextInt();
    
    System.out.println("Please give me a height");
    int h = s.nextInt();
    
    double v = Math.pow(r,2) * Math.PI * h;
    System.out.format("I have a cylinder " + "%.3f", v);
    
    s.close();
  }
}