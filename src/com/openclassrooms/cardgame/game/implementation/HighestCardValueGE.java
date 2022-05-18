package com.openclassrooms.cardgame.game.implementation;

import com.openclassrooms.cardgame.game.GameEvaluator;
import com.openclassrooms.cardgame.model.IPlayer;

import java.util.List;

public class HighestCardValueGE extends CardEvaluator implements GameEvaluator {

    @Override
    public IPlayer evaluate(List<IPlayer> players) {
        return super.evaluate(players, collector("max"));
    }
}
