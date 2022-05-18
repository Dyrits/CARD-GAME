package com.openclassrooms.cardgame.view;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.model.IPlayer;

public interface GameView {
    public void setController(GameController controller);
    public void getPlayerName();
    public void confirmFlip();
    public void displayPlayerName(int number, String playerName);
    public void showCard(int number, String playerName);
    public void revealCard(int number, String playerName, String rank, String suit);
    public void displayWinner(IPlayer winner);
    public void offerNewGame();

}
