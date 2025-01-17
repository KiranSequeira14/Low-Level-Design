package org.company.DTO;

public class Card {
    private Suit suit;
    private Rank rank;

    Card(Suit suit,Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue(){
        return rank.getValue();
    }

    public Rank getRank(){
        return this.rank;
    }
}
