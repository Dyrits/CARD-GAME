package com.openclassrooms.cardgame.model;

import java.util.ArrayList;

public class Deck52 extends Deck {
    public Deck52() {
        this.cards = new ArrayList<PlayingCard>();
        for(Rank rank : Rank.values()) {
            for(Suit suit : Suit.values()) { this.cards.add(new PlayingCard(rank, suit)); }
        }
        shuffle();
    }
}
