import java.util.*;

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