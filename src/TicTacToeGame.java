import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Controller.GameController;
import Models.Bot;
import Models.BotDifficulty;
import Models.Game;
import Models.GameStatus;
import Models.Player;
import Models.PlayerType;

public class TicTacToeGame {
	public static void main(String args[]) {
		System.out.println("Hello,Game Starting.... ");
		Scanner scanner = new Scanner(System.in);

		System.out.println("What is the dimension of the game: ");
		int dimension = scanner.nextInt();

		System.out.println("What is the No Of Player: ");
		int noOfPlayer = scanner.nextInt();

		// we need a list of players
		List<Player> players = new LinkedList<>();

		System.out.println("Is there any bot in the game: Y/N ");
		String isbot = scanner.next();
		if (isbot.equals("Y")) {
			noOfPlayer = noOfPlayer - 1;// no. of human players

			System.out.println("Enter the name of the bot: ");
			String name = scanner.next();

			System.out.println("Enter the symbol of the bot: ");
			String botSymbol = scanner.next();

			System.out.println("Enter thedifficulty of the bot:");
			String botDifficultyLevel = scanner.next();
			// todo for bot difficulty level

			players.add(new Bot(name, botSymbol.charAt(0), BotDifficulty.EASY));
		}

		for (int i = 0; i < noOfPlayer; i++) {
			System.out.println("Enter the name of the player: " + i + 1);
			String namePlayer = scanner.next();
			System.out.println("Enter the symbol of the player: " + i + 1);
			String symbolPlayer = scanner.next();

			Player player = new Player(namePlayer, symbolPlayer.charAt(0), PlayerType.HUMAN);
			players.add(player);

		}

//		Game game = Game.getBuilder().setDimension(dimension).setPlayers(players).build();
		GameController gameController = new GameController();
		Game game = gameController.createGame(dimension, players);
		gameController.setGameStatus(game, GameStatus.IN_PROGRESS);

		while (gameController.getGameStatus(game) == GameStatus.IN_PROGRESS) {
			// players will be playing
			System.out.println("Current Board: ");
			gameController.displayBoard(game);

			System.out.println("Do you want undo ? Y/N ");
			String input = scanner.next();

			if (input.equals("Y")) {
				gameController.undo(game);
			} else {
				gameController.executedNextMove(game);
			}
		}

		if (gameController.getGameStatus(game) == GameStatus.ENDED) {
			// someone has won
			System.out.println("Winning PLayer:" + gameController.getWinnerName(game));
		}
		else {
			System.out.println("Game has Drawn");
		}
		}
	}


