package com.openclassrooms.cardgame.game.implementation;

import com.openclassrooms.cardgame.model.IPlayer;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CardEvaluator {
    public int getRankValue(IPlayer player) { return player.getCard().getRank().getValue(); }
    public int getSuitValue(IPlayer player) { return player.getCard().getSuit().getValue(); }

    public interface Collector { int operate(List<Integer> values);}

    public Collector collector(String operation) {
        switch (operation) {
            case "max":
                return new Collector() {
                    @Override
                    public int operate(List<Integer> values) { return Collections.max(values); }
                };
            case "min":
                return new Collector() {
                    @Override
                    public int operate(List<Integer> values) { return Collections.min(values);}
                };
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }

    public IPlayer evaluate(List<IPlayer> players, Collector collector) {
        List<Integer> values = players.stream().map(this::getRankValue).collect(Collectors.toList());
        int value = collector.operate(values);
        if  (Collections.frequency(values, value) != 1) {
            int temporary = value;
            players = players.stream().filter(player -> this.getRankValue(player) == temporary).collect(Collectors.toList());
            values = players.stream().map(this::getSuitValue).collect(Collectors.toList());
            value = collector.operate(values);
        }
        return Collections.frequency(values, value) != 1 ?  null : players.get(values.indexOf(value));
    }
}
