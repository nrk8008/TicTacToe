package com.lld.tictactoe.controllers;

import com.lld.tictactoe.exceptions.InvalidBotCountException;
import com.lld.tictactoe.exceptions.InvalidPlayerCountException;
import com.lld.tictactoe.models.Game;
import com.lld.tictactoe.models.GameState;
import com.lld.tictactoe.models.Player;
import com.lld.tictactoe.strategies.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) throws InvalidBotCountException, InvalidPlayerCountException {
        return Game.getBuilder()
                .setDimension(3)
                .setPlayers(new ArrayList<Player>())
                .setWinningStrategies(new ArrayList<WinningStrategy>())
                .build();
    }

    public void makeMove(Game game){
         game.makeMove();
    }
    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
}
