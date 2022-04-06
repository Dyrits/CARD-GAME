package com.openclassrooms.cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<PlayingCard> cards;

    public Hand() { this.cards = new ArrayList<PlayingCard>(); }

    public void addCard(PlayingCard card) { this.cards.add(card); }

    public PlayingCard getCard(int index) { return this.cards.get(index);}

    public PlayingCard removeCard(int index) { return this.cards.remove(index); }
    public PlayingCard removeCard() { return this.removeCard(0); }


}
