import java.util.*;

class Proj2_battlefield {
  
  static Scanner s = new Scanner(System.in);
  static int nrows;// set both to to 4-10
  static int nclos;
  static char [][] board = new char [nrows][nclos];
  static int shipLen; //change to 2-4
  static ArrayList<String> previousInputs = new ArrayList<>(); // put the valid input into an arraylist
  static ArrayList<String> shipLocation = new ArrayList<>(); // store ship location into an arralist
  
  public static void main(String[] args) {
    
    nrows = dataRow(); //data validation for the row input
    nclos = dataCol(); //data validation for the columns input
    shipLen = dataValShipLen(); //data validation for the ship length input
    
    board = new char [nrows][nclos];
    
    initBoard(); 
    randomShip();

    int count = 0; // initialize the fire count
    char[] input; 
    String inputString;
    
    /*if the arraylist contain input,
      then ship length minus one until it become to zero, 
      then the while loop will stop and the fire count will be print*/ 
    while (shipLen > 0) {  // Continue until the ship's length reaches zero
      input = dataValidation();
      inputString = String.valueOf(input);
      
      if (shipLocation.contains(inputString)) {
        shipLen--;
      } 
      
      fire(input);
      updateBoard(inputString);
      count++;
    }
    System.out.println("The total fire number is " + count);
  }
  
  

  public static void updateBoard(String inputString) {
    
    char colChar = inputString.charAt(0);
    char rowChar = inputString.charAt(1);

    // Convert row and column characters to indices
    int rowIndex = rowChar - '0';
    int colIndex = colChar - 'A';

    if (shipLocation.contains(inputString)) {
      board[rowIndex][colIndex] = 'H';
    } else {
      board[rowIndex][colIndex] = 'M';
    }
    
    printBoard();//update the board
  }
  
  public static void printBoard() {
    
    System.out.println();
    
     // Print row numbers
    System.out.print("  ");
    for (int i = 0; i < nrows && i < 10; i++) {
      System.out.print((char) ('A' + i) + " ");  // Print column letters
    }
    System.out.println();

    // Print column labels and board content
    for (int i = 0; i < nclos && i < 10; i++) {
      System.out.print(i + " ");  // Print row numbers
      for (int j = 0; j < nrows; j++) {
        char cellValue = board[i][j];
        if (cellValue == '\u0000') {
          System.out.printf("  ");
        } else {
          System.out.printf("%c ", cellValue);
        }
      }
      System.out.println();
    }
  }

  //set board
  public static void initBoard() {
        
    // Print row numbers
    System.out.print("  ");
    for (int i = 0; i < nrows && i < 10; i++) {
      System.out.print((char) ('A' + i) + " ");  // Print column letters
    }
    System.out.println();

    // Print column labels and board content
    for (int i = 0; i < nclos && i < 10; i++) {
      System.out.print(i + " ");  // Print row numbers
      for (int j = 0; j < nrows; j++) {
        char cellValue = board[j][i];
        if (cellValue == ' ') {
          System.out.printf("   ");
        } else {
          System.out.printf(" %c ", cellValue);
        }
      }
      System.out.println();
    }
  }
  
  /* if the input mathes then add ship been destroyed
  update the board for every signle input
  count the number*/
  public static void fire (char [] input) {
    
    String inputString = String.valueOf(input);
    
    if (shipLocation.contains(inputString)) {
      System.out.println("Congradulation, you hit the ship");
    } else {
      System.out.println("You missed,please try again");
    }   
  }
 
  // check the input in the format <one letter><one number>
  public static char [] dataValidation() {
    System.out.println("Plz give a location you want to fired, in the format <one letter> <one number> ");
    char [] input;
    while (true) {
      try {
        input = s.nextLine().toUpperCase().toCharArray();
        if (input.length != 2){
          throw new Exception ("Input should be exact 2 character");
        }
        
        char alpha = input[0];
        char num = input[1];
        
        if (!(alpha >= 'A' && alpha <='A' + nclos-1)){
          throw new Exception("The letter should be between A to " + ((char)('A' + nclos-1)));
        }
        if (!(num >= '0' && num <='0' + nrows-1)){
          throw new Exception("The number should be between 0 to " + (nrows-1));
        }
        
        String currentInput = String.valueOf(input); 

        if (previousInputs.contains(currentInput)) {
          throw new Exception ("you entered the same location as previous input");
        }
        
        System.out.println("Thank you the correct input format");
        previousInputs.add(currentInput);
        break;
      }
      catch (Exception e) {
        System.out.println("An exception occurred" + e);
        System.out.println("Plz give a valid position");
      }
    }
    return input;
  }
  
  /*set ship location
  random choose something from the array
  random choose if it will be vertical or horizatal
  */
  public static void randomShip() {
    Random r = new Random();

    int shipOrientation = r.nextInt(2); // 0 for horizontal, 1 for vertical
    
    
    String shipLoc;
    int randomRow, randomCol;

    if (shipOrientation == 0) { // Horizontal
      randomRow = r.nextInt(nrows);
      randomCol = r.nextInt(nclos- shipLen+1);
      
      for (int i = 0; i < shipLen; i++) {
        shipLoc = String.valueOf((char) ('A' + randomCol + i)) + String.valueOf(randomRow);
        shipLocation.add(shipLoc);
      }
    } else { // Vertical
      randomRow = r.nextInt(nrows - shipLen+1);
      randomCol = r.nextInt(nclos);

      for (int i = 0; i < shipLen; i++) {
        shipLoc = String.valueOf((char) ('A' + randomCol)) + String.valueOf(randomRow + i);
        shipLocation.add(shipLoc);
      }
    }
    //System.out.println("Ship Location: " + shipLocation);
  }
  
  public static int dataRow() {
    System.out.println("Enter an int rows between 4 and 10:");
    while (true) {
      try { 
        nrows = Integer.parseInt(s.nextLine());
        
        if (nrows < 4 || nrows > 10) {
          throw new Exception("Your number should between 4 and 10");
        }
        break;
      } catch (Exception e) {
        System.out.println("Your number is not a valid input");
      }   
    }
    return nrows;
  }
  
  public static int dataCol() {
        
    System.out.println("Enter an int columns between 4 and 10:");
    
    while (true) {
      try { 
        nclos = Integer.parseInt(s.nextLine());
        
        if (nclos < 4 || nclos > 10) {
          throw new Exception("Your number should between 4 and 10");
        }
        break;
      } catch (Exception e) {
        System.out.println("Your number is not a valid input");
      }   
    }
    return nclos;
  }
  public static int dataValShipLen() {

    System.out.println("Enter an int ship length between 2 and 4:");
    while (true) {
      try { 
        shipLen = Integer.parseInt(s.nextLine());
        
        if (shipLen < 2 || shipLen > 4) {
          throw new Exception("Your number should between 2 and 4");
        }
        break;
      } catch (Exception e) {
        System.out.println("Your number is not a valid input");
      }   
    }
    return shipLen;
  }

}
