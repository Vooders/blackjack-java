package com.vooders.blackjack;

import java.util.List;
import java.util.stream.Collectors;

public class CardGenerator {

    private static final List<String> SUITS = List.of("♣", "♥", "♠", "♦");
    public List<Card> generateStandardDeck() {
        return SUITS.stream()
                .map(this::buildSuit)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Card> generateBlackjackDeck() {
        return List.of(
                new Card("A", "♣", 11),
                new Card("10", "♣", 10),
                new Card("A", "♣", 11),
                new Card("10", "♣", 10),
                new Card("A", "♣", 11),
                new Card("10", "♣", 10),
                new Card("A", "♣", 11),
                new Card("10", "♣", 10),
                new Card("A", "♣", 11),
                new Card("10", "♣", 10),
                new Card("A", "♣", 11),
                new Card("10", "♣", 10),
                new Card("A", "♣", 11),
                new Card("10", "♣", 10),
                new Card("A", "♣", 11),
                new Card("10", "♣", 10),
                new Card("A", "♣", 11),
                new Card("10", "♣", 10),
                new Card("A", "♣", 11),
                new Card("10", "♣", 10),
                new Card("A", "♣", 11),
                new Card("10", "♣", 10),
                new Card("A", "♣", 11),
                new Card("10", "♣", 10)
        );
    }

    private List<Card> buildSuit(String suit) {
        return List.of(
                new Card("2", suit, 2),
                new Card("3", suit, 3),
                new Card("4", suit, 4),
                new Card("5", suit, 5),
                new Card("6", suit, 6),
                new Card("7", suit, 7),
                new Card("8", suit, 8),
                new Card("9", suit, 9),
                new Card("10", suit, 10),
                new Card("J", suit, 10),
                new Card("Q", suit, 10),
                new Card("K", suit, 10),
                new Card("A", suit, 11)
        );
    }
}
