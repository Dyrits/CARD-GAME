package com.openclassrooms.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Deck {
    protected List<PlayingCard> cards;

    public void shuffle() {
        Random random = new Random();
        for(int index = 0; index < this.cards.size(); index++) {
            int randomIndex = random.nextInt(this.cards.size());
            Collections.swap(this.cards, index, randomIndex);
        }
    }

    public PlayingCard draw() { return this.cards.remove(0);}

    public void returnCardToDeck(PlayingCard card) { this.cards.add(card); }

    public List<PlayingCard> getCards() { return this.cards; }
}
