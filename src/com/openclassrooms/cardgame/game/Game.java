package com.openclassrooms.cardgame.game;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.game.implementation.HighestCardValueGE;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.view.CommandLineView;

public class Game {
    public static void main(String[] args) {
        GameController gameController = new GameController(new Deck(), new CommandLineView(), new HighestCardValueGE());
        gameController.run();
    }
}
