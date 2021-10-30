package com.skilldistillery.blackjackapp;

import java.util.Scanner;

import com.skilldistillery.blackjack.BlackjackDealer;

public class BlackjackApp {
	private BlackjackDealer bjd = new BlackjackDealer();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();
		bja.run();
		sc.close();
	}

	public void run() {
		boolean playAgain = true;

		printWelcome();

		while (playAgain) {
			startGame();
			dealFirstRound();
			finishGame();
			playAgain = askToPlayAgain();
		}
		sc.close();
	}

	public void printWelcome() {
		System.out.println("Welcome to the Blackjack table. Press enter to play.");
		sc.nextLine();
	}

	public void startGame() {
		System.out.println("Dealer is shuffling deck...");
		bjd.newDeck();
		bjd.shuffle();
		System.out.println("Dealer is dealing...\n");
	}

	public void dealFirstRound() {
		dealPlayerHand();
		dealDealerHand();

		System.out.println("Your cards are:");
		printPlayerHand();

		System.out.print("\nDealer shows ");
		printDealerFirstCard();

		System.out.print("\nYour total is ");
		printPlayerTotal();
	}

	public void finishGame() {

		if (playerHasBlackjack()) {
			System.out.println("Blackjack! Press enter to see the dealer complete their turn.");
			sc.nextLine();
			finishHand();
		}
		if (!playerHasBlackjack()) {
			finishHandWithoutPlayerBlackJack();
		}
	}

	public boolean askToPlayAgain() {
		boolean playAgain;

		System.out.println("\nPlay ANOTHA ONE? Type (1) for yes or (2) for no.");
		int keepGoing = sc.nextInt();
		sc.nextLine();

		switch (keepGoing) {
		case 1:
			System.out.println("\nLet's keep this party going. Press enter to deal the next hand.");
			sc.nextLine();
			clearAllHands();
			playAgain = true;
			break;
		case 2:
			System.out.println("\nLater alligator, bye!");
			playAgain = false;
			break;
		default:
			System.err.println("Not a valid option. You're drunk. Goodbye.");
			playAgain = false;
		}

		return playAgain;
	}

	public void finishHand() {
		System.out.print("Dealer's second card is ");
		printDealerSecondCard();
		printDealerTotal();
		finishDealerTurn();
		checkWinner();
	}

	public void finishHandWithoutPlayerBlackJack() {
		int hitOrStand;
		boolean keepGoing = true;

		while (keepGoing) {
			System.out.println("Would you like to (1) hit or (2) stand?");
			hitOrStand = sc.nextInt();
			sc.nextLine();

			switch (hitOrStand) {
			case 1:
				playerHitCycle();
				keepGoing = checkBustOr21();
				break;
			case 2:
				playerStandCycle();
				keepGoing = false;
				break;
			default:
				System.err.println("\nNot a valid choice. Choose again\n");

			}
		}
	}

	public void playerHitCycle() {
		System.out.println("\nPress enter to prompt the dealer to deal your next card.");
		sc.nextLine();
		System.out.print("Your next card is a ");
		dealPlayerAnotherCard();
		printPlayerLastCard();

		System.out.println("\nYour hand is now: ");
		printPlayerHand();

		System.out.print("\nYour total card value is ");
		printPlayerTotal();
	}

	public void playerStandCycle() {
		System.out.print("\nReminder, dealer shows a ");
		printDealerFirstCard();
		System.out.println("\nPress enter to see dealer's second card: ");
		sc.nextLine();
		finishHand();
//		System.out.print("Dealer's second card is ");
//		printDealerSecondCard();
//		printDealerTotal();
//		finishDealerTurn();
//		checkWinner();
	}

	public boolean checkBustOr21() {
		if (playerHasBlackjack()) {
			System.out.println("21! Time for the dealer to finish their turn.");
			System.out.println("Press enter to see the dealer's second card.");
			sc.nextLine();
			finishHand();
			return false;
		}

		if (checkPlayerBust()) {
			System.out.println("Womp womp, you busted! Dealer wins.");
			return false;
		}
		return true;
	}

	public void dealPlayerHand() {
		bjd.dealPlayerHand();
	}

	public void dealDealerHand() {
		bjd.dealDealerHand();
	}

	public void printPlayerHand() {
		bjd.printPlayerHand();
	}

	public void printDealerFirstCard() {
		bjd.printDealerFirstCard();
	}

	public void printDealerSecondCard() {
		bjd.printDealerSecondCard();
	}

	public void printPlayerLastCard() {
		bjd.printPlayerLastCard();
	}

	public void printPlayerTotal() {
		bjd.printPlayerTotal();
	}

	public void printDealerTotal() {
		System.out.print("Dealer total is ");
		bjd.printDealerTotal();
	}

	public boolean playerHasBlackjack() {
		return bjd.checkPlayerForBlackjack();
	}

	public void finishDealerTurn() {
		bjd.finishDealerTurn();
	}

	public void checkWinner() {
		bjd.checkWinner();
	}

	public void dealPlayerAnotherCard() {
		bjd.dealPlayerAnotherCard();
	}

	public boolean checkPlayerBust() {
		return bjd.checkPlayerForBust();
	}

	public void clearAllHands() {
		bjd.clearAllHands();
	}

}
