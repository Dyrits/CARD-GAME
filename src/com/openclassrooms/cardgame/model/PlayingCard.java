package com.openclassrooms.cardgame.model;

public class PlayingCard {
    private final Rank rank;
    private final Suit suit;
    private boolean faceUp;

    public PlayingCard(Rank rank, Suit suit) {
        super();
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() { return this.rank; }

    public Suit getSuit() { return this.suit; }

    boolean isFaceUp() { return this.faceUp; }

    public boolean flip() { return this.faceUp = !this.faceUp; }
}
