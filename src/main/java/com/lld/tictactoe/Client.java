package com.lld.tictactoe;

import com.lld.tictactoe.controllers.GameController;
import com.lld.tictactoe.exceptions.InvalidBotCountException;
import com.lld.tictactoe.exceptions.InvalidPlayerCountException;
import com.lld.tictactoe.models.*;
import com.lld.tictactoe.strategies.winningStrategies.ColumnWinningStrategy;
import com.lld.tictactoe.strategies.winningStrategies.DiagonalWinningStrategy;
import com.lld.tictactoe.strategies.winningStrategies.RowWinningStrategy;
import com.lld.tictactoe.strategies.winningStrategies.WinningStrategy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, InvalidPlayerCountException {

        int dimension = 3;
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("Rajesh", new Symbol('X'), PlayerType.HUMAN));
        playerList.add(new Player("Anmol", new Symbol('#'), PlayerType.HUMAN));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        GameController gameController = new GameController();
        Game game = gameController.startGame(dimension, playerList, winningStrategies);

        gameController.printBoard(game);

        while(game.getGameState().equals(GameState.IN_PROGRESS)){
            /*
            1. Print the Board
            2. Ask the user to choose where to make the move

            */
            gameController.printBoard(game);

            gameController.makeMove(game);

        }
        if(game.getGameState().equals(GameState.ENDED)){
            gameController.printBoard(game);
            System.out.println("The Winner is " + gameController.getWinner(game).getName());
        }
        else{
            System.out.print("The Game is Draw");
        }

    }
}
