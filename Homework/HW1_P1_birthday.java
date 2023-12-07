import java.util.Scanner;

class HW1_P1_birthday {
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    
    System.out.println("Please input your date fo birth in a format YYYYMMDD");
    int birthday = s.nextInt();
    
    int date = birthday % 100;
    
    int year = birthday / 10000;
    
    int month = birthday % 10000 / 100;
    
    System.out.println("Your birthday in Month/Date/Year format is" + month + "/" + date + "/" + year);
  }
}
