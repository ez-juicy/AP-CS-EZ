
class HW3_P1_Rug {
  static int rugSize = 20;
  static char [] [] rug = new char [rugSize] [rugSize];
  
  public static void main(String[] args) {
    
    border(0, 0, rugSize, rugSize, 1, '#', ' ');
    
    // solid pattern
    square(8, 8, 4, 4, '-'); 
    
    //corner triangle
    cornerTL('0');
    cornerBL('0');
    cornerTR('0');
    cornerBR('0');
    
    checkBroaderTop('e', 'z');
    checkBroaderBottom('e', 'z');
    checkBroaderLeft('e', 'z');
    checkBroaderRight('e', 'z');
    
    diamondTop('d');
    diamondBottom('d');
    
    printRug();
    
  }
  
  public static void printRug() {
    for (int i = 0; i < rugSize; i++) {
      for (int j = 0; j < rugSize; j++) {
        System.out.print(rug[i][j]);
      }
      System.out.println();
    }
  }
  
  public static void square (int rowStart, int colStart, int width, int height, char c) {
    for (int i = rowStart; i < rowStart + width; i++){
      for (int j = colStart; j < colStart + height; j++) {
        rug [i][j] = c;
      }
    }
  }
  
   public static void border(int rowStart, int colStart, int width, int height, int thickness, char border, char fill) {
    square(rowStart, colStart, width, height, border);
    square(rowStart+thickness, colStart+thickness, width-(2*thickness), height-(2*thickness), fill);
  }
  
   public static void cornerTL(char c) {
    for (int i = 5; i < 8; i++) {
      for (int j = 5; j < 13 - i; j++) {
        rug[i][j] = c;
      }
    }
  }
  
  public static void cornerBL(char c) {
    for (int i = 12; i < 15; i++) {
      for (int j = 5; j <= i-7; j++) {
        rug[i][j] = c;
      }
    }
  }
  
  public static void cornerTR(char c) {
    for (int i = 5; i < 8; i++) {
      for (int j = 14; j >= 7+i; j--) {
        rug[i][j] = c;
      }
    }
  }
  
  public static void cornerBR(char c) {
    for (int i = 12; i < 15; i++) {
      for (int j = 14; j >= 26-i; j--) {
        rug[i][j] = c;
      }
    }
  }
  
  public static void checkBroaderTop(char c, char d) {
    for (int i = 1; i <= 4; i++) {
      for (int j = 8; j <= 11; j++){
        if ( (i+j) % 2 == 0){
          rug [i][j] = c;
        } else {
          rug [i][j] = d;
        }
      }
    }
  }
  
  public static void checkBroaderBottom(char c, char d) {
    for (int i = 15; i <= 18; i++) {
      for (int j = 8; j <= 11; j++){
        if ( (i+j) % 2 == 0){
          rug [i][j] = c;
        } else {
          rug [i][j] = d;
        }
      }
    }
  }
  
  public static void checkBroaderLeft(char c, char d) {
    for (int i = 8; i <= 11; i++) {
      for (int j = 1; j <= 4; j++){
        if ( (i+j) % 2 == 0){
          rug [i][j] = c;
        } else {
          rug [i][j] = d;
        }
      }
    }
  }
  
  public static void checkBroaderRight(char c, char d) {
    for (int i = 8; i <= 11; i++) {
      for (int j = 15; j <= 18; j++){
        if ( (i+j) % 2 == 0){
          rug [i][j] = c;
        } else {
          rug [i][j] = d;
        }
      }
    }
  }
  
  public static void diamondTop(char c){
    for (int i = 5; i <= 7; i++) {
      rug [i][9] = c;
  }
    rug[6][8] = c;
    rug[6][10] = c;
 }   
  
  public static void diamondBottom(char c){
    for (int i = 12; i <= 14; i++) {
      rug [i][9] = c;
  }
    rug[13][8] = c;
    rug[13][10] = c;
 }   
}
