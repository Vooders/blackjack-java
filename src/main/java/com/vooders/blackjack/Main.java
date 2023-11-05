package com.vooders.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        Deck deck = new Deck(new CardGenerator().generateStandardDeck());
        deck.shuffle();

        System.out.println("Let's play backjack");
        System.out.println("Ready to play? (s) start; (q) quit");
        
        if (reader.readLine().equals("s")) {
            boolean playing = true;
            Hand dealer = new Hand(deck.takeCard(), deck.takeCard());
            Hand player = new Hand(deck.takeCard(), deck.takeCard());

            display(dealer, player);

            while(playing) {
                System.out.println("(h) hit; (s) stick");
                switch (reader.readLine()) {
                    case "h":
                        player.addCard(deck.takeCard());
                        display(dealer, player);
                        if (player.isBust()) {
                            System.out.println("BUST");
                            playing = false;
                        }
                        break;
                    case "s":
                        while (dealer.getTotal() < 17) {
                            dealer.addCard(deck.takeCard());
                            display(dealer, player);
                        }

                        if (dealer.isBust()) {
                            System.out.println("Dealer BUST - You win");
                        } else if (player.isGreaterThan(dealer)) {
                            System.out.println("You win");
                        } else if (player.equals(dealer)) {
                            System.out.println("Draw");
                        } else {
                            System.out.println("Dealer wins");
                        }
                        playing = false;
                        break;
                }
            }
        }
    }

    private static void display(Hand dealer, Hand player) {
        System.out.println("Dealer");
        System.out.println(dealer.toString() + dealer.getTotal());
        System.out.println("Player");
        System.out.println(player.toString() + player.getTotal());
    }
}
