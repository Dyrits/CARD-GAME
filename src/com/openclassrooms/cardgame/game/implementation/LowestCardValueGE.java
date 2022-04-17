package com.openclassrooms.cardgame.game.implementation;

import com.openclassrooms.cardgame.game.GameEvaluator;
import com.openclassrooms.cardgame.model.Player;

import java.util.List;

public class LowestCardValueGE extends CardEvaluator implements GameEvaluator {

    @Override
    public Player evaluate(List<Player> players) {
        return super.evaluate(players, collector("min"));
    }
}
