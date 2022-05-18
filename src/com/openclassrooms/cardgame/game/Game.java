package com.openclassrooms.cardgame.game;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.game.implementation.HighestCardValueGE;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.model.DeckFactory;
import com.openclassrooms.cardgame.view.implementation.CommandLineView;
import com.openclassrooms.cardgame.view.implementation.GameSwingView;

public class Game {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                DeckFactory.create(DeckFactory.DeckType.DECK_52),
                new GameSwingView(),
                new HighestCardValueGE()
        );
        gameController.run();
    }
}
