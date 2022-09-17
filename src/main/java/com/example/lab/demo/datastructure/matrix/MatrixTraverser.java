package com.example.lab.demo.datastructure.matrix;

public class MatrixTraverser {

    public static void main(String[] args) throws Exception {
        System.out.println("hello world");
        MatrixTraverser app = new MatrixTraverser();
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        app.spiralTraverse_1(matrix);
    }


    public void spiralTraverse_1(int[][] matrix){
        if(matrix == null) return;

        int rows = matrix.length, columns = matrix[0].length;
        if(rows == 0 || columns == 0) return;

        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

        while(left <= right && top <= bottom){

            for(int column = left; column <= right; column++){
                System.out.println(matrix[top][column]);;
            }

            for(int row = top + 1; row <= bottom; row++){
                System.out.println(matrix[row][right]);
            }

            if(top < bottom && left < right){
                for(int new_column = right - 1; new_column > left; new_column--){
                    System.out.println(matrix[bottom][new_column]);
                }
    
                for(int new_row = bottom; new_row > top; new_row--){
                    System.out.println(matrix[new_row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
    }

    public void spiralTraverse(int[][] matrix){

        if(matrix == null) return;

        int rows = matrix.length, columns = matrix[0].length;

        if(rows == 0 || columns == 0){
            return;
        }

        int[][] directions = {{0,1}, {1, 0}, {0, -1}, {-1,0}};
        boolean[][] visited = new boolean[rows][columns];


        int directionsIndex = 0;

        int row_i = 0, col_j = 0;
        for (int i = 0; i < rows * columns; i++) {
            System.out.println(matrix[row_i][col_j]);
            visited[row_i][col_j] = true;

            int nextRow = row_i + directions[directionsIndex][0], nextColumn = col_j + directions[directionsIndex][1];
            // check next row and next column is valid
            if(nextRow < 0 || nextRow >= rows || nextColumn >= columns || nextColumn < 0 || visited[nextRow][nextColumn]){
                // change direction
                directionsIndex = (directionsIndex + 1) % 4;
            }
    
            row_i += directions[directionsIndex][0];
            col_j += directions[directionsIndex][1];
        }

    }
}
