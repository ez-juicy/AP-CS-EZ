import java.util.*;

class Lab9_ChiSquaredSimulations {
  
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    System.out.println("How many times do you want to roll two dice?");
    int k = s.nextInt();

    System.out.println("How many simulations do you want to run?");
    int n = s.nextInt();
    s.close();

    System.out.println("\n\n\n" + "====================================" + "\n\n\n");

    System.out.printf("One simulation of %d rolls: ", k);
    oneSimulation(k);

    System.out.println("\n\n\n" + "====================================" + "\n\n\n");

    System.out.printf("%d simulations of %d rolls: %n", n, k);
    int numRare = manySimulations(n, k);
    double rarePercent = (float) numRare / n * 100;
    System.out.printf("You had %d rolls that were rare, about %.1f%% of the time. %n", numRare, rarePercent);

  }

  public static void oneSimulation(int k) {
    int [] o = observations(k);
    double [] e = expected(k);
    double chi2 = chiSquared(o, e);

    for (int i = 0; i < o.length; i++) {
      System.out.printf("%2d was rolled %d times. %n", i+2, o[i]);
    }
    System.out.println("Chi squared: " + chi2);

    if (chi2 > 25.188) {
      // Probability of this is .5%
      System.out.println("The values you rolled were extremely rare.");
    } else if (chi2 > 23.209) {
      // Probability of this is 1%
      System.out.println("The values you rolled were very rare.");
    } else if (chi2 > 20.483) {
      // Probability of this is 2.5%
      System.out.println("The values you rolled were rare.");
    } else if (chi2 > 18.307) {
      // Probability of this is 5%
      System.out.println("The values you rolled were very uncommon.");
    } else if (chi2 > 15.987) {
      // Probability of this is 10%
      System.out.println("The values you rolled were uncommon.");
    } else {
      // Probability of this is 90%
      System.out.println("The values you rolled were common.");
    }
  }

  public static int manySimulations (int n, int k) {
   
    int count = 0;

    for (int i = 0; i <= n; i++) {
      int [] o = observations(k);
      double [] e = expected(k);
      double chi2 = chiSquared(o, e);
      if (chi2 > 18.307) {
        count++;
      }
    }
    
    return count;
  }
  
  public static int [] observations(int k) {
    int[] o = new int[11];

    Random r = new Random();

    for(int i = 0; i <=k; i++){
      int sum = r.nextInt(7) + r.nextInt(7);
      o[sum-2]++;
    }
    return o;
  }

  public static double [] expected(int k) {
    double [] e = new double [11];
    Arrays.fill(e, 0);

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) { 
        e[i+j]++;
      }
    }
    for (int i = 0; i < e.length; i++) {
      e[i] *= k;
      e[i] /= 36;
    }

    return e;
  }

  public static double chiSquared(int [] o, double [] e) {
    double chi2 = 0.0;

    for (int i = 0; i < o.length; i++){
      chi2 += Math.pow(o[i] - e[i], 2) / e[i];
    }
    return chi2;
  }
  
}
