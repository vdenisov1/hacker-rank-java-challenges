package edu.hackerrank.datastructures;

public class TwoDimensionalArray {

    public static void main(String[] args){
//        int[][] input = {
//                {-1,-1,0,-9,-2,-2},
//                {-2,-1,-6,-8,-2,-5},
//                {-1,-1,-1,-2,-3,-4},
//                {-1,-9,-2,-4,-4,-5},
//                {-7,-3,-3,-2,-9,-9},
//                {-1,-3,-1,-2,-4,-5}
//        };

        int[][] input = {{1,1,1,0,0,0},
                {0,1,0,0,0,0},
                {1,1,1,0,0,0},
                {0,0,2,4,4,0},
                {0,0,0,2,0,0},
                {0,0,1,2,4,0}};

        TwoDimensionalArray m = new TwoDimensionalArray();

        System.out.println(m.getLargestSumOfHourGlass(input));
    }

    private int getLargestSumOfHourGlass(int[][] matrix){
        int max = 0;
        boolean firstMax = true;

        for(int row=0; row < 4; row++){
            for(int col = 0; col < 4; col++){
                int sum = 0;

                for(int subrow = row; subrow < row + 3; subrow++){
                    for(int subcol = col; subcol < col + 3; subcol++){
                        if(subrow == (row + 1)){
                            if(subcol == (col + 1)){
                                sum += matrix[subrow][subcol];
                            }
                        }else{
                            sum += matrix[subrow][subcol];
                        }
                    }
                }

                if(firstMax) {
                    max = sum;
                    firstMax = false;
                }else if(max < sum) {
                    max = sum;
                }
            }
        }

        return max;
    }
}
