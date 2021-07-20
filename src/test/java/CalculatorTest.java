import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @DisplayName("연산 메소드 테스트")
    @Test
    void calculatorResultTest() {
        int num1 = 4;
        int num2 = 2;

        assertThat(calculator.add(num1, num2)).isEqualTo(6);
        assertThat(calculator.minus(num1, num2)).isEqualTo(2);
        assertThat(calculator.multiply(num1, num2)).isEqualTo(8);
        assertThat(calculator.divide(num1, num2)).isEqualTo(2);
    }

    @DisplayName("빈문자열 체크 테스트")
    @Test
    public void calculatorExceptionTest() {
        String str = "";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.checkMathExpression(str))
                .withMessageMatching("빈 문자열입니다.");
    }

    @DisplayName("사칙연산 기호 체크 테스트")
    @Test
    public void operatorTest() {
        String str = "^";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.checkOperator(str))
                .withMessageMatching("사칙연산 기호가 아닙니다.");
    }

    @DisplayName("계산기 결과 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "3 - 2:1", "1 * 2:2" , "4 / 2:2"}, delimiter = ':')
    void executeCalculatorTest(String mathExp, String expected) {
        String[] splitMath = calculator.checkMathExpression(mathExp);
        int num1 = Integer.parseInt(splitMath[0]);
        int num2 = Integer.parseInt(splitMath[2]);
        String operator = splitMath[1];

        assertThat(calculator.executeCalculator(operator, num1, num2)).isEqualTo(expected);
    }

}