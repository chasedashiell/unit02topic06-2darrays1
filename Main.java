import java.util.Arrays;

public class Main {
  
  public static double[] copySquare(double[][] nums){
    double[] solution = new double[nums.length * nums.length];
    int solutionIndex = 0;
    for (int i = 0; i < nums.length; i++){
      for (int j = 0; j < nums.length; j++){
        solution[solutionIndex] = nums[i][j];
        solutionIndex++;
      }
    }
    return solution;
  }


  public static double[] copyRectangle(double[][] nums){
    int cols = 0;
    for (int i = 0; i<nums[0].length; i++){
      cols++;
    }
    double[] solution = new double[nums.length * cols];
    int solutionIndex = 0;
    for (int i = 0; i < nums.length; i++){
      for (int j = 0; j < cols; j++){
        solution[solutionIndex] = nums[i][j];
        solutionIndex++;
      }
    }
    return solution;
  }

  public static double[] copyRagged(double[][] nums){
    int numColsTotal = 0;
    int numRows = nums.length;
    for (int row = 0; row < numRows; row++){
      int numColsInRow = 0;
      for (int col = 0; col < nums[row].length; col++){
        numColsInRow++;
      }
    numColsTotal+=numColsInRow;
    }




    double[] solution = new double[numColsTotal];
    int solutionIndex = 0;
    System.out.println("solution index: " + solutionIndex);
    for (int row = 0; row < numRows; row++){
      System.out.println("Row: " + row);
      int numColsInRow = 0;
      System.out.println("numColsInRow: " + numColsInRow);
      for (int col = 0; col < nums[row].length; col++){
        numColsInRow++;
      }
      for (int col = 0; col < numColsInRow; col++){
        solution[solutionIndex] = nums[row][col];
      }
    }
    return solution;
  }
  public static void main(String[] args) {
    //double[][] testSquares = {{1,2,3,9}, {4,5,6,9}, {7,8,9,9},{7,8,9,9}};
    //System.out.println(Arrays.toString(copySquare(testSquares)));
    //double[][] testRectangles = {{1,2,3,4,},{4,3,2,1},{1,2,3,4}};
    //System.out.println(Arrays.toString(copyRectangle(testRectangles)));
    double[][] a = new double[][] {{1}, {1,2}, {1,2,3}};
    System.out.println(Arrays.toString(copyRagged(a)));
  }
  
}