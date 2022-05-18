package com.openclassrooms.cardgame.model.implementation;

import com.openclassrooms.cardgame.model.Hand;
import com.openclassrooms.cardgame.model.IPlayer;
import com.openclassrooms.cardgame.model.PlayingCard;

public class Player implements IPlayer {
    private String name;
    private Hand hand;

    public Player(String name) {
        super();
        this.setName(name);
        this.hand = new Hand();
    }

    public String getName() { return this.name;}

    public void setName(String name) { this.name = name; }

    public void draw(PlayingCard card) { this.hand.addCard(card); }

    public PlayingCard getCard(int index) { return this.hand.getCard(index); }

    public PlayingCard getCard() { return this.hand.getCard(0); }

    public PlayingCard removeCard() { return this.hand.removeCard(); }
}
