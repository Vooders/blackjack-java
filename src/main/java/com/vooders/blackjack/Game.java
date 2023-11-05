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

        display(dealer, player);

        while(roundActive) {
            print("(h) hit; (s) stick");
            switch (reader.readLine()) {
                case "h" -> {
                    player.addCard(deck.takeCard());
                    display(dealer, player);
                    if (player.isBust()) {
                        roundActive = false;
                    }
                }
                case "s" -> {
                    while (dealer.getTotal() < 17) {
                        dealer.addCard(deck.takeCard());
                        display(dealer, player);
                    }
                    roundActive = false;
                }
            }
        }

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
        } else {
            print("Dealer wins");
        }
        print("");
    }

    private void display(Hand dealer, Hand player) {
        print("Dealer");
        print(dealer.toString() + " " + dealer.getTotal());
        print("Player");
        print(player.toString() + " " + player.getTotal());
    }
    
    private void print(String line) {
        System.out.println(line);
    }
}
