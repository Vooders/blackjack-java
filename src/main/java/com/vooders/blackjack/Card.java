package com.vooders.blackjack;

import java.util.Objects;

public class Card implements Comparable<Card> {
    private final String faceValue;
    private final int value;
    private final String suit;

    public Card(String faceValue, String suit, int value) {
        this.faceValue = faceValue;
        this.value = value;
        this.suit = suit;
    }

    public String getFaceValue() {
        return this.faceValue;
    }

    public String getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isGreaterThan(Card card) {
        return this.compareTo(card) > 0;
    }

    public boolean isLowerThan(Card card) {
        return this.compareTo(card) < 0;
    }

    public String toString() {
        return this.faceValue + this.suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Card card) {
        int compareQuantity = card.getValue();
        return this.value - compareQuantity;
    }
}
