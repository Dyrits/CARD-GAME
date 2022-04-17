package com.openclassrooms.cardgame.game;

import com.openclassrooms.cardgame.model.Player;

import java.util.List;

public interface GameEvaluator {
    public Player evaluate(List<Player> players);
}
