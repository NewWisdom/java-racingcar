package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("자동차들 이름이 중복되었을 경우")
    void carsDuplicatedName() {
        assertThatThrownBy(() -> {
            Cars cars = Cars.makeFromCarNames(Arrays.asList(
                    new Name("pobi"),
                    new Name("pobi"),
                    new Name("pobi")));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차들 중 최대 position car 확인")
    void carsGetMaxPosition() {
        Cars cars = Cars.makeFromCarNames(Arrays.asList(
                new Name("pobi"),
                new Name("amazi")));
        assertThat(cars.getMaxPositionCar()
                .getPosition()).isEqualTo(0);
    }
}
