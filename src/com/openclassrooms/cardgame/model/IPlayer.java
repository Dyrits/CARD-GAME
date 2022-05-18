package com.openclassrooms.cardgame.model;

public interface IPlayer {
    public String getName();
    public void setName(String name);
    public void draw(PlayingCard card);
    public PlayingCard getCard(int index);
    public PlayingCard getCard();
    public PlayingCard removeCard();
}
