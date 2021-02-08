package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    @DisplayName("null 또는 빈문자로 주었을 경우")
    void splitAndSum_null_또는_빈문자() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자가 하나일 경우")
    void splitAndSum_숫자하나() throws Exception {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 하나가 음수일 경우")
    void splitAndSum_숫자하나_음수() throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("쉼표 구분자가 있을 경우")
    void splitAndSum_쉼표구분자() throws Exception {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표와 콜론 구분자가 있을 경우")
    void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 있을 경우 1")
    void splitAndSum_custom_구분자() throws Exception {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 있을 경우 2")
    void splitAndSum_custom_구분자2() throws Exception {
        int result = StringCalculator.splitAndSum("//#\n0#2:3,4");
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("쉼표 구분자와 음수가 있을 경우")
    void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}