package com.vooders.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> cards;
    public Deck(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public Card takeCard() {
        return cards.remove(0);
    }

    public int totalCards() {
        return cards.size();
    }

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public String toString() {
        return cards.toString();
    }
}
