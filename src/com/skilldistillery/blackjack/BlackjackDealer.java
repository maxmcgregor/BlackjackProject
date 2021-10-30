package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class BlackjackDealer {

	public BlackjackHand playerHand = new BlackjackHand();
	public BlackjackHand dealerHand = new BlackjackHand();
	public Deck deck = new Deck();
	Scanner sc = new Scanner(System.in);

	public BlackjackDealer() {

	}

	public void shuffle() {
		deck.shuffle();
	}

	public BlackjackHand dealPlayerHand() {

		Card firstCard = deck.dealCard();
		playerHand.addCard(firstCard);

		Card secondCard = deck.dealCard();
		playerHand.addCard(secondCard);

		return playerHand;
	}

	public BlackjackHand dealDealerHand() {

		Card firstCard = deck.dealCard();
		dealerHand.addCard(firstCard);

		Card secondCard = deck.dealCard();
		dealerHand.addCard(secondCard);

		return dealerHand;
	}

	public void printPlayerHand() {
		playerHand.printPlayerHand();
	}

	public void printDealerFirstCard() {
		dealerHand.printDealerFirstCard();
	}

	public void printDealerSecondCard() {
		dealerHand.printDealerSecondCard();
	}

	public void printPlayerTotal() {
		int playerTotal = playerHand.getHandValue();
		System.out.println(playerTotal + "\n");
	}
	
	public int printDealerTotal() {
		int total = dealerHand.getHandValue();
		System.out.println(total + "\n");
		return total;
	}

	public boolean checkPlayerForBlackjack() {
		return playerHand.isBlackjack();
	}

	public void dealPlayerAnotherCard() {
		Card nextCard = deck.dealCard();
		playerHand.addCard(nextCard);
	}
	
	public void finishDealerTurn() {
		int dealerTotal = dealerHand.getHandValue();
		while (dealerTotal < 17) {
			Card nextCard = deck.dealCard();
			dealerHand.addCard(nextCard);
			dealerTotal = dealerHand.getHandValue();
			printDealerTotal();
			System.out.println("Dealer total test");
		}
	}
}
