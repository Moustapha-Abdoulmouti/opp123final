package com.example.tictactoe.model;

public abstract class Player {
    protected char symbol;

    public char getSymbol() {
        return symbol;
    }

    public abstract String getPlayerType();
}
