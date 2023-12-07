
class rug {
  public static void main(String[] args) {
  
    char [][] rug = new char [10][10];
    
    //border
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        rug[i][j] = 'I';
      }
    }
    
    // Empty area
    for (int i = 1; i < 9; i++) {
      for (int j = 1; j < 9; j++) {
        rug[i][j] = ' ';
      }
    }
    
    // Squeare in the middle
    for (int i = 3; i < 7; i++) {
      for (int j = 3; j < 7; j++) {
        rug[i][j] = 'k';
      }
    } 	
    
    // Top left triangle
    for (int i = 1; i < 4; i++) {
      for (int j = 1; j < 5-i; j++) {
        rug[i][j] = 'd';
      }
    }    
    
    //Top Right Triangle
    for (int i = 1; i < 4 ; i++) {
      for (int j = 5 + i; j < 9; j++) {
        rug[i][j] = 'd';
      }
    }
    
    //Bottom Left Triangle
    for (int i = 6; i < 9; i++) {
      for (int j = 1; j <= i-5; j++) {
        rug[i][j] = 'd';
      }
    }
    
    //Bottom Right Triangle
    int E = 9;
    for (int i = 6; i < 9; i++) {
      E--;
      for (int j = 8; j >= E && j < 9; j--) {
        rug[i][j] = 'd';
      }
    }
    
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        System.out.print(rug[i][j]);
      }
      System.out.println();
    }
      
  }
}
