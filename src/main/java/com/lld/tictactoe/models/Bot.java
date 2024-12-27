package com.lld.tictactoe.models;

import com.lld.tictactoe.strategies.botWinningStrategies.BotWinningStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotWinningStrategy botPlayingStrategy;

    public Bot(String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel, BotWinningStrategy botPlayingStrategy){
        super(name, symbol, PlayerType.BOT);

        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = botPlayingStrategy;
    }

}
