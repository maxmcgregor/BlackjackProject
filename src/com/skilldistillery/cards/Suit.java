package com.skilldistillery.cards;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");

	private final String name;

	Suit(String n) {
		name = n;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

}
