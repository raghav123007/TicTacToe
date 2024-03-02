package Strategies.BotPlayingStrategy;

import Models.Board;
import Models.Cell;
import Models.CellState;
import Models.Move;
import Models.Player;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

	@Override
	public Move decideMove(Player player, Board board) {

		for (int i = 0; i < board.getBoard().size(); i++) {
			for (int j = 0; j < board.getBoard().size(); j++) {
				if (board.getBoard().get(i).get(j).getCellState().equals(CellState.AVALIABLE)) {
					;
					// Bot will make a move here
					return new Move(player, new Cell(i, j));
				}
			}
		}

		return null;
	}

}
