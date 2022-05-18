package com.openclassrooms.cardgame.model.implementation;

import com.openclassrooms.cardgame.model.IPlayer;
import com.openclassrooms.cardgame.model.PlayingCard;

public class WinningPlayer implements IPlayer {
    IPlayer winner;

    public WinningPlayer(IPlayer player) { this.winner = player; }

    @Override
    public String getName() {
        return "***** " + this.winner.getName() + " *****";
    }

    @Override
    public void setName(String name) { this.winner.setName(name); }

    @Override
    public void draw(PlayingCard card) { this.winner.draw(card);}

    @Override
    public PlayingCard getCard(int index) { return this.winner.getCard(index); }

    @Override
    public PlayingCard getCard() { return this.winner.getCard(0); }

    @Override
    public PlayingCard removeCard() { return winner.removeCard(); }
}
