package com.openclassrooms.cardgame.model;

import java.util.ArrayList;

public class Deck32 extends Deck {
    public Deck32() {
        this.cards = new ArrayList<PlayingCard>();
        for(Rank rank : Rank.values()) {
            if (rank.getValue() >= 7) {
                for(Suit suit : Suit.values()) { this.cards.add(new PlayingCard(rank, suit)); }
            }
        }
        shuffle();
    }
}
