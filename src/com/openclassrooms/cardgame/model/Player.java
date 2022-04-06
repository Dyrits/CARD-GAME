package com.openclassrooms.cardgame.model;

public class Player {
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

    public PlayingCard removeCard() { return this.hand.removeCard(); }
}
