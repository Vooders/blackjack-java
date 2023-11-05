package com.vooders.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    @Test
    void takes_card_from_the_top_of_the_deck() {
        Card firstCard = new Card("2", "♣", 2);
        List<Card> cards = new ArrayList<>();
        cards.add(firstCard);
        cards.add(new Card("3", "♣", 3));
        cards.add(new Card("4", "♣", 4));
        Deck deck = new Deck(cards);

        Card topCard = deck.takeCard();

        assertEquals(firstCard, topCard);
    }

    @Test
    void taking_card_removes_it_from_the_deck() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("2", "♣", 2));
        cards.add(new Card("3", "♣", 3));
        cards.add(new Card("4", "♣", 4));
        Deck deck = new Deck(cards);

        assertEquals(3, deck.totalCards());
        deck.takeCard();
        assertEquals(2, deck.totalCards());
    }

    @Test
    void string_value_is_all_cards_in_order() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("3", "♣", 3));
        cards.add(new Card("2", "♣", 2));
        cards.add(new Card("4", "♣", 4));
        Deck deck = new Deck(cards);

        String expectedString = "[3♣, 2♣, 4♣]";

        assertEquals(expectedString, deck.toString());
    }

    @Test
    void shuffle_changes_the_order_of_the_cards() {
        CardGenerator cardGenerator = new CardGenerator();
        List<Card> cards = cardGenerator.generateStandardDeck();
        Deck deck = new Deck(cards);

        deck.shuffle();

        List<Card> shuffledCards = deck.getCards();
        assertNotEquals(cards.toString(), shuffledCards.toString());
    }

    @Test
    void adding_cards_adds_them_to_the_back_of_the_deck() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("3", "♣", 3));
        cards.add(new Card("2", "♣", 2));
        Deck deck = new Deck(cards);

        Card newCard = new Card("4", "♣", 4);
        deck.addCards(List.of(newCard));

        List<Card> theDeck = deck.getCards();
        Card lastCard = theDeck.get(theDeck.size()-1);

        assertEquals(newCard, lastCard);
    }
}
