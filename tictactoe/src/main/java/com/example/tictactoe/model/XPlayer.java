package com.example.tictactoe.model;

public class XPlayer extends Player {

    public XPlayer() {
        this.symbol = 'X';
    }

    @Override
    public String getPlayerType() {
        return "Player X";
    }
}
