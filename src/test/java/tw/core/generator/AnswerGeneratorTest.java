package tw.core.generator;

import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {

    @Test(expected = OutOfRangeAnswerException.class)
    public void should_throw_OutOfRangeAnswerException_which_is_not_between_0_and_9() throws Exception {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 10");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

        answerGenerator.generate();
    }

}

