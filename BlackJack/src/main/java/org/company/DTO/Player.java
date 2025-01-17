package org.company.DTO;

public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public void receiveCard(Card card) {
        hand.addCard(card);
    }

    public int getHandValue() {
        return hand.getHandValue();
    }

    public boolean isBusted() {
        return hand.getHandValue() > 21;
    }

    public String toString() {
        return name + "'s hand: " + hand + " (Value: " + getHandValue() + ")";
    }
}
