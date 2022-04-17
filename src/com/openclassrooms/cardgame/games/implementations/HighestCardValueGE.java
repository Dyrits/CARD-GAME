package com.openclassrooms.cardgame.games.implementations;

import com.openclassrooms.cardgame.games.GameEvaluator;
import com.openclassrooms.cardgame.model.Player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HighestCardValueGE extends CardEvaluator implements GameEvaluator {

    @Override
    public Player evaluate(List<Player> players) {
        List<Integer> values = players.stream().map(this::getRankValue).collect(Collectors.toList());
        int highestValue = Collections.max(values);
        if  (Collections.frequency(values, highestValue) != 1) {
            int value = highestValue;
            players = players.stream().filter(player -> this.getRankValue(player) == value).collect(Collectors.toList());
            values = players.stream().map(this::getSuitValue).collect(Collectors.toList());
            highestValue = Collections.max(values);
        }
        return Collections.frequency(values, highestValue) != 1 ?  null : players.get(values.indexOf(highestValue));
    }
}
