package racingcar.utils;

import racingcar.domain.Name;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarUtils {
    private RacingCarUtils() {
    }

    public static List<Name> splitInputString(final String inputString) {
        return Arrays.stream(inputString.split(","))
                .map(Name::new)
                .collect(Collectors.toList());
    }
}
