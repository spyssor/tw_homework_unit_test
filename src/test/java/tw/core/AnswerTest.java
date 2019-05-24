package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.core.model.GuessResult;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        game = new Game(answerGenerator);
    }

    @Test
    public void should_return_0A0B_when_no_number_is_correct() {

        Answer inputAnswer = Answer.createAnswer("5 6 7 8");

        GuessResult result = game.guess(inputAnswer);

        assertThat(result.getResult()).isEqualTo("0A0B");
    }

    @Test
    public void should_return_4A0B_when_all_number_is_correct() {

        Answer inputAnswer = Answer.createAnswer("1 2 3 4");

        GuessResult result = game.guess(inputAnswer);

        assertThat(result.getResult()).isEqualTo("4A0B");
    }

    @Test
    public void should_return_2A2B_when_two_numbers_are_correct_and_others_is_exist() {

        Answer inputAnswer = Answer.createAnswer("1 4 3 2");

        GuessResult result = game.guess(inputAnswer);

        assertThat(result.getResult()).isEqualTo("2A2B");
    }

    @Test
    public void should_return_0A4B_when_all_number_is_exist() {

        Answer inputAnswer = Answer.createAnswer("4 3 2 1");

        GuessResult result = game.guess(inputAnswer);

        assertThat(result.getResult()).isEqualTo("0A4B");
    }

}