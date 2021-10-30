package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.cards.Hand;

public class BlackjackHand extends Hand {

	protected List<Card> hand;

	public BlackjackHand() {
		hand = new ArrayList<>(2);
	}

	public void addCard(Card c) {
		hand.add(c);
	}

	public void clear() {
		hand.removeAll(hand);
	}

	public int getHandValue() {
		int value = 0;
		for (Card card : hand) {
			value += card.getValue();
		}
		return value;
	}

	public boolean isBlackjack() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();
		}
		if (value == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBust() {
		// if hand value is > 21
		return false;
	}

	public void printPlayerHand() {
		for (Card card : hand) {
			System.out.println("\t" + card);
		}
	}

	public void printDealerFirstCard() {
		System.out.println(hand.get(0));
	}

	public void printDealerSecondCard() {
		System.out.println(hand.get(1));
	}

}
