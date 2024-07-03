package com.example.tictactoe.model;

public class OPlayer extends Player {

    public OPlayer() {
        this.symbol = 'O';
    }

    @Override
    public String getPlayerType() {
        return "Player O";
    }
}
