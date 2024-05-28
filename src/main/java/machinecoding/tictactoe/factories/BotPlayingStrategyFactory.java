package machinecoding.tictactoe.factories;

import machinecoding.tictactoe.models.BotDifficultyLevel;
import machinecoding.tictactoe.strategies.botplayingstrategy.BotPlayingStrategy;
import machinecoding.tictactoe.strategies.botplayingstrategy.EasyBotPlayingStrategy;
import machinecoding.tictactoe.strategies.botplayingstrategy.HardBotPlayingStrategy;
import machinecoding.tictactoe.strategies.botplayingstrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        if (botDifficultyLevel.equals(BotDifficultyLevel.EASY)) {
            return new EasyBotPlayingStrategy();
        } else if (botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)) {
            return new MediumBotPlayingStrategy();
        } else {
            return new HardBotPlayingStrategy();
        }
    }
}
