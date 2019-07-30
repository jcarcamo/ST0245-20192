package eafit.edu.ds1.recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gym {
    private static final int TRIED = 2;
    private static final int PATH = 3;

    private int numberRows, numberColumns;
    private int[][]grid;

    public Gym(String filename) throws FileNotFoundException {
        Scanner scnr = new Scanner(new File(filename));
        numberRows = scnr.nextInt();
        numberColumns = scnr.nextInt();

        grid = new int[numberRows][numberColumns];
        for(int i = 0; i < numberRows; i++){
            for(int j = 0; j < numberColumns; j++){
                grid[i][j] = scnr.nextInt();
            }
        }
    }

    public void tryPosition(int row, int col){
        grid[row][col] = TRIED;
    }

    public int getRows(){
        return numberRows;
    }

    public int getcolumns(){
        return numberColumns;
    }

    public void markPath(int row, int col){
        grid[row][col] = PATH;
    }

    public boolean validPosition(int row, int col){
        boolean result = false;
        if(row >= 0 && row < numberRows && col >= 0 &&
                col < numberColumns){
            if(grid[row][col] == 1){
                result = true;
            }
        }
        return result;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('\n');

        for(int row = 0; row < numberRows; row++){
            for(int col = 0; col < numberColumns; col++){
                sb.append(grid[row][col]);
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
