package com.openclassrooms.cardgame.game;

import com.openclassrooms.cardgame.model.IPlayer;

import java.util.List;

public interface GameEvaluator {
    public IPlayer evaluate(List<IPlayer> players);
}
