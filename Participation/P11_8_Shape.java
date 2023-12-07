import java.util.Arrays;

class P11_8_Shape {
  public static void main(String[] args) {
    
    int length = 6;
    
    Shape1 [] arr = new Shape1[length];
    for (int i = 0; i < length; i++) {
      if ((int)(Math.random() * 10) % 2 == 0) {
        arr[i] = new Circle1(Math.random() * 10);
      }
      else{
        arr[i] = new Square1(Math.random() * 10);    
      }
    }
    System.out.println("Unsorted array:");
        for (Shape1 shape : arr) {
            if (shape instanceof Circle1) {
                System.out.println("Circle - Radius: " + shape.getLength());
            } else if (shape instanceof Square1) {
                System.out.println("Square - Length: " + shape.getLength());
            }
        }

        Arrays.sort(arr);

        System.out.println("Sorted array:");
        for (Shape1 shape : arr) {
            if (shape instanceof Circle1) {
                System.out.println("Circle - Radius: " + shape.getLength());
            } else if (shape instanceof Square1) {
                System.out.println("Square - Length: " + shape.getLength());
            }
        }
    }  
}
abstract class Shape1 implements Comparable<Shape1> {
  
  private double length;
  
  public Shape1 (double length) {
    this.length = length;
  }
  
  public double getLength () {
    return length;
  }
  
  public int compareTo (Shape1 other) {
    return Double.compare(this.length, other.getLength());
  }
}

class Square1 extends Shape1 {
  public Square1 (double length) {
    super(length);
  }
}

class Circle1 extends Shape1 {
  public Circle1 (double length) {
    super(length);
  }
}

