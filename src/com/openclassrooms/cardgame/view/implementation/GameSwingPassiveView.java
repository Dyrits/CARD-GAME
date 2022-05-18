package com.openclassrooms.cardgame.view.implementation;

import com.openclassrooms.cardgame.controller.GameController;
import com.openclassrooms.cardgame.model.IPlayer;
import com.openclassrooms.cardgame.view.GameView;

import javax.swing.*;
import java.awt.*;

public class GameSwingPassiveView implements GameView {
    GameController controller;
    JTextArea textArea;
    JFrame frame;

    public GameSwingPassiveView() { this.createAndShowGUI(); }

    public void createAndShowGUI() {
        this.frame = new JFrame("MVC-SOLID-Game");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(500, 500);
        Container contentPane = this.frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        this.addCommandTracker(contentPane);
        this.frame.setVisible(true);
    }

    private void addCommandTracker(Container contentPane) {
        this.textArea = new JTextArea("Game Status\n", 100, 1);
        JScrollPane scrollPane = new JScrollPane(this.textArea);
        this.addComponent(scrollPane, contentPane);
        this.textArea.setSize(500, 500);
    }

    private void addComponent(JComponent component, Container contentPane) {
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(component);
    }

    private void appendText(String text) {
        this.textArea.append(text + "\n");
        this.textArea.setCaretPosition(this.textArea.getDocument().getLength());
    }

    @Override
    public void setController(GameController controller) { this.controller = controller; }

    @Override
    public void getPlayerName() {
        appendText("Waiting for player name ...");
    }

    @Override
    public void confirmFlip() {}

    @Override
    public void displayPlayerName(int number, String playerName) { appendText("[" + number + "][" + playerName + "]"); }

    @Override
    public void showCard(int number, String playerName) { appendText("[" + number + "] " + playerName + " [#][#]"); }

    @Override
    public void revealCard(int number, String playerName, String rank, String suit) {
        appendText("[" + number + "] " + playerName + " [" + rank + "][" + suit + "]");
    }

    @Override
    public void displayWinner(IPlayer winner) {
        appendText(winner == null ? "It's a draw!" : "The winner is " + winner.getName() + "!");
    }

    @Override
    public void offerNewGame() { appendText("Waiting for next step ..."); }
}
