package com.openclassrooms.cardgame.game;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.game.implementation.HighestCardValueGE;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.view.implementation.CommandLineView;
import com.openclassrooms.cardgame.view.implementation.GameSwingView;

public class Game {
    public static void main(String[] args) {
        GameController gameController = new GameController(new Deck(), new GameSwingView(), new HighestCardValueGE());
        gameController.run();
    }
}
