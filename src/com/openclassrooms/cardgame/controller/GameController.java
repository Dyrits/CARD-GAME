package com.openclassrooms.cardgame.controller;

import com.openclassrooms.cardgame.games.GameEvaluator;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.model.Player;
import com.openclassrooms.cardgame.model.PlayingCard;
import com.openclassrooms.cardgame.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {
    enum GameState { Registering, Calculating, Dealing, Revealing, Rebuilding};

    Deck deck;
    List<Player> players;
    View view;
    GameState gameState;

    public GameController(Deck deck, View view) {
        super();
        this.deck = deck;
        this.view = view;
        this.players = new ArrayList<Player>();
        this.gameState = GameState.Registering;
        view.setGameController(this);
    }

    public void run() {
        switch (gameState) {
            case Registering:
                this.registerPlayers();
                break;
            case Dealing:
                this.dealCards();
                break;
            case Revealing:
                this.flipCards();
                break;
            case Calculating:
                this.calculateOutcome();
                break;
            case Rebuilding:
                this.rebuildDeck();
                break;
        }
    }


    public void registerPlayers() {
        this.view.getPlayerName();
        this.gameState = GameState.Dealing;
        this.run();
    }

    public void addPlayer(String playerName) {
        players.add(new Player(playerName));
        view.displayPlayerName(this.players.size(), playerName);
    }

    public void dealCards() {
        deck.shuffle();
        for (Player player : players) {
            player.draw(deck.draw());
            view.showCard(players.indexOf(player) + 1, player.getName());
        }
        this.gameState = GameState.Revealing;
        this.run();
    }

    public void flipCards() {
        this.view.confirmFlip();
        for (Player player : players) {
            PlayingCard card = player.getCard(0);
            card.flip();
            this.view.revealCard(players.indexOf(player) + 1, player.getName(), card.getRank().toString(), card.getSuit().toString());
        }
        this.gameState = GameState.Calculating;
        this.run();
    }

    private void calculateOutcome() {
        this.view.displayWinner(new GameEvaluator().evaluateWinner(this.players));
        this.gameState = GameState.Rebuilding;
        this.run();
    }

    private void rebuildDeck() {
        this.view.offerNewGame();
        for (Player player : players) { deck.returnCardToDeck(player.removeCard()); }
        this.gameState = GameState.Dealing;
        this.run();
    }
}
