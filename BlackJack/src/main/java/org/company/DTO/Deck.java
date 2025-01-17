package org.company.DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cardList;

    public Deck() {
        cardList = new ArrayList<>(52);

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardList.add(new Card(suit, rank));
            }
        }

        Collections.shuffle(cardList);
    }

    public Card pullCard() {
        return cardList.remove(cardList.size() - 1);
    }
}
