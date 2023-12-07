import java.util.*;

class matrixadd {
  public static void main(String[] args) {
        
        int[][] A = {{3, 8, 2},
                     {5, 10, 3},
                     {2, 3, 1}};
          
        int[][] B = {{1, -2, 4},
                     {1, -1, 1},
                     {-5, 7, -10}};

    
        System.out.println("Matrix addition:");
        printMatrix(matAddition(A, B));
        System.out.println();

        System.out.println("Matrix multiplication:");
        printMatrix(matMultiplication(A, B));

    }
  
  
    public static int[][] matAddition(int[][] A, int[][] B) {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) { 
            for (int j = 0; j < 3; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }

        return result;
    }

    public static int [][] matMultiplication(int [][] A, int [][] B) {
        int [][] result = new int[3][3];
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          for (int x = 0; x < 3; x++) {
            result [i] [j] += A [i][x] * B [x][j];
          }
        }
      }
        return result;
    }

    public static void printMatrix(int [][] matrix) {
        for (int[] row : matrix) System.out.println(Arrays.toString(row));
    }
}