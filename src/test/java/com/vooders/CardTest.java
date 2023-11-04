package com.vooders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void a_card_has_a_face_value() {
        String faceValue = "4";
        Card card = new Card(faceValue, "♣", 1);

        assertEquals(faceValue, card.getFaceValue());
    }

    @Test
    void a_card_has_a_suit() {
        String suit = "♣";
        Card card = new Card("K", suit, 1);

        assertEquals(suit, card.getSuit());
    }

    @Test
    void a_card_has_a_value() {
        int value = 4;
        Card card = new Card("4", "♣" , value);

        assertEquals(value, card.getValue());
    }

    @Test
    void a_high_card_is_greater_than_a_lower_card() {
        Card lowCard = new Card("2","♣", 2);
        Card highCard = new Card("4", "♣", 4);

        assertTrue(highCard.isGreaterThan(lowCard));
    }

    @Test
    void a_low_card_is_lower_than_a_high_card() {
        Card lowCard = new Card("2","♣", 2);
        Card highCard = new Card("4", "♣", 4);

        assertTrue(lowCard.isLowerThan(highCard));
    }

    @Test
    void cards_with_the_same_value_are_equal() {
        Card king = new Card("K", "♣",  10);
        Card ten = new Card("10", "♣", 10);

        assertEquals(king, ten);
    }

    @Test
    void card_string_value_should_be_faceValue_and_suit() {
        Card card = new Card("K", "♣",  10);

        assertEquals("K♣", card.toString());
    }
}
