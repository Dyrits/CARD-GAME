package com.openclassrooms.cardgame.game;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.game.implementation.HighestCardValueGE;
import com.openclassrooms.cardgame.model.DeckFactory;
import com.openclassrooms.cardgame.view.GameViews;
import com.openclassrooms.cardgame.view.implementation.GameSwingPassiveView;
import com.openclassrooms.cardgame.view.implementation.GameSwingView;

public class Game {
    public static void main(String[] args) {
        GameViews views = new GameViews();
        GameSwingView view = new GameSwingView();
        views.addView(view);
        for (int loop = 0; loop < 3; loop++) {
            GameSwingPassiveView passiveView = new GameSwingPassiveView();
            views.addView(passiveView);
            try { Thread.sleep(2500); }
            catch (InterruptedException exception) { exception.printStackTrace(); }
        }
        GameController gameController = new GameController(
                DeckFactory.create(DeckFactory.DeckType.DECK_52),
                views,
                new HighestCardValueGE()
        );
        gameController.run();
    }
}
