package com.example.tictactoe.service;

import org.springframework.stereotype.Service;

import com.example.tictactoe.model.Board;
import com.example.tictactoe.model.OPlayer;
import com.example.tictactoe.model.Player;
import com.example.tictactoe.model.XPlayer;

@Service
public class TicTacToeService {
    private Board board;
    private Player currentPlayer;
    private Player xPlayer;
    private Player oPlayer;
    private int xWins;
    private int oWins;

    public TicTacToeService() {
        board = new Board();
        xPlayer = new XPlayer();
        oPlayer = new OPlayer();
        currentPlayer = xPlayer;
        xWins = 0;
        oWins = 0;
    }

    public Board getBoard() {
        return board;
    }

    public int getXWins() {
        return xWins;
    }

    public int getOWins() {
        return oWins;
    }

    public String makeMove(int row, int col) {
        if (board.makeMove(row, col, currentPlayer.getSymbol())) {
            if (board.hasWon(currentPlayer.getSymbol())) {
                if (currentPlayer == xPlayer) {
                    xWins++;
                } else {
                    oWins++;
                }
                return currentPlayer.getPlayerType() + " has won! Click 'Play Again' to start a new game.";
            } else if (board.isBoardFull()) {
                return "The game is a tie! Click 'Play Again' to start a new game.";
            } else {
                switchPlayer();
                return "Move accepted. Next player: " + currentPlayer.getPlayerType() + ". Choose a box (1-9).";
            }
        } else {
            return "Invalid move. Try again. Current player: " + currentPlayer.getPlayerType() + ". Choose a box (1-9).";
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == xPlayer) ? oPlayer : xPlayer;
    }

    public void resetGame() {
        board = new Board();
        currentPlayer = xPlayer;
    }
}
