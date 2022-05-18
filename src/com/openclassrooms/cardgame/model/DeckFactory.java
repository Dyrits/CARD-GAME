package com.openclassrooms.cardgame.model;

import com.openclassrooms.cardgame.model.implementation.Deck32;
import com.openclassrooms.cardgame.model.implementation.Deck52;
import com.openclassrooms.cardgame.model.implementation.DeckTest;

public class DeckFactory {
    public enum DeckType { DECK_52, DECK_32,DECK_TEST }

    public static Deck create(DeckType type) {
        switch (type) {
            case DECK_52: return new Deck52();
            case DECK_32: return new Deck32();
            case DECK_TEST: return new DeckTest();
        }
        return new Deck52();
    }
}
