package com.openclassrooms.cardgame.view;

import com.openclassrooms.cardgame.controller.GameController;

import java.util.Objects;
import java.util.Scanner;

public class View {
    GameController gameController;
    Scanner scanner = new Scanner(System.in);

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public void getPlayerName() {
        boolean isEmpty;
        do {
            System.out.println("Enter a new player name, or leave empty to continue: ");
            String playerName = scanner.nextLine().trim();
            isEmpty = playerName.isEmpty();
            if (!isEmpty) { gameController.addPlayer(playerName); }
        } while (!isEmpty);
    }

    public void confirmFlip() {
        System.out.println("Press enter to reveal the cards.");
        scanner.nextLine();
    }

    public void displayPlayerName(int number, String playerName) {
        System.out.println("[" + number + "] " + playerName);
    }

    public void showCard(int number, String playerName) {
        System.out.println("[" + number + "] " + playerName + " [#][#]");
    }

    public void revealCard(int number, String playerName, String rank, String suit) {
        System.out.println("[" + number + "] " + playerName + " [" + rank + "][" + suit + "]");
    }

    public void displayWinner(String playerName) {
        System.out.println(Objects.equals(playerName, "DRAW") ? "It's a draw!" : "The winner is " + playerName + "!");
    }

    public void offerNewGame() {
        System.out.println("Press enter to play a new game.");
        scanner.nextLine();
    }
}
