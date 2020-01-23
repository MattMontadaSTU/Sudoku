/** Sudoku Game, 1/12/20
 * @author Matthew Montada
 *
 */

/** This class includes the main program where the game will be created and tested
 * 
 * @author Matthew Montada
 *
 */
public class SudokuGame {
	/**
	 * This function showcases the Sudoku game that will be tested out
	 * @param table 
	 */
	public static void main(char[][] table) {
		sudokuAssist(table); //will showcase the game that is being played by the user
	}
	
	/** This function helps create the Sudoku game
	 * @return true
	 * @return false
	 * @param sudoku1
	 * @param sudoku2
	 * @param sudoku3
	 * @param table
	 */
	private static boolean sudokuAssist (char[][] table) {
		for (int sudoku1 = 0; sudoku1 < 9; sudoku1++) {
			for (int sudoku2 = 0; sudoku2 < 9; sudoku2++) {
				if (table[sudoku1][sudoku2] != '.') {
					continue; //makes you keep playing the game if the user gets the answer right
				} //for loop that will determine if the answer is correct or not
				 
				for (char sudoku3 = '1'; sudoku3 <= 9; sudoku3++) {
					if (validChecker(table, sudoku1, sudoku2, sudoku3)) {
						table[sudoku1][sudoku2] = sudoku3;
						if (sudokuAssist(table)) {
							return true;
						}
						table[sudoku1][sudoku2] = '.'; //Will be used as 0's
					}
				}
				return false; //when the inputed answer is wrong
			}
		}
		return true; //when the inputed answer is correct
	}
	
	/**
	 * This function serves as the valid checker, which indicates whether not the game is being played correctly
	 * @param sudokuInteger1
	 * @param sudokuRow
	 * @param sudokuColumn
	 * @return true
	 * @return false
	 * @param table
	 */
	private static boolean validChecker(char[][] table, int sudokuRow, int sudokuColumn, char c) {
		for (int sudokuInteger1 = 0; sudokuInteger1 < 9; sudokuInteger1++) {
			if (table[sudokuInteger1][sudokuColumn] != '.' && table[sudokuInteger1][sudokuColumn] == c) {
				return false; //what will be returned if there is any form of repetition that is used during the game
			}
			
			if(table[sudokuRow][sudokuInteger1] != '.' && table[sudokuRow][sudokuInteger1] == c) {
				return false; //what will be returned if there is any form of repetition that is used during the game
			}
			
			if (table[3 * (sudokuRow / 3) + sudokuInteger1 / 3][3 * (sudokuColumn / 3) + sudokuInteger1 % 3] != '.' && table[3 * (sudokuRow / 3) + sudokuInteger1 / 3][3 * (sudokuColumn / 3) + sudokuInteger1 % 3]) {
				return false; //what will be returned if there is any form of repetition that is used during the game
			}
		}
		return true; //when there is no repetition during the game
	}
}
