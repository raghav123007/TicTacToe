package Models;

import java.util.Scanner;

public class Player {
	private char symbols;
	private String name;
	private PlayerType type;

	public Player(String name, char symbols, PlayerType playerType) {
		this.symbols = symbols;
		this.name = name;
		this.type = playerType;
		// TODO Auto-generated constructor stub
	}

	public char getSymbols() {
		return symbols;
	}

	public void setSymbols(char symbols) {
		this.symbols = symbols;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerType getType() {
		return type;
	}

	public void setType(PlayerType type) {
		this.type = type;
	}

	public Move decideMove(Board board) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the row to make move");
		int row = scanner.nextInt();

		System.out.println("Enter the column to make move");
		int col = scanner.nextInt();
		return new Move(this, new Cell(row, col));
	}

}
