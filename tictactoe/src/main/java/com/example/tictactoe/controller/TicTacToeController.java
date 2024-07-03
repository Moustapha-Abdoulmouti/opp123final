package com.example.tictactoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tictactoe.service.TicTacToeService;

@Controller
@RequestMapping("/tictactoe")
public class TicTacToeController {
    private final TicTacToeService ticTacToeService;

    @Autowired
    public TicTacToeController(TicTacToeService ticTacToeService) {
        this.ticTacToeService = ticTacToeService;
    }

    @GetMapping
    public String getBoard(Model model) {
        model.addAttribute("board", ticTacToeService.getBoard().getBoard());
        model.addAttribute("message", "Player X's turn. Choose a box (1-9).");
        model.addAttribute("xWins", ticTacToeService.getXWins());
        model.addAttribute("oWins", ticTacToeService.getOWins());
        return "board";
    }

    @PostMapping("/move")
    public String makeMove(@RequestParam int box, Model model) {
        int row = (box - 1) / 3;
        int col = (box - 1) % 3;
        String result = ticTacToeService.makeMove(row, col);
        model.addAttribute("message", result);
        model.addAttribute("board", ticTacToeService.getBoard().getBoard());
        model.addAttribute("xWins", ticTacToeService.getXWins());
        model.addAttribute("oWins", ticTacToeService.getOWins());
        return "board";
    }

    @PostMapping("/reset")
    public String resetGame(Model model) {
        ticTacToeService.resetGame();
        model.addAttribute("board", ticTacToeService.getBoard().getBoard());
        model.addAttribute("message", "Player X's turn. Choose a box (1-9).");
        model.addAttribute("xWins", ticTacToeService.getXWins());
        model.addAttribute("oWins", ticTacToeService.getOWins());
        return "board";
    }

    @PostMapping("/moveByInput")
    public String makeMoveByInput(@RequestParam int box, Model model) {
        int row = (box - 1) / 3;
        int col = (box - 1) % 3;
        String result = ticTacToeService.makeMove(row, col);
        model.addAttribute("message", result);
        model.addAttribute("board", ticTacToeService.getBoard().getBoard());
        model.addAttribute("xWins", ticTacToeService.getXWins());
        model.addAttribute("oWins", ticTacToeService.getOWins());
        return "board";
    }
}
