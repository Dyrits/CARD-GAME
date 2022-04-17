package com.openclassrooms.cardgame.view.implementation;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.model.Player;
import com.openclassrooms.cardgame.view.GameView;

import java.util.Scanner;

public class CommandLineView implements GameView {
    GameController controller;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void setController(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void getPlayerName() {
        boolean isEmpty;
        do {
            System.out.println("Enter a new player name, or leave empty to continue: ");
            String playerName = scanner.nextLine().trim();
            isEmpty = playerName.isEmpty();
            if (!isEmpty) { controller.addPlayer(playerName); }
        } while (!isEmpty);
    }

    @Override
    public void confirmFlip() {
        System.out.println("Press enter to reveal the cards.");
        scanner.nextLine();
    }

    @Override
    public void displayPlayerName(int number, String playerName) {
        System.out.println("[" + number + "] " + playerName);
    }

    @Override
    public void showCard(int number, String playerName) {
        System.out.println("[" + number + "] " + playerName + " [#][#]");
    }

    @Override
    public void revealCard(int number, String playerName, String rank, String suit) {
        System.out.println("[" + number + "] " + playerName + " [" + rank + "][" + suit + "]");
    }

    @Override
    public void displayWinner(Player winner) {
        System.out.println(winner == null ? "It's a draw!" : "The winner is " + winner.getName() + "!");
    }

    @Override
    public void offerNewGame() {
        System.out.println("Press any key to play a new game or type [Exit] to quit.");
        this.controller.setGameState(scanner.nextLine());
    }
}
