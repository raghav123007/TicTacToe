package Models;

public enum BotDifficulty {
	EASY(1), MEDIUM(2), HARD(3);

	private final int value;

	private BotDifficulty(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
