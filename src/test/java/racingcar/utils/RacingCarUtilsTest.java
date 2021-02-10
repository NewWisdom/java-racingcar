package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Name;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarUtilsTest {
    @ParameterizedTest
    @ValueSource(strings = "pobi,amazzi,fortune")
    @DisplayName("자동차 이름을 `,` 로 구분 하기")
    void split_string(String inputString) {
        List<Name> result = RacingCarUtils.splitInputString(inputString);
        assertThat(result).isEqualTo(Arrays.asList(
                new Name("pobi"),
                new Name("amazzi"),
                new Name("fortune")
        ));
    }
}
