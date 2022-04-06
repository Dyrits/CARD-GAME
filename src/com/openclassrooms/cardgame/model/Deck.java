package com.openclassrooms.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<PlayingCard> cards;

    public Deck() {
        this.cards = new ArrayList<PlayingCard>();
        for(Rank rank : Rank.values()) {
            for(Suit suit : Suit.values()) {
                this.cards.add(new PlayingCard(rank, suit));
            }
        }
        shuffle();
    }

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
