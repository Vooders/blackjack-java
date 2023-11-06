package com.vooders.blackjack;

import java.io.BufferedReader;
import java.io.IOException;

public class Game {
    private final BufferedReader reader;
    private final Deck deck;
    private boolean gameRunning;

    public Game(BufferedReader reader, Deck deck) {
        this.gameRunning = false;
        this.reader = reader;
        this.deck = deck;
    }
    
    public void start() throws IOException {
        gameRunning = true;
        deck.shuffle();
        
        while (gameRunning) {
            print("(d)eal, (q)uit");
            switch (reader.readLine()) {
                case "d" -> playRound();
                case "q" -> System.exit(0);
            }
        }
    }
    
    private void playRound() throws IOException {
        boolean roundActive = true;
        Hand dealer = new Hand(deck.takeCard(), deck.takeCard());
        Hand player = new Hand(deck.takeCard(), deck.takeCard());

        display(dealer.toDealerString(), player.toString());

        while(roundActive) {
            print("(h) hit; (s) stick");
            switch (reader.readLine()) {
                case "h" -> {
                    player.addCard(deck.takeCard());
                    if (player.isBust() || player.hasBlackJack()) {
                        roundActive = false;
                    }
                }
                case "s" -> {
                    while (dealer.getTotal() < 17) {
                        dealer.addCard(deck.takeCard());
                    }
                    roundActive = false;
                }
            }
            display(dealer.toDealerString(), player.toString());
        }

        display(dealer.toString(), player.toString());

        deck.addCards(dealer.getCards());
        deck.addCards(player.getCards());

        printRoundResult(player, dealer);
    }

    private void printRoundResult(Hand player, Hand dealer) {
        if (player.isBust()) {
            print("BUST - You lose");
        } else if (dealer.isBust()) {
            print("Dealer BUST - You win");
        } else if (player.isGreaterThan(dealer)) {
            print("You win");
        } else if (player.equals(dealer)) {
            print("Draw");
        } else if (player.hasBlackJack()) {
            print("Blackjack!");
        } else {
            print("Dealer wins");
        }
        print("");
    }

    private void display(String dealer, String player) {
        print("Dealer");
        print(dealer);
        print("Player");
        print(player);
    }
    
    private void print(String line) {
        System.out.println(line);
    }
}
