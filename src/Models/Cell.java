package Models;

public class Cell {
	private Player player;
	private int row;

	private CellState cellState;

	public Cell(int row, int column) {
		this.row = row;
		this.column = column;
		this.cellState = CellState.AVALIABLE;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public CellState getCellState() {
		return cellState;
	}

	public void setCellState(CellState cellState) {
		this.cellState = cellState;
	}
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	private int column;

}
