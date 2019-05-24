package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.generator.AnswerGenerator;
import tw.views.GameView;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;
/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {

    @Mock
    private GameView mockGameView;
    @Mock
    private InputCommand mockInputCommand;
    @Mock
    private AnswerGenerator mockAnswerGenerator;

    private Game game;
    private Answer correctAnswer;
    private Answer errorAnswer;
    private GameController gameController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        correctAnswer = Answer.createAnswer("1 2 3 4");
        errorAnswer = Answer.createAnswer("4 5 6 7");

        when(mockAnswerGenerator.generate()).thenReturn(correctAnswer);
        game = new Game(mockAnswerGenerator);
        gameController = new GameController(game, mockGameView);
    }

    @Test
    public void should_display_guess_history_message_when_guess_number() throws Exception{

        when(mockInputCommand.input()).thenReturn(errorAnswer);
        GameController gameController = new GameController(game, mockGameView);

        gameController.play(mockInputCommand);

        //验证是否显示历史猜测数据，而不是显示了什么历史猜测数据
        verify(mockGameView, times(6)).showGuessHistory(anyList());
    }

    @Test
    public void should_end_game_and_display_sucessful_message_when_number_is_correct_in_first_round() throws Exception {

        when(mockInputCommand.input()).thenReturn(correctAnswer);

        gameController.play(mockInputCommand);

        verify(mockInputCommand, times(1)).input();
        verify(mockGameView).showGameStatus("success");
    }

    @Test
    public void should_end_game_and_display_failure_message_when_reach_last_round() throws Exception {

        when(mockInputCommand.input()).thenReturn(errorAnswer);
        GameController gameController = new GameController(game, mockGameView);

        gameController.play(mockInputCommand);

        verify(mockInputCommand, times(6)).input();
        verify(mockGameView).showGameStatus("fail");
    }
}