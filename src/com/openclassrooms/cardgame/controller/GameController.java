package com.openclassrooms.cardgame.controller;

import com.openclassrooms.cardgame.game.GameEvaluator;
import com.openclassrooms.cardgame.model.Deck;
import com.openclassrooms.cardgame.model.Player;
import com.openclassrooms.cardgame.model.PlayingCard;
import com.openclassrooms.cardgame.view.CommandLineView;
import com.openclassrooms.cardgame.view.GameView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    enum GameState { Registering, Calculating, Dealing, Revealing, Rebuilding, Exiting};

    Deck deck;
    List<Player> players;
    GameView view;
    GameState gameState;
    GameEvaluator evaluator;

    public GameController(Deck deck, GameView view, GameEvaluator evaluator) {
        super();
        this.deck = deck;
        this.view = view;
        this.players = new ArrayList<Player>();
        this.gameState = GameState.Registering;
        view.setController(this);
        this.evaluator = evaluator;
    }

    public void run() {
        switch (this.gameState) {
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
            case Exiting:
                this.exitGame();
                break;

        }
    }


    public void registerPlayers() {
        this.view.getPlayerName();
        this.gameState = GameState.Dealing;
        this.run();
    }

    public void addPlayer(String playerName) {
        this.players.add(new Player(playerName));
        this.view.displayPlayerName(this.players.size(), playerName);
    }

    public void dealCards() {
        deck.shuffle();
        for (Player player : this.players) {
            player.draw(this.deck.draw());
            this.view.showCard(this.players.indexOf(player) + 1, player.getName());
        }
        this.gameState = GameState.Revealing;
        this.run();
    }

    public void flipCards() {
        this.view.confirmFlip();
        for (Player player : this.players) {
            PlayingCard card = player.getCard(0);
            card.flip();
            this.view.revealCard(this.players.indexOf(player) + 1, player.getName(), card.getRank().toString(), card.getSuit().toString());
        }
        this.gameState = GameState.Calculating;
        this.run();
    }

    private void calculateOutcome() {
        this.view.displayWinner(this.evaluator.evaluate(this.players));
        this.view.offerNewGame();
        this.run();
    }

    private void rebuildDeck() {
        for (Player player : players) { this.deck.returnCardToDeck(player.removeCard()); }
        this.gameState = GameState.Dealing;
        this.run();
    }

    private void exitGame() {
        System.exit(0);
    }

    public void setGameState(String input) {
        this.gameState = input.toUpperCase().equals("EXIT") ? GameState.Exiting : GameState.Rebuilding;
    }
}
