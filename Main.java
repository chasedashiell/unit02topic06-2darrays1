import java.util.Arrays;

public class Main {

  public static void print2D(double mat[][])
  {
      // Loop through all rows
      for (double[] row : mat)

          // converting each row as string
          // and then printing in a separate line
          System.out.println(Arrays.toString(row));
  }
  
  public static double[] flattenSquare(double[][] nums){
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


  public static double[] flattenRectangle(double[][] nums){
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

  public static double[] flattenRagged(double[][] nums){
    int numColsTotal = 0;
    int numRows = nums.length;
    for (int row = 0; row < numRows; row++){
      for (int col = 0; col < nums[row].length; col++){
        numColsTotal++;
      }
    }

    double[] solution = new double[numColsTotal];
    int solutionIndex = 0;
    for (int row = 0; row < numRows; row++){
      int numColsInRow = nums[row].length;
      
      for (int col = 0; col < numColsInRow; col++){
        solution[solutionIndex] = nums[row][col];
        solutionIndex++;
      }
    }
    return solution;
  }


  public static double[][] copySquare(double[][] nums){
    double[][] newSquare = new double[nums.length][nums.length];
    for (int row = 0; row < nums.length; row++){
      for(int col = 0; col < nums.length; col++){
        newSquare[row][col] = nums[row][col];
      }
    }
    return newSquare;
  }

  public static double[][] copyRectangle(double[][] nums){
    double[][] newRectangle = new double[nums.length][nums[0].length];
    for (int row = 0; row < nums.length; row++){
      for(int col = 0; col < nums[0].length; col++){
        newRectangle[row][col] = nums[row][col];
      }
    }
    return newRectangle;
  }

  public static double[][] copyRagged(double[][] nums){
    double[][] solution = new double[nums.length][];
    for (int row = 0; row < nums.length; row++){
      solution[row] = nums[row];
    }
    return solution;
  }



  public static void printTrans(double[][] nums){
    double[][] toPrint = new double[nums[0].length][nums.length];
    for (int row = 0; row < nums.length; row++){
      for(int col = 0; col < nums[0].length; col++){
        toPrint[col][row] = nums[row][col];
      }
    }
    print2D(toPrint);
  }

  public static double[][] withWeightedAverage(double[][]nums, double[] weights) {
    double[][] solution = new double[nums.length +1][nums[0].length+1];
    for (int row = 0; row < nums.length; row++){
      int weightsIndex = 0;
      for (int col = 0; col < nums[0].length; col++){
        solution[row][col] = nums[row][col] * weights[weightsIndex];
        weightsIndex++;
      }
    }
    for (int row = 0; row < solution.length-1; row++){
      double currentMean = 0;
      for (int i = 0; i < solution[row].length-1; i++){
        currentMean+= solution[row][i];
      }
      solution[row][solution[row].length-1] = currentMean;
    }
    for (int col = 0; col < solution[0].length; col++){
      double currentMean = 0;
      for (int row = 0; row < solution.length; row++){
        currentMean += solution[row][col];
      }
      solution[solution.length-1][col] = currentMean / nums.length;
    }
    return solution;
  }
  public static void main(String[] args) {
    //double[][] testSquares = {{1,2,3,9}, {4,5,6,9}, {7,8,9,9},{7,8,9,9}};
    //System.out.println(Arrays.toString(flattenSquare(testSquares)));
    //double[][] testRectangles = {{1,2,3,4,},{4,3,2,1},{1,2,3,4}};
    //System.out.println(Arrays.toString(flattenRectangle(testRectangles)));
    //double[][] a = new double[][] {{1}, {1,2}, {1,2,3}};
    //System.out.println(Arrays.toString(flattenRagged(a)));
    //double[][] test = {{1,2},{1,2,3,4}};
    //print2D(copySquare(test));
    //print2D(copyRagged(test));
    /* 
    double[][] a = new double[][] {
      {99, 85, 98},
      {98, 57, 79},
      {92, 77, 74},
      {94, 62, 81},
      {99, 94, 92},
      {80, 76.5, 67},
      {76, 58.5, 90.5},
      {92, 66, 91},
      {77, 70.5, 66.5},
      {89, 89.5, 81}
  };
    printTrans(a);
    */
    double[][] a = new double[][] {
      {99, 85, 98},
      {98, 57, 79},
      {92, 77, 74},
      {94, 62, 81},
      {99, 94, 92},
      {80, 76.5, 67},
      {76, 58.5, 90.5},
      {92, 66, 91},
      {77, 70.5, 66.5},
      {89, 89.5, 81}
  };

  // double[][] answer = new double[][] {
  //   {99, 85, 98, 95},
  //   {98, 57, 79, },
  //   {92, 77, 74, },
  //   {94, 62, 81, },
  //   {99, 94, 92, },
  //   {80, 76.5, 67, },
  //   {76, 58.5, 90.5, },
  //   {92, 66, 91, },
  //   {77, 70.5, 66.5, },
  //   {89, 89.5, 81, }
  //   {               }
// };
  double[] weights = { 0.25, 0.25, 0.50 };
  print2D(withWeightedAverage(a, weights));
  }
  
}