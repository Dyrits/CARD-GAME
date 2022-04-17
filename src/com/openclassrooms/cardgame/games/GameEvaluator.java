package com.openclassrooms.cardgame.games;

import com.openclassrooms.cardgame.model.Player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface GameEvaluator {
    public Player evaluate(List<Player> players);
}
