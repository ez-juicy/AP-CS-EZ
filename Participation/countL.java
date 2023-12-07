import java.util.Scanner;

class countL {
    
  static Scanner s = new Scanner(System.in);
  
  public static void main(String[] args) {
    System.out.println("Give me any text.");
    System.out.println("I will count how many times each letter in the " +
                       "alphabet was used, ignoring case or numbers.");
    String input = s.nextLine();
    
    int [] letterCounts = findLetterCounts(input);
    
    printLetterCounts(letterCounts);
    
  }
  
  public static int [] findLetterCounts(String input) {
    input = input.toLowerCase();
    int [] counts = new int [26];
    for (char c : input.toCharArray()) {
      if (c >= 'a' && c <= 'z' ){
        counts[c - 'a']++;
      }
    }
    // find counts of each letter
    return counts;
  }
  
  public static void printLetterCounts(int [] letterCounts) {
    char c = 'a';
    for (int i = 0; i < letterCounts.length; i++) {
      System.out.printf("%c: %d times %n", c, letterCounts[i]);
      c++;
  }
 }
}
