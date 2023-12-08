import java.math.BigDecimal;    

class HW4_Polynomial {
  
  public static void main(String[] args) {
    
    Polynomial p1 = new Polynomial(new double [] {0, 1, 2});
    System.out.println("Polynomial one is " + p1.toString()); 

    Polynomial p2 = new Polynomial(new double [] {0, 1, 2});
    System.out.println("Polynomial two is " + p2.toString()); 

    System.out.println("When x = 1, Polynomial one equal to " + p1.evaluation(BigDecimal.ONE));
    System.out.println("When add Polynomial 1 and 2 together, new Polynomial equal to " + p1.addTogether(p2));
    System.out.println("When multiply Polynomial 1 and 2 together, new Polynomial equal to " + p1.multiplyTogether(p2));
    System.out.println("polynomial one equal to polynomial two: " + p1.equals(p2));
    
    Derivative p = new Derivative();
    System.out.println("Derivative of polynomial one is " + p.findDerivative(p1)); 
    
  }
  
}

class Polynomial {
  
  BigDecimal[] coefficient;
  
  Polynomial(double [] coefficient) {
    BigDecimal[] temp = new BigDecimal [coefficient.length]; 
    for (int i = 0; i < temp.length; i++) {
      temp[i] = new BigDecimal(coefficient[i]);
    }
    this.coefficient = temp;
  }
  
  Polynomial(BigDecimal[] coefficient) {
    this.coefficient = coefficient;
  }
  
  public BigDecimal evaluation (BigDecimal x) {
    BigDecimal sum = new BigDecimal (0);
    for(int i = 0; i < coefficient.length; i++) {
      BigDecimal j = new BigDecimal (i);
      sum = sum.add(this.coefficient[i].multiply(x.pow(j.intValue())));
    }
    return sum;
  }
  
  public Polynomial addTogether(Polynomial other) {
    
    BigDecimal[] resultCoefficients = new BigDecimal[Math.max(this.coefficient.length, other.coefficient.length)];//check which one is the biggest
    
    for(int i = 0; i < coefficient.length; i++) {
      resultCoefficients[i] = this.coefficient[i].add(other.coefficient[i]);
    }
    return new Polynomial(resultCoefficients);
  }
  
  public Polynomial multiplyTogether(Polynomial other) {

    BigDecimal[] resultCoefficients = new BigDecimal[this.coefficient.length + other.coefficient.length - 1];

    for (int i = 0; i < this.coefficient.length; i++) {
      for (int j = 0; j < other.coefficient.length; j++) {
        if (resultCoefficients[i + j] == null) {
          resultCoefficients[i + j] = BigDecimal.ZERO;
        }
        resultCoefficients[i + j] = resultCoefficients[i + j].add(this.coefficient[i].multiply(other.coefficient[j]));
      }
    }
    return new Polynomial(resultCoefficients);
}

  
  public String toString(){
    
    String resultPolynomial = "";
    for(int i = 0; i < coefficient.length; i++) {
      resultPolynomial += (coefficient[i] +"X" + "^" + i);
      if (i < coefficient.length - 1) 
         resultPolynomial += " + ";
    }
    return resultPolynomial;
  }
  
  public boolean equals(Polynomial other) {
    if (!(this.coefficient.length == other.coefficient.length)) {
      return false;
    }
    for(int i = 0; i < this.coefficient.length; i++) {
      if (!this.coefficient[i].equals(other.coefficient[i])) {
        return false;
      }
    }
    return true;
  }
}

class Derivative {
  
  public Polynomial findDerivative(Polynomial p) {
    BigDecimal[] temp = new BigDecimal[p.coefficient.length - 1];
    for(int i = 1; i < p.coefficient.length; i++) {
      temp[i-1] = p.coefficient[i].multiply(BigDecimal.valueOf(i));
    }
    return new Polynomial(temp);
  }
}
