package com.openclassrooms.cardgame.view;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.model.IPlayer;

import java.util.ArrayList;
import java.util.List;

public class GameViews implements GameView {

    List<GameView> views;

    public GameViews() { this.views = new ArrayList<GameView>(); }

    public void addView(GameView view) { this.views.add(view); }

    @Override
    public void setController(GameController controller) { this.views.forEach(view -> view.setController(controller)); }

    @Override
    public void getPlayerName() { this.views.forEach(GameView::getPlayerName); }

    @Override
    public void confirmFlip() { this.views.forEach(GameView::confirmFlip); }

    @Override
    public void displayPlayerName(int number, String playerName) {
        this.views.forEach(view -> view.displayPlayerName(number, playerName));
    }

    @Override
    public void showCard(int number, String playerName) { this.views.forEach(view -> view.showCard(number, playerName)); }

    @Override
    public void revealCard(int number, String playerName, String rank, String suit) {
        this.views.forEach(view -> view.revealCard(number, playerName, rank, suit));
    }

    @Override
    public void displayWinner(IPlayer winner) {
        this.views.forEach(view -> view.displayWinner(winner));
    }

    @Override
    public void offerNewGame() { this.views.forEach(GameView::offerNewGame); }
}
