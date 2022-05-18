package com.openclassrooms.cardgame.model.implementation;

import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.model.PlayingCard;
import com.openclassrooms.cardgame.model.Rank;
import com.openclassrooms.cardgame.model.Suit;

import java.util.ArrayList;

public class DeckTest extends Deck {
    public DeckTest() {
        this.cards = new ArrayList<PlayingCard>();
        for(int loop = 0; loop < 20; loop ++) { this.cards.add(new PlayingCard(Rank.ACE, Suit.CLUBS)); }
        shuffle();
    }
}
