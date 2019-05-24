package tw.core;


import org.junit.Before;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {

    private RandomIntGenerator randomIntGenerator;

    @Before
    public void setup(){
        randomIntGenerator = new RandomIntGenerator();
    }

    @Test
    public void should_amount_of_generated_numbers_be_equal_to_the_input_number(){

        String answer = randomIntGenerator.generateNums(9, 4);
        String[] result = answer.split(" ");

        assertThat(result.length).isEqualTo(4);
    }

    @Test
    public void should_all_generated_numbers_are_less_than_or_equal_to_the_input_number(){

        String answer = randomIntGenerator.generateNums(9, 4);
        String[] array = answer.split(" ");
        for (int i = 0; i < array.length; i ++) {
            boolean res = Integer.parseInt(array[i]) <= 9;

            assertThat(res).isTrue();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IllegalArgumentException_when_digitmax_less_than_numbersOfNeed() throws Exception{

        randomIntGenerator.generateNums(4, 9);
    }

}