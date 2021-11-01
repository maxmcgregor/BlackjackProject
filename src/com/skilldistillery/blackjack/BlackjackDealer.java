package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class BlackjackDealer {

	private BlackjackHand playerHand = new BlackjackHand();
	private BlackjackHand dealerHand = new BlackjackHand();
	private Deck deck;
	Scanner sc = new Scanner(System.in);

	public BlackjackDealer() {
	}

	public void newDeck() {
		deck = new Deck();
	}
	
	public void shuffle() {
		deck.shuffle();
	}

	public BlackjackHand dealPlayerHand() {
		Card firstCard = deck.dealCard();
		Card secondCard = deck.dealCard();
		playerHand.addCard(firstCard);
		playerHand.addCard(secondCard);
		return playerHand;
	}

	public BlackjackHand dealDealerHand() {
		Card firstCard = deck.dealCard();
		Card secondCard = deck.dealCard();
		dealerHand.addCard(firstCard);
		dealerHand.addCard(secondCard);
		return dealerHand;
	}

	public void dealPlayerAnotherCard() {
		Card nextCard = deck.dealCard();
		playerHand.addCard(nextCard);
	}

	public void dealDealerAnotherCard() {
		Card nextCard = deck.dealCard();
		dealerHand.addCard(nextCard);
	}

	public void printPlayerHand() {
		playerHand.printHand();
	}
	
	public void printPlayerLastCard() {
		playerHand.printLastCard();
	}

	public void printDealerFirstCard() {
		dealerHand.printFirstCard();
	}

	public void printDealerSecondCard() {
		dealerHand.printSecondCard();
	}

	public void printPlayerTotal() {
		int playerTotal = playerHand.getHandValue();
		System.out.println(playerTotal + "\n");
	}

	public void printDealerTotal() {
		int total = dealerHand.getHandValue();
		System.out.println(total + "\n");
	}

	public boolean checkPlayerForBlackjack() {
		return playerHand.isBlackjack();
	}
	
	public boolean checkDealerForBlackjack() {
		return dealerHand.isBlackjack();
	}
	
	public boolean checkPlayerForBust() {
		return playerHand.isBust();
	}
	
	public boolean checkDealerForBust() {
		return dealerHand.isBust();
	}

	public void finishDealerTurn() {
		int dealerTotal = dealerHand.getHandValue();

		while (dealerTotal < 17) {
			System.out.println("Press enter to see the dealer's next card.");
			sc.nextLine();
			Card nextCard = deck.dealCard();
			dealerHand.addCard(nextCard);
			dealerHand.printLastCard();
			dealerTotal = dealerHand.getHandValue();
			System.out.print("Dealer total is ");
			printDealerTotal();
		}
	}

	public void checkWinner() {
		int dealerTotal = dealerHand.getHandValue();
		int playerTotal = playerHand.getHandValue();
		boolean dealerBust = dealerHand.isBust();
		boolean playerBust = playerHand.isBust();

		boolean playerWins = (!playerBust) && ((playerTotal > dealerTotal) || dealerBust);
		boolean dealerWins = (!dealerBust) && ((dealerTotal > playerTotal) || playerBust);
		boolean push = playerTotal == dealerTotal;
		boolean doubleBust = dealerBust && playerBust;

		if (playerWins) {
			System.out.println("You have " + playerTotal + " to the dealer's " + dealerTotal);
			System.out.println("You win!");
		} else if (dealerWins) {
			System.out.println("Dealer has " + dealerTotal + " to your " + playerTotal);
			System.out.println("Dealer wins.");
		} else if (push) {
			System.out.println("You tie, it's a push.");
		} else if (doubleBust) {
			System.out.println("You both busted. Womp womp.");
		}
	}
	
	public void clearAllHands() {
		playerHand.clear();
		dealerHand.clear();
	}
}
