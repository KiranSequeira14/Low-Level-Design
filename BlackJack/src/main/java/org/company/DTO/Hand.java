package org.company.DTO;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getHandValue() {
        int total = 0, aces = 0;
        for (Card card : cards) {
            total += card.getValue();
            if (card.getRank() == Rank.ACE) {
                aces++;
            }
        }

        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }

}
