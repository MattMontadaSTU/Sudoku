package Sudoku;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used to create the game's main functionality
 * @author Matthew Montada
 *
 */
public class SudokuMain {
	private static final int UNASSIGNED = null; //Constant variable 
	int [][] sudokuGrid = new int [9][9]; //creates the grid for the game's board
	int gridsGenerated = 0; //creates the amount of grids that are generated
	/**
	 * This function helps read the sudoku puzzle through the file path
	 * @param filePath
	 * @return
	 * @throws FileNotFoundException
	 */
	public int[][] readSudoku(String filePath) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(filePath));
		
		for (int sudokuRow = 0; sudokuRow < 9; sudokuRow++) {
			for (int sudokuColumn = 0; sudokuColumn < 9; sudokuColumn++) {
				if (sc.hasNextInt()) {
					sudokuGrid[sudokuRow][sudokuColumn] = sc.nextInt();
					
					System.out.print(sudokuGrid[sudokuRow][sudokuColumn]);
				}
				System.out.println();
			}
		sc.close();
		
		return sudokuGrid;
		}
	}
	 /**
	  * The next 4 functions help return the list of valid numbers
	  * @param row
	  * @param col
	  * @return
	  */
	public ArrayList<Integer> getCandidates(int row, int col) {
		return null;
	}
	
	public Boolean isRowValid (int row) {
		return null;
	}
	public Boolean isColumnValid (int col) {
		return null;
	}
	public Boolean isSubGridValid (int row, int col) {
		return null;
	}
	/**
	 * This function helps return the amount of generated grids needed to find the solution
	 * @param row
	 * @param col
	 * @param sudokuRow
	 * @param sudokuColumn
	 * @return
	 */
	public int[] getGridsGenerated(int row, int col, int sudokuRow, int sudokuColumn) {
		int[] sub = new int[9];
		int addOffsetX = 3 - ((row % 3) + 1);
		int addOffsetY = 3 - ((col % 3) + 1);
		int minusOffsetX = (row % 3);
		int minusOffsetY = (col % 3);
		
		int index = 0;
		for(int row1 = sudokuRow - minusOffsetX; row1 < sudokuRow + addOffsetX + 1; row1++) {
			for(int col1 = sudokuColumn - minusOffsetY; col < sudokuColumn + addOffsetY + 1; col++) {
				sub[index] = sudokuGrid[sudokuRow][sudokuColumn].get();
			}
		}
		return sub;
	}
	/**
	 * This function helps solve the sudoku grid with the utilization of the Brute Force alogorithm
	 * @return
	 */
	public boolean sudokuSolve() {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if(sudokuGrid[row][col] == UNASSIGNED) {
					for (int number = 1; number <= 9; number++) {
						if(sudokuSolve()) {
							sudokuGrid[row][col] = number;
						}
						if (sudokuSolve()) {
							return true;
						}
						else {
							sudokuGrid[row][col] = UNASSIGNED;
						}
					}
				}
				return false;
			}
		}
	return true;
	/**
	 * This function creates a 9x9 String representation of the grid
	 */
	int[] sudokuString() {
		for (int i = 0; i < 9; i++) {
			if(i % 3 == 0 && i != 0) {
				System.out.println("------------------------------\n");
			}
			for (int j = 0; j < 9; j++) {
				if (j % 3 == 0 && j != 0) {
					System.out.print(" " + sudokuGrid[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	System.out.println("\n\n__________________________________\n\n");
}}
