package com.openclassrooms.cardgame.games.implementations;

import com.openclassrooms.cardgame.games.GameEvaluator;
import com.openclassrooms.cardgame.model.Player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LowestCardValueGE extends CardEvaluator implements GameEvaluator {

    @Override
    public Player evaluate(List<Player> players) {
        List<Integer> values = players.stream().map(this::getRankValue).collect(Collectors.toList());
        int lowestValue = Collections.min(values);
        if  (Collections.frequency(values, lowestValue) != 1) {
            int value = lowestValue;
            players = players.stream().filter(player -> this.getRankValue(player) == value).collect(Collectors.toList());
            values = players.stream().map(this::getSuitValue).collect(Collectors.toList());
            lowestValue = Collections.min(values);
        }
        return Collections.frequency(values, lowestValue) != 1 ?  null : players.get(values.indexOf(lowestValue));
    }
}
