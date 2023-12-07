
class Lab5_AreaCalculation {
  public static void main(String[] args) {
    
    System.out.printf("The area of image 1 is %.3f%n", imageOne());
    System.out.printf("The area of image 2 is %.3f%n", imageTwo());
    System.out.printf("The area of image 3 is %.3f%n", imageThree());
    
  }
  
  public static double imageOne() {
    double area = 0;
    double areaRecBig;
    double areaCir = 0;
    double areaRecSmall = 0;
    double areaTri = 0;

    areaCir = ((new Circle (1,false).getArea())/2) * 4;
    areaRecBig = new Rectangle (10,7,false).getArea();
    areaRecSmall = (new Rectangle(2,3,false).getArea()) * 2;
    areaTri = (new Triangle(3,3,false).getArea()) * 2;
    area = areaCir + areaRecBig + areaRecSmall -areaTri;
    
    return area;
  }
  
  public static double imageTwo() {
    double area = 0;
    double areaCir = 0;
    double areaRec;
    double areaTri;
    double areaGap;
    double areaChi;
    
    areaCir = new Circle(1,false).getArea() 
      + new Circle(0.75,false).getArea() 
      + new Circle (0.5,false).getArea();
    //那幾個泡泡
    areaTri = new Triangle(4,10,false).getArea();
    //roof
    areaRec = new Rectangle(8,7,false).getArea() 
      - ((new Rectangle(2,2,false).getArea()) *2) 
      - new Rectangle(2,3,false).getArea() 
      + new Circle(1.0/6.0, false).getArea();
    
    areaGap = ((new Rectangle(1,1,false).getArea() - new Circle(0.5,false).getArea()));
    
    areaChi =  new Rectangle(1,2,false).getArea() 
      - new Triangle(0.5,0.5,false).getArea() 
      + new Triangle(0.5,0.5,false).getArea();
    
    area = areaCir + areaTri + areaRec - areaGap + areaChi;
    
    return area;
  }
  
  public static double imageThree() {
    double area = 0;
    double areaRec;
    double areaA;
    double areaP;
    double areaC;
    double areaS;
    
    areaRec = new Rectangle(3, 7, false).getArea();
    
    areaA = areaRec - 
      new Rectangle(3, 1, false).getArea() - 
      new Rectangle(1, 1, false).getArea() - 
      ((new Triangle (1,1,false).getArea()) * 3);
    
    areaP = areaRec 
      - new Rectangle(2, 3, false).getArea() 
      - ((new Triangle (1,1,false).getArea()) * 4);
    
    areaC = areaRec 
      - new Rectangle(2, 3, false).getArea() 
      - ((new Triangle (1,1,false).getArea()) * 6);
    
    areaS = areaRec - ((new Triangle (1.5,1,false).getArea()) * 6);
    
    area = areaA + areaP + areaC + areaS;
    return area;
  }
}

class Circle {
  private double radius;
  private double area;
  private boolean isNegativeSpace;
  
  Circle(double radius, boolean isNegative) {
    this.radius = radius;
    this.area = Math.PI * this.radius * this.radius;
    this.isNegativeSpace = isNegative;
  }
  public double getArea() {
    return this.isNegativeSpace ? -1 * this.area : this.area;
  }
}

class Rectangle {
  private double length;
  private double width;
  private double area;
  private boolean isNegativeSpace;
  
  Rectangle (double length, double width, boolean isNegative) {
    this.length = length;
    this.width = width;
    this.area = this.length * this.width;
    this.isNegativeSpace = isNegative;
}
  public double getArea() {
    return this.isNegativeSpace ? -1 * this.area : this.area;
  }
}


class Triangle {
  private double base;
  private double height;
  private double area;
  private boolean isNegativeSpace;
  Triangle (double base, double height, boolean isNegative) {
  this.base = base;
    this.height = height;
    this.area =this.base * this.height / 2;
    this.isNegativeSpace = isNegative;
}
  
  public double getArea() {
    return this.isNegativeSpace? -1 * this.area: this.area;

  }
}