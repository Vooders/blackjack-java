package com.vooders.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
    @Test
    void a_hand_total_is_the_sum_of_the_cards() {
        Card fistCard = new Card("K", "s", 10);
        Card secondCard = new Card("K", "s", 10);
        Hand hand = new Hand(fistCard, secondCard);

        assertEquals(20, hand.getTotal());
    }

    @Test
    void is_not_bust_if_total_is_less_than_21() {
        Card fistCard = new Card("K", "s", 10);
        Card secondCard = new Card("K", "s", 10);
        Hand hand = new Hand(fistCard, secondCard);

        assertFalse(hand.isBust());
    }

    @Test
    void can_add_a_card_to_a_hand() {
        Hand hand = new Hand(
                new Card("K", "s", 10),
                new Card("K", "s", 10));

        hand.addCard(new Card("K", "s", 10));

        assertEquals(3, hand.getCards().size());
    }

    @Test
    void is_bust_if_total_is_over_21() {
        Card fistCard = new Card("K", "s", 30);
        Card secondCard = new Card("K", "s", 10);
        Hand hand = new Hand(fistCard, secondCard);

        assertTrue(hand.isBust());
    }

    @Test
    void can_split_if_first_two_cards_have_the_same_faceValue() {
        Card fistCard = new Card("K", "s", 10);
        Card secondCard = new Card("K", "s", 10);
        Hand hand = new Hand(fistCard, secondCard);

        assertTrue(hand.canSplit());
    }

    @Test
    void cant_split_a_hand_with_more_than_2_cards() {
        Hand hand = new Hand(
                new Card("K", "s", 10),
                new Card("K", "s", 10));

        hand.addCard(new Card("K", "s", 10));

        assertFalse(hand.canSplit());
    }

    @Test
    void hands_with_the_same_total_are_equal() {
        Hand hand1 = new Hand(
                new Card("K", "s", 10),
                new Card("K", "s", 10));

        Hand hand2 = new Hand(
                new Card("10", "s", 10),
                new Card("Q", "h", 10));

        assertEquals(hand1, hand2);
    }

    @Test
    void a_hand_with_a_higher_total_is_greater_than_one_with_a_lower_total() {
        Hand hand1 = new Hand(
                new Card("K", "s", 10),
                new Card("K", "s", 2));

        Hand hand2 = new Hand(
                new Card("10", "s", 10),
                new Card("Q", "h", 10));

        assertTrue(hand2.isGreaterThan(hand1));
        assertFalse(hand1.isGreaterThan(hand2));
    }

    @Test
    void a_hand_with_a_lower_total_is_lower_than_one_with_a_higher_total() {
        Hand hand1 = new Hand(
                new Card("K", "s", 10),
                new Card("K", "s", 2));

        Hand hand2 = new Hand(
                new Card("10", "s", 10),
                new Card("Q", "h", 10));

        assertTrue(hand1.isLowerThan(hand2));
        assertFalse(hand2.isLowerThan(hand1));
    }

    @Test
    void hand_string_value_should_be_all_its_cards_string_values_and_total() {
        Hand hand = new Hand(
                new Card("10", "s", 10),
                new Card("Q", "h", 10));
        hand.addCard(new Card("K", "s", 10));

        String expectedString = "[10s, Qh, Ks] 30";

        assertEquals(expectedString, hand.toString());
    }

    @Test
    void dealer_string_should_only_show_first_card_and_no_total() {
        Hand hand = new Hand(
                new Card("10", "s", 10),
                new Card("Q", "h", 10));

        String expectedString = "10s, X";

        assertEquals(expectedString, hand.toDealerString());
    }
}
