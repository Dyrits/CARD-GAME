package com.openclassrooms.cardgame.model;

import java.util.ArrayList;

public class DeckTest extends Deck {
    public DeckTest() {
        this.cards = new ArrayList<PlayingCard>();
        for(int loop = 0; loop < 20; loop ++) { this.cards.add(new PlayingCard(Rank.ACE, Suit.CLUBS)); }
        shuffle();
    }
}
