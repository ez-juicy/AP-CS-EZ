import java.util.*;
public class P1128 {
  public static void main(String[] args) {
    
    String s1 = "{()}[]";
    String s2 = "[()]{}{[()()]()}";
    
    String s3 = "[(])";
    String s4 = "{()()";

    String s5 = "This is fine (because the brackets are normal [obviously])...";
    String s6 = "... { but this is not. )";


    
    System.out.printf("s1: %s %n%s %n", s1, balancedBrackets(s1)); // true
    System.out.printf("s2: %s %n%s %n", s2, balancedBrackets(s2)); // true

    System.out.printf("s3: %s %n%s %n", s3, balancedBrackets(s3)); // false
    System.out.printf("s4: %s %n%s %n", s4, balancedBrackets(s4)); // false

    System.out.printf("s5: %s %n%s %n", s5, balancedBrackets(s5)); // true
    System.out.printf("s6: %s %n%s %n", s6, balancedBrackets(s6)); // false

    
    
  }
  
  public static boolean balancedBrackets(String s) {
    Stack<Character> stack = new Stack<Character>("MTG Stack");

    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[' || c == '<') {
            stack.push(c);
        } else if ((c == ')' && !stack.isEmpty() && stack.peek() == '(') ||
                   (c == '}' && !stack.isEmpty() && stack.peek() == '{') ||
                   (c == ']' && !stack.isEmpty() && stack.peek() == '[') ||
                   (c == '>' && !stack.isEmpty() && stack.peek() == '<')) {
            stack.pop();
        }
    }

    return stack.isEmpty();
}


}

public class Stack<T> {
  private String name;
  private ArrayList<T> arr;

  Stack(String name) {
    this.name = name;
    this.arr = new ArrayList<T>();
  }

  public boolean isEmpty() {
    return this.arr.isEmpty();
  }

  public int getSize() {
    return this.arr.size();
  }

  public T peek() {
    return this.arr.get(this.getSize() - 1);
  }

  public T pop() {
    return this.arr.remove(this.getSize() - 1);
  }

  public void push(T x) {
    this.arr.add(x);
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return String.format("Stack %s: %s", this.name, this.arr.toString());
  }

}