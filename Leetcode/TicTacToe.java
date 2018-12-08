public class TicTacToe {
	private int[] rows;
	private int[] cols;
	private int diagonal;
	private int antidiagonal;

	public TicTacToe(int n) {
		rows = new int[n];
		cols = new int[n];
		diagonal = 0;
		antidiagonal = 0;
	}

	/** Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
            0: No one wins.
            1: Player 1 wins.
            2: Player 2 wins. */
	public int move(int row, int col, int player) {
		int toAdd = player == 1 ? -1 : 1;
		int n = rows.length;

		rows[row] += toAdd;
		cols[col] += toAdd;

		if (row == col) {
			diagonal += toAdd;
		}

		if (row + col == n - 1) {
			antidiagonal += toAdd;
		}

		if (Math.abs(rows[row]) == n ||
			Math.abs(cols[col]) == n ||
			Math.abs(diagonal) == n ||
			Math.abs(antidiagonal) == n) {
			return player;
		}

		return 0;
	}
}