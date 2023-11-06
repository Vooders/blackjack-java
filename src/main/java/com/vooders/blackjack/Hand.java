package com.vooders.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hand implements Comparable<Hand> {

    private final List<Card> cards;
    private static final int BUST_LIMIT = 21;
    private static final int BLACKJACK = 21;

    public Hand(Card fistCard, Card secondCard) {
        cards = new ArrayList<>();
        this.cards.add(fistCard);
        this.cards.add(secondCard);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getTotal() {
        return cards.stream()
                .mapToInt(Card::getValue)
                .sum();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public boolean isBust() {
        return this.getTotal() > BUST_LIMIT;
    }

    public boolean canSplit() {
        if (cards.size() != 2) {
            return false;
        }
        return cards.get(0).getFaceValue().equals(cards.get(1).getFaceValue());
    }

    public boolean isGreaterThan(Hand hand) {
        return this.compareTo(hand) > 0;
    }

    public boolean isLowerThan(Hand hand) {
        return this.compareTo(hand) < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand) o;
        return getTotal() == hand.getTotal();
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }

    @Override
    public int compareTo(Hand otherHand) {
        return getTotal() - otherHand.getTotal();
    }

    @Override
    public String toString() {
        return cards.toString() + " " + getTotal();
    }

    public String toDealerString() {
        return cards.get(0).toString() + ", X";
    }

    public boolean hasBlackJack() {
        if (cards.size() != 2) {
            return false;
        }
        return getTotal() == BLACKJACK;
    }
}
