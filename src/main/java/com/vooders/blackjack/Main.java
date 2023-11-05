package com.vooders.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        Deck deck = new Deck(new CardGenerator().generateStandardDeck());
        Game game = new Game(reader, deck);

        System.out.println("Let's play backjack");
        game.start();
    }
}
