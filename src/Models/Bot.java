package Models;

import Strategies.BotPlayingStrategy.BotPlayingStrategy;
import Strategies.BotPlayingStrategy.EasyBotPlayingStrategy;

public class Bot extends Player {

	private BotDifficulty difficulty;
	private BotDifficulty botDifficulty;
	

	private BotPlayingStrategy botPlayingStrategy;
	

	public Bot(String name, char symbols, BotDifficulty botDifficulty) {
		super(name, symbols, PlayerType.BOT); 
		this.botDifficulty = botDifficulty;
		this.botPlayingStrategy = new EasyBotPlayingStrategy();
	}

	public BotDifficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(BotDifficulty difficulty) {
		this.difficulty = difficulty;
	}
	
	public Move decideMove(Board board) {
		return botPlayingStrategy.decideMove(this, board);
	}

}

