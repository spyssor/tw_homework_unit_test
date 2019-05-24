package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    private final Answer actualAnswer = Answer.createAnswer("1 2 3 4");
    private Game game;

    @Before
    public void setUp() throws Exception {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(actualAnswer);
        game = new Game(answerGenerator);
    }

    @Test
    public void should_record_every_guess_result() {
        game.guess(Answer.createAnswer("2 1 6 7"));
        game.guess(Answer.createAnswer("1 2 3 4"));

        List<GuessResult> guessHistory = game.guessHistory();

        assertThat(guessHistory.size()).isEqualTo(2);
        assertThat(guessHistory.get(0).getResult()).isEqualTo("0A2B");
        assertThat(guessHistory.get(0).getInputAnswer().toString()).isEqualTo("2 1 6 7");

        assertThat(guessHistory.get(1).getResult()).isEqualTo("4A0B");
        assertThat(guessHistory.get(1).getInputAnswer().toString()).isEqualTo("1 2 3 4");
    }



}
