package Models;

import java.util.LinkedList;
import java.util.List;

import Exception.InvalidGameDimensionException;
import Strategies.GameWinningStrategy.GameWinningStrategy;
import Strategies.GameWinningStrategy.OrderOneGameWinningStrategy;

public class Game {

	private Board board;
	private List<Player> players;
	private List<Move> moves;
	private GameStatus gameStatus;
	private int nextPlayerIndex;
	private Player winner;

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	private GameWinningStrategy gameWinningStrategy;


	public GameWinningStrategy getGameWinningStrategy() {
		return gameWinningStrategy;
	}

	public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
		this.gameWinningStrategy = gameWinningStrategy;
	}

	private Game() {
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public List<Player> getPlayer() {
		return players;
	}

	public void setPlayer(List<Player> players) {
		this.players = players;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	public int getNextPlayerIndex() {
		return nextPlayerIndex;
	}

	public void setNextPlayerIndex(int nextPlayerIndex) {
		this.nextPlayerIndex = nextPlayerIndex;
	}

	public static class Builder {
		private int dimension;
		private List<Player> players;

		public Builder setDimension(int dimension) {
			this.dimension = dimension;
			return this;
		}

		public Builder setPlayers(List<Player> players) {
			this.players = players;
			return this;
		}

//		public static Builder getBuilder() {
//			return new Builder();
//
//		}

		public Game build() {
			try {
				isValid();
				
			}
			catch (InvalidGameDimensionException e) {
				System.out.println("e");
				return null;
			}
			Game game = new Game();
			game.setBoard(new Board(dimension));
			game.setPlayer(players);
			game.setMoves(new LinkedList<>());
			game.setNextPlayerIndex(0);
			game.setGameWinningStrategy(new OrderOneGameWinningStrategy(dimension));

			return game;
		}

		private void isValid() throws InvalidGameDimensionException {
			if (dimension < 3) {
				throw new InvalidGameDimensionException("Dimension should not be less than 3");

			}
		}

	}

	public static Builder getBuilder() {
		// TODO Auto-generated method stub
		return new Builder();
	}

	public void makeNextMove() {
		Player playerWhoMoveItIs = players.get(nextPlayerIndex);
		System.out.println("It Is " + playerWhoMoveItIs + "'s turn");
		Move move = playerWhoMoveItIs.decideMove(board);
		
		int row=move.getCell().getRow();
		int col=move.getCell().getColumn();
		if (board.getBoard().get(row).get(col).getCellState().equals(CellState.AVALIABLE)) {
			board.applyMove(move);
			moves.add(move);

			// check the winner
			if (gameWinningStrategy.checkWinner(board, move)) {
				gameStatus = GameStatus.ENDED;
				winner = playerWhoMoveItIs;
			}

			nextPlayerIndex += 1;
			nextPlayerIndex %= players.size();
		} else {
			// throw exception
		}

	}
}

