package org.company;

import org.company.DTO.Deck;
import org.company.DTO.Player;

import java.util.Scanner;

public class BlackJackGame {
    private Deck deck;
    private Player dealer;
    private Player player;

    BlackJackGame(String playerName) {
        player = new Player(playerName);
        dealer = new Player("Dealer");
        deck = new Deck();
    }

    public void play() {
        initialize();
        playerTurn();
        if (!player.isBusted()) {
            dealerTurn();
        }
        checkWinner();
    }

    private void initialize() {
        //2 cards to player
        player.receiveCard(deck.pullCard());
        player.receiveCard(deck.pullCard());
        System.out.println(player);

        //2 cards to dealer
        dealer.receiveCard(deck.pullCard());
        dealer.receiveCard(deck.pullCard());
        System.out.println(dealer);
    }

    private void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Do you want to hit(h) or stand(s)?");
            String selection = scanner.nextLine();

            if (selection.equalsIgnoreCase("h")) {
                player.receiveCard(deck.pullCard());
                System.out.println(player);
                if (player.isBusted()) {
                    System.out.println(player + " is Busted!!");
                    break;
                }
            } else {
                break;
            }
        }
    }

    private void dealerTurn() {
        while (dealer.getHandValue() < 17) {
            dealer.receiveCard(deck.pullCard());
        }
        System.out.println(dealer);
        if (dealer.isBusted()) {
            System.out.println(dealer + " is Busted!!");
        }
    }

    private void checkWinner() {
        if (player.isBusted()) {
            System.out.println(dealer + " WON");
        } else if (dealer.isBusted() || player.getHandValue() > dealer.getHandValue()) {
            System.out.println(player + " WON");
        } else if (player.getHandValue() < dealer.getHandValue()) {
            System.out.println(dealer + " WON!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        BlackJackGame blackJackGame = new BlackJackGame("Kiran");
        blackJackGame.play();
    }
}
