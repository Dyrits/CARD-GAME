package com.openclassrooms.cardgame.model;

public enum Suit {
    DIAMONDS (1), HEARTS (2), SPADES (3), CLUBS (4);

    final int suit;

    Suit(int value) { this.suit = value; }

    public int getValue() { return suit; }
}
