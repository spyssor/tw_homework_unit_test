package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.validator.InputValidator;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    InputValidator inputValidator;

    @Before
    public void setUp(){
        inputValidator = new InputValidator();
    }

    @Test
    public void should_return_false_when_amount_of_input_numbers_out_of_bound(){

        Boolean result = inputValidator.validate("1 2 3 4 5");

        assertThat(result).isFalse();
    }

    @Test
    public void should_return_false_when_value_of_input_number_bigger_than_max(){

        Boolean result = inputValidator.validate("1 2 3 10");

        assertThat(result).isFalse();
    }

    @Test
    public void should_return_true_when_all_input_numbers_are_correct(){

        Boolean result1 = inputValidator.validate("3 5 7 9");
        assertThat(result1).isTrue();

        Boolean result2 = inputValidator.validate("2 4 6 8");
        assertThat(result2).isTrue();
    }
}
