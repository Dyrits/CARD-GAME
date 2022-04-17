package com.openclassrooms.cardgame.games.implementations;

import com.openclassrooms.cardgame.model.Player;

public abstract class CardEvaluator {
    public int getRankValue(Player player) { return player.getCard().getRank().getValue(); }
    public int getSuitValue(Player player) { return player.getCard().getSuit().getValue(); }
}
