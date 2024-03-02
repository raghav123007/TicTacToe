package Strategies.GameWinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Models.Board;
import Models.Move;

public class OrderOneGameWinningStrategy implements GameWinningStrategy {
	// for every row/column/diagonal - a hashmap of symbol vs count
	List<HashMap<Character, Integer>> rowSymbolCounts = new ArrayList<>();
	List<HashMap<Character, Integer>> colSymbolCounts = new ArrayList<>();
	HashMap<Character, Integer> toprightdiagonalSymbolCount = new HashMap<>();
	HashMap<Character, Integer> topleftdiagonalSymbolCount = new HashMap<>();

	public OrderOneGameWinningStrategy(int dimension) {
		for (int i = 0; i < dimension; i++) {
			rowSymbolCounts.add(new HashMap<>());
			colSymbolCounts.add(new HashMap<>());
		}
	}

	private boolean isCellOnTopLeftDiagonal(int row, int col) {
		return row == col;
	}

	private boolean isCellOnTopRightDiagonal(int row, int col, int dimension) {
		return row + col == dimension - 1;
	}

	@Override
	public boolean checkWinner(Board board, Move move) {
		char symbol = move.getPlayer().getSymbols();
		int row = move.getCell().getRow();
		int col = move.getCell().getColumn();
		int dimension = board.getBoard().size();

		if (!rowSymbolCounts.get(row).containsKey(symbol)) {
			rowSymbolCounts.get(row).put(symbol, 0);
		}
		rowSymbolCounts.get(row).put(symbol, rowSymbolCounts.get(row).get(symbol) + 1);

		if (!colSymbolCounts.get(col).containsKey(symbol)) {
			colSymbolCounts.get(col).put(symbol, 0);
		}
		colSymbolCounts.get(col).put(symbol, colSymbolCounts.get(col).get(symbol) + 1);

		if (isCellOnTopRightDiagonal(row, col, dimension)) {
		if (!toprightdiagonalSymbolCount.containsKey(symbol)) {
			toprightdiagonalSymbolCount.put(symbol, 0);
		}
		toprightdiagonalSymbolCount.put(symbol, toprightdiagonalSymbolCount.get(symbol) + 1);
	}

	if (isCellOnTopLeftDiagonal(row, col)) {
		if (!topleftdiagonalSymbolCount.containsKey(symbol)) {
			topleftdiagonalSymbolCount.put(symbol, 0);
		}
		topleftdiagonalSymbolCount.put(symbol, topleftdiagonalSymbolCount.get(symbol) + 1);
	}

	// check winner

	if ((rowSymbolCounts.get(row).get(symbol) == dimension) || (colSymbolCounts.get(col).get(symbol) == dimension)) {
		return true;
	}
	if (isCellOnTopLeftDiagonal(row, col) && topleftdiagonalSymbolCount.get(symbol) == dimension) {
		return true;
	}
	if (isCellOnTopRightDiagonal(row, col, dimension) && toprightdiagonalSymbolCount.get(symbol) == dimension) {
		return true;
	}
	return false;
}

}
