package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DealingTest {

	public static void main(String[] args) {
		DealingTest d = new DealingTest();
		d.deal();
	}

	private void deal() {
		Deck deck = new Deck();
		deck.shuffle();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("How many cards: ");

		try {
			int numCards = sc.nextInt();
			if (numCards > 52) {
				throw new InputMismatchException();
			}

			List<Card> hand = new ArrayList<>(numCards);
			int totalValue = 0;
			for (int i = 0; i < numCards; i++) {
				Card newCard = deck.dealCard();
				totalValue += newCard.getValue();
				hand.add(newCard);
			}
			printHandAndValue(hand, totalValue);
		} catch (InputMismatchException e) {
			System.err.println("That is not a valid number of cards.");
		} finally {
			sc.close();
		}
	}

	private void printHandAndValue(List<Card> hand, int value) {
		for (Card card : hand) {
			System.out.println(card);
		}
		System.out.println("Total value: " + value);
	}

}
