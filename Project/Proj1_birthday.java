import java.util.Scanner;

class Proj1_birthday {
  public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in);
    
    System.out.println("please input the first person's name. ");
    String name1 = s.nextLine();
    
    System.out.println("Please input first person's date of birth in a format YYYYMMDD");
    int birthday1 = s.nextInt();
    s.nextLine();
    
    int date1 = birthday1 % 100;

    int year1 = birthday1 / 10000;
    
    int month1 = birthday1 % 10000 / 100;
    
    System.out.println("please input the Second person's name. ");
    String name2 = s.nextLine();
    
    System.out.println("Please input Second person's date of birth in a format YYYYMMDD");
    int birthday2 = s.nextInt();
    
    int date2 = birthday2 % 100;

    int year2 = birthday2 / 10000;
    
    int month2 = birthday2 % 10000 / 100;
    
   switch (month1) {
      case 1:
        System.out.println("January for the 1st person");
        break;
      case 2:
        System.out.println("Febuary for the 1st person");
        break;
      case 3:
        System.out.println("March for the 1st person");
        break;
      case 4:
        System.out.println("April for the 1st person");
        break;
      case 5:
        System.out.println("May for the 1st person");
        break;
      case 6:
        System.out.println("June for the 1st person");
        break;
      case 7:
        System.out.println("July for the 1st person");
        break;
      case 8:
        System.out.println("August for the 1st person");
        break;
      case 9:
        System.out.println("September for the 1st person");
        break;
      case 10:
        System.out.println("October for the 1st person");
        break;
      case 11:
        System.out.println("November for the 1st person");
        break;
      case 12:
        System.out.println("December for the 1st person");
        break;
      default:
        System.out.println("That is not a valid number");
    }
    
    switch (month2) {
      case 1:
        System.out.println("January for the 2nd person");
        break;
      case 2:
        System.out.println("Febuary for the 2nd person");
        break;
      case 3:
        System.out.println("March for the 2nd person");
        break;
      case 4:
        System.out.println("April for the 2nd person");
        break;
      case 5:
        System.out.println("May for the 2nd person");
        break;
      case 6:
        System.out.println("June for the 2nd person");
        break;
      case 7:
        System.out.println("July for the 2nd person");
        break;
      case 8:
        System.out.println("August for the 2nd person");
        break;
      case 9:
        System.out.println("September for the 2nd person");
        break;
      case 10:
        System.out.println("October for the 2nd person");
        break;
      case 11:
        System.out.println("November for the 2nd person");
        break;
      case 12:
        System.out.println("December for the 2nd person");
        break;
      default:
        System.out.println("That is not a valid number");
    }
    
    
    if (birthday1 < birthday2) {
      System.out.println(name1 + " who born in " + birthday1 + " is older than another.");
    } else if (birthday2 < birthday1 ) {
      System.out.println((name2) + " who born in " + birthday2 + " is older than another.");
    } else {
      System.out.println(name1 + " and " + name2 + "are in the same age");
    } 
  }
}

