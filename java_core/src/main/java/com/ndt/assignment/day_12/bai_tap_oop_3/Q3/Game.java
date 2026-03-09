package com.ndt.assignment.day_12.bai_tap_oop_3.Q3;

public class Game {
    String name;

    int remainingTurn;

    int score;


    public Game() {
    }


    public Game(String name, int remainingTurn, int score) {
        this.name = name;
        this.remainingTurn = remainingTurn;
        this.score = score;
    }


    public void startGame() {
        System.out.println("Game is starting");
    }


    public void stopGame() {
        System.out.println("Game is stopped");
    }
}
