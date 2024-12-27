package com.lld.tictactoe.models;

import com.lld.tictactoe.exceptions.InvalidBotCountException;
import com.lld.tictactoe.exceptions.InvalidPlayerCountException;
import com.lld.tictactoe.strategies.winningStrategies.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerMoveIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        this.players = players;
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerMoveIndex = 0;
        this.winningStrategies = winningStrategies;
    }
    public void makeMove(){

    }
    public void printBoard(){
        board.print();
    }
    public Player getWinner(){
        return winner;
    }
    //Game.getBuilder().setDimension(3).setPlayers().setWinningStrategies().build();
    public static Builder getBuilder(){
        return new Builder();
    }


    public static class Builder{
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        private void validateBotCount() throws InvalidBotCountException {
            int botCount = 0;
            for (Player player : players) {
                if(player.getPlayerType()== PlayerType.BOT){
                    botCount++;
                }
            }
            if(botCount > 1){
                throw new InvalidBotCountException("Count of BOTs are greater than 1");
            }
        }
        private void validatePlayerCount() throws InvalidPlayerCountException {
            if(players.size() > dimension-1){
                throw new InvalidPlayerCountException("Player Count is Invalid");
            }
        }

        private void vaidateUniqueSynbolsForEachPlayer(){

        }



        private void validate() throws InvalidBotCountException, InvalidPlayerCountException {
            validateBotCount();
            validatePlayerCount();

        }

        public Game build() throws InvalidBotCountException, InvalidPlayerCountException {
            // before building the game we should validate
            validate();
            return new Game(dimension, players, winningStrategies);
        }
    }
}
